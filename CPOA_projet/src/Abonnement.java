import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Abonnement {
	private Connection maConnection;
    private Connexion Connection;

    public Abonnement(){
        Connection = new Connexion();
		maConnection = Connection.creeConnexion();
    }

    public void AddAbo(String datedeb, String datefin, int IdRevue){

        PreparedStatement requete;
        try {
            requete = maConnection.prepareStatement("insert into Abonnement (date_debut, date_fin,  id_revue) values(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            requete.setString(1, datedeb);
            requete.setString(2, datefin);
            
            requete.setInt(4, IdRevue);
            int nbLignes = requete.executeUpdate();

            ResultSet res = requete.getGeneratedKeys();
            if (res.next()) {
                int cle = res.getInt(1);
            }
            
        } catch (SQLException sqle) {
            System.out.println("Pb select" + sqle.getMessage());
            }
    }

    public void SuppAbo(int Id){

        PreparedStatement requete;
        try {
            requete = maConnection.prepareStatement("delete from Abonnement where id_abonnement=?", Statement.RETURN_GENERATED_KEYS);
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

    public void ModAbo(int Id) throws ParseException{
    	
    	System.out.println("Que voulez-vous modifier ?");
		System.out.println("1. date de début d'abonnement");
		System.out.println("2. date de fin d'abonnement");
		System.out.println("3. revue concernée");
		
		Scanner choix = new Scanner(System.in);
		int nchoix = choix.nextInt();
		
		PreparedStatement requete;
		
		switch (nchoix) {
		
		case 1:
			System.out.println("Saisir la nouvelle date au format AAAA-MM-JJ :");
			
			Scanner newdate = new Scanner(System.in);
			String nbdate = newdate.nextLine();
			
			SimpleDateFormat Date = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date datedeb =  (java.sql.Date) Date.parse(nbdate);
			
		        try {
		        	
		            requete = maConnection.prepareStatement("update date_debut set libelle=? where id_client=? ", Statement.RETURN_GENERATED_KEYS);
		            requete.setDate(1, datedeb);
		            requete.setInt(2, Id);
		            int nbLignes = requete.executeUpdate();

		            ResultSet res = requete.getGeneratedKeys();
		            if (res.next()) {
		                int cle = res.getInt(1);
		            }
		        }
		            
		         catch (SQLException sqle) {
		            System.out.println("Pb select" + sqle.getMessage());
		            }
		        break;
		    		        
		case 2:
				
			System.out.println("Saisir la nouvelle date au format AAAA-MM-JJ :");
			
			Scanner newdate1 = new Scanner(System.in);
			String nbdate1 = newdate1.nextLine();
			
			SimpleDateFormat Date1 = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date datefin =  (java.sql.Date) Date1.parse(nbdate1);
			
		        try {
		        	
		            requete = maConnection.prepareStatement("update date_fin set libelle=? where id_client=? ", Statement.RETURN_GENERATED_KEYS);
		            requete.setDate(1, datefin);
		            requete.setInt(2, Id);
		            int nbLignes = requete.executeUpdate();

		            ResultSet res = requete.getGeneratedKeys();
		            if (res.next()) {
		                int cle = res.getInt(1);
		            }
		        }
		            
		         catch (SQLException sqle) {
		            System.out.println("Pb select" + sqle.getMessage());
		            }
		        break;
		       
		case 3:
			System.out.println("Saisir le numero de la revue :");
			
			Scanner revue = new Scanner(System.in);
			int numrevue = revue.nextInt();
			
		        try {
		            requete = maConnection.prepareStatement("update id_revue set libelle=? where id_client=? ", Statement.RETURN_GENERATED_KEYS);
		            requete.setInt(1, numrevue);
		            requete.setInt(2, Id);
		            int nbLignes = requete.executeUpdate();

		            ResultSet res = requete.getGeneratedKeys();
		            if (res.next()) {
		                int cle = res.getInt(1);
		            }
		            
		        } 
		        catch (SQLException sqle) {
		            System.out.println("Pb select" + sqle.getMessage());
		            }
		        break;
		        
		}
				
		}
		
        
    
}
