package conference.manager.business.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import conference.manager.data.Database;

public class ReviewerTest {

	Database database;
	
	@Before
	public void setUp() {
		database = new Database();
	}
	
	@Test
	public void testIsAbleToReview() {
		List<Conference> conferences = database.getUnallocatedConferences();
		Conference c1 = conferences.get(0);
		
		List<Reviewer> reviewers = c1.getReviewers();
		Reviewer r1 = reviewers.get(0);
		
		List<Paper> papers = c1.getUnallocatedPapers();
		
		for (Paper p : papers) {
			if (r1.equals(p.getAuthor()))
				assertFalse(r1.isAbleToReview(p));
		}
		
		boolean commonInterest = false;
		for (Paper p: papers) {
			for (ResearchTopic rt : r1.getInterests()) {
				if (rt.equals(p.getResearchTopic())) {
					commonInterest = true;
				}
			}
			
			if (commonInterest == false)
				assertFalse(r1.isAbleToReview(p));
		}
	}

}
