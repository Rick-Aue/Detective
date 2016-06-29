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
	
	private String suspectAppearance = "onbekend";
	public String getsuspectAppearance() {
		return suspectAppearance;
	}

	public void setsuspectAppearance(String suspectappearance) {
		suspectAppearance = suspectappearance;
	}
	
	private String suspectName = "onbekend";
	public String getsuspectName() {
		return suspectName;
	}

	public void setsuspectName(String suspectname) {
		suspectName = suspectname;
	}
	
	private String suspectAge = "onbekend";
	public String getsuspectAge() {
		return suspectAge;
	}

	public void setsuspectAge(String suspectage) {
		suspectAge = suspectage;
	}
}
