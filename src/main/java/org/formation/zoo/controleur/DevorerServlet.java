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

import org.formation.zoo.modele.metier.Animal;
import org.formation.zoo.modele.metier.Mangeable;
import org.formation.zoo.modele.technique.BeurkException;
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
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String valMangeur =req.getParameter("mangeur");
		String valMange = req.getParameter("mange");
		for(int i = 0; i < Manager.getInstance().getAnimaux().size();i++) {
		if(Manager.getInstance().getAnimaux().get(i) instanceof Mangeable) {
			Manager.getInstance().devorer(Integer.parseInt(valMangeur), Integer.parseInt(valMange));
		}
		else {
				req.setAttribute("burkException", new BeurkException());
			}
		}
		req.getServletContext().getRequestDispatcher("/init").forward(req, resp);
	}
	

}
