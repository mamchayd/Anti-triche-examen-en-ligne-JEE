package est.pfe.metier;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import est.pfe.dao.ServiceEtudiant;



public class Etudiant {
	
	private String cne;
    private String motDePasse;
    private String nom;
    private String prenom;
    private String  adresseIP;
    private String lognicielNonAutoriser;
    private boolean sessionFermer=false;
   
    
    public Etudiant()
	{
	}
    
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
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
	public String getAdresseIP() {
		return adresseIP;
	}
	public void setAdresseIP(String adresseIP) {
		this.adresseIP = adresseIP;
	}
	
	
	
	
	public boolean isSessionFermer() {
		return sessionFermer;
	}

	public void setSessionFermer(boolean sessionFermer) {
		this.sessionFermer = sessionFermer;
	}

	public String getLognicielNonAutoriser() {
		return lognicielNonAutoriser;
	}

	public void setLognicielNonAutoriser(String lognicielNonAutoriser) {
		this.lognicielNonAutoriser = lognicielNonAutoriser;
	}

	public static Etudiant verifierEtu( HttpServletRequest request, Connection connexion )
	{
		ServiceEtudiant ListeEtu = new ServiceEtudiant();
		for(Etudiant i : ListeEtu.recupererUtilisateurs(connexion))
		{
			if(i.getCne().equals(request.getParameter("username")) && i.getMotDePasse().equals(request.getParameter("motdepasse")))
				return ListeEtu.recupererUtilisateur(connexion, request, i);
		}
		return null;
	}
	
	
	
		
	

}
