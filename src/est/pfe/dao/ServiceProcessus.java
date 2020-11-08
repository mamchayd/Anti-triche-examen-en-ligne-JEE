package est.pfe.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import est.pfe.metier.Processus;


public class ServiceProcessus {
	
	 public ArrayList<Processus> recupererProcessusBD(Connection connexion) {
	        ArrayList<Processus> Processus = new ArrayList<Processus>();
	        Statement statement = null;
	        ResultSet resultat = null;
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT * FROM `processus_nonautoriser`");

	            // Récupération des données
	            while (resultat.next()) {
	                String cin = resultat.getString("nom_pros");
	                
	                Processus Processu = new Processus();
	                Processu.setNomPros(cin);
	                
	                Processus.add(Processu);
	            }
	        } catch (SQLException e) {
	        } finally {
	            // Fermeture de la connexion
	            try {
	                if (resultat != null)
	                    resultat.close();
	                if (statement != null)
	                    statement.close();
	            } catch (SQLException ignore) {
	            }
	        }
	        
	        return Processus;
	    }


}
