package est.pfe.controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import est.pfe.metier.ContrainteForm;
import est.pfe.metier.Etudiant;


@WebServlet("/Deconnection")
public class Deconnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Deconnection() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	System.out.println("init decon");

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionEtudiant") != null){
		Etudiant e = (Etudiant) session.getAttribute("sessionUtilisateur");
		ContrainteForm.supprimer(e);
		request.getSession().invalidate();
		System.out.println("post decon");
    	response.sendRedirect( "ServletLogin" );
		}
		else{
		request.getSession().invalidate();
		System.out.println("post decon");
    	response.sendRedirect( "ServletLogin" );
		}
	}

}
