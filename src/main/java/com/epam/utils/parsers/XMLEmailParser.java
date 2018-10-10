package com.epam.utils.parsers;

import com.epam.model.Email;


import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class XMLEmailParser {
    public List<Email> emails = new ArrayList<>();
    public Email email;
    private static final Logger log = Logger.getLogger(XMLEmailParser.class);

    public List parseEmailXML() {
        //Initialize a list of users
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("src/main/resources/datasorce.xml"));
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("email");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    //Create new Email Object
                    email = new Email();
                    email.setReceiver(eElement.getElementsByTagName("receiver").item(0).getTextContent());
                    email.setSubject(eElement.getElementsByTagName("subject").item(0).getTextContent());
                    email.setText(eElement.getElementsByTagName("text").item(0).getTextContent());
                    emails.add(email);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            log.info(e.getMessage());
        }
        return emails;
    }

}
