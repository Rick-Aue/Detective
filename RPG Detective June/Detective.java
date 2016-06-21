package rpgDetective;

public class Detective extends Person {
	//Player variables
	
	private int points = 100;			
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

	private int power = 0;
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	private int intelligence = 0;
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	
	private int charisma = 0;
	public int getCharisma() {
		return charisma;
	}
	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
	

}
