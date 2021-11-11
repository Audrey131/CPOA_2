package cpoa_DAO_metier;

/**
 * POJO
 * @author tijou7u
 *
 */
public class Abonnement {
	  
	private int id;
	private String date_debut;
	private String date_fin;
	private int id_client;
	private int id_revue;
	private int duree;
	
	public Abonnement(int id, String date_debut,String date_fin,int id_client,int id_revue, int duree) {
		this.id = id;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.id_client = id_client;
		this.id_revue = id_client;
		this.duree = duree;
	}
	
//	_____________________________________________getter_______________________________________________________________
	public int getId() {
		return id;
	}
	public String getDateDebut() {
		return date_debut;
	}
	public String getDateFin() {
		return date_fin;
	}
	public int getIdClient() {
		return id_client;
	}
	public int getIdRevue() {
		return id_revue;
	}
	public int getDuree() {
		return duree;
	}


	//________________________________________________setter_______________________________________________________
	public void setId(int id) {
		this.id = id;
	}
	public void setDateDebut(String date_debut) {
		this.date_debut = date_debut;
	}
	public void setDateFin(String date_fin) {
		this.date_fin = date_fin;
	} 
	public void setIdClient(int id_client) {
		this.id_client = id_client;
	}
	public void setIdRevue(int id_revue) {
		this.id_revue = id_revue;
	}
	public void setDuree(int Duree) {
		this.duree = Duree;
	}


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
		Periodicite other = (Periodicite) obj;
		if (id != other.getID()) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "id = " + id + "/ date_debut" + date_debut + "/ date_fin" + date_fin + "/ id_client" + id_client + "/ id_revue" +id_revue+ "/ duree" +duree;
	}
}
