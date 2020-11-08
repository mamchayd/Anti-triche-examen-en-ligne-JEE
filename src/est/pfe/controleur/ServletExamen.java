package est.pfe.controleur;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import est.pfe.dao.ServiceEtudiant;
import est.pfe.metier.AgentEtudiant;
import est.pfe.metier.SessionUtil;
import est.pfe.metier.Tricheur;
import est.pfe.metier.TricheurMBean;



@WebServlet("/ServletExamen")
public class ServletExamen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

    public ServletExamen() {
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
		if(ServiceEtudiant.checkIfTrich()){
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			   ipAddress = request.getRemoteAddr();
		}
		TricheurMBean t=new Tricheur();
		t.setSessionExam();
		SessionUtil.setSessionIP(ipAddress);
		AgentEtudiant ag = new AgentEtudiant(response, con);
		ag.start();
		this.getServletContext().getRequestDispatcher( "/Examen.jsp" ).forward( request, response );
		}else
		{
			response.sendRedirect("Erreur.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
