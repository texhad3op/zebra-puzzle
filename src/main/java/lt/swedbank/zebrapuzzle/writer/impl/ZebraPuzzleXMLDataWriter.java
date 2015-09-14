package lt.swedbank.zebrapuzzle.writer.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import lt.swedbank.zebrapuzzle.data.House;
import lt.swedbank.zebrapuzzle.utils.FormatDescriber;
import lt.swedbank.zebrapuzzle.writer.ZebraPuzzleDataWriter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;

public class ZebraPuzzleXMLDataWriter extends ZebraPuzzleDataWriter {

	public ZebraPuzzleXMLDataWriter(FormatDescriber formatDescriber) {
		super(formatDescriber);
	}

	public Document getDecisionDOM(List<House[]> solution) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		}
		Document document = documentBuilder.newDocument();
		ProcessingInstruction pi = document.createProcessingInstruction(
				"xml-stylesheet", "type=\"text/xsl\" href=\"solutions.xsl\"");
		Element decision = document.createElement("solutions");
		document.appendChild(decision);
		document.insertBefore(pi, decision);
		for (House[] houses : solution) {
			Element solutionDOM = document.createElement("solution");
			decision.appendChild(solutionDOM);
			for (House house : houses) {
				Element houseDOM = document.createElement("house");
				solutionDOM.appendChild(houseDOM);
				for (Entry<String, String> property : house.getProperties()
						.entrySet()) {
					houseDOM.setAttribute(property.getKey(),
							property.getValue());
				}
			}
		}
		return document;
	}

	public void writeData(List<House[]> decision) {
		Document document = getDecisionDOM(decision);
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			throw new RuntimeException(e);
		}
		DOMSource source = new DOMSource(document);
		File file = new File(formatDescriber.getFile());
		FileOutputStream fop = null;
		try {
			fop = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		StreamResult result = new StreamResult(fop);
		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			throw new RuntimeException(e);
		}
	}
}
