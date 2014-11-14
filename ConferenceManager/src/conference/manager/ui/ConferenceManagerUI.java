package conference.manager.ui;

import conference.manager.ui.text.command.Command;

public abstract class ConferenceManagerUI {

	protected Command allocateCommitteeCommand;
	protected Command assignGradeCommand;
	protected Command selectPapersCommand;
	
	public abstract void createAndShow();

}
