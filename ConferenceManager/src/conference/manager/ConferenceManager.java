package conference.manager;

import conference.manager.ui.ConferenceManagerUI;
import conference.manager.ui.text.ConferenceManagerTextUI;

public class ConferenceManager {

	public static void main(String[] args) {
		ConferenceManagerUI conferenceManagerText = new ConferenceManagerTextUI();
		conferenceManagerText.createAndShow();
	}
}
