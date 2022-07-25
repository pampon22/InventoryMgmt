package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.daos.MySQLShoeDAOImpl;
import com.skillstorm.daos.ShoeDAO;
import com.skillstorm.models.NotFound;
import com.skillstorm.models.Shoe;
import com.skillstorm.services.URLParserService;


/**
 * Servlet Lifecycle
 * 
 * init - A method called when the web server first creates our servlet
 * service - method called before EVERY request
 * destroy - method called when the web server is stopped/servlet terminates
 * @author phil
 *
 */

// telling TomCat about my servlet
@WebServlet(urlPatterns = {"/shoes/*"})
public class ShoeServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6537249861225369193L;
	ShoeDAO dao = new MySQLShoeDAOImpl();
	ObjectMapper mapper = new ObjectMapper();
	URLParserService urlService = new URLParserService();
	
	
	/**
	 * This allows us to write code that is run right as the servlet is created
	 * You can establish any connections
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("Shoe Servlet Created!");
		super.init();
	}
	
	/**
	 * If any connections were established in init
	 * Terminate those connections here
	 */
	@Override
	public void destroy() {
		System.out.println("Shoe Servlet Destroyed!");
		super.destroy();
	}
	
	
	/**
	 * we would prefer filters to this
	 * activates on ALL HTTP requests to this servlet
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servicing request!");
		super.service(req, resp);
	}	
	
	
	/**
	 * handles GET requests from the client. 
	 * returns all shoes if no id is specified
	 * if id provided (as in {.../shoe/(id)}, then returns the shoe with that id
	 * @param
	 * @param
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = urlService.extractIdFromURL(req.getPathInfo());
			Shoe shoe = dao.findById(id);
			if (shoe != null) {
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(shoe));	// sends back the data to the request side, parsed as JSON
			} else {
				resp.setStatus(404);
				// resp.getWriter().print(mapper.writeValueAsString(new IllegalArgumentException("No shoe with the provided Id found")));
				resp.getWriter().print(mapper.writeValueAsString(new NotFound("No shoe with the provided id found")));
			}
			/*
			try {
				String key = urlService.extractStringFromURL(req.getPathInfo());
				List<Shoe> shoes = dao.findShoeLike(key);
				if ( !(shoes.isEmpty()) ) {
					resp.setContentType("application/json");
					resp.getWriter().print(mapper.writeValueAsString(shoes));	// sends back the data to the request side, parsed as JSON
				} else {
					resp.setStatus(404);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			*/
		} catch (Exception e) {
			System.out.println(req.getPathInfo());
			List<Shoe> shoes = dao.findAll();
			System.out.println(shoes);									// writes to the console when we send the GET request.
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(shoes));	// sends back the data to the request side, parsed as JSON
		}
	}
	
	
//	protected void doGet() {
//		
//	}
	
	
	/**
	 * handles POST requests from the client
	 * creates a shoe with provided attributes
	 * @param
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream reqBody = req.getInputStream();
		Shoe newShoe = mapper.readValue(reqBody, Shoe.class);
		try {
			newShoe = dao.save(newShoe);	// in case our id changes
			if (newShoe != null) {
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(newShoe));
				resp.setStatus(201);	// because creating an object				
			}
		} catch (Exception e) {
			resp.setStatus(400);
			resp.getWriter().print(mapper.writeValueAsString(new NotFound("Couldn't create shoe")));
		}
	}
	
	
	/**
	 * handles PUT requests from the client
	 * idempotent so creates or updates the same shoe if called multiple time. 
	 * use to update a shoe
	 * @param
	 */	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream reqBody = req.getInputStream();
		Shoe newShoe = mapper.readValue(reqBody, Shoe.class);
		boolean success = false;
		try {
			success = dao.update(newShoe);	// in case our id changes
			if (success) {
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(newShoe));
				resp.setStatus(201);	// because updating an object				
			}
		} catch (Exception e) {
			resp.setStatus(400);
			resp.getWriter().print(mapper.writeValueAsString(new NotFound("Couldn't create shoe")));
		}
	}
	
	
	/**
	 * handles DELETE requests from the client
	 * deletes a shoe 
	 * @param
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = urlService.extractIdFromURL(req.getPathInfo());
			Shoe shoe = dao.findById(id);
			boolean success = dao.delete(shoe.getId());	// in case our id changes
			if (success) {
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(shoe));
				resp.setStatus(200);	// because deleting an object
			} else {
				resp.setStatus(400);
				resp.getWriter().print(mapper.writeValueAsString("Unsuccessful deleting shoe"));			}
		} catch (Exception e) {
			resp.setStatus(400);
			resp.getWriter().print(mapper.writeValueAsString(new NotFound("Couldn't delete shoe because it doesn't exist")));
		}
	}

}
