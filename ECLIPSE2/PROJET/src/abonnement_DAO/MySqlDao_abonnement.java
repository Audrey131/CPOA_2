package abonnement_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cpoa_DAO.*;
import cpoa_DAO_metier.Abonnement;



/* Cette classe va simuler un accès à la DB. */
public class MySqlDao_abonnement implements IDAO_abonnement {

	private static MySqlDao_abonnement instance;
	private Connexion connexion;


	public static MySqlDao_abonnement getInstance() {
		if (instance == null) {
			instance = new MySqlDao_abonnement();
		}
		System.out.println("Je suis en SQL");
		return instance;
	}

	private MySqlDao_abonnement() {
		connexion = new Connexion();
		
	}
	
	@Override
	public Abonnement getById(int id) {
		Abonnement a = null;
		Connection laConnexion = connexion.creeConnexion();
		
		try {

			
			PreparedStatement requete = laConnexion.prepareStatement("select * from Abonnement where id_abonnement=?");
			requete.setInt(1, id);
			ResultSet res = requete.executeQuery();
			while (res.next()) {
				int id_abonnement = res.getInt("id_abonnement");
				String date_debut = res.getString("date_debut");
				String date_fin = res.getString("date_fin");	
				int id_client = res.getInt("id_client");
				int id_revue = res.getInt("id_revue");
				
				Abonnement Abo = new Abonnement (id_abonnement, date_debut, date_fin,id_client,id_revue);
				
				a = new Abonnement(res.getInt(1), res.getString("date_debut"),res.getString("date_fin"),res.getInt(1),res.getInt(1));
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return a;
	}

	//________________________________________________________________________________________________________
	@Override
	public Abonnement getByDateDebut(String date_debut1) {
			Abonnement a = null;
			Connection laConnexion = connexion.creeConnexion();
		
		try {
			
			PreparedStatement requete = laConnexion.prepareStatement("select * from Abonnement where date_debut1=?");
			requete.setString(1, date_debut1);
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				int id_abonnement = res.getInt("id_abonnement");
				String date_debut = res.getString("date_debut");
				String date_fin = res.getString("date_fin");	
				int id_client = res.getInt("id_client");
				int id_revue = res.getInt("id_revue");
				
				Abonnement Abo = new Abonnement (id_abonnement, date_debut, date_fin,id_client,id_revue);
				
				a = new Abonnement(res.getInt(1), res.getString("date_debut"),res.getString("date_fin"),res.getInt(1),res.getInt(1));
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return a;
		
		
		

	}
	
	
	
	@Override
	public Abonnement getByDatefin(String date_fin1) {
		Abonnement a = null;
		Connection laConnexion = connexion.creeConnexion();
				
				try {

					
					PreparedStatement requete = laConnexion.prepareStatement("select * from Abonnement where date_fin1=?");
					requete.setString(1, date_fin1);
					ResultSet res = requete.executeQuery();
					
					while (res.next()) {
						int id_abonnement = res.getInt("id_abonnement");
						String date_debut = res.getString("date_debut");
						String date_fin = res.getString("date_fin");	
						int id_client = res.getInt("id_client");
						int id_revue = res.getInt("id_revue");
						
						Abonnement Abo = new Abonnement (id_abonnement, date_debut, date_fin,id_client,id_revue);
						
						a = new Abonnement(res.getInt(1), res.getString("date_debut"),res.getString("date_fin"),res.getInt(1),res.getInt(1));
					}
				} catch (SQLException sqle) {
					System.out.println("Pb select" + sqle.getMessage());
				}
				return a;
		
	}
	
	
	@Override
	public Abonnement getByIdClient(int id_client1) {
		Abonnement a = null;
		Connection laConnexion = connexion.creeConnexion();
				
				try {
		
					
					PreparedStatement requete = laConnexion.prepareStatement("select * from Abonnement where id_client1=?");
					requete.setInt(1, id_client1);
					ResultSet res = requete.executeQuery();
					
					while (res.next()) {
						int id_abonnement = res.getInt("id_abonnement");
						String date_debut = res.getString("date_debut");
						String date_fin = res.getString("date_fin");	
						int id_client = res.getInt("id_client");
						int id_revue = res.getInt("id_revue");
						
						Abonnement Abo = new Abonnement (id_abonnement, date_debut, date_fin,id_client,id_revue);
						
						a = new Abonnement(res.getInt(1), res.getString("date_debut"),res.getString("date_fin"),res.getInt(1),res.getInt(1));
					}
				} catch (SQLException sqle) {
					System.out.println("Pb select" + sqle.getMessage());
				}
				return a;
		
	}
	

	@Override
	public Abonnement getByIdRevue(int id_revue1) {
		Abonnement a = null;
		Connection laConnexion = connexion.creeConnexion();
				
				try {
		
					
					PreparedStatement requete = laConnexion.prepareStatement("select * from Abonnement where id_revue1=?");
					requete.setInt(1, id_revue1);
					ResultSet res = requete.executeQuery();
					
					while (res.next()) {
						int id_abonnement = res.getInt("id_abonnement");
						String date_debut = res.getString("date_debut");
						String date_fin = res.getString("date_fin");	
						int id_client = res.getInt("id_client");
						int id_revue = res.getInt("id_revue");
						
						Abonnement Abo = new Abonnement (id_abonnement, date_debut, date_fin,id_client,id_revue);
						
						a = new Abonnement(res.getInt(1), res.getString("date_debut"),res.getString("date_fin"),res.getInt(1),res.getInt(1));
					}
				} catch (SQLException sqle) {
					System.out.println("Pb select" + sqle.getMessage());
				}
				return a;
		
	}

	
	//_________________________________________________________________________________________________________
	
	@Override
	public List<Abonnement> getAll() {
		List<Abonnement> liste = new ArrayList<>();
		
		return liste;
	}

	
	
	@Override
		public boolean update(Abonnement objet) {
			
			
			try {
				Connection laConnexion = connexion.creeConnexion();
				Statement requete1 = laConnexion.createStatement();
				
				PreparedStatement requete = laConnexion.prepareStatement("update Abonnement set id_abonnement=?, date_debut=?, date_fin=?, id_client=? , id_revue=? where id_abonnement=?");
				
				requete.setInt(1,objet.getId());
				requete.setString(2,objet.getDateDebut());
				requete.setString(3,objet.getDateFin());
				requete.setInt(4,objet.getIdClient());
				requete.setInt(5,objet.getIdRevue());
			

				int nbLignes = requete.executeUpdate();
				
				System.out.println("La modification de l'abonnement a été effectuée");
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;

			}
			
			

	}


	
	
	@Override
	public boolean create(Abonnement objet){
		
		try {
		
		Connection laConnexion = connexion.creeConnexion();
		Statement requete1 = laConnexion.createStatement();
		
		PreparedStatement requete = laConnexion.prepareStatement("insert into Abonnement values (id_abonnement=?, date_debut=?, date_fin=?, id_client=? , id_revue=?) where id_abonnement=?");
		
		requete.setInt(1,objet.getId());
		requete.setString(2,objet.getDateDebut());
		requete.setString(3,objet.getDateFin());
		requete.setInt(4,objet.getIdClient());
		requete.setInt(5,objet.getIdRevue());
	

		int nbLignes = requete.executeUpdate();
		
		System.out.println("L'ajout de l'abonnement a été effectuée");
		return true;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}
		
	}
		


	
		
		@Override
		public boolean delete(Abonnement objet){
			
			
			try {
				Connection laConnexion = connexion.creeConnexion();
				Statement requete1 = laConnexion.createStatement();
				PreparedStatement requete = laConnexion.prepareStatement("delete from Abonnement where id_abonnement=?");
				
				requete.setInt(1,objet.getId());
				
			

				int nbLignes = requete.executeUpdate();
				
				System.out.println("La suppression de l'abonement a été effectuée");
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;

			}
			
			
		}

		
	

}