package mobileApp;
import java.util.HashMap;

public class ContactService{
	
	//hold list of contacts
	public HashMap <String, Contact> contacts = new HashMap <String, Contact>();
	
	//add contact to hash-map
	public boolean addContact (String id, String first, String last, String number, String address) {
		boolean contactExists = false;
		//check if contact already exists
		if (contacts.get(id)!= null) {
			System.out.println("This contact already exists: " +contacts.get(id));
			contactExists = true;
		}
		//add contact
		if (!contactExists) {
			Contact contact = new Contact(id, first, last, number, address);
			contacts.put(contact.getContactId(), contact);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//remove contact
	public boolean removeContact (String id) {
		if(contacts.get(id) != null) {
		contacts.remove(id);
		return true;
		}
		else {
			return false;
		}
	}
	
	//Update contacts
	public boolean updateContactFirst (String id, String first) {
		if (contacts.get(id) != null) {
			contacts.get(id).updateFirstName(first);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean updateContactLast (String id, String last) {
		if (contacts.get(id) != null) {
			contacts.get(id).updateLastName(last);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean updateContactNumber (String id, String number) {
		if (contacts.get(id) != null) {
			contacts.get(id).updateNumber(number);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean updateContactAddress (String id, String address) {
		if (contacts.get(id) != null) {
			contacts.get(id).updateAddress(address);
			return true;
		}
		else {
			return false;
		}
	}
	
}
