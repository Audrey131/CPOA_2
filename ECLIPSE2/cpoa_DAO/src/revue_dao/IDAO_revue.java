package revue_dao;

import cpoa_DAO.IDAO;
import cpoa_DAO_metier.Revue;

public interface IDAO_revue extends IDAO<Revue>{
	String getByLibelle(String libelle);
}
