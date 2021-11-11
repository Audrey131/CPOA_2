package periodicite_dao;

/**
 * 
 * @author girard144u
 *
 */

import cpoa_DAO_metier.*;

import java.util.List;

import cpoa_DAO.*;

public interface IDAO_periodicite extends IDAO<Periodicite>{
	List<Periodicite> getByLibelle(String libelle);
}
