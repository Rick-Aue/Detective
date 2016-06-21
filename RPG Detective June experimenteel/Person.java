package rpgDetective;

public class Person {
	
	String Name = "onbekend";
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	int age;
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	private String Gender;
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		this.Gender = gender;
	}
}