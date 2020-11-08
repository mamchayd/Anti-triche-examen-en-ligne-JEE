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
import javax.sql.DataSource;

import est.pfe.metier.ContrainteForm;
import est.pfe.metier.Etudiant;
import est.pfe.metier.SessionUtil;

@WebServlet("/ServletContrainte")
public class ServletContrainte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

    public ServletContrainte() {
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
		String s = request.getParameter("matiere");
		Etudiant e = (Etudiant) request.getSession().getAttribute("sessionUtilisateur");
		SessionUtil.setSessionIdExam(Integer.valueOf(request.getParameter("idexam")));
		SessionUtil.setSessionIP(request.getRemoteAddr());
		ContrainteForm form = new ContrainteForm();
		form.insererEtudiant(s, e);
		this.getServletContext().getRequestDispatcher("/Contraints.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
