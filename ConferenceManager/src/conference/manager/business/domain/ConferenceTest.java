package conference.manager.business.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import conference.manager.data.Database;

public class ConferenceTest {

	Database database;
	Conference conference;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.database = new Database();
	}
	
	/**
	 * Test method for {@link conference.manager.business.domain.Conference#isValidAcronym(java.lang.String)}.
	 */
	@Test
	public void testIsValidAcronym() {
		List<Conference> conferences = this.database.getUnallocatedConferences();
		
		for (Conference c : conferences) {
			assertTrue(c.isValidAcronym());
			assertTrue(c.isValidAcronym());
		}
	}
	
	@Test
	public void testEquals() {
		List<Conference> conferences = this.database.getUnallocatedConferences();
		
		Conference c1 = conferences.get(0);
		Conference c2 = conferences.get(1);
		
		assertFalse(c1.equals(c2));
		assertTrue(c1.equals(c1));
	}
}