package cpoa_DAO_metier;

public class Adresse {
	
	private int no_adresse;
	private String voie;
	private String numVoie;
	private String code_postal;
	private String ville;
	private String pays;
	
	public int getNo_adresse() {
		return no_adresse;
	}
	public void setNo_adresse(int no_adresse) {
		this.no_adresse = no_adresse;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	
	public String getNumVoie() {
	    return numVoie;
	}
	    
	public void setNumVoie(String numVoie) {
	    this.numVoie = numVoie;
	}
	    
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}

}
