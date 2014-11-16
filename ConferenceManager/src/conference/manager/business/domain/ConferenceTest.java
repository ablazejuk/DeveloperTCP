package conference.manager.business.domain;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ConferenceTest {

	Conference conference;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		conference = new Conference();
	}
	
	/**
	 * Test method for {@link conference.manager.business.domain.Conference#isValidAcronym(java.lang.String)}.
	 */
	@Test
	public void testAcronymIsNotNull() {
		assertTrue(conference.isValidAcronym("ICSE"));
	}
	
	@Test
	public void testAcronymIsNull() {
		assertFalse(conference.isValidAcronym(null));
	}
	
	@Test
	public void testListOfPapersIsValid(){
		List<Paper> papers = new ArrayList<Paper>();
		assertTrue(conference.isValidListOfPapers(papers));
	}
	
	@Test
	public void testListOfMembersIsValid(){
		List<Researcher> members = new ArrayList<Researcher>();
		assertTrue(conference.isValidListOfMembers(members));
	}

}