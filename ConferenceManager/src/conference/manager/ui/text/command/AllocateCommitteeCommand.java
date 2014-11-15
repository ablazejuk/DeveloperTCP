package conference.manager.ui.text.command;

import conference.manager.business.CommitteeAllocationService;
import conference.manager.business.PaperSelectionService;

import java.util.List;

import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.ui.text.ConferenceManagerTextUI;

public class AllocateCommitteeCommand extends Command {

	public AllocateCommitteeCommand(ConferenceManagerTextUI ConferenceManagerInterface) {
		this.ConferenceManagerInterface = ConferenceManagerInterface;
	}
	
	private void showUnallocatedConferences(List<Conference> unallocatedConferences) {

	}

	private Conference selectConference() {
		return null;
	}

	private int askNumberReviewers() {
		return 0;
	}

	private void showAllocatedPapers(List<Paper> allocatedPapers) {

	}

	private void printLog(List<Paper> allocatedPapers) {

	}

	public void execute() {

	}

	/**
	 * @see conference.manager.business.CommitteeAllocationService#getUnallocatedConferences()
	 */
	public List<Conference> getUnallocatedConferences() {
		return null;
	}

	/**
	 * @see conference.manager.business.CommitteeAllocationService#getunallocatedPapersICSE(conference.manager.business.domain.Conference)
	 */
	public List<Paper> getunallocatedPapersICSE(Conference conference) {
		return null;
	}

	/**
	 * @see conference.manager.business.CommitteeAllocationService#allocatePapers(, conference.manager.business.domain.Conference, int)
	 */
	public List<Paper> allocatePapers(List<Paper> papers, Conference conference, int numReviewers) {
		return null;
	}

}
