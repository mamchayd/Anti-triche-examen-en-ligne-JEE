package est.pfe.metier;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface TricheurMBean {
	

	public boolean recupererProcessus(Etudiant user, Connection con,int idexam);
	public int getCurrentExam();
	public String getCneTricheur();
	public boolean isSessionExamDemarer();
	public void setSessionExam();
	public void stopExam();
	
}
