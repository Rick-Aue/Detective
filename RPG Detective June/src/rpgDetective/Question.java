package rpgDetective;

public class Question {

	private Question Question[];
	public Question[] getQuestion() {
		return Question;
	}

	public void setQuestion(Question[] Question) {
		this.Question = Question;
	}
	public Question getQuestion(int i){
		return Question[i];
	}
	
	private String text;
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
