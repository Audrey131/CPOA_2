package periodicite_dao;

/**
 * 
 * @author girard144u
 *
 */

import java.util.ArrayList;
import java.util.List;

import cpoa_DAO_metier.Periodicite;
import cpoa_DAO_metier.Revue;

public class ListeMemoireDAO_periodicite implements IDAO_periodicite {

	private static IDAO_periodicite instance;

	private List<Periodicite> data;

	public static IDAO_periodicite getInstance() {
		if (instance == null) {
			instance = new ListeMemoireDAO_periodicite();
		}
		System.out.println("Je suis en mémoire");
		return instance;
	}

	private ListeMemoireDAO_periodicite() {
		if (data == null || data.isEmpty()) {
			data = new ArrayList<>();
			data.add(new Periodicite(1, "Journalière"));
			data.add(new Periodicite(2, "Hebdomadaire"));
			data.add(new Periodicite(3, "Mensuelle"));
			data.add(new Periodicite(4, "Annuelle"));
		}
	}

	@Override
	public Periodicite getById(int id) {
		
		int idx = this.data.indexOf(new Periodicite(id, "test"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.data.get(idx);
		}
	}

	@Override
	public List<Periodicite> getAll() {
		return data;
	}

	@Override
	public boolean update(Periodicite objet) {
		int idx = this.data.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.data.set(idx, objet);
		}
		
		return true;
	}

	@Override
	public boolean create(Periodicite objet) {
		objet.setNo(3);
		
		while (this.data.contains(objet)) {
			objet.setNo(objet.getID() + 1);
		}
		return this.data.add(objet);
	}

	@Override
	public boolean delete(Periodicite objet) {
		Periodicite supprime;
		
		int idx = this.data.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.data.remove(idx);
		}
		
		return objet.equals(supprime);
	}

	@Override
	public List<Periodicite> getByLibelle(String libelle) {
		return (ArrayList<Periodicite>) this.data;
	}
}
