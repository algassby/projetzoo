package org.formation.zoo.controleur;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.formation.zoo.service.CagePOJO;

/**
 * Servlet implementation class SupprimerServlet
 */
@WebServlet("/supprimer")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerServlet() {
    	logger = Logger.getLogger("level");
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CagePOJO tmp = null;
		tmp =  new CagePOJO();
		int valCle = 0;
		String cle = request.getParameter("cle");
		valCle = Integer.parseInt(cle);
		if(valCle!=tmp.getCle() || cle.length()!=0) {
		
//			try {   
//				valCle = Integer.parseInt(cle);
//				} catch (NumberFormatException nfe) {
//					request.setAttribute("msg", nfe.getMessage());
//				  
//				}
			tmp.setCle(valCle);
//			if(Integer.parseInt(cle) == tmp.getCle()) {
				Manager.getInstance().supprimer(tmp.getCle());
				request.getServletContext().getRequestDispatcher("/init").forward(request, response);
			
//			else {
//				request.getServletContext().getRequestDispatcher("/supprimer").forward(request, response);
//				request.setAttribute("msgCle", "veuillez entrer une clé valide");
//			}
		}
		else
		{

			request.getServletContext().getRequestDispatcher("/supprimer").forward(request, response);
			request.setAttribute("msg", "veuillez entrer une valeur dont la longeur est superieeur à 0 ");
		}
		
		
	}

}
