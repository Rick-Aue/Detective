package rpgDetective;

public class Person {
	
	String Name = "onbekend";
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	String age;
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	private String Gender;
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		this.Gender = gender;
	}
	
	private String text;
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}