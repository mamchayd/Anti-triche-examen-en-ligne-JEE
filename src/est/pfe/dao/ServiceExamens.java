package est.pfe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import est.pfe.metier.Examen;


public class ServiceExamens {
	
    public ArrayList<Examen> recupererExamens(Connection connexion) {
    	ArrayList<Examen> examens = new ArrayList<Examen>();
        Statement statement = null;
        ResultSet resultat = null;

        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("     SELECT id_examen,matiere,nom,prenom, date_debut,date_fin "
            								   + "	from examen, professeur "
            								   + "	WHERE examen.cin = professeur.cin order by date_debut ;");

            // Récupération des données
            while (resultat.next()) {
            	String matiere = resultat.getString("matiere");
            	String nomPro = resultat.getString("nom")+" "+resultat.getString("prenom");
            	String dateDebut = resultat.getString("date_debut");
            	String datefin = resultat.getString("date_fin");
            	int idExam=resultat.getInt("id_examen");
            	
                Examen examen = new Examen();
                examen.setMatiere(matiere);
                examen.setNomPro(nomPro);
                examen.setDateDebut(dateDebut);
                examen.setDateFin(datefin);
                examen.setIdExam(idExam);
                
                examens.add(examen);
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
        
        return examens;
    }
    


}
