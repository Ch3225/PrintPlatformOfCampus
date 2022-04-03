package pfpsc.model.define;

import java.util.List;

public class Question {
    private Integer qid;
    private Integer defaultAnswer;
    private String note;
    private List<Answer> answerList;
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<Answer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	public Integer getDefaultAnswer() {
		return defaultAnswer;
	}
	public void setDefaultAnswer(Integer defaultAnswer) {
		this.defaultAnswer = defaultAnswer;
	}
	
	public Answer getAnswerById(Integer answerId) {
		for(Answer answer:answerList) {
			if(answer.getAid()==answerId) {
				return answer;
			}
		}
		return null;
	}
}