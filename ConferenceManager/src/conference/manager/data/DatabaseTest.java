package conference.manager.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.exceptions.AllocatedConferencesException;

public class DatabaseTest {
	
	private Database database;
	
	@Before
	public void setUp() {
		this.database = new Database();
	}
	
	@Test
	public void testSetAllocated() throws AllocatedConferencesException {
		List<Conference> unallocatedConferences = database.getUnallocatedConferences();
		List<Conference> allocatedConferences   = database.getAllocatedConferences();
		
		Conference allocatedConf = unallocatedConferences.get(0);
		database.setAllocated(allocatedConf);
		
		for (Conference unallocatedConf : unallocatedConferences) {
			assertFalse(allocatedConf.equals(unallocatedConf));
		}
		
		for (Conference allocatedConfDatabase : allocatedConferences) {
			assertTrue(allocatedConfDatabase.equals(allocatedConf));
		}
	}
	
	@Test
	public void testSetUngraded() {
		Paper unallocatedPaper = database.getUnallocatedPapers().get(0);
		database.setUngraded(unallocatedPaper);
		
		for (Paper p : database.getUnallocatedPapers()) {
			assertFalse(unallocatedPaper.equals(p));
		}
		
		for (Paper p : database.getUngradedPapers()) {
			assertTrue(unallocatedPaper.equals(p));
		}
	}
	
	@Test
	public void testSetGraded() {
		Paper unallocPaper = database.getUnallocatedPapers().get(0);
		this.database.setUngraded(unallocPaper);
		
		Paper ungradedPaper = database.getUngradedPapers().get(0);
		database.setGraded(ungradedPaper);
		
		for (Paper p : this.database.getUngradedPapers()) {
			assertFalse(ungradedPaper.equals(p));
		}
		
		for (Paper p : database.getGradedPapers()) {
			assertTrue(ungradedPaper.equals(p));
		}
	}
}
