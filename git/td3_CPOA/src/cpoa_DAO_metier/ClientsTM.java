package cpoa_DAO_metier;

/**
 * 
 * @author marotta9u
 *
 */

public class ClientsTM {
	
	private Adresse adresse;

	private int id_client;
	private String nom;
	private String prenom;
	private String no_rue;
	private String voie;
	private String code_postal;
	private String ville;
	private String pays;

	public ClientsTM(int id_client, String nom, String prenom, String no_rue, String voie, String code_postal, String ville, String pays) {
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.no_rue = no_rue;
		this.voie = voie;
		this.code_postal = code_postal;
		this.ville = ville;
		this.pays = pays;
	}

	//==============ci-dessous les getters=================
	
	public int getId_client() {
		return id_client;
	}

	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getNoRue() {
		return no_rue;
	}
	
	public String getVoie() {
		return voie;
	}
	
	public String getCodePostal() {
		return code_postal;
	}
	
	public String getVille() {
		return ville;
	}
	
	public String getPays() {
		return pays;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}

	//==============ci-dessous les setters=================
	
	public void setId(int id_client) {
		this.id_client = id_client;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setNoRue(String no_rue) {
		this.no_rue = no_rue;
	}
	
	public void setVoie(String voie) {
		this.voie = voie;
	}
	
	public void setCodePostal(String code_postal) {
		this.code_postal = code_postal;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public void setPays(String pays) {
		this.pays = pays;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	//===============================

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ClientsTM other = (ClientsTM) obj;
		if (id_client != other.getId_client()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Id_client = " + id_client + " / Nom = " + nom + " / Prenom = " + prenom + "NoRue = " + no_rue + " / Voie = " + voie + " / CodePostal = " + code_postal + " / Ville = " + ville + " / Pays = " + pays;
	}

	
}
