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
	
	private rpgDetective.Answer[] Answer;
	public rpgDetective.Answer[] getAnswer() {
		return Answer;
	}

	public void setAnswer(Answer[] Answer) {
		this.Answer = Answer;
	}
	public rpgDetective.Answer getAnswer(int i){
		return Answer[i];
	}
	
}