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
	
	public Paper(int id, String title, Researcher author, ResearchTopic researchTopic) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.researchTopic = researchTopic;
	}

	public int getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public float getAverageGrade() {
		return 0;
	}

	public ResearchTopic getResearchTopic() {
		return this.researchTopic;
	}

	public List<Reviewer> getReviewers() {
		return this.reviewers;
	}

	public Conference getConference() {
		return this.conference;
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

	public void addGrade(Reviewer reviewer, int grade) {

	}
	
	public void addConference(Conference conference) {
		this.conference = conference;
	}

}
