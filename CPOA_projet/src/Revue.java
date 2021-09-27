import java.sql.*;

public class Revue{
    
	Connexion LAConnexion= new Connexion();        // appeler l'instance
    Connection laConnexion = LAConnexion.creeConnexion();
    
    public void addRevue(String titre, String description, Double tarif_numero, String visuel, int id_periodicite)throws SQLException{
    
        PreparedStatement requete = laConnexion.prepareStatement("insert into Revue(titre,description,tarif_numero,visuel,id_periodicite) values(?, ?, ?, ?, ?)");
       
        requete.setString(1,titre);
        requete.setString(2,description);
        requete.setDouble(3,tarif_numero);
        requete.setString(4,visuel);
        requete.setInt(5,id_periodicite);
       
        int nbLignes = requete.executeUpdate();
       
        System.out.println("L'ajout de la revue a été effectué");
    }
    
    
    
    public void removeRevue(int id_revue)throws SQLException{
       
        PreparedStatement requete = laConnexion.prepareStatement("delete from Revue where id_revue=?");
       
        requete.setInt(1,id_revue);
        int nbLignes = requete.executeUpdate();
       
        System.out.println("La suppression de la revue a été effectuée");
    }
    
    
    
    public void updateRevue(String titre, String description, Double tarif_numero, String visuel, int id_periodicite, int id_revue )throws SQLException{
       
        PreparedStatement requete = laConnexion.prepareStatement("update Revue set titre=?, description=?, tarif_numero=?, visuel=?, id_periodicite=? where id_revue=?");
       
        requete.setString(1,titre);
        requete.setString(2,description);
        requete.setDouble(3,tarif_numero);
        requete.setString(4,visuel);
        requete.setInt(5,id_periodicite);
        requete.setInt(6,id_revue);

        int nbLignes = requete.executeUpdate();
       
        System.out.println("La modification de la revue a été effectuée");
    }
}
