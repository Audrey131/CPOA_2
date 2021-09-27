package cpoa_DAO_metier;

import java.sql.Date;

public class Abonnement {
	
	private int id_abo;
	private int id_cl;
	private int id_revue;
	private Date datedeb;
	private Date datefin;
	
	public Abonnement(int id_abo, int id_cl, int id_revue, Date datedeb, Date datefin) {
		this.id_abo = id_abo;
		this.id_cl = id_cl;
		this.id_revue = id_revue;
		this.datedeb = datedeb;
		this.datefin = datefin;
	}

	public int getId_abo() {
		return id_abo;
	}

	public void setId_abo(int id_abo) {
		this.id_abo = id_abo;
	}

	public int getId_cl() {
		return id_cl;
	}

	public void setId_cl(int id_cl) {
		this.id_cl = id_cl;
	}

	public int getId_revue() {
		return id_revue;
	}

	public void setId_revue(int id_revue) {
		this.id_revue = id_revue;
	}

	public Date getDatedeb() {
		return datedeb;
	}

	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	@Override
	public String toString() {
		return "Abonnement [id_abo=" + id_abo + ", id_cl=" + id_cl + ", id_revue=" + id_revue + ", datedeb=" + datedeb
				+ ", datefin=" + datefin + "]";
	}

}
