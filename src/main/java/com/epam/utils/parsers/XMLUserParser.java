package com.epam.utils.parsers;

import com.epam.model.User;
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

public class XMLUserParser {
    public List<User> users = new ArrayList<>();
    public User user;
    private static final Logger log = Logger.getLogger(XMLUserParser.class);

    public List<User> parseUserXML() {
        //Initialize a list of users
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("src/main/resources/logindata.xml"));
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("user");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    //Create new User Object
                    this.user = new User();
                    this.user.setLogin(eElement.getElementsByTagName("login").item(0).getTextContent());
                    this.user.setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());
                    users.add(user);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            log.info(e.getMessage());
        }
        return users;
    }

}
