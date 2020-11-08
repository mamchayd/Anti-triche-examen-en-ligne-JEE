package est.pfe.controleur;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import est.pfe.metier.ClientProfesseur;
import est.pfe.metier.ContrainteForm;
import est.pfe.metier.Etudiant;
import est.pfe.metier.EtudiantConnecter;
import est.pfe.metier.Professeur;

/**
 * Servlet implementation class ServletStopExam
 */
@WebServlet("/ServletStopExam")
public class ServletStopExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private boolean stop=false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletStopExam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!stop){
		String ipEtudiant=request.getParameter("ip_etud");
		 for(Etudiant e :  ClientProfesseur.getListTricheurs())
		  {
			  if(e.getAdresseIP().equals(ipEtudiant))
				{e.setSessionFermer(true);
				}
		  }
		ClientProfesseur client=new ClientProfesseur();
		try {
    		//Class.forName("com.mysql.jdbc.Driver");
           
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			
    		}
		client.stopExam(ipEtudiant);
		}
						 
						  ContrainteForm form = new ContrainteForm();
							Professeur pfr = (Professeur) request.getSession().getAttribute("sessionUtilisateur");	
							ArrayList<EtudiantConnecter> liste = form.getListe(pfr);
							request.setAttribute("liste", liste);
						 request.setAttribute("listeTricheurs",ClientProfesseur.getListTricheurs());
						  stop=true;
		
						 this.getServletContext().getRequestDispatcher("/Tracking.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
