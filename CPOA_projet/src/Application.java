import java.util.*;
public class Application {
	
	public Application(){
		
		System.out.println("Application de gestion d\'une base de donn�e");
		System.out.println("Quelle table voulez-vous modifier ?");
		
		System.out.println("a. La table \"P�riodicit�\"");
		System.out.println("b. La table \"Abonnement\"");
		System.out.println("c. La table \"Client\"");
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		switch (str) {
			case "a": 
				Periodicite p = new Periodicite();
				System.out.println("Que voulez-vous faire ?");
				System.out.println("1. Ajouter une P�riodicit�");
				System.out.println("2. Supprimer une P�riodicit�");
				System.out.println("3. Modifier une P�riodicit�");

				Scanner sc2 = new Scanner(System.in);
				String str2 = sc2.nextLine();
				
				switch (str2) {
					case "1":
						System.out.println("Veuillez saisir le nom de la p�riodicit� � cr�er :");
						
						Scanner sc3 = new Scanner(System.in);
						String str3 = sc3.nextLine();
						
						p.AddPerio(str3);
						
						System.out.println("C'est fait !");

						break;
						
					case "2":
						System.out.println("Veuillez saisir le num�ro de la p�riodicit� � supprimer :");
						
						Scanner sc4 = new Scanner(System.in);
						int str4 = sc4.nextInt();
						
						p.SuppPerio(str4);						
						System.out.println("C'est fait !");

						break;
						
					case "3":
						System.out.println("Veuillez saisir le num�ro de la p�riodicit� � modifier :");
						
						Scanner sc5 = new Scanner(System.in);
						int str5 = sc5.nextInt();
						
						System.out.println("Veuillez maintenant saisir le nouveau libell� :");
						
						Scanner sc6 = new Scanner(System.in);
						String str6 = sc6.nextLine();
						
						p.ModPerio(str5,str6);	
						
						System.out.println("C'est fait !");

						break;
						
					default :
						break;
				}
			case "b":
				Abonnement a = new Abonnement();
				
				System.out.println("Que voulez-vous faire ?");
				System.out.println("1. Ajouter un abonnement");
				System.out.println("2. Supprimer un abonnement");
				System.out.println("3. Modifier un abonnement");
		    	
		    	Scanner sc7 = new Scanner(System.in);
				int str7 = sc7.nextInt();
				
				switch (str7) {
					case 1:
						System.out.println("Veuillez saisir la date de d�but d'abonnement au format MM-JJ-AAAA :");
						
						Scanner datedeb = new Scanner(System.in);
						String sdatedeb = datedeb.nextLine();
						
						System.out.println("Veuillez saisir la date de fin d'abonnement au format MM-JJ-AAAA :");
						
						Scanner datefin = new Scanner(System.in);
						String sdatefin = datefin.nextLine();
						
						System.out.println("Veuillez saisir le numero de la revue concern�e :");
						
						Scanner revue = new Scanner(System.in);
						int numrevue = revue.nextInt();
						
						a.AddAbo(sdatedeb, sdatefin, numrevue);
						
						System.out.println("C'est fait !");
						
						break;
						
					case 2:
						
						System.out.println("Veuillez saisir le numero du client a supprimer :");
						Scanner cl = new Scanner(System.in);
						int numcl = cl.nextInt();
						
						a.SuppAbo(numcl);
						
						break;
						
					case 3:
						
						System.out.println("Pour quel client voulez-vous modifier quelque chose?");
				    	
				    	Scanner mod = new Scanner(System.in);
						int choixmod = mod.nextInt();
				}
				
			case "c":
				Client c =  new Client();
				
				System.out.println("Que voulez-vous faire ?");
				System.out.println("1. Ajouter un Client");
				System.out.println("2. Supprimer un client");
				System.out.println("3. Modifier un client");
		    	
		    	Scanner cl = new Scanner(System.in);
				int cl1 = cl.nextInt();
				
				switch (cl1) {
					case 1:
						System.out.println("Veuillez saisir le nom :");
						
						Scanner nom = new Scanner(System.in);
						String newnom = nom.nextLine();
						
						System.out.println("Veuillez saisir le prenom :");
						
						Scanner prenom = new Scanner(System.in);
						String newprenom = prenom.nextLine();
						
						System.out.println("Veuillez saisir le numero de rue :");
						
						Scanner norue = new Scanner(System.in);
						String newrue = norue.nextLine();
						
						System.out.println("Veuillez saisir la voie :");
						
						Scanner voie = new Scanner(System.in);
						String newvoie = voie.nextLine();
						
						System.out.println("Veuillez saisir le code postal :");
						
						Scanner cp = new Scanner(System.in);
						String newcp = cp.nextLine();
						
						System.out.println("Veuillez saisir la ville :");
						
						Scanner ville = new Scanner(System.in);
						String newville = ville.nextLine();
						
						System.out.println("Veuillez saisir le pays :");
						
						Scanner pays = new Scanner(System.in);
						String newpays = pays.nextLine();
						
						c.AddClient(newnom, newprenom, newrue, newvoie, newcp, newville, newpays);
						
						System.out.println("C'est fait !");
						
						break;
						
					case 2:
						
						System.out.println("Veuillez saisir le numero du client a supprimer :");
						Scanner clsup = new Scanner(System.in);
						int numclsup = clsup.nextInt();
						
						c.SuppClient(numclsup);
						
						break;
						
					case 3:
						
						System.out.println("Pour quel client voulez-vous modifier quelque chose?");
				    	
				    	Scanner mod = new Scanner(System.in);
						int choixmod = mod.nextInt();
				}
				
		}
	}
}
