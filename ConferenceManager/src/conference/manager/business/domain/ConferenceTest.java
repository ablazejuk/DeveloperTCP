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
		Conference c3 = conferences.get(2);
		
		assertFalse(c1.equals(c2));
		assertTrue(c1.equals(c1));
		assertFalse(c2.equals(c3));
		assertTrue(c3.equals(c3));
		assertTrue(c2.equals(c2));
		assertFalse(c1.equals(c3));
	}
	
	@Test
	public void testAllocatePaper() {
		List<Conference> conferences = this.database.getUnallocatedConferences();
		Conference c1 = conferences.get(0);
		
		List<Paper>    papers    = c1.getUnallocatedPapers();
		List<Reviewer> reviewers = c1.getReviewers();
		
		Paper paperToAllocate = papers.get(0);
		c1.allocatePaper(paperToAllocate, reviewers);
		
		for (Paper p : c1.getUnallocatedPapers()) {
			assertFalse(p.equals(paperToAllocate));
		}
		
		for (Paper p : c1.getUngradedPapers()) {
			assertTrue(p.equals(paperToAllocate));
		}
	}
}
















