package pfpsc.constant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

import pfpsc.model.define.Answer;
import pfpsc.model.define.Question;
import pfpsc.model.define.QuestionNaire;
import pfpsc.util.MapUtility;

public class QuestionNaireConstant {
	public static Map<Integer,QuestionNaire> questionNaires;
	
	public static String translate(String string) {
		QuestionNaire questionNaire=QuestionNaireConstant.getQuestionNaireByInformation(string);
		return questionNaire.makeStringWithChoice(string);
	}
	
	public static QuestionNaire getQuestionNaireByInformation(String string) {
		String informationString=MapUtility.getInformationByString(string);
		String substring = informationString.substring(1);
		Integer integer=Integer.parseInt(substring);
		return questionNaires.get(integer);
	}
	
	public static void onLoad() {
		questionNaires = new HashedMap<Integer,QuestionNaire>();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 创建DocumentBuilder对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下
			Document document = db.parse("./src/main/resources/static/xml/QuestionNaires.xml");
			NodeList questionNaireList = document.getElementsByTagName("questionnaire");
			for (int i = 0; i < questionNaireList.getLength(); i++) {// para to questionnaire
				Node questionNaireNode = questionNaireList.item(i);

				QuestionNaire questionNaire = new QuestionNaire();

				NamedNodeMap questionNaireAttributes = questionNaireNode.getAttributes();
				Integer nid = Integer.parseInt(questionNaireAttributes.getNamedItem("nid").getNodeValue());
				questionNaire.setNid(nid);

				NodeList questionNaireNodeList = questionNaireNode.getChildNodes();
				List<Question> questions = new ArrayList<Question>();
				for (int j = 0; j < questionNaireNodeList.getLength(); j++) {// para to question
					Node questionNaireItemNode = questionNaireNodeList.item(j);

					if (questionNaireItemNode.getNodeName().equals("note")) {
						String questionNaireNote = questionNaireItemNode.getTextContent();
						questionNaire.setNote(questionNaireNote);
					} else if(questionNaireItemNode.getNodeType()==Node.ELEMENT_NODE){
						Question question = new Question();

						NamedNodeMap questionAttributes = questionNaireItemNode.getAttributes();
						Integer qid = Integer.parseInt(questionAttributes.getNamedItem("qid").getNodeValue());
						question.setQid(qid);
						Integer def = Integer.parseInt(questionAttributes.getNamedItem("default").getNodeValue());
						question.setDefaultAnswer(def);

						NodeList questionNodeList = questionNaireItemNode.getChildNodes();
						List<Answer> answers = new ArrayList<Answer>();
						for (int k = 0; k < questionNodeList.getLength(); k++) {
							Node questionItemNode = questionNodeList.item(k);

							if (questionItemNode.getNodeName().equals("note")) {
								String questionNote = questionItemNode.getTextContent();
								question.setNote(questionNote);
							} else if(questionItemNode.getNodeType()==Node.ELEMENT_NODE){
								Answer answer = new Answer();

								NamedNodeMap answerAttributes = questionItemNode.getAttributes();
								Integer aid = Integer.parseInt(answerAttributes.getNamedItem("aid").getNodeValue());
								answer.setAid(aid);

								NodeList answerNodeList = questionItemNode.getChildNodes();
								for (int l = 0; l < answerNodeList.getLength(); l++) {
									if (answerNodeList.item(l).getNodeName().equals("note")) {
										String answerNote = answerNodeList.item(l).getTextContent();
										answer.setNote(answerNote);
									}
									
								}

								answers.add(answer);
							}
						}
						question.setAnswerList(answers);

						questions.add(question);
					}
				}
				questionNaire.setKeys(questions);
				questionNaires.put(nid, questionNaire);
			}

		} catch (IOException | ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
