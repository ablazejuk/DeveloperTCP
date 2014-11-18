package conference.manager.ui.text.command;

import conference.manager.business.GradeAssignmentService;
import conference.manager.ui.text.ConferenceManagerTextUI;

import java.util.List;

import conference.manager.business.domain.Paper;
import conference.manager.business.domain.Reviewer;
import conference.manager.business.impl.GradeAssignmentServiceImpl;
import conference.manager.data.Database;
import conference.manager.business.GradeAssignmentService;

public class AssignGradeCommand extends Command {
	
	private GradeAssignmentService gradeAssignmentService;
	
	public AssignGradeCommand(ConferenceManagerTextUI ConferenceManagerInterface, Database database) {
		this.ConferenceManagerInterface = ConferenceManagerInterface;
		this.gradeAssignmentService = new GradeAssignmentServiceImpl(database);
	}

	public void execute() {
		List<Paper> ungradedPapers = this.getPapers();
		this.ConferenceManagerInterface.showUngradedPapers(ungradedPapers);
	}
	
	private List<Paper> getPapers(){
		return this.gradeAssignmentService.getPapers();
	}
	
	private void showPapers(List<Paper> papersToAssignGrade) {
		
	}

	private Paper selectPaper(List<Paper> papersToAssignGrade) {
		return null;
	}

	private void showReviewers(List<Reviewer> reviewers) {

	}

	private Reviewer selectReviewer(List<Reviewer> reviewers) {
		return null;
	}

	private int requestGrade() {
		return 0;
	}

}
