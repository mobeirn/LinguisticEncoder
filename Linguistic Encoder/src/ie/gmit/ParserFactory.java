package ie.gmit;

public class ParserFactory {

	public Parser getParser(ParserType type){
		switch (type) {
		case NUMBERS:
			return new NumbersParser();
		case WORDLIST:
			return new WordListParser();
		case PLAINTEXT:
			return new PlainTextParser();
		case CYPHERTEXT:
			return new CypherTextParser();
		case DECODEDTEXT:
			return new DecodedTextParser();
		default:
			return null;
		}
	}

}
