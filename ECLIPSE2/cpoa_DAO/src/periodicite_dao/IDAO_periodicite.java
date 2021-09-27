package periodicite_dao;

import cpoa_DAO_metier.*;
import cpoa_DAO.*;

public interface IDAO_periodicite extends IDAO<Periodicite>{
	String getByLibelle(String libelle);
}
