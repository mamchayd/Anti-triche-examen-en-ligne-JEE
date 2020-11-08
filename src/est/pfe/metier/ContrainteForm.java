package est.pfe.metier;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ContrainteForm {
	private static ArrayList<EtudiantConnecter> liste = new ArrayList<>();
	public void insererEtudiant(String s, Etudiant e)
	{
		EtudiantConnecter etu = new EtudiantConnecter(s,e);
		liste.add(etu);
	}
	public ArrayList<EtudiantConnecter> getListe(Professeur pfr) {
		ArrayList<EtudiantConnecter> liste1 = new ArrayList<>();
		for(EtudiantConnecter i : liste)
		{
			if(pfr.getMatiere().equals(i.getMatierselect())){
				liste1.add(i);
			}
		}
		return liste1;
	}
	
	public static void supprimer(Etudiant e)
	{
		Iterator<EtudiantConnecter> itr = liste.iterator();
		while(itr.hasNext())
		{
			if(itr.next().getEtudiant().equals(e))
			{
				itr.remove();
			}
		}
	}

	
}
