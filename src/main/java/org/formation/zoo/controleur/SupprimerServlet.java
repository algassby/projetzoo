package org.formation.zoo.controleur;

import java.io.IOException;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerServlet() {
        super();
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
		String cle = request.getParameter("cle");
		request.setAttribute("cle", cle);
		tmp.setCle(Integer.parseInt(cle));
		Manager.getInstance().supprimer(tmp.getCle());
		request.getServletContext().getRequestDispatcher("/init").forward(request, response);
		
	}

}
