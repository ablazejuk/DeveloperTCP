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

		while (!unallocatedPapers.isEmpty()) {
			Paper          currentPaper      = unallocatedPapers.get(0);
			List<Reviewer> reviewers         = conference.getReviewers();
			
			List<Reviewer> selectedReviewers = selectReviewers(currentPaper, reviewers, numReviewers); 
			
			conference.allocatePaper(currentPaper, selectedReviewers);
			database.setUngraded(currentPaper);
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
		List<Reviewer> allocatedReviewersAbleToReview = new ArrayList<>();
		
		boolean numReviewersBiggerThanListSize = numReviewers > reviewersAbleToReview.size();
		
		int sizeReviewersArray = numReviewersBiggerThanListSize ? 
				reviewersAbleToReview.size() : numReviewers;
		
		for (int i = 0; i < sizeReviewersArray; i++) {
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

	@Override
	public Conference getUnallocatedConferenceByIndex(int index) {
		List<Conference> unallocatedConferences = getUnallocatedConferences();
		return unallocatedConferences.get(index);
	}
}
