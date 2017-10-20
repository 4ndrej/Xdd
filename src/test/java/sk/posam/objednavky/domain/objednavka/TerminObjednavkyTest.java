package sk.posam.objednavky.domain.objednavka;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TerminObjednavkyTest {

	private TerminObjednavky terminObjednavky10_30;
	private TerminObjednavky terminObjednavky10_20;
	private TerminObjednavky terminObjednavky15_20;

	@Before
	public void setUp() throws Exception {
		terminObjednavky10_30 = TerminObjednavkyFactory.create(10, 30);
		terminObjednavky10_20 = TerminObjednavkyFactory.create(10, 20);
		terminObjednavky15_20 = TerminObjednavkyFactory.create(15, 20);
	}

	@Test
	public void testTerminObjednavky10_30SaPrekryvaSObjednavkou10_20() {

		assertTrue(terminObjednavky10_30.prekryvaSa(terminObjednavky10_20));
		assertTrue(terminObjednavky10_20.prekryvaSa(terminObjednavky10_30));
	}

	@Test
	public void testTerminObjednavky10_30SaNeprekryvaSObjednavkou15_20() {

		assertFalse(terminObjednavky10_30.prekryvaSa(terminObjednavky15_20));
		assertFalse(terminObjednavky15_20.prekryvaSa(terminObjednavky10_30));
	}

}
