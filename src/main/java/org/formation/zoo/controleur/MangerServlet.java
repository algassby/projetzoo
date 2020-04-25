/**
 * 
 */
package org.formation.zoo.controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author algas
 *
 */
public class MangerServlet extends HttpServlet {

	/**
	 * 
	 */
	public MangerServlet() {
		super();
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
		this.nourrir();
		//req.getServletContext().getRequestDispatcher("/principal.jsp").forward(req, resp);
	}
	

}
