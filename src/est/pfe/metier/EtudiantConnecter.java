package est.pfe.metier;

public class EtudiantConnecter{
	
	private String matierselect;
	private Etudiant etudiant;
	
	public EtudiantConnecter()
	{
		super();
	}

	public String getMatierselect() {
		return matierselect;
	}


	public void setMatierselect(String matierselect) {
		this.matierselect = matierselect;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public EtudiantConnecter(String matierselect, Etudiant etudiant) {
		super();
		this.matierselect = matierselect;
		this.etudiant = etudiant;
	}
	
	

}
