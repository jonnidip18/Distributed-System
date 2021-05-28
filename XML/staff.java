package XML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class staff {
	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// parse XML file
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("XML/staff.xml"));
			
			Element rootElement = (Element) doc.getDocumentElement();
			NodeList staffs = rootElement.getElementsByTagName("staff");

			for(int i = 0; i<staffs.getLength(); i++) {
				Element staff = (Element) staffs.item(i);
				
				System.out.println("ID: " + staff.getAttribute("id"));
				System.out.println("Firstname : " + staff.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println("Lastname : " + staff.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println("Salary : " + staff.getElementsByTagName("salary").item(0).getTextContent() 
									+ ((Element) staff.getElementsByTagName("salary").item(0)).getAttribute("currency"));
				System.out.println("Nickname: "+ staff.getElementsByTagName("nickname").item(0).getTextContent());
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
