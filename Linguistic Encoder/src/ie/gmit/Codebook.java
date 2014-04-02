package ie.gmit;

import java.util.Collection;
import java.util.Map;

public class Codebook {
	private CodebookCreator cbc = CodebookCreator.getInstance();
	
	

	public Map<String, Collection<String>> getCodebook() {
		cbc.getCodebooks();
		Map<String, Collection<String>> codebook = (cbc.getCodebook());
		return codebook;
	}

}
