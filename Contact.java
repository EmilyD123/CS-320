package mobileApp;

public class Contact {

	//member variables
	private String contactId;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	
	//contact constructor
	public Contact (String contactId, String firstName, String lastName, String number, String address) {
		
		super();

		if (contactId == null || contactId.length() < 1 || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (firstName == null || firstName.length() < 1 || firstName.length() >10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if (lastName == null || lastName.length() < 1 || lastName.length() >10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		if (number == null || number.length() != 10) {
			throw new IllegalArgumentException("Invalid Number");
		}
		if (address == null || address.length() < 1 || address.length() >30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		try {
	        @SuppressWarnings("unused")
			double d = Double.parseDouble(number);
	        } catch (NumberFormatException nfe) {
	        	throw new IllegalArgumentException("Invalid Number");}

		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.address = address;
	}
	
	//Getters
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getAddress() {
		return address;
	}
	
	//Setters
	public void updateFirstName(String firstName) {
		
		if (firstName == null || firstName.length() < 1 || firstName.length() >10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		this.firstName = firstName;
	}
	
	public void updateLastName(String lastName) {
		
		if (lastName == null  || lastName.length() < 1 || lastName.length() >10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		this.lastName = lastName;
	}
	
	public void updateNumber(String number) {
		
		if (number == null || number.length() != 10) {
			throw new IllegalArgumentException("Invalid Number");
		}
		
		try {
	        @SuppressWarnings("unused")
			double d = Double.parseDouble(number);
	        } catch (NumberFormatException nfe) {
	        	throw new IllegalArgumentException("Invalid Number");}
		
		this.number = number;
	}
	
	public void updateAddress(String address) {
		
		if (address == null || address.length() < 1 || address.length() >30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.address = address;
	}
	
}
