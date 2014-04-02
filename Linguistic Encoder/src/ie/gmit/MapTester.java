package ie.gmit;

import java.util.*;

public class MapTester {
	
	public static void main(String[] args) {
		int upperlimit = 30;
		Collection<String> words = null;
		Collection<String> numbers = null;
		List<String> subNums = null;
		Map<String, List<String>> codebook = new HashMap<String, List<String>>();
		int start = 0;
		int end = 2;
		int step = 2;
		
		try {
			words = new ParserFactory().getParser(ParserType.WORDLIST).parse();
			System.out.println(words);
			numbers = new ParserFactory().getParser(ParserType.NUMBERS).parse();
			System.out.println(numbers);
			System.out.println(numbers.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		/*for (String word : words) {
			for (int i = 0; i < words.size(); i++) {
				subNums = ((List<String>) numbers).subList(start, end);
				codebook.put(word, subNums);
				start = end;
				end += step;
			}
		}
		System.out.println(codebook);*/
	
		
/*		for (String word : words) {
			System.out.println(word);
			List<String> subNums = ((List<String>) numbers).subList(0, (int) (upperlimit * 0.33));
			codebook.put(word, subNums);
			System.out.println(codebook.keySet());
			System.out.println(codebook.values());
			System.out.println("-----------------------");
		}
		
		while (end < upperlimit) {
			for (String word : words) {
				List<String> subNums = ((List<String>) numbers).subList(start, end);
				codebook.put(word, subNums);
				System.out.println(codebook.values());
				System.out.println(codebook.keySet());
				System.out.println("----------------------");
				if (end <= upperlimit * 0.33) {
					step = 3;
				}
				else if (end <= upperlimit * 0.66) {
					step = 2;
				}
				else step = 1;
				
				start = end;
				end += step;
			}
		}
		System.out.println("End of program");*/
	}
	
	private List<String> subNums(Collection<String> numbers,int start, int end){
		return ((List<String>)numbers).subList(start, end);
	}
}
