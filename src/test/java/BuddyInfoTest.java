import static org.junit.Assert.*;

import App.Models.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

public class BuddyInfoTest {
	private BuddyInfo buddy1;

	private String name;
	private String number;
	private String email;
	private EntityManager EM;

	@Before
	public void setUp() throws Exception {

		buddy1 = new BuddyInfo();
		name = "Kyle";
		number = "9058078241";
		email = "yeetus@deletus.com";
		buddy1.setAll(name, number, email);
	}

	@Test
	public void testSettingAndGettingAll() {
		buddy1.setAll(name, number, email);

		assertEquals("Name should be Kyle", name, buddy1.getName());
		assertEquals("Number should be 9058078241", number, buddy1.getNumber());
		assertEquals("Name should be yeetus@deletus.com", email, buddy1.getEmail());

	}

	@Test
	public void testSetAndGetName() {
		buddy1.setName(name);
		assertEquals("Name should be " + name, name, buddy1.getName());
	}
	@Test
	public void testSetAndGetNumber() {
		buddy1.setNumber(number);
		assertEquals("Number should be " + number, number, buddy1.getNumber());
	}
	@Test
	public void testSetAndGetEmail() {
		buddy1.setEmail(email);
		assertEquals("email should be " + email, email, buddy1.getEmail());
	}


}