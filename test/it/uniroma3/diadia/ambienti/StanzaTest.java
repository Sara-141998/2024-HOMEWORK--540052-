package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * Classe di test per la classe Stanza
 * 
 *
 */
public class StanzaTest {

	private Stanza stanza;
	private Stanza stanzaAdiacente;
	private Stanza stanzaNord;
	private Stanza stanzaSud;
	private Stanza stanzaEst;
	private Stanza stanzaOvest;
	private Attrezzo tablet;
	private Attrezzo quaderno;
	private Attrezzo computer;
	private Attrezzo penna;
	private Attrezzo borraccia;
	private Attrezzo calcolatrice;
	private Attrezzo libro;
	private Stanza stanzaPiena;


	private Stanza nulla;

	@Before
	public void setUp() {

		this.stanza = new Stanza("Stanza di prova");
		this.stanzaEst= new Stanza("Est");
		this.stanzaOvest= new Stanza("Ovest");
		this.stanzaNord= new Stanza("Nord");
		this.stanzaSud= new Stanza("Sud");
		this.stanzaAdiacente= new Stanza("stanza adiacente");
		
		this.tablet= new Attrezzo("tablet", 10);
		this.quaderno= new Attrezzo("quaderno", 1);
		this.computer=new Attrezzo("computer", 1);
		this.penna= new Attrezzo("penna", 2);
		this.borraccia= new Attrezzo("borraccia", 1);
		this.calcolatrice = new Attrezzo("calcolatrice", 3);
		this.libro= new Attrezzo("libro", 4);
	    this.stanzaPiena= new Stanza("stanza piena");
		this.stanzaPiena.addAttrezzo(tablet);
		this.stanzaPiena.addAttrezzo(quaderno);
		this.stanzaPiena.addAttrezzo(computer);
		this.stanzaPiena.addAttrezzo(penna);

		
		
		this.nulla= new Stanza("Stanza nulla");

	}
	
    @Test
    public void testImpostaStanzaAdiacenteNord() {
        Stanza stanzaAdiacente = new Stanza("Stanza adiacente");
        stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
        assertEquals(stanzaAdiacente, stanza.getStanzaAdiacente("nord"));
    }
    
    @Test
	public void testImpostaStanzaAdiacenteEst() {
    	Stanza stanzaAdiacente = new Stanza("Stanza adiacente");
		stanza.impostaStanzaAdiacente("est", stanzaAdiacente);
		assertEquals(stanzaAdiacente , stanza.getStanzaAdiacente("est"));
	}
	@Test
	public void testImpostaStanzaAdiacenteSud() {
		Stanza stanzaAdiacente = new Stanza("Stanza adiacente");
		stanza.impostaStanzaAdiacente("sud", stanzaAdiacente);
		assertEquals(stanzaAdiacente , stanza.getStanzaAdiacente("sud"));
	}
	@Test
	public void testImpostaStanzaAdiacenteOvest() {
		Stanza stanzaAdiacente = new Stanza("Stanza adiacente");
		stanza.impostaStanzaAdiacente("ovest", stanzaAdiacente);
		assertEquals(stanzaAdiacente , stanza.getStanzaAdiacente("ovest"));
	}

	/**
	 * Test metodo addAttrezzo
	 */
	
	@Test
	public void testAddAttrezzoStanzaVuota() {
		assertEquals("Errore, avrebbe dovuto aggiungerlo", true, this.stanzaAdiacente.addAttrezzo(tablet));

	}

	@Test
    public void testAddAttrezzo() {
        assertTrue(stanza.addAttrezzo(quaderno));
    }
    
	 @Test
	 public void testAddAttrezzoDiverso() {
	    assertTrue(stanza.addAttrezzo(tablet));
	    }

	/**
	 * Test metodo hasAttrezzo
	 */

	 @Test
	 public void testHasAttrezzo() {
	    assertEquals(true, stanzaPiena.hasAttrezzo("tablet")); // Dovrebbe restituire true se l'attrezzo è presente nella stanza
	    }

	@Test
	public void testHasAttrezzoConAttrezzoNonPresente() {
		assertEquals( false, this.stanzaPiena.hasAttrezzo("mouse"));
	}
	@Test
	public void testHasAttrezzoConAttrezzoNonPresenteBis() {
		assertEquals( false, this.stanzaAdiacente.hasAttrezzo("bottiglia"));
	}

	@Test
	public void testHasAttrezzoConAttrezzoSconosciuto() {
		assertEquals( false, this.stanzaPiena.hasAttrezzo("righello"));

	}

	/**
	 * Test metodo getAttrezzo
	 */

	@Test
	public void testGetAttrezzoConAttrezzoPresente() {
		    Attrezzo attrezzo = new Attrezzo("telefono",5);
	        stanza.addAttrezzo(attrezzo);
	        assertEquals(attrezzo, stanza.getAttrezzo("telefono"));
	    }
	@Test
	public void testGetAttrezzoConAttrezzoNonPresente() {
		assertEquals("Errore, l'attrezzo non � presente", null, this.stanzaPiena.getAttrezzo("mouse"));
	}
	@Test
	public void testGetAttrezzoConAttrezzoNonPresenteBis() {
		assertEquals("Errore, non ci sono proprio attrezzi qui", null, this.stanzaAdiacente.getAttrezzo("orologio"));
	}


	@Test
	public void testGetAttrezzoConAttrezzoSconosciuto() {
		assertEquals("Errore, l'attrezzo non esiste proprio", null , this.stanzaPiena.getAttrezzo("matita"));


	}

	/**
	 * Test metodo removeAttrezzo
	 */

	@Test
	 public void testRemoveAttrezzoStanzaVuota() {
		  assertEquals("Non ci sono attrezzi",false, stanza.removeAttrezzo("penna"));
	  }
	
	@Test
	public void testRemoveAttrezzoConAttrezzoNonPresente() {

		assertEquals("Errore, l'attrezzo non era presente", false , this.stanzaPiena.removeAttrezzo("calcolatrice"));
	}
	
	@Test
	public void testRemoveAttrezzoConAttrezzoNullo() {
		assertEquals("Errore, non gli avevi dato nulla da rimuovere", false, this.stanzaPiena.removeAttrezzo(null));
	}
}
