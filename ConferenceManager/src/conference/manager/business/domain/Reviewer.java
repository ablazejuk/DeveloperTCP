package conference.manager.business.domain;

import java.util.List;
import java.util.Collection;

public class Reviewer extends Researcher implements Comparable {

	private List<Paper> papersToReview;
	
	public Reviewer(int id, String name, University affiliation, List<ResearchTopic> interests, List<Paper> papers, Conference conference, List<Paper> papersToReview) {
		super(id, name, affiliation, interests, papers, conference);
		this.papersToReview = papersToReview;
	}

	private boolean hasSameAffiliation(Researcher researcher) {
		return this.getAffiliation().equals(researcher.getAffiliation());
	}

	private boolean hasInterestIn(ResearchTopic topic) {
		return false;
	}

	private boolean hasPaperToReviewInConference(Conference conference) {
		return false;
	}

	public List<Paper> getPapersToReview() {
		return null;
	}

	public void addPaperToReview(Paper paper) {

	}

	public boolean isAbleToReview(Paper paper) {
		return false;
	}

	public void removePaperToReview(Paper paper) {

	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
