package cpoa_DAO;

import abonnement_DAO.IDAO_abonnement;
import abonnement_DAO.MySqlDao_abonnement;

/**
 * 
 * @author girard144u
 *
 */

import client_DAO.IDAO_client;
import client_DAO.MySqlDao_client;
import duree_DAO.IDAO_duree;
import duree_DAO.MySqlDaoDureeTM;
import periodicite_dao.*;

import revue_dao.IDAO_revue;
import revue_dao.MySqlDao_revue;

public class MySQLFactoryDAO extends DAOFactory{
	
	@Override
	public IDAO_periodicite getPeriodiciteDao() {
		return MySqlDaoPeriodicite.getInstance();
	}

	@Override
	public IDAO_revue getRevueDao() {
		// TODO Auto-generated method stub
		return MySqlDao_revue.getInstance();
	}

	@Override
	public IDAO_client getClientDao() {
		// TODO Auto-generated method stub
		return MySqlDao_client.getInstance();
	}

	@Override
	public IDAO_duree getDureeDao() {
		// TODO Auto-generated method stub
		return MySqlDaoDureeTM.getInstance();
	}
	
	@Override
	public IDAO_abonnement getAbonnementDao() {
		// TODO Auto-generated method stub
		return MySqlDao_abonnement.getInstance();
	}
	
}
