package conference.manager.business.domain;

import java.util.List;

public class Paper {

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

	/**
	 *  
	 */
	public int getId() {
		return id;
	}

	/**
	 *  
	 */
	public String getTitle() {
		return title;
	}

	/**
	 *  
	 */
	public float getAverageGrade() {
		float sum = 0;
		for(PaperGrade grade : grades){
			sum += grade.getGrade();
		}
		return sum/grades.size();
	}

	/**
	 *  
	 */
	public ResearchTopic getResearchTopic() {
		return researchTopic;
	}

	public List<Reviewer> getReviewers() {
		return reviewers;
	}

	public Conference getConference() {
		return conference;
	}
	
	public Researcher getAuthor(){
		return author;
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
}
