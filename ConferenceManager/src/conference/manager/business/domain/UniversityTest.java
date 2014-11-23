package conference.manager.business.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UniversityTest {
	
	private University u1;
	private University u2;
	
	@Before
	public void setUp() {
		u1 = new University("UFRGS");
		u2 = new University("UFSC");
	}
	
	@Test
	public void testEquals() {
		assertTrue(u1.equals(u1));
		assertFalse(u1.equals(u2));
	}

}
