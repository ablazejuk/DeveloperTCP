package conference.manager.ui.text.command;

import java.util.List;

import conference.manager.business.CommitteeAllocationService;
import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.business.impl.CommitteeAllocationServiceImpl;
import conference.manager.data.Database;
import conference.manager.ui.text.ConferenceManagerTextUI;

public class AllocateCommitteeCommand extends Command {
	
	private CommitteeAllocationService committeeAllocationService;
	
	public AllocateCommitteeCommand(ConferenceManagerTextUI ConferenceManagerInterface, Database database) {
		this.ConferenceManagerInterface = ConferenceManagerInterface;
		this.committeeAllocationService = new CommitteeAllocationServiceImpl(database);
	}

	public void execute() {
		List<Conference> unallocatedConferences = this.getUnallocatedConferences();
		this.ConferenceManagerInterface.showUnallocatedConferences(unallocatedConferences);
	}

	public List<Conference> getUnallocatedConferences() {
		return this.committeeAllocationService.getUnallocatedConferences();
	}

	public List<Paper> getUnallocatedPapers(Conference conference) {
		return conference.getUnallocatedPapers();
	}

	public List<Paper> allocatePapers(List<Paper> papers, Conference conference, int numReviewers) {
		return null;
	}
	
	private void showAllocatedPapers(List<Paper> allocatedPapers) {

	}

	private void printLog(List<Paper> allocatedPapers) {

	}

	private Conference selectConference() {
		return null;
	}

	private int askNumberReviewers() {
		return 0;
	}
}
