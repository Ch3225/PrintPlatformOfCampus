package pfpsc.model.define;

import java.util.List;
import java.util.Map;

import pfpsc.constant.QuestionNaireConstant;
import pfpsc.util.MapUtility;

public class QuestionNaire {
	public static String renderMethodToString(String methodString) {
		String information=MapUtility.getInformationByString(methodString);
		Map<String,String> choiceMap=MapUtility.getMapByString(methodString);
		String questionNaireId=information.replace("n", "");
		Integer questionNaireIdInteger=Integer.parseInt(questionNaireId);
		QuestionNaire questionNaire = QuestionNaireConstant.questionNaires.get(questionNaireIdInteger);
		return questionNaire.renderToString(choiceMap);
	}
	
	private int nid;
	private String note;
	private List<Question> keys;
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<Question> getKeys() {
		return keys;
	}
	public void setKeys(List<Question> keys) {
		this.keys = keys;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	
	public String choiceStringListToString(List<String> choiceList) {
		String string = "n"+nid+"?";
		
		for (int i = 0; i < keys.size(); i++) {
			String str = choiceList.get(i);
			Integer defaultAnswer = getKeys().get(i).getDefaultAnswer().getAid();
			if (str.equalsIgnoreCase("" + defaultAnswer)) {

			} else {
				string += ("" + (i + 1) + ":" + str + ";");
			}
		}
		
		return string;
	}
	public String renderToString(Map<String,String> methodMap) {
		String string=""+this.note+"。";
		for(Question question:keys) {
			String answerId = methodMap.get(question.getQid().toString());
			if(answerId==null) {
				string+=
						question.getNote()+":"
						+question.getAnswerById(question.getDefaultAnswer().getAid())+";";
			} else {
				string+=
						question.getNote()+":"
						+question.getAnswerById(Integer.parseInt(answerId))+";";
			}
		}
		return string;
	}
	public String makeStringWithChoice(String string) {
		String re="";
		re+=note+";";
		Map<String, String> map = MapUtility.getMapByString(string);
		for(Question question:keys) {
			if(map.get(question.getQid().toString())!=null) {
				String answerid=map.get(question.getQid().toString());
				Answer answer=question.getAnswerById(Integer.parseInt(answerid));
				re+=question.getNote()+":"+answer.getNote()+";";
			}else {
				Answer answer=question.getDefaultAnswer();
				re+=question.getNote()+":"+answer.getNote()+";";
			}
		}
		return re;
	}
	
}
