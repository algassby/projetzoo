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

import org.formation.zoo.modele.metier.Animal;
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
		List<CagePOJO> liste = null;
		liste = Manager.getInstance().getAnimaux();
		for(int i = 0; i < liste.size();i++) {
			liste.get(i).getImage();
			liste.get(i).getPancarte();
		}
		return liste;
	}
	public String getImage() {
		String image = null;
		List<CagePOJO> liste = null;
		liste = Manager.getInstance().getAnimaux();
		for(int i = 0; i < liste.size();i++) {
		 image = 	liste.get(i).getImage();
		}
		return image;
		
	}
	public int getX() {
		int x = 0;
		List<CagePOJO> liste = null;
		liste = Manager.getInstance().getAnimaux();
		for(int i = 0; i < liste.size();i++) {
			x = liste.get(i).getX();
		}
		return x;
	}
	public int getY() {
		int y = 0;
		List<CagePOJO> liste = null;
		liste = Manager.getInstance().getAnimaux();
		for(int i = 0; i < liste.size();i++) {
			y = liste.get(i).getY();
		}
		return y;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("ListAnimal",this.getAnimaux());
		req.setAttribute("X", this.getX());
		req.setAttribute("Y", this.getY());
		req.setAttribute("IMGAE", this.getImage());
		req.getServletContext().getRequestDispatcher("/principal.jsp").forward(req, resp);
		
	}
	
	

}
