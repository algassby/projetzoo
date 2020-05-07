package org.formation.zoo.controleur;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.service.GazellePOJO;

/**
 * Servlet implementation class AjouterServlet
 */
@WebServlet("/ajouter")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		GazellePOJO gaz = null;
		gaz = new GazellePOJO();
		
		tmp = new CagePOJO();
		
		String cle = request.getParameter("cle");
		String age = request.getParameter("age");
		String nom = request.getParameter("nom");
		String codeAnimal = request.getParameter("codeAnimal");
		String poids = request.getParameter("poids");
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String lgCorne = request.getParameter("lgcorne");
		String cleGaz = request.getParameter("cleGaz");
		
		tmp.setCle(Integer.parseInt(cle));
		tmp.setAge(Integer.parseInt(age));
		tmp.setCodeAnimal(codeAnimal);
		tmp.setNom(nom);
		tmp.setPoids(Float.parseFloat(poids));
		tmp.setX(Integer.parseInt(x));
		tmp.setY(Integer.parseInt(y));
		//si c'est une gazelle
		if(tmp.getCodeAnimal().equals("Gazelle")) {
			gaz.setId(Integer.parseInt(cleGaz));
			gaz.setIdAnimal(tmp.getCle());
			gaz.setLgCornes(Integer.parseInt(lgCorne));
			tmp.setGaz(gaz);
		}
		
		
		Manager.getInstance().ajouter(tmp);
		
		request.getServletContext().getRequestDispatcher("/init").forward(request, response);
	}

}
