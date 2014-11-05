package conference.manager.business.impl;

import conference.manager.business.GradeAssignmentService;
import conference.manager.business.domain.Reviewer;
import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.data.Database;
import java.util.List;

public class GradeAssignmentServiceImpl implements GradeAssignmentService {

	private Database database;

	public void GradeAssignmentServiceImpl(Database database) {

	}

	public List<Paper> getPapers() {
		return null;
	}

	public List<Reviewer> getReviewers(Paper paper) {
		return null;
	}

	public void assignGrade(Paper paper, Reviewer reviewer, int grade) {

	}


	/**
	 * @see conference.manager.business.GradeAssignmentService#assignGrade(paper : Paper, reviewer :Reviewer)()
	 */
	public void assignGrade(Paper paper, Reviewer reviewer) {

	}

}
