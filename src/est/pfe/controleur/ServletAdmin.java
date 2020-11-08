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
import est.pfe.metier.EtudiantConnecter;
import est.pfe.metier.Professeur;


/**
 * Servlet implementation class ServletAdmin
 */
@WebServlet("/ServletAdmin")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
    public ServletAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/pfe");
            con = ds.getConnection();
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			
    		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContrainteForm form = new ContrainteForm();
		Professeur pfr = (Professeur) request.getSession().getAttribute("sessionUtilisateur");	
		ArrayList<EtudiantConnecter> liste = form.getListe(pfr);
		request.setAttribute("liste", liste);
		request.setAttribute("listeTricheurs",ClientProfesseur.getListTricheurs());
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
