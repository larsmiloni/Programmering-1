public class Name {

	String firstname;
	String middleName;
	String lastName;

	public Name(String firstName, String middleName, String lastName){
		this.firstname = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	public String getFirstName(){
		return firstname;
	}
	public String getMiddleName(){
		return middleName;
	}
	public String getLastName(){
		return lastName;
	}
	public String fullName(){
		return ("Hi, my name is " + this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName());
	}

	public static void main(String[] args){
		Name name = new Name("Lars Mikkel","Lødeng","Nilsen");
		System.out.println(name.fullName());
	}
}