package ie.gmit;

public abstract class AbstractParser {
	
	public Parser getParser(String type){
		Parser parser;
		
		parser = createParser(type);
		return parser;
	}
	
	protected abstract Parser createParser(String type);

}
