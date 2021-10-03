package duree_DAO;

/**
 * 
 * @author marotta9u
 *
 */

import java.util.ArrayList;
import java.util.List;

import cpoa_DAO_metier.DureeTM;
import cpoa_DAO_metier.Revue;


public class ListeMemoireDaoDureeTM implements IDAO_duree {

	private static IDAO_duree instance;

	private List<DureeTM> data;

	public static IDAO_duree getInstance() {
		if (instance == null) {
			instance = new ListeMemoireDaoDureeTM();
		}
		System.out.println("Je suis en mémoire");
		return instance;
	}

	private ListeMemoireDaoDureeTM() {
		if (data == null || data.isEmpty()) {
			data = new ArrayList<>();
			data.add(new DureeTM(1, "TIJOU")); 
		}
	}

	@Override
	public DureeTM getById(int id_duree) {
		
		int idx = this.data.indexOf(new DureeTM(id_duree, "TIJOU"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.data.get(idx);
		}
	}

	@Override
	public List<DureeTM> getAll() {
		return data;
	}

	@Override
	public boolean update(DureeTM objet) {
		

		int idx = this.data.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.data.set(idx, objet);
		}
		
		return true;
	}

	@Override
	public boolean create(DureeTM objet) {
		objet.setId(3);
		while (this.data.contains(objet)) {
			objet.setId(objet.getId_duree() + 1);
		}
		return this.data.add(objet);
	}

	@Override
	public boolean delete(DureeTM objet) {

		DureeTM delete;
		
		int idx = this.data.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			delete = this.data.remove(idx);
		}
		
		return objet.equals(delete);
	}

	@Override	
	public List<DureeTM> getByLibelle_formule(String libelle_formule) {
		return (ArrayList<DureeTM>) this.data;
	}

}


