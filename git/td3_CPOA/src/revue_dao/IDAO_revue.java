package revue_dao;

/**
 * 
 * @author girard144u
 *
 */

import java.util.List;

import cpoa_DAO.IDAO;
import cpoa_DAO_metier.Revue;

public interface IDAO_revue extends IDAO<Revue>{
	List<Revue> getByLibelle(String libelle);
}
