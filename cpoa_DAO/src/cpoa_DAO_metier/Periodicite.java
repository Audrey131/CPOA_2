package cpoa_DAO_metier;

public class Periodicite {
	
		private int id;
		private String lib;
		
		public Periodicite(int id, String lib) {
			this.id = id;
			this.lib = lib;
		}
		
		public int getID() { 
			return this.id; 
		} 
		
		public String getLib() {
			return this.lib;
		}
		
	
		public void setNo(int no) {
			this.id = no;
		}
		
		public void setLib(String nom) {
			if (nom==null || nom.trim().length()==0) {
				throw new IllegalArgumentException("Libelle de la periodicite vide !");
			}
			this.lib = nom;
		}
		
		public String toString() {
			return "(" + (this.id>=0?this.id:"nouveau") + ") " + this.lib;
		}
}


