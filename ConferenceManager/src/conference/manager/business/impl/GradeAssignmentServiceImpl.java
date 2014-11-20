package conference.manager.business.impl;

import conference.manager.business.GradeAssignmentService;
import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Reviewer;
import conference.manager.business.domain.Paper;
import conference.manager.data.Database;
import java.util.List;

public class GradeAssignmentServiceImpl implements GradeAssignmentService {

	private Database database;

	public GradeAssignmentServiceImpl(Database database) {
		this.database = database;
	}

	public List<Paper> getPapers() {
		return this.database.getUnallocatedPapers();
	}

	public List<Reviewer> getReviewers(Paper paper) {
		return paper.getReviewers();
	}

	public void assignGrade(Paper paper, Reviewer reviewer, int grade) {
		Conference conference = paper.getConference();
		conference.assignGrade(paper, reviewer, grade);
		reviewer.removePaperToReview(paper);
		if(paper.isGraded())
			database.setGraded(paper);
	}

}
