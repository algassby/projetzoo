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
@WebServlet("/devorer")
public class DevorerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public DevorerServlet() {
		super();
		//Manager.getInstance().devorer(, mange)
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("mangeur", req.getAttribute("radiobuttons"));
		req.setAttribute("mange", req.getAttribute("radiobutton"));
		resp.getWriter().print("<p>servelet devorer</p>");
		resp.getWriter().print(req.getAttribute("mangeur"));
		resp.getWriter().print(req.getAttribute("mange"));
		//req.setAttribute("devorer", Manager.getInstance().);
		//req.getServletContext().getRequestDispatcher("/init").forward(req, resp);
		
	}
	

}
