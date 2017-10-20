package sk.posam.objednavky.domain.objednavka;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sk.posam.objednavky.domain.osoba.Osoba;

public class ObjednavkaTest {

	private Osoba osoba;
	private TerminObjednavky terminObjednavky;
	private TerminObjednavky termin_10_30;
	private TerminObjednavky termin_15_30;

	@Before
	public void setUp() {
		osoba = new Osoba("Albert", "Einstein");
		terminObjednavky = TerminObjednavkyFactory.create(10, 30);
		termin_10_30 = TerminObjednavkyFactory.create(10, 30);
		termin_15_30 = TerminObjednavkyFactory.create(15, 30);
	}

	@Test
	public void testVTremine10_30JeVolno() {
		Objednavka objednavka = new Objednavka(osoba, terminObjednavky);
		assertFalse(objednavka.terminJeObsadeny(termin_15_30));
	}

	@Test
	public void testVTremine10_30NieJeJeVolno() {
		Objednavka objednavka = new Objednavka(osoba, terminObjednavky);
		assertTrue(objednavka.terminJeObsadeny(termin_10_30));
	}

}
