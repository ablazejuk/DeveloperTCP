package conference.manager.business.impl;

import conference.manager.business.CommitteeAllocationService;
import conference.manager.business.PaperSelectionService;
import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.business.domain.Reviewer;
import conference.manager.data.Database;
import java.util.List;

public class CommitteeAllocationServiceImpl implements CommitteeAllocationService {

	private Database database;

	private List<Reviewer> selectReviewers(Paper paper, List<Reviewer> reviewers, int numReviewers) {
		return null;
	}

	private void allocatePaper(Paper paper, List<Reviewer> reviewers) {

	}

	public CommitteeAllocationServiceImpl(Database database) {
		this.database = database;
	}

	public List<Paper> allocatePapers(List<Paper> papers, Conference conference, int numReviewers) {
		return null;
	}

	public List<Paper> getunallocatedPapersICSE(Conference conference) {
		return null;
	}

	public List<Conference> getUnallocatedConferences() {
		return null;
	}

	/**
	 * @see conference.manager.business.PaperSelectionService#getConferences()
	 */
	public List<Conference> getConferences() {
		return null;
	}

	/**
	 * @see conference.manager.business.PaperSelectionService#getAcceptedPapers(conference.manager.business.domain.Conference)
	 */
	public List<Paper> getAcceptedPapers(Conference conference) {
		return null;
	}


	/**
	 * @see conference.manager.business.PaperSelectionService#getRejectedPapers(conference.manager.business.domain.Conference)
	 */
	public List<Paper> getRejectedPapers(Conference conference) {
		return null;
	}

}
