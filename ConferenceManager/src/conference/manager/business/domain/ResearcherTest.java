package conference.manager.business.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import conference.manager.data.Database;

public class ResearcherTest {
	
	Database database;
	
	@Before
	public void setUp() {
		database = new Database();
	}
	
	@Test
	public void testEquals() {
		List<Researcher> researchers = database.getResearchers();
		Researcher r1 = researchers.get(0);
		Researcher r2 = researchers.get(1);
		
		assertFalse(r1.equals(r2));
		assertTrue(r1.equals(r1));
	}

}
