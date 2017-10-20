package sk.posam.objednavky.domain.objednavka;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import sk.posam.objednavky.domain.osoba.Osoba;

public class ObjednavkyNaDenTest {

	ObjednavkyNaDen objednavkyNaDnes;
	TerminObjednavky termin_15_00;
	TerminObjednavky termin_10_00;

	@Before
	public void setUp() {
		termin_10_00 = TerminObjednavkyFactory.create(10, 00);
		termin_15_00 = TerminObjednavkyFactory.create(15, 00);

		objednavkyNaDnes = new ObjednavkyNaDen(LocalDate.now());
		objednavkyNaDnes.objednaj(new Objednavka(new Osoba("Albert", "Einstein"), TerminObjednavkyFactory.create(10, 00)));
		objednavkyNaDnes.objednaj(new Objednavka(new Osoba("Issac", "Newton"), TerminObjednavkyFactory.create(11, 00)));
		objednavkyNaDnes.objednaj(new Objednavka(new Osoba("Niels", "Bohr"), TerminObjednavkyFactory.create(12, 30)));
	}

	@Test
	public void testJeVolno15_00() {
		assertTrue(objednavkyNaDnes.jeVolno(termin_15_00));
	}

	@Test
	public void testJeVolno10_00() {
		assertFalse(objednavkyNaDnes.jeVolno(termin_10_00));
	}

}
