package fakeTestData;

import org.testng.annotations.Test;

import fabricator.Contact;
import fabricator.Fabricator;

public class FabricatorAPI {
	//This API is slower than the other APIs

	@Test
	public void fabricatorData() {
		
	Contact contact = Fabricator.contact();
	String fullname = contact.fullName(true,true); //booleans are for dr etc.
	String firstname = contact.firstName();
	String lastname  = contact.lastName();
	String address = contact.address();
	String phone = contact.phoneNumber();
	String email = contact.eMail();
	System.out.println(contact.birthday(45));
	
	System.out.println(fullname);
	System.out.println(firstname);		
	System.out.println(lastname);
	System.out.println(address);
	System.out.println(phone);
	System.out.println(email);
	

	}
	
	
	
	
}
