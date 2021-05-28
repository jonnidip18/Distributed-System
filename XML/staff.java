package XML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class staff {
	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// parse XML file
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("XML/staff.xml"));

			System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
			System.out.println("------");

			String name = doc.getElementsByTagName("name").item(0).getTextContent();
			String salary = doc.getElementsByTagName("salary").item(0).getTextContent();

			System.out.println("Name : " + name);
			System.out.println("salarye : " + salary);

		} catch (ParserConfigurationException | SAXException | IOException | NullPointerException e) {
			e.printStackTrace();
		}
	}
}
