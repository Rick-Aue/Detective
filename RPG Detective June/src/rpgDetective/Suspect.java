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
	
	private int SuspectChoice;
	public int getSuspectChoice() {
		return SuspectChoice;
	}

	public void setSuspectChoice(int suspectchoice) {
		SuspectChoice = suspectchoice;
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