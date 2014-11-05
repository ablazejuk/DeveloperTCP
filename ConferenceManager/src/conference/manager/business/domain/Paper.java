package conference.manager.business.domain;

import java.util.List;
import java.util.Collection;

public class Paper {

	private int id;

	private String title;

	private Conference conference;

	private List<Reviewer> reviewers;

	private Researcher author;

	private List<PaperGrade> grades;

	private ResearchTopic researchTopic;

	private Conference conference;

	private Researcher researcher;

	private ResearchTopic researchTopic;

	private PaperGrade paperGrade;

	private Collection<Reviewer> reviewer;

	/**
	 *  
	 */
	public int getId() {
		return 0;
	}

	/**
	 *  
	 */
	public String getTitle() {
		return null;
	}

	/**
	 *  
	 */
	public float getAverageGrade() {
		return 0;
	}

	/**
	 *  
	 */
	public ResearchTopic getResearchTopic() {
		return null;
	}

	public List<Reviewer> getReviewers() {
		return null;
	}

	public Conference getConference() {
		return null;
	}

	public boolean isAllocated() {
		return false;
	}

	public boolean isGraded() {
		return false;
	}

	public boolean isAccepted() {
		return false;
	}

	public void addReviewers(List<Reviewer> reviewers) {

	}

	public void addGrade(Reviewer reviewer, int {-3..3} grade) {

	}

}
