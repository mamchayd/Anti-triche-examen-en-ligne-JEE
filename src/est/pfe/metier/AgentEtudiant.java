package est.pfe.metier;

import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.sql.Connection;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AgentEtudiant extends Thread{
	
	MBeanServer mbs =null;
	ObjectName name = null;
	JMXConnectorServer cs=null;
	static HttpServletResponse response;
	Connection con;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		startExam();
	}
	public AgentEtudiant(HttpServletResponse response, Connection con)
	{
		AgentEtudiant.response=response;
		this.con=con;
	}
	public void startExam()
	{
	    try {
	      System.out.println("start MBean Agent");
	      name = new ObjectName("pfe.gl.metier.Tricheur:type=TricheurMBean");
	      TricheurMBean mbean = new Tricheur(Thread.currentThread());
	      mbs = ManagementFactory.getPlatformMBeanServer();
	      LocateRegistry.createRegistry(9991);
	      mbs.registerMBean(mbean, name);

	      // Creation et demarrage du connecteur RMI
	      System.out.println(SessionUtil.getSessionIP()+"---------------");
	      JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9991/server");
	       cs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
	      cs.start();
	      System.out.println("Lancement connecteur RMI "+url);
	      //Etudiant etud=(Etudiant)AgentEtudiant.request.getSession().getAttribute("sessionUtilisateur");
	      Etudiant etud=SessionUtil.getSessionEtudian();
	     // System.err.println(etud.getNom());
	      boolean a = false;
	      while (!a) {
	    	a = mbean.recupererProcessus(etud, con,SessionUtil.getSessionIdExam());
			Thread.sleep(10000);			
		}
	      ClientProfesseur.declarerTricheur(etud);
	      System.out.println(etud.getLognicielNonAutoriser());
	      System.out.println("-----Pross detected--------");
	      
	      
	    } 
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	
	public static HttpServletResponse getSessionResponse()
	{
		return  AgentEtudiant.response;
	}
}
