package conference.manager.ui.text.command;

import conference.manager.ui.text.ConferenceManagerTextUI;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.business.impl.PaperSelectionServiceImpl;
import conference.manager.data.Database;

public class SelectPapersCommand extends Command {
	
	private Database database;
	
	private PaperSelectionServiceImpl paperSelectionServiceImpl = new PaperSelectionServiceImpl(database);
	
	public SelectPapersCommand(ConferenceManagerTextUI ConferenceManagerInterface, Database database) {
		this.ConferenceManagerInterface = ConferenceManagerInterface;
		this.database = database;
	}
	

	public void execute() {
		showConferences(database.getAllocatedConferences());
	}
	
	private Hashtable<Integer, String> makeHashTable(List<Conference> conferences){
		Hashtable<Integer, String> conferenceHash = new Hashtable<Integer, String>();
		
		int i =1;
		
		for (Conference conferencia: conferences){
			conferenceHash.put(i, conferencia.getAcronym());
			i++;
		}
		
		return conferenceHash;
	}

	private void showConferences(List<Conference> conferences) {
		List<Conference> lista_de_conferencias = this.paperSelectionServiceImpl.getConferences();
				
		Hashtable<Integer, String> conferenceHash;
		conferenceHash = makeHashTable(lista_de_conferencias);
		
		Enumeration<Integer> numbers;
		numbers = conferenceHash.keys();
		
		while(numbers.hasMoreElements()){
			int iterator = numbers.nextElement();
			System.out.println(iterator + ":" +
					conferenceHash.get(iterator));
		}

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



}
