package est.pfe.controleur;

import java.io.IOException;

import java.sql.Connection;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import est.pfe.dao.ServiceExamens;
import est.pfe.metier.Examen;


@WebServlet("/ServletProfileEtu")
public class ServletProfileEtu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LISTE = "liste";
	Connection con;

    public ServletProfileEtu() {
        super();
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
			ServiceExamens examen = new ServiceExamens();
			ArrayList<Examen> liste = examen.recupererExamens(con);
			request.setAttribute("examens", liste);
			this.getServletContext().getRequestDispatcher("/ProfileEtudiant.jsp").forward(request, response);
	    	

			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect( "Deconnection" );
	}
	
	
}
