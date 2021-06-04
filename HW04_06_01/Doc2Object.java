package HW04_06_01;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Doc2Object {
	public static List<Student> XMLtoStudents(String xml) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;		
		List<Student> students = new ArrayList<Student>();
		Student student = null;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xml)));
			NodeList nl = doc.getElementsByTagName("student");

			for (int i = 0; i < nl.getLength(); i++) {
				Node n = nl.item(i);
				Element e = (Element) n;
				String id = e.getElementsByTagName("id").item(0).getTextContent();
				String name = e.getElementsByTagName("name").item(0).getTextContent();
				String grade = e.getElementsByTagName("grade").item(0).getTextContent();
				student = new Student(Integer.parseInt(id),name,Double.parseDouble(grade));
				students.add(student);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return students;
	}
	
	public static Student XMLtoStudent(String xml) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;		
		Student student = null;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xml)));
			NodeList nl = doc.getElementsByTagName("student");

			for (int i = 0; i < nl.getLength(); i++) {
				Node n = nl.item(i);
				Element e = (Element) n;
				String id = e.getElementsByTagName("id").item(0).getTextContent();
				String name = e.getElementsByTagName("name").item(0).getTextContent();
				String grade = e.getElementsByTagName("grade").item(0).getTextContent();
				student = new Student(Integer.parseInt(id),name,Double.parseDouble(grade));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return student;
	}
}
