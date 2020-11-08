package est.pfe.metier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import est.pfe.dao.ServiceProcessus;

public class Tricheur implements TricheurMBean{
    private static String pross;
    private static int idExamDemarrer;
    private static String cneTricheur;
    private Thread m_thrd = null;
    private static boolean sessionIsRuning=true;
    
    public Tricheur()
    {  }
	
    
    public Tricheur(Thread thrd)
    {
    	m_thrd = thrd;
    }
	


	@Override
	public int getCurrentExam() {
		return idExamDemarrer;
	}
	
	@Override
	public String getCneTricheur() {
		return cneTricheur;
	}
	
	public String getListePross() {
		return pross;
	}



	@Override
	public boolean recupererProcessus(Etudiant user, Connection con,int idexam) {
		String line;
		Process p = null;
		boolean a = false;
		ServiceProcessus prs = new ServiceProcessus();
		ArrayList<Processus> liste = prs.recupererProcessusBD(con);
		if(!user.getCne().matches("[A-Z][1-9]+"))
		{
			Tricheur.cneTricheur=user.getCne();
			Tricheur.idExamDemarrer=idexam;
			try{
				if(System.getProperty("os.name").contains("Windows")){
					p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
				}
				else if(System.getProperty("os.name").contains("Mac os")){
					p = Runtime.getRuntime().exec("ps -e");
				}	
				BufferedReader input =  new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = input.readLine()) != null) {
					//System.out.println(line);
					for(Processus i : liste){
				    	if(line.contains(i.getNomPros())){
				    		user.setLognicielNonAutoriser(i.getNomPros());
				    		a = true;
				    	}
				    }
				}
				input.close();
			}catch(Exception e)
			{
			System.out.println(e.getMessage());
			}
		}
		else
			System.out.println("juste l'etudiant peut entrer à cet page");
		return a;
	}



	@Override
	public void stopExam() {
		try {
			sessionIsRuning=false;
			//m_thrd.stop();
		} catch (Exception e) {
		}
	}



	@Override
	public boolean isSessionExamDemarer() {
		return sessionIsRuning;
	}


	@Override
	public void setSessionExam() {
		this.sessionIsRuning=true;
	}
	
	

}
