package conference.manager.business.domain;

public class PaperGrade {

	private int grade;
	private Reviewer reviewer;

	public PaperGrade(Reviewer reviewer, int grade) {
		this.reviewer = reviewer;
		this.grade = grade;
	}

	public int getGrade() {
		return grade;
	}

	public Reviewer getReviewer() {
		return reviewer;
	}

	public boolean isValidGrade(){
		if(grade >= -3 && grade <= 3)
			return true;
		else
			return false;
	}
}
