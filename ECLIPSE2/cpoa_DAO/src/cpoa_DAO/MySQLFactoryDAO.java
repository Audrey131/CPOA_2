package cpoa_DAO;

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
}
