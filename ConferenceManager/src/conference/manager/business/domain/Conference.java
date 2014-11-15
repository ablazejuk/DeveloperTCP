package conference.manager.business.domain;

import java.util.List;

public class Conference {

	private String acronym;

	private List<Researcher> committeeMembers;

	private Researcher coordenator;

	private List<Paper> gradedPapers;

	private List<Paper> ungradedPapers;

	private List<Paper> unallocatedPapers;

	private List<Reviewer> reviewers;

	private boolean allocated;
	
	private boolean graded;

	public boolean isAllocated() {
		return allocated;
	}

	public boolean isGraded() {
		return graded;
	}

	public void allocatePaper(Paper paper, List<Reviewer> reviewers) {
		paper.addReviewers(reviewers);
	}

	/**
	 *  
	 */
	public void assignGrade(Paper paper, Reviewer reviewer, int grade) {
		paper.addGrade(reviewer, grade);
	}

	public List<Paper> getGradedPapers() {
		return gradedPapers;
	}

	public List<Paper> getUngradedPapers() {
		return ungradedPapers;
	}

	public List<Paper> getUnallocatedPapers() {
		return unallocatedPapers;
	}

	/**
	 *  
	 */
	public String getAcronym() {
		return acronym;
	}

	public List<Researcher> getCommitteeMembers() {
		return committeeMembers;
	}

	public List<Reviewer> getReviewers() {
		return reviewers;
	}

	public Researcher getCoordenator(){
		return coordenator;
	}
	
	public boolean isValidAcronym(String acronym) {
		if (!acronymIsNotNull(acronym))
			return false;
		else
			return true;
	}
	
	private boolean acronymIsNotNull(String acronym){
		if (acronym != null)
			return true;
		else
			return false;
	}

	public boolean isValidListOfPapers(List<Paper> unallocatedPaper) {
		if (areValidPapers(unallocatedPaper))
			return true;
		else
			return false;
	}

	private boolean areValidPapers(List<Paper> unallocatedPaper){
		for(Paper paper : unallocatedPaper){
			if(!(paper instanceof List<?>) && paper != null){
				return false;
			}
		}
		return true;
	}
	
	public boolean isValidListOfMembers(List<Researcher> members) {
		if (areValidMembers(members))
			return true;
		else
			return false;
	}

	private boolean areValidMembers(List<Researcher> members){
		for(Researcher member : members){
			if(!(member instanceof List<?>) && member != null){
				return false;
			}
		}
		return true;
	}
}
