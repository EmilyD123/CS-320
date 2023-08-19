package Test;

import mobileApp.Contact;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ContactTest {

	@Test
	public void testContactConstructor() {
		
		Contact contact = new Contact("001", "Paul", "Simon", "4128675309", "1 Whey Street");
		
		assertNotNull(contact);
		assertEquals(contact.getContactId(), "001");
		assertEquals(contact.getFirstName(), "Paul");
		assertEquals(contact.getLastName(), "Simon");
		assertEquals(contact.getNumber(), "4128675309");
		assertEquals(contact.getAddress(), "1 Whey Street");
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", "Too many characters"})
	@NullSource
	public void testExceptions (String testValues) {
		
		//test ID exceptions
		IllegalArgumentException expectedException1 =
				assertThrows(IllegalArgumentException.class, () -> new Contact (testValues, "Paul", "Simon", "4128675309", "1 Whey Street"));
		
		assertNotNull(expectedException1);
		assertEquals("Invalid ID", expectedException1.getMessage());
		
		//test first name exceptions
		IllegalArgumentException expectedException2 =
				assertThrows(IllegalArgumentException.class, () -> new Contact ("001", testValues, "Simon", "4128675309", "1 Whey Street"));
		
		assertNotNull(expectedException2);
		assertEquals("Invalid First Name", expectedException2.getMessage());
		
		//test last name exceptions
		IllegalArgumentException expectedException3 =
				assertThrows(IllegalArgumentException.class, () -> new Contact ("001", "Paul", testValues, "4128675309", "1 Whey Street"));
		
		assertNotNull(expectedException3);
		assertEquals("Invalid Last Name", expectedException3.getMessage());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", "123456789", "characters", "Too many characters"})
	@NullSource
	public void testNumberExceptions (String testValues) {
		
		IllegalArgumentException expectedException =
				assertThrows(IllegalArgumentException.class, () -> new Contact ("001", "Paul", "Simon", testValues, "1 Whey Street"));
		
		assertNotNull(expectedException);
		assertEquals("Invalid Number", expectedException.getMessage());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", "This is more than 30 characters 3.1415926535897932382626433"})
	@NullSource
	public void testAddressExceptions (String testValues) {
		
		IllegalArgumentException expectedException =
				assertThrows(IllegalArgumentException.class, () -> new Contact ("001", "Paul", "Simon", "4128675309", testValues));
		
		assertNotNull(expectedException);
		assertEquals("Invalid Address", expectedException.getMessage());
	}
	
	@Test
	public void testUpdates() {
		Contact contact = new Contact("01Aa", "Paul", "Simon", "4128675309", "1 Whey Street");
		
		//test update first name
		assertEquals(contact.getFirstName(), "Paul");
	    contact.updateFirstName("Ringo");
	    assertEquals(contact.getFirstName(), "Ringo");
	    
	    //test update last name
		assertEquals(contact.getLastName(), "Simon");
	    contact.updateLastName("Starr");
	    assertEquals(contact.getLastName(), "Starr");
	    
	    //test update phone number
		assertEquals(contact.getNumber(), "4128675309");
	    contact.updateNumber("0101010101");
	    assertEquals(contact.getNumber(), "0101010101");
	    
	    //test update address
		assertEquals(contact.getAddress(), "1 Whey Street");
	    contact.updateAddress("221B Baker Street");
	    assertEquals(contact.getAddress(), "221B Baker Street");
	}
	
	//test first and last name update exceptions
	@ParameterizedTest
	@ValueSource(strings = {"", "Too many characters"})
	@NullSource
	public void testUpdateNameExceptions (String testValues) {
		
		Contact contact = new Contact("01Aa", "Paul", "Simon", "4128675309", "1 Whey Street");
		
		IllegalArgumentException expectedException1 =
			       assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(testValues));
			assertNotNull(expectedException1);
			assertEquals("Invalid First Name", expectedException1.getMessage());
			
		IllegalArgumentException expectedException2 =
				   assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(testValues));
			assertNotNull(expectedException2);
			assertEquals("Invalid Last Name", expectedException2.getMessage());	
	}
	
	//test phone number update exceptions
	@ParameterizedTest
	@ValueSource(strings = {"", "123456789", "characters", "Too many characters"})
	@NullSource
	public void testUpdateNumberExceptions (String testValues) {
		
		Contact contact = new Contact("01Aa", "Paul", "Simon", "4128675309", "1 Whey Street");
		
		IllegalArgumentException expectedException =
				assertThrows(IllegalArgumentException.class, () -> contact.updateNumber(testValues));
		
		assertNotNull(expectedException);
		assertEquals("Invalid Number", expectedException.getMessage());
	}
	
	//test address update exceptions
	@ParameterizedTest
	@ValueSource(strings = {"", "This is more than 30 characters 3.1415926535897932382626433"})
	@NullSource
	public void testUpdateAddressExceptions (String testValues) {
		
		Contact contact = new Contact("01Aa", "Paul", "Simon", "4128675309", "1 Whey Street");
		
		IllegalArgumentException expectedException =
				assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(testValues));
		
		assertNotNull(expectedException);
		assertEquals("Invalid Address", expectedException.getMessage());
	}
	
}
