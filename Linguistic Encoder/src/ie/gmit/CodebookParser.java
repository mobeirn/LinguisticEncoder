package ie.gmit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class CodebookParser extends Parser {
	String name = "Codebook Parser";
	private String word = null;
	private List<String> words = null;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public List parseFile(String file) throws Exception {//file may not be found
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			words = new LinkedList<String>();
	
			while ((word = br.readLine())!=null) {//Iterate over each line in the buffer until it is empty
				System.out.println(word);//for testing
				words.add(word);
				}
				
			br.close();//keep things tidy
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*System.out.println("--------------------------------------");
		System.out.println("Total number of words: " + words.size());
		System.out.println("Tenth word is " + ((LinkedList<String>) words).get(9));	*/
		return words;
	}

}
