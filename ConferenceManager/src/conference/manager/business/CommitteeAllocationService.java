package conference.manager.business;

import java.util.List;

import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;

public interface CommitteeAllocationService {

	public abstract List<Conference> getUnallocatedConferences();

	public abstract List<Paper> getUnallocatedPapers(Conference conference);

	public abstract List<Paper> allocatePapers(List<Paper> papers, Conference conference, int numReviewers);

}
