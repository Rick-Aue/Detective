package rpgDetective;

public class QuestionAnswer extends Suspect {

	private String text;
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	private int charismaNeed;
	public int getcharismaNeed() {
		return charismaNeed;
	}

	public void setcharismaNeed(int charismaNeed) {
		this.charismaNeed = charismaNeed;
	}
	
	private int powerNeed;
	public int getpowerNeed() {
		return powerNeed;
	}

	public void setpowerNeed(int powerNeed) {
		this.powerNeed = powerNeed;
	}

	private int intelligenceNeed;
	public int getintelligenceNeed() {
		return intelligenceNeed;
	}

	public void setintelligenceNeed(int intelligenceNeed) {
		this.intelligenceNeed = intelligenceNeed;
	}
}