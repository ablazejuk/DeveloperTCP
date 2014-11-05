package conference.manager.ui.text.command;

import conference.manager.business.CommitteeAllocationService;
import conference.manager.business.PaperSelectionService;
import java.util.List;
import conference.manager.business.domain.Conference;

public class AllocateCommitteeCommand implements Command, CommitteeAllocationService {

	/**
	 *  
	 */
	private void showUnallocatedConferences(List<Conference> unallocatedConferences) {

	}

	/**
	 *  
	 */
	private Conference selectConference() {
		return null;
	}

	/**
	 *  
	 */
	private int askNumberReviewers() {
		return 0;
	}

	/**
	 *  
	 */
	private void showAllocatedPapers(List<Paper> allocatedPapers) {

	}

	private void printLog(List<Paper> allocatedPapers) {

	}

	/**
	 *  
	 */
	public void execute() {

	}


	/**
	 * @see conference.manager.business.CommitteeAllocationService#getUnallocatedConferences()
	 */
	public List<Conference> getUnallocatedConferences() {
		return null;
	}


	/**
	 * @see conference.manager.business.CommitteeAllocationService#getUnallocatedPapers(conference.manager.business.domain.Conference)
	 */
	public List<Paper> getUnallocatedPapers(Conference conference) {
		return null;
	}


	/**
	 * @see conference.manager.business.CommitteeAllocationService#allocatePapers(, conference.manager.business.domain.Conference, int)
	 */
	public List<Paper> allocatePapers(List<Paper> papers, Conference conference, int numReviewers) {
		return null;
	}

}
