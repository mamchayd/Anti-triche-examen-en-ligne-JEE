package est.pfe.dao;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import est.pfe.metier.Etudiant;
import est.pfe.metier.SessionUtil;



public class ServiceEtudiant {

    public ArrayList<Etudiant> recupererUtilisateurs(Connection connexion) {
    	ArrayList<Etudiant> utilisateurs = new ArrayList<Etudiant>();
        Statement statement = null;
        ResultSet resultat = null;
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT * FROM etudiant;");

            // Récupération des données
            while (resultat.next()) {
                String cne = resultat.getString("cne");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String password = resultat.getString("motdepasse");
                
                Etudiant utilisateur = new Etudiant();
                utilisateur.setCne(cne);
                utilisateur.setNom(nom);
                utilisateur.setPrenom(prenom);
                utilisateur.setMotDePasse(password);
                
                utilisateurs.add(utilisateur);
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
        
        return utilisateurs;
    }
    public Etudiant recupererUtilisateur(Connection connexion, HttpServletRequest request, Etudiant utilisateur) {
        Statement statement = null;
        ResultSet resultat = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connexion.prepareStatement("UPDATE etudiant SET adresse_IP = ? WHERE cne = "+utilisateur.getCne()+" ;");
            preparedStatement.setString(1, utilisateur.getAdresseIP());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT * FROM etudiant  WHERE cne = "+utilisateur.getCne()+" ;");

            // Récupération des données
            
                String cne = resultat.getString("cne");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String password = resultat.getString("motdepasse");
                String adresseIP = resultat.getString("adresse_IP");
                utilisateur = new Etudiant();
                utilisateur.setCne(cne);
                utilisateur.setNom(nom);
                utilisateur.setPrenom(prenom);
                utilisateur.setMotDePasse(password);
                utilisateur.setAdresseIP(adresseIP);
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
        
		return utilisateur;
    }
    public static int marquerCommeTricheur(String cne,int id_exam)
    {
    	 Context ctx;
    	 Connection connexion=null;
		try {
			ctx = new InitialContext();
	         DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/pfe");
	          connexion = ds.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connexion.prepareStatement("INSERT INTO tricheurs values(?,?,?) ;");
            preparedStatement.setString(1,cne );
            preparedStatement.setInt(2, id_exam);
            preparedStatement.setString(3, new Date().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return 0;
    }
    
    public static boolean checkIfTrich()
    {
    	String cne=SessionUtil.getSessionEtudian().getCne();
    	int id_exam=SessionUtil.getSessionIdExam();
    	 Context ctx;
    	 Connection connexion=null;
		try {
			ctx = new InitialContext();
	         DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/pfe");
	          connexion = ds.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connexion.prepareStatement("SELECT * FROM tricheurs where cne_etudiant=? and id_examen=?;");
            preparedStatement.setString(1,cne );
            preparedStatement.setInt(2, id_exam);
            
            ResultSet resultat =preparedStatement.executeQuery();
            if(resultat.next() )
            	return false;
            else
            	return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return true;
    }
    

   
}