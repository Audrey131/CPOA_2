package cpoa_DAO;

/**
 * 
 * @author girard144u
 *
 */

import client_DAO.*;
import periodicite_dao.IDAO_periodicite;
import periodicite_dao.ListeMemoireDAO_periodicite;
import revue_dao.IDAO_revue;
import revue_dao.ListeMemoireDAO_revue;
import duree_DAO.*;

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
	
	@Override
	public IDAO_client getClientDao() {
		// TODO Auto-generated method stub
		return ListeMemoireDAO_client.getInstance();	
		}
	
	@Override
	public IDAO_duree getDureeDao() {
		// TODO Auto-generated method stub
		return ListeMemoireDaoDureeTM.getInstance();	
		}
}
