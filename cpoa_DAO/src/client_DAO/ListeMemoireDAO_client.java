package client_DAO; 	

/**
 * 
 * @author marotta9u
 *
 */

import java.util.ArrayList;
import java.util.List;

import cpoa_DAO_metier.ClientsTM;
import cpoa_DAO_metier.Periodicite;


public class ListeMemoireDAO_client implements IDAO_client {

	private static IDAO_client instance;

	private List<ClientsTM> data;

	public static IDAO_client getInstance() {
		if (instance == null) {
			instance = new ListeMemoireDAO_client();
		}
		System.out.println("Je suis en mémoire");
		return instance;
	}

	private ListeMemoireDAO_client() {
		if (data == null || data.isEmpty()) {
			data = new ArrayList<>();
			data.add(new ClientsTM(1, "TIJOU", "Allan", "8", "antoine_louis", "58000", "Paris", "Espagne"));
		}
	}

	@Override
	public ClientsTM getById(int id_client) {
		
		int idx = this.data.indexOf(new ClientsTM(id_client, "TIJOU", "Allan", "8", "antoine_louis", "58000", "Paris", "Espagne"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.data.get(idx);
		}
	}

	@Override
	public List<ClientsTM> getAll() {
		return data;
	}

	@Override
	public boolean update(ClientsTM objet) {
		
		
		int idx = this.data.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.data.set(idx, objet);
		}
		
		return true;
	}

	@Override
	public boolean create(ClientsTM objet) {
		objet.setId(3);
		while (this.data.contains(objet)) {
			objet.setId(objet.getId_client() + 1);
		}
		return this.data.add(objet);
	}

	@Override
	public boolean delete(ClientsTM objet) {

		ClientsTM delete;
		
		int idx = this.data.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			delete = this.data.remove(idx);
		}
		
		return objet.equals(delete);
	}

	@Override	
	public ClientsTM getByNom(String nom) {
		
		int id = this.data.indexOf(new ClientsTM(1, nom, "test", "test","test", "test", "test", "test"));
		if (id == -1) {
			throw new IllegalArgumentException("Aucun client ne possède ce nom");
		} else {
			return this.data.get(id);
		}
	}

	@Override
	public ClientsTM getByPrenom(String prenom) {
		int id = this.data.indexOf(new ClientsTM(1, "test", prenom, "test","test", "test", "test", "test"));
		if (id == -1) {
			throw new IllegalArgumentException("Aucun client ne possède ce prénom");
		} else {
			return this.data.get(id);
		}
	}
	
	@Override
	public ClientsTM getByNo_rue(String no_rue) {
		int id = this.data.indexOf(new ClientsTM(1, "test", "test", no_rue,"test", "test", "test", "test"));
		if (id == -1) {
			throw new IllegalArgumentException("Aucun client ne possède ce nom");
		} else {
			return this.data.get(id);
		}
	}
	
	@Override
	public ClientsTM getByVoie(String voie) {
		int id = this.data.indexOf(new ClientsTM(1, "test", "test", "test",voie, "test", "test", "test"));
		if (id == -1) {
			throw new IllegalArgumentException("Aucun client ne possède ce nom");
		} else {
			return this.data.get(id);
		}
	}
	
	@Override
	public ClientsTM getByCode_postal(String code_postal) {
		int id = this.data.indexOf(new ClientsTM(1, "test", "test", "test","test", code_postal, "test", "test"));
		if (id == -1) {
			throw new IllegalArgumentException("Aucun client ne possède ce nom");
		} else {
			return this.data.get(id);
		}
	}
	
	@Override
	public ClientsTM getByVille(String ville) {
		int id = this.data.indexOf(new ClientsTM(1, "test", "test", "test","test", "test", ville, "test"));
		if (id == -1) {
			throw new IllegalArgumentException("Aucun client ne possède ce nom");
		} else {
			return this.data.get(id);
		}
	}
	
	@Override
	public ClientsTM getByPays(String pays) {
		int id = this.data.indexOf(new ClientsTM(1, "test", "test", "test","test", "test", "test", pays));
		if (id == -1) {
			throw new IllegalArgumentException("Aucun client ne possède ce nom");
		} else {
			return this.data.get(id);
		}
	}

}

