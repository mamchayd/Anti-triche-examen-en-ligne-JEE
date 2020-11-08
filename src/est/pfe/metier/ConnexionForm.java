package est.pfe.metier;

import java.sql.Connection;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class ConnexionForm {
    private static final String CHAMP_USERNAME  = "username";
    private static final String CHAMP_PASS   = "motdepasse";
    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();
    public HttpSession session;
    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void connecterUtilisateur( HttpServletRequest request, Connection connexion ) {
        /* Récupération des champs du formulaire */
        String username = getValeurChamp( request, CHAMP_USERNAME );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );


        /* Validation du champ username. */
        try {
            validationUsername( username );
        } catch ( Exception e ) {
            setErreur( CHAMP_USERNAME, e.getMessage() );
        }

        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( motDePasse );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() )
        {
        	if(!verfifcationUtilisateur(request))
        	{
        		Etudiant etu = Etudiant.verifierEtu(request, connexion);
        		if(etu != null)
        		{
            		etu.setAdresseIP(request.getRemoteAddr());
        			/* Récupération de la session depuis la requête */
        	        session = request.getSession();
        	        session.setAttribute( "sessionUtilisateur", etu );
        	        session.setAttribute( "sessionEtudiant", etu );
        	        request.setAttribute("utilisateur", etu);
        	        SessionUtil.setSession(session);

        		}
            	else resultat = "Échec de la connexion.";
        	}
        	else
        	{
        		Professeur pfr = Professeur.verifierPro(request, connexion);
        		if(pfr != null)
        		{
        			/* Récupération de la session depuis la requête */
        	        session = request.getSession();
        	        session.setAttribute( "sessionUtilisateur", pfr );
        	        request.setAttribute("utilisateur", pfr);
        		}
            	else resultat = "Échec de la connexion.";
        	}
        	
        } else 
        {
        	//session.setAttribute( "sessionUtilisateur", null );
            resultat = "Échec de la connexion.";
        }

    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationUsername( String username ) throws Exception {
        if ( username == null  ) {
            throw new Exception( "Merci de saisir un username valide." );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String motDePasse ) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    public String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
    
    public boolean verfifcationUtilisateur(HttpServletRequest request)
    {
    	String s = request.getParameter("username");
    	if(s.matches("[A-Z][1-9]+"))
    		return true;
    	else 
    		return false;
    }
}