package conference.manager.ui.text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.business.domain.Reviewer;
import conference.manager.data.Database;
import conference.manager.ui.text.command.AllocateCommitteeCommand;
import conference.manager.ui.ConferenceManagerUI;
import conference.manager.ui.text.command.Command;
import conference.manager.ui.text.command.SelectPapersCommand;
import conference.manager.ui.text.command.AssignGradeCommand;

public class ConferenceManagerTextUI extends ConferenceManagerUI {

	private static final int COMMAND_ALLOCATION = 1;
	private static final int COMMAND_ASSIGN_GRADE = 2;
	private static final int COMMAND_SELECTION = 3;
	private static final int COMMAND_EXIT = 0;
	
	private Map<Integer, Command> commands;
	
	public ConferenceManagerTextUI() {
		Database database = new Database();
		
		this.allocateCommitteeCommand = new AllocateCommitteeCommand(this, database);
		this.assignGradeCommand = new AssignGradeCommand(this, database);
		this.selectPapersCommand = new SelectPapersCommand(this);
		
		this.commands = new HashMap<Integer, Command>();
		this.commands.put(COMMAND_ALLOCATION, this.allocateCommitteeCommand);
		this.commands.put(COMMAND_ASSIGN_GRADE, this.assignGradeCommand);
		this.commands.put(COMMAND_SELECTION, this.selectPapersCommand);
	}
	
	public void createAndShow() {
		this.showMenu();
	    int option = this.getCommand();
	    
	    if (option != COMMAND_EXIT) {
	    	this.executeCommand(option);
	    }
	}
	
	private void showMenu() {
		System.out.println("#########################################");
		System.out.println("######                             ######");
		System.out.println("######    COMMITTEE HELPER MENU    ######");
		System.out.println("######                             ######");
		System.out.println("#########################################");
		System.out.println();
		System.out.println("1 - Allocation of Articles");
		System.out.println("2 - Grade Allocated Articles");
		System.out.println("3 - Select Graded Articles");
		System.out.println("0 - Exit");
		System.out.println();
	}
	
	private int getCommand() {
		int option = UIUtils.getInstance().readInteger("Select Your Option: ", 1, 3);
		System.out.println();
		
		return option;
	}

	private void executeCommand(int option) {
		Command command = this.commands.get(option);
		command.execute();
	}
	
	public void showUnallocatedConferences(List<Conference> unallocatedConferences) {		
		System.out.println("*Unallocated Conferences*");
		int cont = 1;
		for (Conference c : unallocatedConferences) {
			System.out.println(cont++ + " - " + c.toString());
		}
		System.out.println();
	}
	
	public void showUngradedPapers(List<Paper> ungradedPapers) {
		System.out.println("*Ungraded Papers*");
		
		for (Paper p : ungradedPapers){
			System.out.println(p);
		}
		System.out.println();
	}
	
	public void showReviewers(List<Reviewer> reviewers) {
		System.out.println("*Reviewers*");
		
		for (Reviewer r : reviewers){
			System.out.println(r);
		}
		System.out.println();
	}
	
	public void showAllocatedPapers(List<Paper> allocatedPapers) {
		System.out.println("*Allocated Papers*");
		
		for (Paper p : allocatedPapers) {
			System.out.println(p);
			for (Reviewer r : p.getReviewers()) {
				System.out.println("    " + r);
			}
		}
	}
}
