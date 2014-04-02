package ie.gmit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubNumsTester {

	public static void main(String[] args) throws Exception {
		Map<String, List<String>> codebook = new HashMap<String, List<String>>();
		Collection<String> numbers = new ParserFactory().getParser(ParserType.NUMBERS).parse();
		LinkedList<String> words = (LinkedList<String>) new ParserFactory().getParser(ParserType.WORDLIST).parse();
		int start = 0;
		int end = 25;
		int step = 0;
		
		long startTime;
		long endTime;
		
		SubNumsTester snt = new SubNumsTester();
		System.out.println(numbers.size());
		
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < words.size(); i++) {//by casting to int we lose the decimal portion, so it always rounds down
			if (i < 25) {//first 25 words
				step = (int) ((numbers.size()*0.33)/25);//1000 numbers per word for 75000 numbers
			}
			else if (i < 100) {//words 26 to 100
				step = (int) ((numbers.size()*0.17)/75);//170 numbers
			}
			else if (i < 300) {//words 101 to 300. words.size()*0.15
				step = (int) ((numbers.size()*0.15)/200);//56 numbers
			}
			else {
				int remainingWords = (words.size() - 300);//takes wordlist less 300 already used
				step = (int) ((numbers.size()*0.35f)/remainingWords);//calculates amount of numbers for each word
			}
			//can't cast from HashSet to List directly
			List<String> subNumbers = snt.subNums(new ArrayList<String>(numbers), start, end);
			
			codebook.put(words.get(i), subNumbers);
			start = end;
			end += step;
		}
		endTime = System.currentTimeMillis();
		//System.out.println(codebook);
		
		for(Map.Entry<String, List<String>> entry: codebook.entrySet()) {//gets key pair values of codebook
		    System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println("Time taken for codebook: " + (endTime - startTime) + " milliseconds");
		System.out.println(codebook.containsKey("sharp"));

	}
	
	private List<String> subNums(Collection<String> numbers,int start, int end){//gets sub lists of numbers
		return ((List<String>)numbers).subList(start, end);//has to be a list to use subList()
	}

}
