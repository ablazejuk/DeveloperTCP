package conference.manager.ui.text.command;

import conference.manager.ui.text.ConferenceManagerTextUI;
import conference.manager.ui.text.UIUtils;

import java.util.ArrayList;
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

	private PaperSelectionServiceImpl paperSelectionServiceImpl;
	
	private static final int MINIMUM_HASH_VALUE = 1;

	public SelectPapersCommand(
			ConferenceManagerTextUI ConferenceManagerInterface,
			Database database) {
		this.ConferenceManagerInterface = ConferenceManagerInterface;
		this.database = database;
		this.paperSelectionServiceImpl = new PaperSelectionServiceImpl(this.database);
	}

	public void execute() {
		try {
			List<Conference> conferences;
			conferences = this.getConferences();
			
			Hashtable<Integer, Conference> conferenceHash = this
					.showConferences(conferences);
			
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

		int i = MINIMUM_HASH_VALUE; 

		for (Conference conferencia : conferences) {
			conferenceHash.put(i, conferencia);
			i++;
		}

		return conferenceHash;
	}

	private Hashtable<Integer, Conference> showConferences(
			List<Conference> conferences) throws AllocatedConferencesException {

		List<Conference> lista_de_conferencias = new ArrayList<>();

		lista_de_conferencias = this.paperSelectionServiceImpl.getConferences();

		Hashtable<Integer, Conference> conferenceHash;
		conferenceHash = makeHashTable(lista_de_conferencias);

		this.ConferenceManagerInterface.showConferences(conferenceHash);

		return conferenceHash;
	}

	private Conference selectConference(
			Hashtable<Integer, Conference> conferenceHash) {
		
		Conference selectedConference;
		int selection = UIUtils.getInstance().readInteger("Please select a conference", MINIMUM_HASH_VALUE, conferenceHash.size()); 
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
				"Papers aceitos:");
		ConferenceManagerInterface.printPapers(rejectedPapers,
				"Papers rejeitados:");

	}
	
	private List<Conference> getConferences() throws AllocatedConferencesException  {
		return this.paperSelectionServiceImpl.getConferences(); 
	}

	/*
	 * private boolean arePapersReviewed(Conference selectedConference) { //???
	 * god knows what this is return false; }
	 */

}
