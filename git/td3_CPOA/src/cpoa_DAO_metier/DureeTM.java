package cpoa_DAO_metier;

import cpoa_DAO_metier.DureeTM;

/**
 * 
 * @author marotta9u
 *
 */

public class DureeTM {

	private int id_duree;
	private String libelle_formule;

	public DureeTM(int id_duree, String libelle_formule) {
		this.id_duree = id_duree;
		this.libelle_formule = libelle_formule;
	}

	//==============ci-dessous les getters=================
	
	public int getId_duree() {
		return id_duree;
	}

	public String getLibelle_formule() {
		return libelle_formule;
	}

	//==============ci-dessous les setters=================
	
	public void setId(int id_duree) {
		this.id_duree = id_duree;
	}

	public void setLibelle_formule(String libelle_formule) {
		this.libelle_formule = libelle_formule;
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
		DureeTM other = (DureeTM) obj;
		if (id_duree != other.getId_duree()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Id_duree = " + id_duree + " / libelle_formule = " + libelle_formule;
	}

}
