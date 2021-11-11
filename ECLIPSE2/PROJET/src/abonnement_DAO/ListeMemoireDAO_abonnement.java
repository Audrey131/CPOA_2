package abonnement_DAO;



import java.util.ArrayList;
import java.util.List;

//import client_DAO.IllegalArgumentException;
//import client_DAO.Override;
//import client_DAO.String;
import cpoa_DAO_metier.ClientsTM;

import cpoa_DAO_metier.Abonnement;

public class ListeMemoireDAO_abonnement implements IDAO_abonnement {

	private static IDAO_abonnement instance;

	private List<Abonnement> data;

	public static IDAO_abonnement getInstance() {
		if (instance == null) {
			instance = new ListeMemoireDAO_abonnement();
		}
		System.out.println("Je suis en m�moire");
		return instance;
	}

	private ListeMemoireDAO_abonnement() {
		if (data == null || data.isEmpty()) {
			data = new ArrayList<>();
			data.add(new Abonnement(1, "une_premiere_date_de_debut","une_premiere_date_de_fin" ,1 ,1, 1));
		}	
	}
	
	@Override
	public Abonnement getById(int id_abonnement) {

		int idx = this.data.indexOf(new Abonnement(id_abonnement, "test","",1,1, 1));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
		} else {
			return this.data.get(idx);
		}
	}

	


	//_________________________________________________________________________________________________________
	
	@Override
	public List<Abonnement> getAll() {
		return data;
	}

	
	@Override
	public boolean update(Abonnement objet) {

		int idx = this.data.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.data.set(idx, objet);
		}
		
		return true;
	}

	
	@Override
	public boolean create(Abonnement objet) {
		objet.setId(3);

		while (this.data.contains(objet)) {
			objet.setId(objet.getId() + 1);
		}
		return this.data.add(objet);
	}


	@Override
	public boolean delete(Abonnement objet) {
Abonnement supprime;
		
		int idx = this.data.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.data.remove(idx);
		}
		
		return objet.equals(supprime);
	}
	
	
	
	
	

	@Override	
	public Abonnement getByDateDebut(String date_debut) {
		
		int id = this.data.indexOf(new Abonnement(1, date_debut, "", 1,1,1 ));
		if (id == -1) {
			throw new IllegalArgumentException("aucun abonnement n'a commenc� � cette date");
		} else {
			return this.data.get(id);
		}
	}

	@Override
	public Abonnement getByDatefin(String date_fin) {
		int id = this.data.indexOf(new Abonnement(1, "", date_fin, 1,1, 1 ));
		if (id == -1) {
			throw new IllegalArgumentException("Aucun abonnement ne se termine � cette date");
		} else {
			return this.data.get(id);
		}
	}
	
	@Override
	public Abonnement getByIdClient(int id_client) {
		int id = this.data.indexOf(new Abonnement(1, "", "", 1,1, 1 ));
		if (id == -1) {
			throw new IllegalArgumentException("Aucun client ne poss�de cet identifiant");
		} else {
			return this.data.get(id);
		}
	}
	
	@Override
	public Abonnement getByIdRevue(int id_revue) {
		int id = this.data.indexOf(new Abonnement(1, "", "", 1,1, 1 ));
		if (id == -1) {
			throw new IllegalArgumentException("Aucune revue ne poss�de cet identifiant");
		} else {
			return this.data.get(id);
		}
	}
	
	


	}