package ie.gmit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestConfigReader {
	private ConfigReader reader; 
	private int upperLimit = 100000;
	private int listSize = 10;
	private String plaintext = "topTenWords.txt";

	@Before
	public void setUp() throws Exception {
		reader = new ConfigReader();
	}

	@After
	public void tearDown() throws Exception {
		reader = null;
	}

	@Test
	public void testGetUpperLimit() {
		assertEquals(reader.getUpperLimit(), upperLimit);
	}

	@Test
	public void testGetListSize() {
		assertEquals(reader.getListSize(), listSize);
	}

	@Test
	public void testGetPlainText() {
		assertTrue(reader.getPlainText().equals(plaintext));
	}

}
