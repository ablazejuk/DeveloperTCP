package conference.manager.business.domain;

import java.util.List;
import java.util.Collection;

public class Reviewer extends Researcher implements Comparable {

	private List<Paper> papersToReview;

	private Collection<Paper> paper;

	private boolean hasSameAffiliation(Researcher researcher) {
		return false;
	}

	/**
	 *  
	 */
	private boolean hasInterestIn(ResearchTopic topic) {
		return false;
	}

	/**
	 *  
	 */
	private boolean hasPaperToReviewInConference(Conference conference) {
		return false;
	}

	public List<Paper> getPapersToReview() {
		return null;
	}

	public void addPaperToReview(Paper paper) {

	}

	public int compareTo(Reviewer Reviewer) {
		return 0;
	}

	/**
	 *  
	 */
	public boolean isAbleToReview(Paper paper) {
		return false;
	}

	public void removePaperToReview(Paper paper) {

	}


	/**
	 * @see java.lang.Comparable#compareTo(java.lang.T)
	 */
	public int compareTo(T o) {
		return 0;
	}

}
