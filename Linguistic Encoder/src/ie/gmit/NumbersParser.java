package ie.gmit;

import java.util.*;


public class NumbersParser extends Parser {

	@Override
	public Collection<String> parse() throws Exception {
		// TODO Auto-generated method stub
		RandomListGenerator rlg = new RandomListGenerator();
		return rlg.numberlist();
	}
	
}
