package ie.gmit;

import java.io.File;
import java.util.*;

public class WordListParser extends Parser {//parses lists of words, one word per line
	private LinkedList<String> words = new LinkedList<String>();

	@Override
	public Collection<String> parse() throws Exception {
		String file = (new ConfigReader().getWordList());//gets word list from config file
		Scanner scan = new Scanner(new File(file));
		while (scan.hasNext()) {//keep going until end of file
			String word = (String) scan.next();//get word
			words.add(word);//add to collection
			
		}
		scan.close();
		return words;
	}
}

