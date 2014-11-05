package conference.manager.business.domain;

import java.util.List;
import java.util.Collection;

public class Conference {

	private String acronym;

	private List<Researcher> committeeMembers;

	private Researcher coordenator;

	private List<Paper> gradedPapers;

	private List<Paper> ungradedPapers;

	private List<Paper> unallocatedPaper;

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
		return null;
	}

	public List<Paper> getUngradedPapers() {
		return null;
	}

	public List<Paper> getUnallocatedPapers() {
		return null;
	}

	/**
	 *  
	 */
	public String getAcronym() {
		return null;
	}

	public List<Researcher> getCommitteeMembers() {
		return null;
	}

	public List<Reviewer> getReviewers() {
		return null;
	}

}
