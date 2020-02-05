import static org.junit.Assert.*;

import webAPP.Models.AddressBook;
import webAPP.Models.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {
	private AddressBook book1;
	
	@Before
	public void setUp() throws Exception {
		
		book1 = new AddressBook();
		
		//Add two buddies to address book
		book1.addBuddy(new BuddyInfo("Kyle"));
		book1.addBuddy(new BuddyInfo("MyKyle"));
		
	}

	@Test
	public void testSize() {
		assertEquals("Size of Address Book should be 2.", 2, book1.size());
	}

	@Test
	public void testClear() {
		book1.clear();
		assertEquals("Size of Address Book should be 0.", 0, book1.size());
	}

}
