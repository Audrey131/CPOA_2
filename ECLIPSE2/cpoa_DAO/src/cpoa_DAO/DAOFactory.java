package cpoa_DAO;

import cpoa_DAO_metier.*;
import periodicite_dao.*;
import revue_dao.IDAO_revue;
import ENUMERATION.*;

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
}
