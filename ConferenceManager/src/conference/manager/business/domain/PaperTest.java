package conference.manager.business.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaperTest {

	Paper paper;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//paper = new Paper();
	}
	
	/**
	 * Test method for {@link conference.manager.business.domain.Paper
	 */
	@Test
	public void testValidLowerId() {
		assertTrue(paper.isValidId(1));
	}
	
	@Test
	public void testInvalidLowerId() {
		assertFalse(paper.isValidId(0));
	}

	@Test
	public void testValidString() {
		assertTrue(paper.isValidTitle("Coupling and Cohesion"));
	}
	
	@Test
	public void testInvalidStringNull() {
		assertFalse(paper.isValidTitle(null));
	}
	
	@Test
	public void testInvalidStringEmpty() {
		assertFalse(paper.isValidTitle(""));
	}
	
	@Test
	public void testValidAuthor() {
		//Researcher author = new Researcher();
		//assertTrue(paper.isValidAuthor(author));
	}
	
	@Test
	public void testInvalidAuthorNull() {
		assertFalse(paper.isValidAuthor(null));
	}
	
	@Test
	public void testValidConference() {
		//Conference conference = new Conference();
		//assertTrue(paper.isValidConference(conference));
	}
	
	@Test
	public void testInvalidConferenceNull() {
		assertFalse(paper.isValidConference(null));
	}
	
	@Test
	public void testValidResearchTopic() {
		//ResearchTopic topic = new ResearchTopic();
		//assertTrue(paper.isValidResearchTopic(topic));
	}
	
	@Test
	public void testInvalidResearchTopicNull() {
		assertFalse(paper.isValidResearchTopic(null));
	}

}
