package est.pfe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import est.pfe.metier.Professeur;


public class ServiceProfesseur {
	
    public List<Professeur> recupererUtilisateurs(Connection connexion) {
        List<Professeur> utilisateurs = new ArrayList<Professeur>();
        Statement statement = null;
        ResultSet resultat = null;
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT * FROM professeur;");

            // Récupération des données
            while (resultat.next()) {
                String cin = resultat.getString("cin");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String password = resultat.getString("motdepasse");
                String matiere = resultat.getString("matiere");
                Professeur utilisateur = new Professeur();
                utilisateur.setCin(cin);
                utilisateur.setNom(nom);
                utilisateur.setPrenom(prenom);
                utilisateur.setMotDePasse(password);
                utilisateur.setMatiere(matiere);
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

}
