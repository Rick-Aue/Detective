package rpgDetective;

public class QuestionAnswer extends Suspect {

	private String text;
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	private int maxQuestions;
	public int getmaxQuestions() {
		return maxQuestions;
	}

	public void setmaxQuestions(int maxquestions) {
		maxQuestions = maxquestions;
	}
	
	private String personAppearance = "onbekend";
	public String getpersonAppearance() {
		return personAppearance;
	}

	public void setpersonAppearance(String personappearance) {
		personAppearance = personappearance;
	}
	
	private String personName = "onbekend";
	public String getpersonName() {
		return personName;
	}

	public void setpersonName(String personname) {
		personName = personname;
	}
	
	private String personAge = "onbekend";
	public String getpersonAge() {
		return personAge;
	}

	public void setpersonAge(String personage) {
		personAge = personage;
	}
	
	
}