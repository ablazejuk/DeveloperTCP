package conference.manager.ui.text.command;

import conference.manager.ui.text.ConferenceManagerTextUI;

public abstract class Command {

	protected ConferenceManagerTextUI ConferenceManagerInterface;
	
	public abstract void execute();

}
