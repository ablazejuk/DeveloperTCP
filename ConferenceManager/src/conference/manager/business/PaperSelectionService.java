package conference.manager.business;

import java.util.List;

import Exceptions.UnallocatedConferencesException;
import Exceptions.UngradedPapersException;
import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;

public interface PaperSelectionService {

	public abstract List<Conference> getConferences() throws UnallocatedConferencesException;

	public abstract List<Paper> getAcceptedPapers(Conference conference) throws UngradedPapersException;

	public abstract List<Paper> getRejectedPapers(Conference conference) throws UngradedPapersException;

}
