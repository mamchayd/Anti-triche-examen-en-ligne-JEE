package est.pfe.metier;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import est.pfe.dao.ServiceExamens;


public class ProfileForm {
	
	
	public void recupereEtudiants(HttpServletRequest request,Connection connexion)
	{
		
	}
	
	public ArrayList<Examen> recupereExamensPro(HttpServletRequest request, Connection connexion)
	{
		ServiceExamens form = new ServiceExamens();
		ArrayList<Examen> liste = new ArrayList<>();
		for( Examen i : form.recupererExamens(connexion)){
			Professeur user=(Professeur)request.getSession().getAttribute("sessionUtilisateur");
			if(user.getMatiere().equals(i.getMatiere()))
				liste.add(i);
		}
		return liste;
	}

}
