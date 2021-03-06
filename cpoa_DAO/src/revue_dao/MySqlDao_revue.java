package revue_dao;

/**
 * 
 * @author girard144u
 *
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cpoa_DAO.Connexion;
import cpoa_DAO_metier.Revue;

public class MySqlDao_revue implements IDAO_revue{
	
	Connexion LAConnexion= new Connexion();        
    Connection laConnexion = LAConnexion.creeConnexion();
    
	private static MySqlDao_revue instance;
	
	public static MySqlDao_revue getInstance() {
		if (instance == null) {
			instance = new MySqlDao_revue();
		}
		System.out.println("Je suis en SQL");
		return instance;
	}

	@Override
	public Revue getById(int id) {
		PreparedStatement requete;
		
		try {
			requete = laConnexion.prepareStatement("select * from Revue where id_revue = ?");
			requete.setInt(1, id);
			
			ResultSet res = requete.executeQuery();
			while (res.next()) {
				int idrev = res.getInt("id_revue");
				String title = res.getString("titre");
				String desc = res.getString("description");
				float tarnum = res.getFloat("tarif_numero");
				String visu = res.getString("visuel");
				int idperiod = res.getInt("id_periodicite");
				
				return new Revue(idrev, title, desc, tarnum, visu, idperiod);  
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<Revue> getAll() {  // NE FONCTIONNE PAS
		List<Revue> liste = new ArrayList<>();
		PreparedStatement requete;
		
		try {
			requete = laConnexion.prepareStatement("select id_revue, titre, description, tarif_numero, visuel, id_periodicite from Revue");
			
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				int id = res.getInt("id_revue");
				String title = res.getString("titre");
				String desc = res.getString("description");
				float tarnum = res.getFloat("tarif_numero");
				String visu = res.getString("visuel");
				int idperiod = res.getInt("id_periodicite");
				
				liste.add(new Revue(id, title, desc, tarnum, visu, idperiod));  
				
				return liste;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return liste;
	}

	@Override
	public boolean update(Revue objet) {
		
		PreparedStatement requete;
		try {
			requete = laConnexion.prepareStatement("update Revue set titre=?, description=?, tarif_numero=?, visuel=?, id_periodicite=? where id_revue=?");
			requete.setString(1,objet.getTitre());
	        requete.setString(2,objet.getDescription());
	        requete.setDouble(3,objet.getTarif_numero());
	        requete.setString(4,objet.getVisuel());
	        requete.setInt(5,objet.getId_periodicite());

	        int nbLignes = requete.executeUpdate();
	        
	        return true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
	       
		
	}

	@Override
	public boolean create(Revue objet) {
		
		PreparedStatement requete;
		try {
			requete = laConnexion.prepareStatement("insert into Revue(titre,description,tarif_numero,visuel,id_periodicite) values(?, ?, ?, ?, ?)");
		
			requete.setString(1,objet.getTitre());
	        requete.setString(2,objet.getDescription());
	        requete.setDouble(3,objet.getTarif_numero());
	        requete.setString(4,objet.getVisuel());
	        requete.setInt(5,objet.getId_periodicite());
	       
	        int nbLignes = requete.executeUpdate();
	        return true;
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	   
	}

	@Override
	public boolean delete(Revue objet) {
		
		PreparedStatement requete;
		try {
			requete = laConnexion.prepareStatement("delete from Revue where id_revue=?");
			requete.setInt(1,objet.getId_revue());
	        int nbLignes = requete.executeUpdate();
	        
	        return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	       
      
	}

	@Override
	public List<Revue> getByLibelle(String libelle) {
		PreparedStatement requete;
		
		try {
			requete = laConnexion.prepareStatement("select * from Revue where titre = ?");
			requete.setString(1, libelle);
			ArrayList<Revue> liste = new ArrayList<Revue>();
			
			ResultSet res = requete.executeQuery();
			while (res.next()) {
				int idrev = res.getInt("id_revue");
				String title = res.getString("titre");
				String desc = res.getString("description");
				float tarnum = res.getFloat("tarif_numero");
				String visu = res.getString("visuel");
				int idperiod = res.getInt("id_periodicite");
				
				liste.add(new Revue(idrev, title, desc, tarnum, visu, idperiod));
				
				
			}
			return liste;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
