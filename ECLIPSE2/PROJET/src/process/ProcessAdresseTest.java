package process;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cpoa_DAO_metier.Adresse;

public class ProcessAdresseTest {
	private ProcessAdresse process;
	
	final String c2 = "=+*$£^¨&:\\é\"";
  	final String c3 = "8640283";
	
	@Before
	public void setUp() {
		this.process = new ProcessAdresse();
	}
	
	@Test
	public void testNormalizePaysCasSimple() {
		Adresse adresse = new Adresse();
		adresse.setPays("Letzbuerg");
		assertEquals("Luxembourg", process.normalize(adresse).getPays());
	}
	
	@Test
	public void testNormalizePaysCasLowerCase() {
		Adresse adresse = new Adresse();
		adresse.setPays("letzbuerg");
		assertEquals("Luxembourg", process.normalize(adresse).getPays());
	}
	
	@Test
	public void testNormalizePaysCasUpperCase() {
		Adresse adresse = new Adresse();
		adresse.setPays("LETZBUERG");
		assertEquals("Luxembourg", process.normalize(adresse).getPays());
	}
	
	@Test
	public void testNormalizePaysCasInconnu() {
		Adresse adresse = new Adresse();
		adresse.setPays("");
		assertEquals("Inconnu", process.normalize(adresse).getPays());
	}
	
	@Test
	public void testNormalizeVilleCas1() {
		Adresse adresse = new Adresse();
		adresse.setPays("");
		adresse.setVille("Montigny lès metz");
		assertEquals("Montigny-lès-Metz", process.normalize(adresse).getVille());
	}
	
	@Test
	public void testNormalizeVilleCas2() {
		Adresse adresse = new Adresse();
		adresse.setPays("");
		adresse.setVille("ste blandine");
		assertEquals("Sainte-Blandine", process.normalize(adresse).getVille());
	}
	
	@Test
	public void testNormalizeVilleCas3() {
		Adresse adresse = new Adresse();
		adresse.setPays("");
		adresse.setVille("Metz");
		assertEquals("Metz", process.normalize(adresse).getVille());
	}
	
	@Test
    public void testNormalizeVoie() {
        Adresse adresse = new Adresse();
        
        //=====================================================================================
        //=====================================================================================
        //DEBUT BLOC TEST BOULEVARD
        //=====================================================================================
        //=====================================================================================
        
        //testNormalizeVoieBoulevardUpperCase1
        adresse.setVoie("BOUL");
        assertEquals("boulevard", process.normalize(adresse).getVoie());
        
        //testNormalizeVoieBoulevardUpperCase2
        adresse.setVoie("BOUL.");
        assertEquals("boulevard", process.normalize(adresse).getVoie());
        
        //testNormalizeVoieBoulevardUpperCase3
        adresse.setVoie("BD");
        assertEquals("boulevard", process.normalize(adresse).getVoie());
        
        //testNormalizeVoieBoulevardLowerCase1
        adresse.setVoie("boul");
        assertEquals("boulevard", process.normalize(adresse).getVoie());
        
        //testNormalizeVoieBoulevardLowerCase2
        adresse.setVoie("boul.");
        assertEquals("boulevard", process.normalize(adresse).getVoie());
        
        //testNormalizeVoieBoulevardLowerCase3
        adresse.setVoie("bd");
        assertEquals("boulevard", process.normalize(adresse).getVoie());
        
        //=====================================================================================
        //=====================================================================================
        //DEBUT BLOC TEST AVENUE
    	//=====================================================================================
        //=====================================================================================
        
        //testNormalizeVoieAvenueUpperCase1
        adresse.setVoie("AV");
        assertEquals("avenue", process.normalize(adresse).getVoie());
        
        //testNormalizeVoieAvenueUpperCase2
        adresse.setVoie("AV.");
        assertEquals("avenue", process.normalize(adresse).getVoie());
        
        //testNormalizeVoieAvenueLowerCase1
        adresse.setVoie("av");
        assertEquals("avenue", process.normalize(adresse).getVoie());
        
        //testNormalizeVoieAvenueLowerCase2
        adresse.setVoie("av.");
        assertEquals("avenue", process.normalize(adresse).getVoie());
        
        //=====================================================================================
        //=====================================================================================
        //DEBUT BLOC TEST FAUBOURG
        //=====================================================================================
        //=====================================================================================
        
        //testNormalizeVoieFaubourgUpperCase1
        adresse.setVoie("FAUB.");
        assertEquals("faubourg", process.normalize(adresse).getVoie());
        
        //testNormalizeVoieFaubourgUpperCase2
        adresse.setVoie("FG");
        assertEquals("faubourg", process.normalize(adresse).getVoie());
        
        //testNormalizeVoieFaubourgLowerCase1
        adresse.setVoie("faub.");
        assertEquals("faubourg", process.normalize(adresse).getVoie());
        
        //testNormalizeVoieFaubourgLowerCase2
        adresse.setVoie("fg");
        assertEquals("faubourg", process.normalize(adresse).getVoie());
        
        //=====================================================================================
        //=====================================================================================
        //DEBUT BLOC TEST PLACE
        //=====================================================================================
        //=====================================================================================
        
        //testNormalizeVoiePlaceUpperCase1
        adresse.setVoie("PL");
        assertEquals("place", process.normalize(adresse).getVoie());
        
        //testNormalizeVoiePlaceLowerCase1
        adresse.setVoie("pl");
        assertEquals("place", process.normalize(adresse).getVoie());
        
        //=====================================================================================
        //=====================================================================================
        //DEBUT BLOC TEST INCONNU
        //=====================================================================================
        //=====================================================================================
        
        //testNormalizeVoieCasInconnuVide
        adresse.setVoie("");
        assertEquals("inconnu", process.normalize(adresse).getVoie());
        
        //testNormalizeVoieCasInconnuConstante2
        adresse.setVoie(c2);
        assertEquals("inconnu", process.normalize(adresse).getVoie());
        
        //testNormalizeVoieCasInconnuConstante3
        adresse.setVoie(c3);
        assertEquals("inconnu", process.normalize(adresse).getVoie());
    }
    
    @Test
    public void testNormalizeNumVoie() {
        Adresse adresse = new Adresse();
        adresse.setVoie("boulevard");
        
        //=====================================================================================
        //=====================================================================================
        //DEBUT BLOC TEST 34A
        //=====================================================================================
        //=====================================================================================
        
        //testNormalizeNumVoieUpperCase
        adresse.setNumVoie("34A");
        assertEquals("34A,", process.normalize(adresse).getNumVoie());
        
        //testNormalizeNumVoieLowerCase
        
        adresse.setNumVoie("34a");
        assertEquals("34A,", process.normalize(adresse).getNumVoie());
        
        //testNormalizeNumVoieReplace
        
        adresse.setNumVoie(")==))3)4)A)");
        assertEquals("34A,", process.normalize(adresse).getNumVoie());
        
        //testNormalizeNumVoieTrim
        
        adresse.setNumVoie("    3 4   A,         ");
        assertEquals("34A,", process.normalize(adresse).getNumVoie());
        
        //testNormalizeNumVoieLowerCase+Trim+Replace
        
        adresse.setNumVoie("    ))  )3)4{{  )   a)   ==");
        assertEquals("34A,", process.normalize(adresse).getNumVoie());
        
        //=====================================================================================
        //=====================================================================================
        //DEBUT BLOC TEST INCONNU
        //=====================================================================================
        //=====================================================================================
        
        //testNormalizeNumVoieCasInconnu
        
        adresse.setNumVoie("");
        assertEquals(",", process.normalize(adresse).getNumVoie());
    }
    
    @Test
    public void TestNormalizeCodePostal() {
        Adresse adresse = new Adresse();
        
      
        //TestNormalizeCodePostalReplaceAll
        adresse.setCode_postal("L-8200");
        assertEquals("08200", process.normalize(adresse).getCode_postal()) ;
        
        
        //TestNormalizeCodePostalInconnu
        adresse.setCode_postal("");
        assertEquals("Inconnu", process.normalize(adresse).getCode_postal()) ;
        
        //TestNormalizeCodePostalDifferentDe4et5
        adresse.setCode_postal("000000000008200");
        assertEquals("Inconnu", process.normalize(adresse).getCode_postal()) ;
        
         //TestNormalizeCodePostalFrancais
        adresse.setCode_postal("8200");
        assertEquals("08200", process.normalize(adresse).getCode_postal());
        
        //TestNormalizeCodePostalA5Caracteres
        adresse.setCode_postal("08200");
        assertEquals("08200", process.normalize(adresse).getCode_postal()) ;
    
       }
	
	
}
