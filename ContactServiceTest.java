package Test;

import mobileApp.ContactService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	
	ContactService cs = new ContactService();
	
	//shows each contact parameter was assigned and not null
	@Test
	public void testAddContact() {
		
		assertTrue(cs.addContact("01Aa", "Paul", "Simon", "4128675309", "1 Whey Street"));
		assertTrue(cs.contacts.containsKey("01Aa"));
		assertEquals("Paul", cs.contacts.get("01Aa").getFirstName());
		assertEquals("Simon", cs.contacts.get("01Aa").getLastName());
		assertEquals("4128675309", cs.contacts.get("01Aa").getNumber());
		assertEquals("1 Whey Street", cs.contacts.get("01Aa").getAddress());
		assertFalse(cs.addContact("01Aa", "Ringo", "Starr", "0101010101", "221B Baker Street"));
	}
	
	//test parameters of contact removal method
	@Test
	public void testRemove() {
		
		cs.addContact("01Aa", "Paul", "Simon", "4128675309", "1 Whey Street");
		
		assertTrue(cs.contacts.containsKey("01Aa"));
		assertTrue(cs.removeContact("01Aa"));
		assertFalse(cs.contacts.containsKey("01Aa"));
		assertFalse(cs.removeContact("001"));
	}
	
	//test parameters of contact update methods
	@Test
	public void testUpdate() {
		cs.addContact("01Aa", "Paul", "Simon", "4128675309", "1 Whey Street");
		
		//test update first name
		assertTrue(cs.updateContactFirst("01Aa", "Ringo"));
		assertFalse(cs.updateContactFirst("02Bb", "Doesn't work"));
		assertEquals(cs.contacts.get("01Aa").getFirstName(), "Ringo");
		
		//test update last name
		assertTrue(cs.updateContactLast("01Aa", "Starr"));
		assertFalse(cs.updateContactLast("02Bb", "Doesn't work"));
		assertEquals(cs.contacts.get("01Aa").getLastName(), "Starr");
		
		//test update number
		assertTrue(cs.updateContactNumber("01Aa", "0101010101"));
		assertFalse(cs.updateContactNumber("02Bb", "Doesn't work"));
		assertEquals(cs.contacts.get("01Aa").getNumber(), "0101010101");
		
		//test update address
		assertTrue(cs.updateContactAddress("01Aa", "221B Baker Street"));
		assertFalse(cs.updateContactAddress("02Bb", "Doesn't work"));
		assertEquals(cs.contacts.get("01Aa").getAddress(), "221B Baker Street");
	}
}
