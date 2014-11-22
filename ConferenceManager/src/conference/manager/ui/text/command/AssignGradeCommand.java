package conference.manager.ui.text.command;

import conference.manager.business.GradeAssignmentService;
import conference.manager.ui.text.ConferenceManagerTextUI;
import conference.manager.ui.text.UIUtils;

import java.util.List;

import conference.manager.business.domain.Paper;
import conference.manager.business.domain.Reviewer;
import conference.manager.business.impl.GradeAssignmentServiceImpl;
import conference.manager.data.Database;

public class AssignGradeCommand extends Command {
	
	private GradeAssignmentService gradeAssignmentService;
	
	public AssignGradeCommand(ConferenceManagerTextUI ConferenceManagerInterface, Database database) {
		this.ConferenceManagerInterface = ConferenceManagerInterface;
		this.gradeAssignmentService = new GradeAssignmentServiceImpl(database);
	}

	public void execute() {
		List<Paper> ungradedPapers = getUngradedPapers();
		showPapers(ungradedPapers);
		int paperId;
		int reviewerId;
		
		do{
			paperId = UIUtils.getInstance().readInteger("Insert a valid paper id: ");
		} while(!validatePaperId(ungradedPapers, paperId));
		
		Paper selectedPaper = selectPaper(ungradedPapers, paperId);
		
		List<Reviewer> reviewers = getReviewers(selectedPaper);
		showReviewers(reviewers);
		
		do{
			reviewerId = UIUtils.getInstance().readInteger("Insert a valid reviewer id: ");
		} while(!validateReviewerId(reviewers, reviewerId));
		
		Reviewer selectedReviewer = selectReviewer(reviewers, reviewerId);
		
		int grade = requestGrade();
		gradeAssignmentService.assignGrade(selectedPaper, selectedReviewer, grade);
		
		System.out.println("End of Grade Assignment");
		
		ConferenceManagerInterface.createAndShow();
	}
	
	private List<Paper> getUngradedPapers(){
		return gradeAssignmentService.getUngradedPapers();
	}
	
	private List<Reviewer> getReviewers(Paper selectedPaper){
		return gradeAssignmentService.getReviewers(selectedPaper);
	}
	
	private void showPapers(List<Paper> papersToAssignGrade) {
		ConferenceManagerInterface.showUngradedPapers(papersToAssignGrade);
	}

	private Paper selectPaper(List<Paper> papersToAssignGrade, int id) {
		Paper selectedPaper = null;
		for(Paper p : papersToAssignGrade){
			if(p.getId() == id){
				selectedPaper = p;
			}
		}
		return selectedPaper;
	}

	private void showReviewers(List<Reviewer> reviewers) {
		ConferenceManagerInterface.showReviewers(reviewers);
	}

	private Reviewer selectReviewer(List<Reviewer> reviewers, int id) {
		Reviewer selectedReviewer = null;
		for(Reviewer r : reviewers){
			if(r.getId() == id){
				selectedReviewer = r;
			}
		}
		return selectedReviewer;
	}

	private int requestGrade() {
		return UIUtils.getInstance().readInteger("Insert a valid grade: ", -3, 3);
	}
	
	private boolean validatePaperId(List<Paper> papers, int id) {
		for(Paper p : papers){
			if(p.getId() == id){
				return true;
			}
		}
		System.out.println("There is no paper with this id!");
		return false;
	}
	
	private boolean validateReviewerId(List<Reviewer> reviewers, int id) {
		for(Reviewer r : reviewers){
			if(r.getId() == id){
				return true;
			}
		}
		System.out.println("There is no reviewer with this id!");
		return false;
	}

}
