package revue_dao;

import java.util.ArrayList;
import java.util.List;

import cpoa_DAO_metier.Revue;


public class ListeMemoireDAO_revue implements IDAO_revue {
	private static IDAO_revue instance;

	private List<Revue> data;

	/* @return un objet de type IDaoPeriodicite en singleton. */
	public static IDAO_revue getInstance() {
		if (instance == null) {
			instance = new ListeMemoireDAO_revue();
		}
		System.out.println("Je suis en mémoire");
		return instance;
	}

	private ListeMemoireDAO_revue() {
		if (data == null || data.isEmpty()) {
			data = new ArrayList<>();
			data.add(new Revue(1, "Spirou", "jsp", (float) 10.0 , "jsp", 1));
			data.add(new Revue(2, "Narvalo", "jsp", (float) 10.0, "jsp", 2));
			data.add(new Revue(3, "Disney", "jsp", (float) 10.0, "jsp", 1));
			data.add(new Revue(4, "Film", "jsp", (float) 10.0, "jsp", 2));
		}
	}

	@Override
	public Revue getById(int id) {
//		for (Periodicite periodicite : data) {
//			if (periodicite.getId() == id) {
//				return periodicite;
//			}
//		}
//		return null;
		int idx = this.data.indexOf(new Revue(id, "test", "test", (float) 0.0, "test", 0));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.data.get(idx);
		}
	}

	@Override
	public List<Revue> getAll() {
		return data;
	}

	@Override
	public boolean update(Revue objet) {
		return true;
	}

	@Override
	public boolean create(Revue objet) {
		objet.setId_revue(3);
		
		while (this.data.contains(objet)) {
			objet.setId_revue(objet.getId_revue() + 1);
		}
		return this.data.add(objet);
	}

	@Override
	public boolean delete(Revue objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return null;
	}
}
