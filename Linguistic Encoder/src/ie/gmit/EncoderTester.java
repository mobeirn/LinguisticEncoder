package ie.gmit;

import java.util.*;

public class EncoderTester {

	public static void main(String[] args) {
		Collection<String> plaintextWords;
		// TODO Auto-generated method stub
		
		try {
			plaintextWords = (List<String>) new ParserFactory().getParser(ParserType.PLAINTEXT).parse();
			System.out.println(plaintextWords);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
