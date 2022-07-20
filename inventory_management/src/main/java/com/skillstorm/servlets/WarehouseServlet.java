package com.skillstorm.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.daos.MySQLWarehouseDAOImpl;
import com.skillstorm.daos.WarehouseDAO;
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
			}
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(req.getPathInfo());
			List<Warehouse> warehouses = dao.findAll();
			System.out.println(warehouses);									// writes to the console when we send the GET request.
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(warehouses));	// sends back the data to the request side, parsed as JSON
		}
			
	}
	
	/**
	 * handles PUT requests from the client
	 * @param
	 */	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
	
	/**
	 * handles POST requests from the client
	 * @param
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	/**
	 * handles DELETE requests from the client
	 * @param
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}
