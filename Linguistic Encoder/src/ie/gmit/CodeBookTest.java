package ie.gmit;

import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CodeBookTest {
	private String textFile = null;
	private Collection<String> words = null;
	Parser scanText = null;
	

	@Before
	public void setUp() throws Exception {
		textFile = "dictionary.txt";
		
	}

	@After
	public void tearDown() throws Exception {
		textFile = null;
		words = null;
		scanText = null;
	}

	@Test
	public void parseFileGetNameTest(){
		scanText = new CodebookParser();
		assert equals(scanText.getName().equals("Codebook Parser"));
		
	}
	@Test
	public void parseFileTestSize(){
		try {
			scanText.parseFile(textFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert equals(words.size() == 900);
		
	}

}
