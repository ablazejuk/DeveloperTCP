package conference.manager.business.impl;

import conference.manager.business.CommitteeAllocationService;
import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.business.domain.Reviewer;
import conference.manager.data.Database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommitteeAllocationServiceImpl implements CommitteeAllocationService {

	private Database database;

	public CommitteeAllocationServiceImpl(Database database) {
		this.database = database;
	}
	
	public List<Paper> allocatePapers(Conference conference, int numReviewers) {
		List<Paper> unallocatedPapers = conference.getUnallocatedPapers();
		
		sortUnallocatedPapersBySmallerId(unallocatedPapers);
		
		List<Reviewer> selectedReviewers;
		
		for (Paper paper : unallocatedPapers) {
			List<Reviewer> reviewers = conference.getReviewers();
			selectedReviewers = selectReviewers(paper, reviewers, numReviewers); 
			
			conference.allocatePaper(paper, selectedReviewers);
			database.setUngraded(paper);
		}
		
		database.setAllocated(conference);
		
		List<Paper> allocatedPapers = conference.getUngradedPapers();
		
		return allocatedPapers;
	}
	
	private List<Reviewer> selectReviewers(Paper paper, List<Reviewer> reviewers, int numReviewers) {
		List<Reviewer> reviewersAbleToReview = new ArrayList<>();
		
		for (Reviewer reviewer : reviewers) {
			if (reviewer.isAbleToReview(paper)) {
				reviewersAbleToReview.add(reviewer);
			}
		}
		
		sortReviewersAbleToReviewByNumOfAllocations(reviewersAbleToReview);
		List<Reviewer> selectedReviewers = createAllocatedReviewersArray(reviewersAbleToReview, numReviewers);
		
		return selectedReviewers;
	}

	private List<Reviewer> createAllocatedReviewersArray(List<Reviewer> reviewersAbleToReview, int numReviewers) {
		List<Reviewer> allocatedReviewersAbleToReview = new ArrayList<>(numReviewers);
		
		for (int i = 0; i < numReviewers; i++) {
			Reviewer reviewerToAdd = reviewersAbleToReview.get(i);
			allocatedReviewersAbleToReview.add(reviewerToAdd);
		}
		
		return allocatedReviewersAbleToReview;
	}
	
	@Override
	public List<Conference> getUnallocatedConferences() {
		return this.database.getUnallocatedConferences();
	}

	@Override
	public List<Paper> getUnallocatedPapers(Conference conference) {
		return this.database.getUnallocatedPapers();
	}

	private void sortUnallocatedPapersBySmallerId(List<Paper> unallocatedPapers) {
		Collections.sort(unallocatedPapers);	
	}
	
	private void sortReviewersAbleToReviewByNumOfAllocations(List<Reviewer> reviewersAbleToReview) {
		Collections.sort(reviewersAbleToReview);
	}
}
