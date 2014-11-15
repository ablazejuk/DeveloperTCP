package conference.manager.business.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaperGradeTest {

	PaperGrade grade;
	Reviewer reviewer;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		reviewer = new Reviewer();
	}
	
	/**
	 * Test method for {@link conference.manager.business.domain.PaperGrade
	 */
	@Test
	public void testValidLowerGrade() {
		grade = new PaperGrade(reviewer, -3);
		assertTrue(grade.isValidGrade());
	}
	
	@Test
	public void testInvalidLowerGrade() {
		grade = new PaperGrade(reviewer, -4);
		assertFalse(grade.isValidGrade());
	}
	
	@Test
	public void testValidHigherGrade() {
		grade = new PaperGrade(reviewer, 3);
		assertTrue(grade.isValidGrade());
	}
	
	@Test
	public void testInvalidHigherGrade() {
		grade = new PaperGrade(reviewer, 4);
		assertFalse(grade.isValidGrade());
	}

}
