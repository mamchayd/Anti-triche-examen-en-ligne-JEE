package est.pfe.metier;

import javax.servlet.http.HttpSession;

public class SessionUtil {

	private static Etudiant etud;
	private static int idExam;
	private static String ip;
	
	public static void setSession(HttpSession session)
	{
		etud=(Etudiant)session.getAttribute("sessionUtilisateur");
	}
	public static void setSessionIdExam(int id)
	{
		idExam=id;
	}
	public static Etudiant getSessionEtudian()
	{
		return etud;
	}
	public static int getSessionIdExam()
	{
		return idExam;
	}
	public static void setSessionIP(String ip)
	{
		ip=ip;
	}
	public static String  getSessionIP()
	{
		return ip;
	}
	
	
}
