package rpgDetective;

public class Answer {
	
	private Answer Answer[];
	public Answer[] getAnswer() {
		return Answer;
	}

	public void setAnswer(Answer[] Answer) {
		this.Answer = Answer;
	}
	public Answer getAnswer(int i){
		return Answer[i];
	}
	
	private String text;
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
