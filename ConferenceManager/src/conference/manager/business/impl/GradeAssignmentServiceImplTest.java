package conference.manager.business.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import conference.manager.business.CommitteeAllocationService;
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
		Conference  conference = database.getUnallocatedConferences().get(0);
		CommitteeAllocationService committeeAllocationService = new CommitteeAllocationServiceImpl(database);
		
		committeeAllocationService.allocatePapers(conference, 1);
		
		Paper paper = gradeAssignmentServiceImpl.getUngradedPapers().get(0);
		Reviewer reviewer = paper.getReviewers().get(0);
		gradeAssignmentServiceImpl.assignGrade(paper, reviewer, 0);
		assertTrue(paper.isGraded());
	}

}
