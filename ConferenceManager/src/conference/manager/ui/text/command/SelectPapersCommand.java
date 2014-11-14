package conference.manager.ui.text.command;

import conference.manager.ui.text.ConferenceManagerTextUI;

import java.util.List;

import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;

public class SelectPapersCommand extends Command {

	public SelectPapersCommand(ConferenceManagerTextUI ConferenceManagerInterface) {
		this.ConferenceManagerInterface = ConferenceManagerInterface;
	}
	
	public SelectPapersCommand() {
		
	}

	public void execute() {

	}

	private void showConferences(List<Conference> conferences) {

	}

	private Conference selectConference(List<Conference> conferences) {
		return null;
	}

	private void showAcceptedPapers(List<Conference> selectedConference) {

	}

	private boolean arePapersReviewed(Conference selectedConference) {
		return false;
	}

	private void printPapers(List<Paper> papers, String field) {

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
