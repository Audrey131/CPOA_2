import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Client {
	
	private Connection maConnection;
    private Connexion Connection;

    public Client(){
    	Connection = new Connexion();
		maConnection = Connection.creeConnexion();
    }

    public void AddClient(String nom, String prenom, String no_rue, String voie, String cp, String ville, String pays){

        PreparedStatement requete;
        try {
            requete = maConnection.prepareStatement("insert into Client (nom, prenom,  no_rue, voie, code_postal, ville, pays) values(?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            requete.setString(1, nom);
            requete.setString(2, prenom);
            requete.setString(3, no_rue);
            requete.setString(4, voie);
            requete.setString(5, cp);
            requete.setString(6, ville);
            requete.setString(7, pays);
            
            int nbLignes = requete.executeUpdate();

            ResultSet res = requete.getGeneratedKeys();
            if (res.next()) {
                int cle = res.getInt(1);
            }
            
        } catch (SQLException sqle) {
            System.out.println("Pb select" + sqle.getMessage());
            }
    }

    public void SuppClient(int Id){

        PreparedStatement requete;
        try {
            requete = maConnection.prepareStatement("delete from Client where id_client=?", Statement.RETURN_GENERATED_KEYS);
            requete.setInt(1, Id);
            int nbLignes = requete.executeUpdate();

            ResultSet res = requete.getGeneratedKeys();
            if (res.next()) {
                int cle = res.getInt(1);
            }
            
        } catch (SQLException sqle) {
            System.out.println("Pb select" + sqle.getMessage());
            }
    }

    public void modifClient(String nom, String prenom,String no_rue,String voie,String code_postale,String ville,String Pays ,int id)throws SQLException {
        Connexion maConnexion=new Connexion();
        // appeler l'instance
         Connection connec = maConnexion.creeConnexion();
      PreparedStatement req = connec.prepareStatement("update Client set nom=? , prenom=? , no_rue=? , voie=? , code_postal=? , ville=? , Pays=? where id_Client=?");
      //lorsque suppr, modif, ou add, on utilise executeUpdate()
     
      req.setString(1,nom);
     
      req.setString(2,prenom);
      req.setString(3,no_rue);
      req.setString(4,voie);
      req.setString(5,code_postale);
      req.setString(6,ville);
      req.setString(7,Pays);
      req.setInt(8,id);
      int nbLignes = req.executeUpdate();
     
    }
		
        
    
}
