package ie.gmit;

public class TestRunner {
	public static void main(String[] args) {
		ParserFactory parserFactory = new ParserFactory();
		
		Parser parser1 = parserFactory.getParser(ParserType.WORDLIST);
		
		try {
			System.out.println(parser1.parse().size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Codebook cb = new Codebook();
		
		System.out.println(cb.getCodebook().size());
	}

}
