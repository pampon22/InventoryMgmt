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
 * 
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
	 * handles GET requests from the client. returns all warehouses
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
				resp.setStatus(201);	// because creating an object				
			}
		} catch (Exception e) {
			resp.setStatus(400);
			resp.getWriter().print(mapper.writeValueAsString(new NotFound("Couldn't create warehouse")));
		}
	}
	
	
	/**
	 * handles DELETE requests from the client
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
				resp.setStatus(201);	// because creating an object				
			}
		} catch (Exception e) {
			resp.setStatus(400);
			resp.getWriter().print(mapper.writeValueAsString(new NotFound("Couldn't create warehouse")));
		}
	}

}
