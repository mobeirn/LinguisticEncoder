package ie.gmit;

import java.util.*;

public class CodebookCreator {
	private static CodebookCreator uniqueInstance = new CodebookCreator();
	private Map<String, Collection<String>> codebook = new HashMap<String, Collection<String>>();
	private Map<String, String> decodebook = new HashMap<String, String>();
	private ConfigReader cfr = new ConfigReader();
	
	private LinkedList<String> words  = new LinkedList<String>();
	private Random rnd = new Random();
	private int start = 0;
	private int end = 25;
	private int step = 0;
	
	private CodebookCreator() {
		
	}
	
	public static CodebookCreator getInstance(){
		return uniqueInstance;
	}

	public void getCodebooks (){
		
		try {
			words = (LinkedList<String>) new ParserFactory().getParser(ParserType.WORDLIST).parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < words.size(); i++) {//by casting to int we lose the decimal portion, so it always rounds down
			String word = words.get(i);//get the present word from list
			
			if (i < 25) {//first 25 words
				codebook.put(word, numberList(1000, word));//1000 numbers per word for 75000 numbers
			}
			else if (i < 100) {//words 26 to 100
				codebook.put(word, numberList(170, word));//170 numbers
			}
			else if (i < 300) {//words 101 to 300. words.size()*0.15
				codebook.put(word, numberList(56, word));//56 numbers
			}
			else {
				int remainingWords = (words.size() - 300);//takes wordlist less 300 already used
				codebook.put(word, numberList(43 , word));
			}
		
			//put the word and the associated numberlist into the codebook
			start = end;
			end += step;
		}
	}
	public Collection<String> numberList (int step, String word){
		Collection<String> numbers = new LinkedList<String>();
		for (int i = 0; i < step; i++) {

			String num = null;//should be do while loop to make sure
			do {//
				int number = rnd.nextInt(cfr.getUpperLimit());
				num = String.format("%05d", number );//number in 5 digit padded format		
			} while (decodebook.containsKey(num));
			numbers.add(num);
			decodebook.put(num, word);

		}
		return numbers;
	}
		
	
	public Map<String, Collection<String>> getCodebook() {
		return codebook;
	}
	public Map<String, String> getDecodebook() {
		return decodebook;
	}
	
	

}
