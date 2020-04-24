/**
 * 
 */
package org.formation.zoo.controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.formation.zoo.service.CagePOJO;

/**
 * @author algas
 *
 */
@WebServlet("/init")
public class InitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public InitServlet() {
		super();
	}
	public List<CagePOJO> getAnimaux()
	{
		return  Manager.getInstance().getAnimaux();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("ListAnimal",this.getAnimaux());
		req.getServletContext().getRequestDispatcher("/principal.jsp").forward(req, resp);
		
	}
	
	

}
