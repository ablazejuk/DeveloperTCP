package conference.manager.ui.text;

import java.util.Scanner;

import conference.manager.business.CommitteeAllocationService;
import conference.manager.business.GradeAssignmentService;
import conference.manager.business.PaperSelectionService;
import conference.manager.business.impl.CommitteeAllocationServiceImpl;
import conference.manager.business.impl.GradeAssignmentServiceImpl;
import conference.manager.business.impl.PaperSelectionServiceImpl;
import conference.manager.data.Database;
import conference.manager.ui.text.command.AllocateCommitteeCommand;
import conference.manager.ui.ConferenceManagerUI;
import conference.manager.ui.text.command.SelectPapersCommand;
import conference.manager.ui.text.command.AssignGradeCommand;
import conference.manager.ui.text.command.Command;

public class ConferenceManagerTextUI extends ConferenceManagerUI {

	private static final int COMMAND_ALLOCATION = 1;
	private static final int COMMAND_ASSIGN_GRADE = 2;
	private static final int COMMAND_SELECTION = 3;
	
	public ConferenceManagerTextUI() {
		Database database = new Database();
		
		CommitteeAllocationService committeeAllocationService = new CommitteeAllocationServiceImpl(database);
		GradeAssignmentService gradeAssignmentService = new GradeAssignmentServiceImpl();
		PaperSelectionService paperSelectionService = new PaperSelectionServiceImpl(database);
		
		this.allocateCommitteeCommand = new AllocateCommitteeCommand(this);
		this.assignGradeCommand = new AssignGradeCommand(this);
		this.selectPapersCommand = new SelectPapersCommand(this);
	}
	
	public void createAndShow() {
		this.showMenu();
	    int option = this.getCommand();
	    this.executeCommand(option);
	}
	
	private void showMenu() {
		System.out.println("#########################################");
		System.out.println("######                             ######");
		System.out.println("######    COMMITTEE HELPER MENU    ######");
		System.out.println("######                             ######");
		System.out.println("#########################################");
		System.out.println("");
		System.out.println("1 - Allocation of Articles");
		System.out.println("2 - Grade Allocated Articles");
		System.out.println("3 - Select Graded Articles");
		System.out.println("");
		System.out.println("Select Your Option: ");
	}
	
	private int getCommand() {
		Scanner reader = new Scanner(System.in);
		int option;
		
		do {
			option = reader.nextInt();
		} while(!this.isValid(option));
		
		return option;
	}
	
	private boolean isValid(int option) {
		switch (option) {
		case 1:
		case 2:
		case 3:
			return true;
		default:
			return false;
		}
	}
	
	private void executeCommand(int option) {
		switch (option) {
		case COMMAND_ALLOCATION:
			allocateCommitteeCommand.execute();
			break;
		case COMMAND_ASSIGN_GRADE:
			assignGradeCommand.execute();
			break;
		case COMMAND_SELECTION:
			selectPapersCommand.execute();
			break;
		default:
			assert false;
		}
	}
}
