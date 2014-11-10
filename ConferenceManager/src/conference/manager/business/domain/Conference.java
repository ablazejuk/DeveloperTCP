package conference.manager.business.domain;

import java.util.List;
import java.util.Collection;

public class Conference {

	private String acronym;

	private List<Researcher> committeeMembers;

	private Researcher coordenator;

	private List<Paper> gradedPapers;

	private List<Paper> ungradedPapers;

	private List<Paper> unallocatedPapers;

	private List<Reviewer> reviewers;

	private Collection<Paper> paper;

	private Collection<Reviewer> reviewer;

	private Researcher researcher;

	public boolean isAllocated() {
		return false;
	}

	public boolean isGraded() {
		return false;
	}

	public void allocatePaper(Paper paper, List<Reviewer> reviewers) {

	}

	/**
	 *  
	 */
	public void assignGrade(Paper paper, Reviewer reviewer, int grade) {

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

}
