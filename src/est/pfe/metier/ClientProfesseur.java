package est.pfe.metier;

import java.sql.Connection;
import java.util.ArrayList;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.servlet.http.HttpServletRequest;

import est.pfe.dao.ServiceEtudiant;


public class ClientProfesseur {
	private static ArrayList<Etudiant> listTricheurs=new ArrayList<>();
	
	
	public boolean stopExam(String ipEtudiant)
	{
		 try
		    {   
		        // connecting to JMX
		        System.out.println("Connect to JMX service.");
		        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://"+ipEtudiant+":9991/server");
		        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
		        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

		        // Construct proxy for the the MBean object
		        ObjectName mbeanName = new ObjectName("pfe.gl.metier.Tricheur:type=TricheurMBean");
		        TricheurMBean mbeanProxy = JMX.newMBeanProxy(mbsc, mbeanName, TricheurMBean.class, true);

		          ServiceEtudiant.marquerCommeTricheur(mbeanProxy.getCneTricheur(), mbeanProxy.getCurrentExam());
	             mbeanProxy.stopExam();
		        // clean up and exit
		        jmxc.close();
		        System.out.println("Session de " +ipEtudiant+ "a ete fermer");   
		        return true;
		    }
		    catch(Exception e)
		    {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		 return false;
	}
	
	public static void declarerTricheur(Etudiant e)
	{
		listTricheurs.add(e);
	}
	public static ArrayList<Etudiant> getListTricheurs()
	{
		return listTricheurs;
	}

}
