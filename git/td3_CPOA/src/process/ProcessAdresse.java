package process;

import cpoa_DAO_metier.Adresse;

public class ProcessAdresse {

	public Adresse normalize(Adresse adresse) {
		normalizePays(adresse);
		normalizeVille(adresse);
		normalizeVoie(adresse);
		normalizeNumVoie(adresse);
		return adresse;
	}

	public Adresse normalizePays(Adresse adresse) {
		if (adresse.getPays() != null) {
			String pays = adresse.getPays().trim().toLowerCase();
			if (adresse != null && adresse.getPays() != null) {

				if (("letzbuerg").equals(pays)) {
					adresse.setPays("Luxembourg");
				} else if (("belgium").equals(pays)) {
					adresse.setPays("Belgique");
				} else if (("schweiz").equals(pays)) {
					adresse.setPays("Suisse");
				} else {
					adresse.setPays("Inconnu");
				}
			}
		}

		return adresse;
	}

	public Adresse normalizeVille(Adresse adresse) {
		
		if (adresse != null && adresse.getVille() != null) { // Vérif adresse ou ville vide
			
			if (adresse.getVille().trim().length()!=0) {
		        final String separ = " ";
		        final String separ2 = "-";
		        
		        String prepo[] = {"le", "lès", "sous", "sur", "à", "aux"};
		        String Resultat = adresse.getVille().toLowerCase();

		        if (Resultat.contains(separ)) { //La ville contient des espaces
		            String VilleTri[] = Resultat.split(separ);
		            
		            for (int i = 0; i < VilleTri.length; i++){
		            	VilleTri[i] = VilleTri[i].trim();
		            }
		        
		            Resultat = "";
		        
		            for (int i = 0; i < VilleTri.length; i++){ 
		        	
			            if (VilleTri.length == i+1) {
			                String str = VilleTri[i];
			                String output = str.substring(0, 1).toUpperCase() + str.substring(1);
			                Resultat = Resultat + output;
			                adresse.setVille(Resultat);
			                
			            }
			            
			            else{
		            	
			                if (VilleTri[i].compareTo("le") == 0){
			                    for (int k = 0; k < prepo.length; k++){
			                        if (VilleTri[i].compareTo(prepo[k]) == 0) {
			                        	Resultat = Resultat + prepo[k] + "-";
			                            adresse.setVille(Resultat);
			                        }
			                    }
			                }
	
			                else if (VilleTri[i].compareTo("lès") == 0){
			                    for (int k = 0; k < prepo.length; k++){
			                        if (VilleTri[i].compareTo(prepo[k]) == 0) {
			                        	Resultat = Resultat + prepo[k] + "-";
			                            adresse.setVille(Resultat);
			                        }
			                    }
			                }

		                else if (VilleTri[i].compareTo("sous") == 0){
		                    for (int k = 0; k < prepo.length; k++){
		                        if (VilleTri[i].compareTo(prepo[k]) == 0) {
		                        	Resultat = Resultat + prepo[k] + "-";
		                            adresse.setVille(Resultat);
		                        }
		                    }
		                }

		                else if (VilleTri[i].compareTo("sur") == 0){
		                    for (int k = 0; k < prepo.length; k++){
		                        if (VilleTri[i].compareTo(prepo[k]) == 0) {
		                        	Resultat = Resultat + prepo[k] + "-";
		                            adresse.setVille(Resultat);
		                        }
		                    }
		                }

		                else if (VilleTri[i].compareTo("à") == 0){
		                    for (int k = 0; k < prepo.length; k++){
		                        if (VilleTri[i].compareTo(prepo[k]) == 0) {
		                        	Resultat = Resultat + prepo[k] + "-";
		                            adresse.setVille(Resultat);
		                        }
		                    }
		                }

		                else if (VilleTri[i].compareTo("aux") == 0){
		                    for (int k = 0; k < prepo.length; k++){
		                        if (VilleTri[i].compareTo(prepo[k]) == 0) {
		                        	Resultat = Resultat + prepo[k] + "-";
		                            adresse.setVille(Resultat);
		                        }
		                    }
		                }
		                
		                else if (VilleTri[i].compareTo("st") == 0) {
		                	Resultat = Resultat + "Saint" + "-";
		                    adresse.setVille(Resultat);
		                }
		                else if (VilleTri[i].compareTo("ste") == 0) {
		                	Resultat = Resultat + "Sainte" + "-";
		                    adresse.setVille(Resultat);
		                }
		                else {
		                    String str = VilleTri[i];
		                    String output = "";
		                    
		                    output = str.substring(0, 1).toUpperCase() + str.substring(1);
		                    Resultat = Resultat + output + "-";
		                    adresse.setVille(Resultat);
		                }
		            }
		        }
		        
		        return adresse; 
		    
		} 
		        
		        else if (Resultat.contains(separ2)) { //La ville contient des tirets
		        	String VilleTri[] = Resultat.split(separ2);
		        	for (int i = 0; i < VilleTri.length; i++){
		        		VilleTri[i] = VilleTri[i].trim();
		        	}
		        	Resultat = "";
		
		        	for (int i = 0; i < VilleTri.length; i++){ 
		        		if (VilleTri.length == i+1) {
		        	String str = VilleTri[i];
		        	String output = str.substring(0, 1).toUpperCase() + str.substring(1);
		        	Resultat = Resultat + output;
		        	adresse.setVille(Resultat);
		        	}
		        		
		        	else{
		        		if (VilleTri[i].compareTo("le") == 0){
		        			for (int k = 0; k < prepo.length; k++){
		        				if (VilleTri[i].compareTo(prepo[k]) == 0) {
		        					Resultat = Resultat + prepo[k] + "-";
		        					adresse.setVille(Resultat);
		        				}
		        			}
		        		}

			        	else if (VilleTri[i].compareTo("lès") == 0){
			        		for (int k = 0; k < prepo.length; k++){
			        			if (VilleTri[i].compareTo(prepo[k]) == 0) {
			        				Resultat = Resultat + prepo[k] + "-";
			        				adresse.setVille(Resultat);
			        			}
			        		}
			        	}
	
			        	else if (VilleTri[i].compareTo("sous") == 0){
			        		for (int k = 0; k < prepo.length; k++){
			        			if (VilleTri[i].compareTo(prepo[k]) == 0) {
			        				Resultat = Resultat + prepo[k] + "-";
			        				adresse.setVille(Resultat);
			        			}
			        		}
			        	}
	
			        	else if (VilleTri[i].compareTo("sur") == 0){
			        		for (int k = 0; k < prepo.length; k++){
			        			if (VilleTri[i].compareTo(prepo[k]) == 0) {
			        				Resultat = Resultat + prepo[k] + "-";
			        				adresse.setVille(Resultat);
			        			}
			        		}
			        	}

		        	else if (VilleTri[i].compareTo("à") == 0){
		        		for (int k = 0; k < prepo.length; k++){
		        			if (VilleTri[i].compareTo(prepo[k]) == 0) {
		        				Resultat = Resultat + prepo[k] + "-";
		        				adresse.setVille(Resultat);
		        			}
		        		}
		        	}

		        	else if (VilleTri[i].compareTo("aux") == 0){
		        		for (int k = 0; k < prepo.length; k++){
		        			if (VilleTri[i].compareTo(prepo[k]) == 0) {
		        				Resultat = Resultat + prepo[k] + "-";
		        				adresse.setVille(Resultat);
		        			}
		        		}
		        	}
		        
		        	else if (VilleTri[i].compareTo("st") == 0) {
			        	Resultat = Resultat + "Saint" + "-";
			        	adresse.setVille(Resultat);
		        	}
		        
		        	else if (VilleTri[i].compareTo("ste") == 0) {
		        		Resultat = Resultat + "Sainte" + "-";
		        		adresse.setVille(Resultat);
			        }
			        
			        else {
			            String str = VilleTri[i];
			            String output = "";
			            
			            output = str.substring(0, 1).toUpperCase() + str.substring(1);
			            Resultat = Resultat + output + "-";
			            adresse.setVille(Resultat);
			                }
			            }
			        }
		
				adresse.setVille(Resultat);
		        return adresse; 
		        
		        }
		        
		        else { //La ville ne contient ni de tirets ni d'espaces
		        	Resultat = adresse.getVille().toLowerCase().trim();
		        	String output = Resultat.substring(0, 1).toUpperCase() + Resultat.substring(1);
		        	
		        	if (output.contains("le")){
	        			for (int k = 0; k < prepo.length; k++){
	        				if (output.contains(prepo[k])) {
	        					Resultat = Resultat + prepo[k] + "-";
	        					adresse.setVille(Resultat);
	        				}
	        			}
	        		}

		        	else if (output.contains("lès")){
		        		for (int k = 0; k < prepo.length; k++){
		        			if (output.contains(prepo[k])) {
		        				Resultat = Resultat + prepo[k] + "-";
		        				adresse.setVille(Resultat);
		        			}
		        		}
		        	}

		        	else if (output.contains("sous")){
		        		for (int k = 0; k < prepo.length; k++){
		        			if (output.contains(prepo[k])) {
		        				Resultat = Resultat + prepo[k] + "-";
		        				adresse.setVille(Resultat);
		        			}
		        		}
		        	}

		        	else if (output.contains("sur")){
		        		for (int k = 0; k < prepo.length; k++){
		        			if (output.contains(prepo[k])) {
		        				Resultat = Resultat + prepo[k] + "-";
		        				adresse.setVille(Resultat);
		        			}
		        		}
		        	}

	        	else if (output.contains("à")){
	        		for (int k = 0; k < prepo.length; k++){
	        			if (output.contains(prepo[k])) {
	        				Resultat = Resultat + prepo[k] + "-";
	        				adresse.setVille(Resultat);
	        			}
	        		}
	        	}

	        	else if (output.contains("aux")){
	        		for (int k = 0; k < prepo.length; k++){
	        			if (output.contains(prepo[k])) {
	        				Resultat = Resultat + prepo[k] + "-";
	        				adresse.setVille(Resultat);
	        			}
	        		}
	        	}
	        
	        	else if (output.contains("st")) {
		        	Resultat = Resultat + "Saint" + "-";
		        	adresse.setVille(Resultat);
	        	}
	        
	        	else if (output.contains("ste")) {
	        		Resultat = Resultat + "Sainte" + "-";
	        		adresse.setVille(Resultat);
		        }
		        }
			}
			
		    return adresse;
	}
		return adresse;
	}
	
	public Adresse normalizeVoie(Adresse adresse) {
		if (adresse != null && adresse.getVoie() != null) {
	     String voie = adresse.getVoie().trim().toUpperCase();
	        if (voie != null && adresse.getVoie() != null && adresse.getVoie() != "boulevard"&& adresse.getVoie() != "avenue"&& adresse.getVoie() != "faubourg"&& adresse.getVoie() != "place") {
	        
	            if (("BOUL").equals(voie) || ("BOUL.").equals(voie) || ("BD").equals(voie)){
	                adresse.setVoie("boulevard");
	            }
	            else if (("AV.").equals(voie) || ("AV").equals(voie)){
	                adresse.setVoie("avenue");
	            }
	            else if (("FAUB.").equals(voie) || ("FG").equals(voie)){
	                adresse.setVoie("faubourg");
	            }
	            else if (("PL.").equals(voie) || ("PL").equals(voie)){
	                adresse.setVoie("place");
	            }
	            else {
	                adresse.setVoie("inconnu");
	            }
	            return adresse;
	        }
			return adresse;
		}
		return adresse;
	        
	}
	
	public Adresse normalizeNumVoie(Adresse adresse) {
		if (adresse != null && adresse.getNumVoie() != null) {
			
		
		String numVoie = adresse.getNumVoie().toUpperCase().replaceAll("[^A-Za-z0-9]","").trim();
        if (numVoie != null && adresse.getNumVoie() != null) {
            adresse.setNumVoie(numVoie + ",");
        }
        else {
            adresse.setNumVoie("inconnu");
        }
        return adresse;
	}
		return adresse;
	}
	
}
