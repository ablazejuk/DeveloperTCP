package conference.manager.ui.text.command;

import conference.manager.ui.text.ConferenceManagerTextUI;
import conference.manager.ui.text.UIUtils;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.business.impl.PaperSelectionServiceImpl;
import conference.manager.data.Database;
import conference.manager.exceptions.AllocatedConferencesException;
import conference.manager.exceptions.UngradedPapersException;

public class SelectPapersCommand extends Command {

	private Database database;

	private PaperSelectionServiceImpl paperSelectionServiceImpl = new PaperSelectionServiceImpl(
			database);

	public SelectPapersCommand(
			ConferenceManagerTextUI ConferenceManagerInterface,
			Database database) {
		this.ConferenceManagerInterface = ConferenceManagerInterface;
		this.database = database;
	}

	public void execute() {
		try {
			Hashtable<Integer, Conference> conferenceHash = this
					.showConferences(database.getAllocatedConferences());
			Conference selectedConference = this
					.selectConference(conferenceHash);
			this.showAcceptedandRejectedPapers(selectedConference);
		} catch (AllocatedConferencesException unallocatedConference) {
			System.out.println(unallocatedConference);
		} catch (UngradedPapersException ungradedPaper) {
			System.out.println(ungradedPaper);
		} 

		ConferenceManagerInterface.createAndShow();

	}

	private Hashtable<Integer, Conference> makeHashTable(
			List<Conference> conferences) {
		Hashtable<Integer, Conference> conferenceHash = new Hashtable<Integer, Conference>();

		int i = 1;

		for (Conference conferencia : conferences) {
			conferenceHash.put(i, conferencia);
			i++;
		}

		return conferenceHash;
	}

	private Hashtable<Integer, Conference> showConferences (
			List<Conference> conferences) throws AllocatedConferencesException {

		List<Conference> lista_de_conferencias = new LinkedList<Conference>();

		lista_de_conferencias = this.paperSelectionServiceImpl.getConferences();

		ConferenceManagerInterface.createAndShow();

		Hashtable<Integer, Conference> conferenceHash;
		conferenceHash = makeHashTable(lista_de_conferencias);

		Enumeration<Integer> numbers;
		numbers = conferenceHash.keys();

		while (numbers.hasMoreElements()) {
			int iterator = numbers.nextElement();
			System.out.println(iterator + ":"
					+ conferenceHash.get(iterator).getAcronym());
		}

		return conferenceHash;
	}

	private Conference selectConference(
			Hashtable<Integer, Conference> conferenceHash) {
		Conference selectedConference;
		int selection = UIUtils.getInstance().readInteger(null);
		selectedConference = conferenceHash.get(selection);
		return selectedConference;

	}

	private void showAcceptedandRejectedPapers(Conference selectedConference)
			throws UngradedPapersException {
		List<Paper> acceptedPapers = paperSelectionServiceImpl
				.getAcceptedPapers(selectedConference);
		List<Paper> rejectedPapers = paperSelectionServiceImpl
				.getRejectedPapers(selectedConference);
		printPapers(acceptedPapers, "Papers aceitos:");
		printPapers(rejectedPapers, "Papers rejeitados:");

	}

	/*
	 * private boolean arePapersReviewed(Conference selectedConference) { //???
	 * god knows what this is return false; }
	 */

	private void printPapers(List<Paper> papers, String field) {
		System.out.println(field);
		for (Paper paper : papers) {
			System.out.println(paper.getTitle());
		}

	}

}
