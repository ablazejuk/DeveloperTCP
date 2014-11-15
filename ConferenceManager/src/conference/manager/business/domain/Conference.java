package conference.manager.business.domain;

import java.util.List;
import java.util.Collection;

public class Conference {

	private String acronym;

	private List<Researcher> committeeMembers;

	private Researcher coordenator;

	private List<Paper> gradedPapers;

	private List<Paper> ungradedPapers;

	private List<Paper> unallocatedPapersICSE;

	private List<Reviewer> reviewers;
	
	public Conference(String acronym, List<Researcher> committeeMembers, List<Paper> unallocatedPapersICSE) {
		this.acronym = acronym;
		this.committeeMembers = committeeMembers;
		this.unallocatedPapersICSE = unallocatedPapersICSE;
	}

	public boolean isAllocated() {
		return false;
	}

	public boolean isGraded() {
		return false;
	}

	public void allocatePaper(Paper paper, List<Reviewer> reviewers) {

	}

	public void assignGrade(Paper paper, Reviewer reviewer, int grade) {

	}

	public List<Paper> getGradedPapers() {
		return gradedPapers;
	}

	public List<Paper> getUngradedPapers() {
		return ungradedPapers;
	}

	public List<Paper> getunallocatedPapersICSE() {
		return unallocatedPapersICSE;
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

}
