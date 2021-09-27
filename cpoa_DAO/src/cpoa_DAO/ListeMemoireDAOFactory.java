package cpoa_DAO;

import periodicite_dao.IDAO_periodicite;
import periodicite_dao.ListeMemoireDAO_periodicite;
import revue_dao.IDAO_revue;
import revue_dao.ListeMemoireDAO_revue;

public class ListeMemoireDAOFactory extends DAOFactory {
	
	@Override
	public IDAO_periodicite getPeriodiciteDao() {
		return ListeMemoireDAO_periodicite.getInstance();
	}

	@Override
	public IDAO_revue getRevueDao() {
		// TODO Auto-generated method stub
		return ListeMemoireDAO_revue.getInstance();	
		}
}
