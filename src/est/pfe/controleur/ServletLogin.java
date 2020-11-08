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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import est.pfe.metier.ConnexionForm;

import java.net.*;
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE              = "/Login.jsp";
    public static final String LISTE              = "liste";
    Connection con;
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	try {
    		//Class.forName("com.mysql.jdbc.Driver");
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/pfe");
            con = ds.getConnection();
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			
    		}
    }
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	/* Préparation de l'objet formulaire */
    	ConnexionForm form = new ConnexionForm();
    	
        /* Traitement de la requête et récupération du bean en résultant */
    	form.connecterUtilisateur(request, con);
    	
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        
        if(!form.getErreurs().isEmpty())
        	this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        else if(form.verfifcationUtilisateur(request)){
        	response.sendRedirect( "ServletProfilePro" );
        }else
        	response.sendRedirect( "ServletProfileEtu" );
    }
    

}
