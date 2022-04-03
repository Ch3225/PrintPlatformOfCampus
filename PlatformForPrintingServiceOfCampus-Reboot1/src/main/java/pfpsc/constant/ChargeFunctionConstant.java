package pfpsc.constant;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.collections4.map.HashedMap;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import pfpsc.model.define.ChargeFunction;
import pfpsc.model.define.Reference;

public class ChargeFunctionConstant {
	public static Map<Integer, ChargeFunction> chargeMethodMap;
	public static ChargeFunction findChargeMethodById(Integer chargeFunctionId) {
		return chargeMethodMap.get(chargeFunctionId);
	}
	public static void onLoad() {
		chargeMethodMap = new HashedMap<Integer, ChargeFunction>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 创建DocumentBuilder对象
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			// 通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下
			Document document = db.parse("./src/main/resources/static/xml/ChargeMethods.xml");
			NodeList ChargeMethodList = document.getElementsByTagName("ChargeMethod");
			for (int i = 0; i < ChargeMethodList.getLength(); i++) {// para to chargemethod
				Node chargeMethodNode = ChargeMethodList.item(i);

				ChargeFunction chargeFunction = new ChargeFunction();

				NamedNodeMap chargeFunctionAttributes = chargeMethodNode.getAttributes();
				Integer mid = Integer.parseInt(chargeFunctionAttributes.getNamedItem("mid").getNodeValue());
				chargeFunction.setMid(mid);

				NodeList chargeMethodNodeList = chargeMethodNode.getChildNodes();
				for (int j = 0; j < chargeMethodNodeList.getLength(); j++) {// para to arguments
					Node chargeMethodItemNode = chargeMethodNodeList.item(j);
					NodeList argumentNodeList = chargeMethodItemNode.getChildNodes();

					switch (chargeMethodItemNode.getNodeName()) {
					case "arguments-shop":
						for (int k = 0; k < argumentNodeList.getLength(); k++) {
							Node argumentAtrribute = argumentNodeList.item(k);
							if (argumentAtrribute.getNodeName().equals("argument")) {
								NodeList chargeArgumentItemNode = argumentAtrribute.getChildNodes();
								Reference reference=new Reference();
								for(int l=0;l<chargeArgumentItemNode.getLength();l++) {
									Node node=chargeArgumentItemNode.item(l);
									if (node.getNodeName().equals("note")) {
										reference.setNote(node.getTextContent());
									}else if(node.getNodeName().equals("name")) {
										reference.setName(node.getTextContent());
									}
								}
								chargeFunction.addShopReference(reference);
							}
						}
						break;
					case "arguments-customer":
						for (int k = 0; k < argumentNodeList.getLength(); k++) {
							Node argumentAtrribute = argumentNodeList.item(k);
							if (argumentAtrribute.getNodeName().equals("argument")) {
								NodeList chargeArgumentItemNode = argumentAtrribute.getChildNodes();
								Reference reference=new Reference();
								for(int l=0;l<chargeArgumentItemNode.getLength();l++) {
									Node node=chargeArgumentItemNode.item(l);
									if (node.getNodeName().equals("note")) {
										reference.setNote(node.getTextContent());
									}else if(node.getNodeName().equals("name")) {
										reference.setName(node.getTextContent());
									}
								}
								chargeFunction.addcustomerReferences(reference);
							}
						}
						break;
					case "arguments-fee":
						for (int k = 0; k < argumentNodeList.getLength(); k++) {
							Node argumentAtrribute = argumentNodeList.item(k);
							if (argumentAtrribute.getNodeName().equals("argument")) {
								NodeList chargeArgumentItemNode = argumentAtrribute.getChildNodes();
								Reference reference=new Reference();
								for(int l=0;l<chargeArgumentItemNode.getLength();l++) {
									Node node=chargeArgumentItemNode.item(l);
									if (node.getNodeName().equals("note")) {
										reference.setNote(node.getTextContent());
									}else if(node.getNodeName().equals("name")) {
										reference.setName(node.getTextContent());
									}
								}
								chargeFunction.setCharge(reference);
							}
						}
						break;
					case "function":
						chargeFunction.setFunction(chargeMethodItemNode.getTextContent());
						break;
					}
				}
				chargeMethodMap.put(mid, chargeFunction);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
