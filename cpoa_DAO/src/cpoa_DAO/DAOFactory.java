package cpoa_DAO;

/**
 * 
 * @author girard144u
 *
 */

import duree_DAO.IDAO_duree;
import periodicite_dao.*;
import revue_dao.IDAO_revue;
import ENUMERATION.*;
import abonnement_DAO.IDAO_abonnement;
import client_DAO.IDAO_client;

public abstract class DAOFactory {
	
	public static DAOFactory getDaoFactory(Enumerations cible) {
		DAOFactory daof = null;
		switch (cible) {
		
		case MYSQL:
			daof = new MySQLFactoryDAO();
			break;
			
		case LISTE_MEMOIRE:
			daof = new ListeMemoireDAOFactory();
			break;
			
		default:
			break;
		}
		return daof;
	}

	public abstract IDAO_periodicite getPeriodiciteDao();
	public abstract IDAO_revue getRevueDao();
	public abstract IDAO_client getClientDao();
	public abstract IDAO_duree getDureeDao();
	public abstract IDAO_abonnement getAbonnementDao();

	
}
