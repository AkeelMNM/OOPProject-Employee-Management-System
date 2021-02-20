package com.ems.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class QueryUtil extends CommonUtil {
	
	//Method to Read EmployeeMSDBQuary.xml file and Retrieve Query by query id
	
	public static String queryByID(String id) throws SAXException,IOException,ParserConfigurationException
	{
		NodeList nodeList;
		Element element = null;
		
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\EmployeeMS\\WEB-INF\\EmployeeMSDBQuery.xml"))
				.getElementsByTagName(CommonConstants.TAG_NAME);
		
		for(int value = 0; value < nodeList.getLength(); value++)
		{
			element=(Element) nodeList.item(value);
			if(element.getAttribute(CommonConstants.ATT_ID).equals(id))
				break;
		}
		return element.getTextContent().trim();
	}

}
