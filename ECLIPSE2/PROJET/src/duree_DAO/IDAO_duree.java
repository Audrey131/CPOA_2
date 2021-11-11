package duree_DAO;

import java.util.List;

/**
 * 
 * @author marotta9u
 *
 */

import cpoa_DAO.*;
import cpoa_DAO_metier.DureeTM;

public interface IDAO_duree extends IDAO<DureeTM> {
	
	List<DureeTM> getByLibelle_formule(String libelle_formule);
}