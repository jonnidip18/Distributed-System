package HW04_06_01;

import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Object2Doc {
	public static String convertObject2Doc(Student student) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();

		Element root = doc.createElement("students");
		doc.appendChild(root);

		root.appendChild(createStudent(doc, student.getId(), student.getName(), student.getGrade()));
		// test
		String xmlString = convertDoc2XmlString(doc);
		return xmlString;
	}
	
	public static String convertObjects2Doc(List<Student> students) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();

		Element root = doc.createElement("students");
		doc.appendChild(root);
		for(Student student:students) {
			root.appendChild(createStudent(doc, student.getId(), student.getName(), student.getGrade()));
		}
		// test
		String xmlString = convertDoc2XmlString(doc);
		return xmlString;
	}

	private static Node createStudent(Document doc, int id, String name, double grade) {
		Element student = doc.createElement("student");
		
		Element idNode = doc.createElement("id");
		idNode.appendChild(doc.createTextNode(id+""));
		student.appendChild(idNode);
		
		Element nameNode = doc.createElement("name");
		nameNode.appendChild(doc.createTextNode(name));
		student.appendChild(nameNode);
		
		Element gradeNode = doc.createElement("grade");
		gradeNode.appendChild(doc.createTextNode(grade+""));
		student.appendChild(gradeNode);

		return student;
	}
	
	public static String convertDoc2XmlString(Document doc) {
		String output = "";
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = tf.newTransformer();
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));
			output = writer.getBuffer().toString();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
		return output;
	}
}
