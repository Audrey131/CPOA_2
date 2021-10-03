package abonnement_DAO;

import cpoa_DAO.*;
import cpoa_DAO_metier.Abonnement;

public interface IDAO_abonnement extends IDAO<Abonnement> {


	Abonnement getByDateDebut(String date_debut);
	Abonnement getByDatefin(String date_fin);
	Abonnement getByIdClient(int id_client);
	Abonnement getByIdRevue(int id_revue);
}