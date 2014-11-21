package conference.manager.business.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.business.domain.Reviewer;
import conference.manager.data.Database;

public class GradeAssignmentServiceImplTest {

	GradeAssignmentServiceImpl gradeAssignmentServiceImpl;
	Database database;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		database = new Database();
		gradeAssignmentServiceImpl = new GradeAssignmentServiceImpl(database);
	}
	
	@Test
	public void testAssignGrade() {
		//chamar método de alocação de conferências aqui!
		Conference c = database.geAllocatedConferences().get(0);
		Paper paper = c.getUngradedPapers().get(0);
		Reviewer reviewer = paper.getReviewers().get(0);

		gradeAssignmentServiceImpl.assignGrade(paper, reviewer, 0);
		assertTrue(paper.isGraded());
	}

}
