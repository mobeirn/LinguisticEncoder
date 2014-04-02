package ie.gmit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ConfigReader {
	private String upperLimitTag = "upper-limit";
	private String listSizeTag = "list-size";
	private String plaintextTag = "plaintext";
	private String wordListTag = "wordlist";
	
	public int getUpperLimit(){	
		return getConfigNumberInfo(upperLimitTag);
	}
	
	public int getListSize(){		
		return getConfigNumberInfo(listSizeTag);
	}
	
	public String getPlainText() {		
		return getConfigTextInfo(plaintextTag);
	}
	
	public String getWordList() {		
		return getConfigTextInfo(wordListTag);
	}
	
	private int getConfigNumberInfo(String tag) {
		int type = 0;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db =  dbf.newDocumentBuilder();
			String configFile = "config.xml";
			
			Document doc = db.parse(configFile);
			NodeList n = doc.getElementsByTagName(tag);
			type = Integer.parseInt(n.item(0).getFirstChild().getNodeValue());
		} catch (Exception e) {
			System.out.println("Problem getting configuration information: ");
			e.printStackTrace();
		}
		return type;
	}
	
	private String getConfigTextInfo(String tag) {
		String type = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db =  dbf.newDocumentBuilder();
			String configFile = "config.xml";
			
			Document doc = db.parse(configFile);
			NodeList n = doc.getElementsByTagName(tag);
			type = n.item(0).getFirstChild().getNodeValue();
		} catch (Exception e) {
			System.out.println("Problem getting configuration information: ");
			e.printStackTrace();
		}
		return type;
	}

}
