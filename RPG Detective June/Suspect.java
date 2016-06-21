package rpgDetective;

public class Suspect extends Person {
	//naam
	//leeftijd
	//uiterlijk
	//kenmerken
	//arrays voor verdachten antwoorden
	
	
	private String Appearance;
	public String getAppearance() {
		return Appearance;
	}

	public void setAppearance(String appearance) {
		Appearance = appearance;
	}
	
	/*
	private QuestionAnswer QuestionAnswer[];
	public QuestionAnswer[] getQuestionAnswer() {
		return QuestionAnswer;
	}

	public void setQuestionAnswer(QuestionAnswer[] QuestionAnswer) {
		this.QuestionAnswer = QuestionAnswer;
	}
	public QuestionAnswer getQuestionAnswer(int i){
		return QuestionAnswer[i];
	}
	 */
	private boolean NameKnown = false;
	public boolean getNameKnown() {
		return NameKnown;
	}

	public void setNameKnown(boolean nameknown) {
		NameKnown = nameknown;
	}
	
	private boolean AppearanceKnown = false;
	public boolean getAppearanceKnown() {
		return AppearanceKnown;
	}

	public void setAppearanceKnown(boolean appearanceknown) {
		AppearanceKnown = appearanceknown;
	}
	
	private boolean AgeKnown = false;
	public boolean getAgeKnown() {
		return AgeKnown;
	}

	public void setAgeKnown(boolean ageknown) {
		AgeKnown = ageknown;
	}
	
	private boolean DiningRoomKnown = false;
	public boolean getDiningRoomKnown() {
		return DiningRoomKnown;
	}

	public void setDiningRoomKnown(boolean diningroomknown) {
		DiningRoomKnown = diningroomknown;
	}
	
	private int SuspectChoice;
	public int getSuspectChoice() {
		return SuspectChoice;
	}

	public void setSuspectChoice(int suspectchoice) {
		SuspectChoice = suspectchoice;
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