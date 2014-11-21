package conference.manager.business.domain;

import java.util.List;

public class Paper implements Comparable<Paper> {

	private int id;

	private String title;

	private Conference conference;

	private List<Reviewer> reviewers;

	private Researcher author;

	private List<PaperGrade> grades;

	private ResearchTopic researchTopic;
	
	private boolean allocated;
	
	private boolean graded;
	
	private boolean accepted;
	
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
		float sum = 0;
		for(PaperGrade grade : grades){
			sum += grade.getGrade();
		}
		return sum/grades.size();
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

	public Researcher getAuthor(){
		return this.author;
	}

	public boolean isAllocated() {
		return allocated;
	}

	public boolean isGraded() {
		return graded;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void addReviewers(List<Reviewer> reviewers) {
		this.reviewers = reviewers;
	}

	public void addGrade(Reviewer reviewer, int grade) {
		PaperGrade paperGrade = new PaperGrade(reviewer, grade);
		grades.add(paperGrade);
	}
	
	public void addConference(Conference conference) {
		this.conference = conference;
	}

	public boolean isValidId(int id){
		if(id > 0)
			return true;
		else
			return false;
	}
	
	public boolean isValidTitle(String title){
		if(titleIsNotNull(title) && titleIsNotEmpty(title))
			return true;
		else
			return false;
	}
	
	private boolean titleIsNotNull(String title){
		if(title != null)
			return true;
		else
			return false;
	}
	
	private boolean titleIsNotEmpty(String title){
		if(!title.isEmpty())
			return true;
		else
			return false;
	}
	
	public boolean isValidAuthor(Researcher author){
		if(author != null)
			return true;
		else
			return false;
	}
	
	public boolean isValidConference(Conference conference){
		if(conference != null)
			return true;
		else
			return false;
	}
	
	public boolean isValidResearchTopic(ResearchTopic researchTopic){
		if(researchTopic != null)
			return true;
		else
			return false;
	}
	
	public boolean equals(Paper paper) {
		return this.id == paper.getId();
	}
	
	public String toString() {
		return this.id + " - " + this.title;
	}

	@Override
	public int compareTo(Paper paper) {
		int compare = this.id - paper.getId();
		return compare;
	}
}
