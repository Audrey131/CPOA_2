package client_DAO; 

/**
 * 
 * @author marotta9u
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import cpoa_DAO.*;

import cpoa_DAO_metier.ClientsTM;

public class MySqlDao_client implements IDAO_client {

	private static MySqlDao_client instance;
	private Connexion connexion;

	public static MySqlDao_client getInstance() {
		if (instance == null) {
			instance = new MySqlDao_client();
		}
		System.out.println("Je suis en SQL");
		return instance;
	}

	private MySqlDao_client() {
		connexion = new Connexion();
	}

	@Override
	public ClientsTM getById(int id) {
		ClientsTM p = null;
		
		Connection laConnexion = connexion.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where id_client = ?");
			requete.setInt(1, id);
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				int id_client = res.getInt("id_client");
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				String no_rue = res.getString("no_rue");
				String voie = res.getString("voie");
				String code_postal = res.getString("code_postal");
				String ville = res.getString("ville");
				String pays = res.getString("pays");
				
				ClientsTM Client=new ClientsTM(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays);
				return Client;
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return p;
	}
	
	@Override
	public ClientsTM getByNom(String nom1) {
		ClientsTM p = null;
		
		Connection laConnexion = connexion.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where nom = ?");
			requete.setString(1, nom1);
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				int id_client = res.getInt("id_client");
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				String no_rue = res.getString("no_rue");
				String voie = res.getString("voie");
				String code_postal = res.getString("code_postal");
				String ville = res.getString("ville");
				String pays = res.getString("pays");
				
				ClientsTM Client=new ClientsTM(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays);
				return Client;
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return p;
	}
	
	@Override
	public ClientsTM getByPrenom(String prenom1) {
		ClientsTM p = null;
		
		Connection laConnexion = connexion.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where prenom = ?");
			requete.setString(1, prenom1);
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				int id_client = res.getInt("id_client");
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				String no_rue = res.getString("no_rue");
				String voie = res.getString("voie");
				String code_postal = res.getString("code_postal");
				String ville = res.getString("ville");
				String pays = res.getString("pays");
				
				ClientsTM Client=new ClientsTM(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays);
				return Client;
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return p;
	}
	
	@Override
	public ClientsTM getByNo_rue(String no_rue1) {
		ClientsTM p = null;
		
		Connection laConnexion = connexion.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where no_rue = ?");
			requete.setString(1, no_rue1);
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				int id_client = res.getInt("id_client");
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				String no_rue = res.getString("no_rue");
				String voie = res.getString("voie");
				String code_postal = res.getString("code_postal");
				String ville = res.getString("ville");
				String pays = res.getString("pays");
				
				ClientsTM Client=new ClientsTM(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays);
				return Client;
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return p;
	}

	@Override
	public ClientsTM getByVoie(String voie1) {
		ClientsTM p = null;
		
		Connection laConnexion = connexion.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where voie = ?");
			requete.setString(1, voie1);
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				int id_client = res.getInt("id_client");
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				String no_rue = res.getString("no_rue");
				String voie = res.getString("voie");
				String code_postal = res.getString("code_postal");
				String ville = res.getString("ville");
				String pays = res.getString("pays");
				
				ClientsTM Client=new ClientsTM(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays);
				return Client;
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return p;
	}
	
	@Override
	public ClientsTM getByCode_postal(String code_postal1) {
		ClientsTM p = null;
		
		Connection laConnexion = connexion.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where code_postal = ?");
			requete.setString(1, code_postal1);
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				int id_client = res.getInt("id_client");
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				String no_rue = res.getString("no_rue");
				String voie = res.getString("voie");
				String code_postal = res.getString("code_postal");
				String ville = res.getString("ville");
				String pays = res.getString("pays");
				
				ClientsTM Client=new ClientsTM(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays);
				return Client;
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return p;
	}
	
	@Override
	public ClientsTM getByVille(String ville1) {
		ClientsTM p = null;
		
		Connection laConnexion = connexion.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where ville = ?");
			requete.setString(1, ville1);
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				int id_client = res.getInt("id_client");
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				String no_rue = res.getString("no_rue");
				String voie = res.getString("voie");
				String code_postal = res.getString("code_postal");
				String ville = res.getString("ville");
				String pays = res.getString("pays");
				
				ClientsTM Client=new ClientsTM(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays);
				return Client;
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return p;
	}
	
	@Override
	public ClientsTM getByPays(String pays1) {
		ClientsTM p = null;
		
		Connection laConnexion = connexion.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where pays = ?");
			requete.setString(1, pays1);
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				int id_client = res.getInt("id_client");
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				String no_rue = res.getString("no_rue");
				String voie = res.getString("voie");
				String code_postal = res.getString("code_postal");
				String ville = res.getString("ville");
				String pays = res.getString("pays");
				
				ClientsTM Client=new ClientsTM(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays);
				return Client;
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return p;
	}

	
	@Override
	
	public List<ClientsTM> getAll() {
		List<ClientsTM> liste = new ArrayList<>();
		
		// TODO Auto-generated method stub
		return liste;
	}

	public boolean update(ClientsTM objet) {
		
		try {
			Connection laConnexion = connexion.creeConnexion();
			Statement requete1 = laConnexion.createStatement();
			
			PreparedStatement requete = laConnexion.prepareStatement("update Client set nom=?, prenom=?, no_rue=?, voie=? , code_postal=?, ville=?, pays=? where id_client=?");
			
			requete.setString(1,objet.getNom());
			requete.setString(2,objet.getPrenom());
			requete.setString(3,objet.getNoRue());
			requete.setString(4,objet.getVoie());
			requete.setString(5,objet.getCodePostal());
			requete.setString(6,objet.getVille());
			requete.setString(7,objet.getPays());

			int nbLignes = requete.executeUpdate();
			
			System.out.println("La modification du client a été effectuée");
			return true;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	public boolean create(ClientsTM objet) {
		
		try {
		
		Connection laConnexion = connexion.creeConnexion();
		Statement requete1 = laConnexion.createStatement();
		
		PreparedStatement requete = laConnexion.prepareStatement("insert into Client(nom, prenom, no_rue, voie, code_postal, ville, pays) values(?, ?, ?, ?, ?, ?, ?)");
		
		requete.setString(1,objet.getNom());
		requete.setString(2,objet.getPrenom());
		requete.setString(3,objet.getNoRue());
		requete.setString(4,objet.getVoie());
		requete.setString(5,objet.getCodePostal());
		requete.setString(6,objet.getVille());
		requete.setString(7,objet.getPays());
		
		int nbLignes = requete.executeUpdate();
		
    	System.out.println("L'ajout du client a été effectué");
    	
		return true;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(ClientsTM objet) {
		
		try {
		
		Connection laConnexion = connexion.creeConnexion();
		Statement requete1 = laConnexion.createStatement();
		
		PreparedStatement requete = laConnexion.prepareStatement("delete from Client where id_client=?");
		
		requete.setInt(1,objet.getId_client());
		int nbLignes = requete.executeUpdate();
		
    	System.out.println("La suppression du client a été effectuée");
    	
		return false;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}



	

}

