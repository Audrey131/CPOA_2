package duree_DAO;

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
import cpoa_DAO_metier.DureeTM;
import cpoa_DAO_metier.Revue;

public class MySqlDaoDureeTM implements IDAO_duree {

	private static MySqlDaoDureeTM instance;
	private Connexion connexion;

	public static MySqlDaoDureeTM getInstance() {
		if (instance == null) {
			instance = new MySqlDaoDureeTM();
		}
		System.out.println("Je suis en SQL");
		return instance;
	}

	private MySqlDaoDureeTM() {
		connexion = new Connexion();
	}

	@Override
	public DureeTM getById(int id_duree) {
		DureeTM p = null;
		
		Connection laConnexion = connexion.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Duree where id_duree = ?");
			requete.setInt(1, id_duree);
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				int id_duree2 = res.getInt("id_duree");
				String libelle_formule = res.getString("libelle_formule");
				
				DureeTM Duree=new DureeTM(id_duree2, libelle_formule);
				return Duree;
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return p;
	}
	
	@Override
	public List<DureeTM> getByLibelle_formule(String libelle_formule) {
		ArrayList<DureeTM> liste = new ArrayList<DureeTM>();
		
		Connection laConnexion = connexion.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Duree where libelle_formule = ?");
			requete.setString(1, libelle_formule);
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				int id_duree = res.getInt("id_duree");
				String libelle_formule2 = res.getString("libelle_formule");
				
				DureeTM Duree=new DureeTM(id_duree, libelle_formule2);
				
				liste.add(Duree);
				return liste;
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return liste;
	}

	
	@Override
	
	public List<DureeTM> getAll() {
		List<DureeTM> liste = new ArrayList<>();
		
		// TODO Auto-generated method stub
		return liste;
	}

	public boolean update(DureeTM duree){
		
		Connection laConnexion = connexion.creeConnexion();
		try {
			Statement requete1 = laConnexion.createStatement();
			PreparedStatement requete = laConnexion.prepareStatement("update Duree set libelle_formule=? where id_duree=?");
			
			requete.setString(1,duree.getLibelle_formule());

			int nbLignes = requete.executeUpdate();
			
			System.out.println("La modification de la duree a été effectuée");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	public boolean create(DureeTM duree){
		
		
		try {
			Connection laConnexion = connexion.creeConnexion();
			Statement requete1 = laConnexion.createStatement();
			
			PreparedStatement requete;
			requete = laConnexion.prepareStatement("insert into Duree(libelle_formule) values(?)");
			requete.setString(1, duree.getLibelle_formule());
			
			int nbLignes = requete.executeUpdate();
			
	    	System.out.println("L'ajout de la duree a été effectué");
	    	
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	public boolean delete(DureeTM duree){
		
		
		try {
			Connection laConnexion = connexion.creeConnexion();
			Statement requete1 = laConnexion.createStatement();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Duree where id_duree=?");
			
			requete.setInt(1,duree.getId_duree());
			int nbLignes = requete.executeUpdate();
			
	    	System.out.println("La suppression de la duree a été effectuée");
	    	
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}
		
		
	}
}

