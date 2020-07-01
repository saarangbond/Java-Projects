public class Contact{
	private String firstName;
	private String lastName;
	private String email;
	
	public Contact(String firstName, String lastName, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public String toString(){
		return firstName + " " + lastName + ": " + email;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public String getUsername(){
		String username = email.substring(0, email.indexOf("@"));
		return username;
	}
	public String getDomainName(){
		String domainName = email.substring(email.indexOf("@") + 1, email.lastIndexOf("."));
		return domainName;
	}
		
	public String getDomainExtension(){
		String domainExtension = email.substring(email.lastIndexOf("."), email.length());
		return domainExtension;
	}
}