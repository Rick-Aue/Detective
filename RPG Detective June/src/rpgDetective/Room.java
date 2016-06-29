package rpgDetective;

public class Room {
	
	private String Name;
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	private int RoomChoice;
	public int getRoomChoice() {
		return RoomChoice;
	}

	public void setRoomChoice(int roomchoice) {
		RoomChoice = roomchoice;
	}
	
	private String text;
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}