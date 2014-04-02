package ie.gmit;

import java.io.*;
import java.util.*;

public class CodebookFileToText extends Parser{
	private String word = null;
	private Collection<String> words = null;
		
	public CodebookFileToText() {
		super();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public Collection parseFile(String file) throws Exception {//file may not be found
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			words = new LinkedList<String>();
	
			while ((word = br.readLine())!=null) {//Iterate over each line in the buffer until it is empty
				System.out.println(word);
				words.add(word);
				}
				
			br.close();//keep things tidy
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------------------");
		System.out.println("Total number of words: " + words.size());
		System.out.println("Tenth word is " + ((LinkedList<String>) words).get(9));	
		return words;
	}

}
