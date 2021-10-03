package client_DAO;

/**
 * 
 * @author marotta9u
 *
 */

import cpoa_DAO.*;
import cpoa_DAO_metier.ClientsTM;

public interface IDAO_client extends IDAO<ClientsTM> {
	
	ClientsTM getByNom(String nom);
	ClientsTM getByPrenom(String prenom);
	ClientsTM getByNo_rue(String no_rue);
	ClientsTM getByVoie(String voie);
	ClientsTM getByCode_postal(String code_postal);
	ClientsTM getByVille(String ville);
	ClientsTM getByPays(String pays);
}
