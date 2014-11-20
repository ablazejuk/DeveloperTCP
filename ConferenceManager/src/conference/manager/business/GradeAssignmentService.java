package conference.manager.business;

import java.util.List;

import conference.manager.business.domain.Paper;
import conference.manager.business.domain.Reviewer;

public interface GradeAssignmentService {

	public abstract List<Paper> getPapers();

	public abstract List<Reviewer> getReviewers(Paper paper);

	public abstract void assignGrade(Paper paper, Reviewer reviewer, int grade);

}
