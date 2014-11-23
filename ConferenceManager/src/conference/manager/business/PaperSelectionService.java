package conference.manager.business;

import java.util.List;

import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.exceptions.AllocatedConferencesException;
import conference.manager.exceptions.UngradedPapersException;

public interface PaperSelectionService {

	public abstract List<Conference> getConferences() throws AllocatedConferencesException;

	public abstract List<Paper> getAcceptedPapers(Conference conference) throws UngradedPapersException;

	public abstract List<Paper> getRejectedPapers(Conference conference) throws UngradedPapersException;

}
