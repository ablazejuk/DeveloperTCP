package conference.manager.ui.text.command;

import conference.manager.ui.text.ConferenceManagerTextUI;
import conference.manager.ui.text.UIUtils;

import java.util.Hashtable;
import java.util.List;

import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.business.impl.PaperSelectionServiceImpl;
import conference.manager.data.Database;
import conference.manager.exceptions.AllocatedConferencesException;
import conference.manager.exceptions.UngradedPapersException;

public class SelectPapersCommand extends Command {

	private Database database;

	private PaperSelectionServiceImpl paperSelectionServiceImpl;

	private static final int MINIMUM_HASH_VALUE = 1;

	public SelectPapersCommand(
			ConferenceManagerTextUI ConferenceManagerInterface,
			Database database) {
		this.ConferenceManagerInterface = ConferenceManagerInterface;
		this.database = database;
		this.paperSelectionServiceImpl = new PaperSelectionServiceImpl(
				this.database);
	}

	public void execute() {
		try {
			List<Conference> conferences;
			conferences = this.getConferences();

			Hashtable<Integer, Conference> conferenceHash = this
					.makeHashTable(conferences);

			this.showConferences(conferenceHash);

			Conference selectedConference = this
					.selectConference(conferenceHash);

			this.showAcceptedandRejectedPapers(selectedConference);

		} catch (AllocatedConferencesException unallocatedConference) {
			System.out.println("\n" + unallocatedConference + "\n");

		} catch (UngradedPapersException ungradedPaper) {
			System.out.println("\n" + ungradedPaper + "\n");
		}

		ConferenceManagerInterface.createAndShow();

	}

	private Hashtable<Integer, Conference> makeHashTable(
			List<Conference> conferences) {
		Hashtable<Integer, Conference> conferenceHash = new Hashtable<Integer, Conference>();

		int i = MINIMUM_HASH_VALUE;

		for (Conference conferencia : conferences) {
			conferenceHash.put(i, conferencia);
			i++;
		}

		return conferenceHash;
	}

	private void showConferences(Hashtable<Integer, Conference> conferenceHash)
			throws AllocatedConferencesException {
		this.ConferenceManagerInterface.showConferences(conferenceHash);

	}

	private Conference selectConference(
			Hashtable<Integer, Conference> conferenceHash) {

		Conference selectedConference;
		int selection = UIUtils.getInstance().readInteger(
				"\nPlease select a conference", MINIMUM_HASH_VALUE,
				conferenceHash.size());

		selectedConference = conferenceHash.get(selection);
		return selectedConference;

	}

	private void showAcceptedandRejectedPapers(Conference selectedConference)
			throws UngradedPapersException {
		List<Paper> acceptedPapers = this.paperSelectionServiceImpl
				.getAcceptedPapers(selectedConference);
		List<Paper> rejectedPapers = this.paperSelectionServiceImpl
				.getRejectedPapers(selectedConference);
		ConferenceManagerInterface.printPapers(acceptedPapers,
				"*Accepted Papers*");
		ConferenceManagerInterface.printPapers(rejectedPapers,
				"*Rejected Papers*");

	}

	private List<Conference> getConferences()
			throws AllocatedConferencesException {

		return this.paperSelectionServiceImpl.getConferences();
	}

}
