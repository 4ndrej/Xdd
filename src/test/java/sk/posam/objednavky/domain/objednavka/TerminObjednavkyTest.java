package sk.posam.objednavky.domain.objednavka;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TerminObjednavkyTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTerminObjednavky10_30SaPrekryvaSObjednavkou10_20() {
		TerminObjednavky terminObjednavky10_30 = TerminObjednavkyFactory.create(10, 30);
		TerminObjednavky terminObjednavky10_20 = TerminObjednavkyFactory.create(10, 20);

		assertTrue(terminObjednavky10_30.prekryvaSa(terminObjednavky10_20));
		assertTrue(terminObjednavky10_20.prekryvaSa(terminObjednavky10_30));
	}

	@Test
	public void testTerminObjednavky10_30SaNeprekryvaSObjednavkou15_20() {
		TerminObjednavky terminObjednavky10_30 = TerminObjednavkyFactory.create(10, 30);
		TerminObjednavky terminObjednavky15_20 = TerminObjednavkyFactory.create(15, 20);

		assertFalse(terminObjednavky10_30.prekryvaSa(terminObjednavky15_20));
		assertFalse(terminObjednavky15_20.prekryvaSa(terminObjednavky10_30));
	}

}
