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
import com.skillstorm.daos.MySQLWarehouseDAOImpl;
import com.skillstorm.daos.WarehouseDAO;
import com.skillstorm.models.NotFound;
import com.skillstorm.models.Warehouse;
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
@WebServlet(urlPatterns = {"/warehouses/*"})
public class WarehouseServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1255978588645665829L;
	WarehouseDAO dao = new MySQLWarehouseDAOImpl();
	ObjectMapper mapper = new ObjectMapper();
	URLParserService urlService = new URLParserService();
	
	
	/**
	 * This allows us to write code that is run right as the servlet is created
	 * You can establish any connections
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("Warehouse Servlet Created!");
		super.init();
	}
	
	/**
	 * If any connections were established in init
	 * Terminate those connections here
	 */
	@Override
	public void destroy() {
		System.out.println("Warehouse Servlet Destroyed!");
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
	 * returns all warehouses if no id is specified
	 * if id provided (as in {.../warehouse/(id)}, then returns the warehouse with that id
	 * @param
	 * @param
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = urlService.extractIdFromURL(req.getPathInfo());
			Warehouse warehouse = dao.findById(id);
			if (warehouse != null) {
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(warehouse));	// sends back the data to the request side, parsed as JSON
			} else {
				resp.setStatus(404);
				// resp.getWriter().print(mapper.writeValueAsString(new IllegalArgumentException("No warehouse with the provided Id found")));
				resp.getWriter().print(mapper.writeValueAsString(new NotFound("No warehouse with the provided id found")));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(req.getPathInfo());
			List<Warehouse> warehouses = dao.findAll();
			System.out.println(warehouses);									// writes to the console when we send the GET request.
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(warehouses));	// sends back the data to the request side, parsed as JSON
		}
			
	}
	
	
	/**
	 * handles POST requests from the client
	 * creates a warehouse with provided attributes
	 * @param
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream reqBody = req.getInputStream();
		Warehouse newWarehouse = mapper.readValue(reqBody, Warehouse.class);
		try {
			newWarehouse = dao.save(newWarehouse);	// in case our id changes
			if (newWarehouse != null) {
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(newWarehouse));
				resp.setStatus(201);	// because creating an object				
			}
		} catch (Exception e) {
			resp.setStatus(400);
			resp.getWriter().print(mapper.writeValueAsString(new NotFound("Couldn't create warehouse")));
		}
	}
	
	
	/**
	 * handles PUT requests from the client
	 * idempotent so creates or updates the same warehouse if called multiple time. 
	 * use to update a warehouse
	 * @param
	 */	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream reqBody = req.getInputStream();
		Warehouse newWarehouse = mapper.readValue(reqBody, Warehouse.class);
		boolean success = false;
		try {
			success = dao.update(newWarehouse);	// in case our id changes
			if (success) {
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(newWarehouse));
				resp.setStatus(201);	// because updating an object				
			}
		} catch (Exception e) {
			resp.setStatus(400);
			resp.getWriter().print(mapper.writeValueAsString(new NotFound("Couldn't create warehouse")));
		}
	}
	
	
	/**
	 * handles DELETE requests from the client
	 * deletes a warehouse 
	 * @param
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream reqBody = req.getInputStream();
		Warehouse newWarehouse = mapper.readValue(reqBody, Warehouse.class);
		try {
			boolean success = dao.delete(newWarehouse);	// in case our id changes
			if (success) {
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(newWarehouse));
				resp.setStatus(200);	// because deleting an object				
			}
		} catch (Exception e) {
			resp.setStatus(400);
			resp.getWriter().print(mapper.writeValueAsString(new NotFound("Couldn't create warehouse")));
		}
	}

}
