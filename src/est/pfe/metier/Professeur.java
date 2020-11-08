package est.pfe.metier;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import est.pfe.dao.ServiceProfesseur;



public class Professeur {
	
	private String cin;
    private String motDePasse;
    private String nom;
    private String prenom;
    private String matiere;
    
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public static Professeur verifierPro( HttpServletRequest request, Connection connexion )
	{
		ServiceProfesseur ListePro = new ServiceProfesseur();
		for(Professeur i : ListePro.recupererUtilisateurs(connexion))
		{
			if(i.getCin().equals(request.getParameter("username")) && i.getMotDePasse().equals(request.getParameter("motdepasse")))
				return i;
		}
		return null;
	}
    

}
