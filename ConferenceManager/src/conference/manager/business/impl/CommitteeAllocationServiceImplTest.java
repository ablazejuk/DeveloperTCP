package conference.manager.business.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import conference.manager.business.CommitteeAllocationService;
import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.business.domain.Reviewer;
import conference.manager.data.Database;

public class CommitteeAllocationServiceImplTest {

	Database database;
	CommitteeAllocationService committeeAllocationService;
	
	@Before
	public void setUp() {
		database = new Database();
		committeeAllocationService = new CommitteeAllocationServiceImpl(database);
	}
	
	@Test
	public void testAllocatePapers() {
		Conference  conference = database.getUnallocatedConferences().get(0);
		List<Paper> papers     = conference.getUnallocatedPapers();
		int         papersSize = papers.size();
		
		committeeAllocationService.allocatePapers(conference, 3);
		
		List<Paper> allocatedPapers = conference.getUngradedPapers();
		
		assertTrue(papers.isEmpty());
		assertTrue(papersSize == allocatedPapers.size());
		
		for (Paper paper : allocatedPapers) {
			if (paper.getId() == 10) {
				assertTrue(paper.getReviewers().get(0).getId() == 5);
				assertTrue(paper.getReviewers().get(1).getId() == 4);
				
			}
		}
	}

}
