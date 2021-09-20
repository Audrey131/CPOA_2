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

    public void ModClient(int Id) throws ParseException{
    	
    	System.out.println("Que voulez-vous modifier ?");
    	
		System.out.println("1. le nom");
		System.out.println("2. le prenom");
		System.out.println("3. la rue");
		System.out.println("4. la voie");
		System.out.println("5. le code postal");
		System.out.println("6. la ville");
		System.out.println("7. le pays");
		
		Scanner choix = new Scanner(System.in);
		int nchoix = choix.nextInt();
		
		PreparedStatement requete;
		
		switch (nchoix) {
		
		case 1:
			System.out.println("Saisir le nouveau nom :");
			
			Scanner newnom = new Scanner(System.in);
			String nom = newnom.nextLine();
			
		        try {
		        	
		            requete = maConnection.prepareStatement("update nom set libelle=? where id_client=? ", Statement.RETURN_GENERATED_KEYS);
		            requete.setString(1, nom);
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
				
			System.out.println("Saisir le nouveau prenom :");
			
			Scanner newprenom = new Scanner(System.in);
			String prenom = newprenom.nextLine();
			
		        try {
		        	
		            requete = maConnection.prepareStatement("update prenom set libelle=? where id_client=? ", Statement.RETURN_GENERATED_KEYS);
		            requete.setString(1, prenom);
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
			System.out.println("Saisir le nouveau numero de rue :");
			
			Scanner newrue = new Scanner(System.in);
			String rue = newrue.nextLine();
			
		        try {
		        	
		            requete = maConnection.prepareStatement("update no_rue set libelle=? where id_client=? ", Statement.RETURN_GENERATED_KEYS);
		            requete.setString(1, rue);
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
		        
		case 4:
			System.out.println("Saisir la nouvelle voie :");
			
			Scanner newvoie = new Scanner(System.in);
			String voie = newvoie.nextLine();
			
		        try {
		        	
		            requete = maConnection.prepareStatement("update voie set libelle=? where id_client=? ", Statement.RETURN_GENERATED_KEYS);
		            requete.setString(1, voie);
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
		        
		case 5:
			System.out.println("Saisir le nouveau code postal :");
			
			Scanner newcp = new Scanner(System.in);
			String cp = newcp.nextLine();
			
		        try {
		        	
		            requete = maConnection.prepareStatement("update code_postal set libelle=? where id_client=? ", Statement.RETURN_GENERATED_KEYS);
		            requete.setString(1, cp);
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
		        
		case 6:
			System.out.println("Saisir la nouvelle ville :");
			
			Scanner newville = new Scanner(System.in);
			String ville = newville.nextLine();
			
		        try {
		        	
		            requete = maConnection.prepareStatement("update ville set libelle=? where id_client=? ", Statement.RETURN_GENERATED_KEYS);
		            requete.setString(1, ville);
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
		        
		case 7:
			System.out.println("Saisir le nouveau pays :");
			
			Scanner newpays = new Scanner(System.in);
			String pays = newpays.nextLine();
			
		        try {
		        	
		            requete = maConnection.prepareStatement("update pays set libelle=? where id_client=? ", Statement.RETURN_GENERATED_KEYS);
		            requete.setString(1, pays);
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
