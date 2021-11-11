package periodicite_dao;

/**
 * 
 * @author girard144u
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cpoa_DAO.Connexion;
import cpoa_DAO_metier.Periodicite;
import cpoa_DAO_metier.Revue;

public class MySqlDaoPeriodicite implements IDAO_periodicite {
	
	Connexion Connection= new Connexion();        
    Connection maConnection = Connection.creeConnexion();
    
	private static MySqlDaoPeriodicite instance;

	/* @return un objet de type MySqlDaoPeriodicite en singleton */
	public static MySqlDaoPeriodicite getInstance() {
		if (instance == null) {
			instance = new MySqlDaoPeriodicite();
		}
		System.out.println("Je suis en SQL");
		return instance;
	}

	@Override
	public Periodicite getById(int id) {
		PreparedStatement requete;
		
		try {
			requete = maConnection.prepareStatement("select * from Periodicite where id_periodicite = ?");
			requete.setInt(1, id);
			
			ResultSet res = requete.executeQuery();
			while (res.next()) {
				
				int idperiod = res.getInt("id_periodicite");
				String libelle= res.getString("libelle");
				
				return new Periodicite(idperiod, libelle);  
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Periodicite> getAll() {
		List<Periodicite> liste = new ArrayList<>();
		
		PreparedStatement requete;
		
		try {
			requete = maConnection.prepareStatement("select * from Periodicite");
			
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				int id = res.getInt("id_periodicite");
				String libelle = res.getString("libelle");
				
				liste.add(new Periodicite(id, libelle));  
				

			}
			return liste;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return liste;
	}

	@Override
	public boolean update(Periodicite objet) {
		PreparedStatement requete;
		
        try {
            requete = maConnection.prepareStatement("update Periodicite set libelle=? where id_periodicite=? ", Statement.RETURN_GENERATED_KEYS);
            requete.setString(1, objet.getLib());
            requete.setInt(2, objet.getID());
            int nbLignes = requete.executeUpdate();

            ResultSet res = requete.getGeneratedKeys();
            if (res.next()) {
                int cle = res.getInt(1);
            }
            return true;
            
        } catch (SQLException sqle) {
            System.out.println("Pb select" + sqle.getMessage());
            return false;
            }
	}

	@Override
	public boolean create(Periodicite objet) {
		
		PreparedStatement requete;
        try {
            requete = maConnection.prepareStatement("insert into Periodicite (libelle) values(?)", Statement.RETURN_GENERATED_KEYS);
            requete.setString(1, objet.getLib());
            int nbLignes = requete.executeUpdate();

            ResultSet res = requete.getGeneratedKeys();
            if (res.next()) {
                int cle = res.getInt(1);
            }
            
            return true;
            
        } catch (SQLException sqle) {
            System.out.println("Pb select" + sqle.getMessage());
            return false;
            }
	}

	@Override
	public boolean delete(Periodicite objet) {
		PreparedStatement requete;
		
        try {
            requete = maConnection.prepareStatement("delete from Periodicite where id_periodicite=?", Statement.RETURN_GENERATED_KEYS);
            requete.setInt(1, objet.getID());
            int nbLignes = requete.executeUpdate();

            ResultSet res = requete.getGeneratedKeys();
            if (res.next()) {
                int cle = res.getInt(1);
            }
            return true;
            
        } catch (SQLException sqle) {
            System.out.println("Pb select" + sqle.getMessage());
            return false;
            }
	}

	@Override
	public List<Periodicite> getByLibelle(String libelle) {
		PreparedStatement requete;
		
		try {
			requete = maConnection.prepareStatement("select * from Periodicite where libelle = ?");
			requete.setString(1, libelle);
			ArrayList<Periodicite> liste = new ArrayList<Periodicite>();
			
			ResultSet res = requete.executeQuery();
			while (res.next()) {
				int idper = res.getInt("id_revue");
				String lib = res.getString("libelle");
				
				liste.add(new Periodicite(idper, lib));
				
			}
			return liste;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
