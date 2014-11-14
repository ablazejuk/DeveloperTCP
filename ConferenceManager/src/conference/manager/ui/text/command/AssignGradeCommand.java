package conference.manager.ui.text.command;

import conference.manager.business.GradeAssignmentService;
import conference.manager.ui.text.ConferenceManagerTextUI;
import java.util.List;
import conference.manager.business.domain.Paper;
import conference.manager.business.domain.Reviewer;

public class AssignGradeCommand extends Command {
	
	public AssignGradeCommand(ConferenceManagerTextUI ConferenceManagerInterface) {
		this.ConferenceManagerInterface = ConferenceManagerInterface;
	}

	public void execute() {

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
