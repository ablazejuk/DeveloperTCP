package conference.manager.business.domain;

import java.util.List;
import java.util.Collection;

public class Reviewer extends Researcher implements Comparable<Reviewer> {

	private List<Paper> papersToReview;
	
	public Reviewer(int id, String name, University affiliation, List<ResearchTopic> interests, List<Paper> papers, Conference conference, List<Paper> papersToReview) {
		super(id, name, affiliation, interests, papers, conference);
		this.papersToReview = papersToReview;
	}

	private boolean hasSameAffiliation(Researcher researcher) {
		boolean sameAffiliation = this.getAffiliation().equals(researcher.getAffiliation());
		return sameAffiliation;
	}

	private boolean hasInterestIn(ResearchTopic topic) {
		for (ResearchTopic rt : this.interests) {
			if (topic.equals(rt))
				return true;
		}
		return false;
	}

	private boolean hasPaperToReviewInConference(Conference conference) {
		List<Paper> papersConference = conference.getUnallocatedPapers();
		
		for (Paper p : papersConference) {
			Researcher paperAuthor = p.getAuthor();
			
			if (!this.equals(paperAuthor))
				return true;
		}
		
		return false;
	}

	private boolean isTheAuthor(Paper paper) {
		boolean isTheAuthor = this.equals(paper.getAuthor());
		return isTheAuthor;
	}
	
	public List<Paper> getPapersToReview() {
		return papersToReview;
	}

	public void addPaperToReview(Paper paper) {
		papersToReview.add(paper);
	}

	public boolean isAbleToReview(Paper paper) {
		Researcher    paperAuthor = paper.getAuthor();
		ResearchTopic paperTopic  = paper.getResearchTopic();
		
		boolean isAbleToReview = this.hasSameAffiliation(paperAuthor) &&
								 this.hasInterestIn(paperTopic) &&
								 !this.isTheAuthor(paper);
		
		return isAbleToReview;
	}

	public void removePaperToReview(Paper paper) {
		for(Paper p : papersToReview){
			if(p.equals(papersToReview))
				papersToReview.remove(p);
		}
	}

	@Override
	public int compareTo(Reviewer r) {
		int numOfAllocatedPapers = this.papersToReview.size();
		int compareNumOfAllocatedPapers = r.getPapersToReview().size();
		
		int compare = numOfAllocatedPapers - compareNumOfAllocatedPapers;
		if (compare == 0) {
			compare = this.id - r.getId();
		}
		
		return compare;
	}

}
