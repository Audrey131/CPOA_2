package cpoa_DAO_metier;

public class Client {
	
	private int id;
	private String nom;
	private String prenom;
	private String no_rue;
	private String voie;
	private String cp;
	private String ville;
	private String pays;
	
	public Client(int id, String nom, String prenom, String no_rue, String voie, String cp, String ville, String pays) {
		this.id = id;
		this.nom = nom;
		this.no_rue = no_rue;
		this.voie = voie;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNo_rue() {
		return no_rue;
	}

	public void setNo_rue(String no_rue) {
		this.no_rue = no_rue;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
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

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", no_rue=" + no_rue + ", voie=" + voie
				+ ", cp=" + cp + ", ville=" + ville + ", pays=" + pays + "]";
	}
	
}
