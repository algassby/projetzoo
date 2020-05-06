/**
 * 
 */
package org.formation.zoo.controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author algas
 *
 */
@WebServlet("/manger")
public class MangerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public MangerServlet() {
		super();
		this.nourrir();
	}


	public void nourrir() {
		Manager.getInstance().nourrir();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//resp.getWriter().print("<p>coucou on mange bien</p>");
		req.getServletContext().getRequestDispatcher("/init").forward(req, resp);
	}
	
	

}
