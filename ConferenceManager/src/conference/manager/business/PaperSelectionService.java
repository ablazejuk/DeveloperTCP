package conference.manager.business;

import java.util.List;
import conference.manager.business.domain.Conference;

public interface PaperSelectionService {

	public abstract List<Conference> getConferences();

	public abstract List<Paper> getAcceptedPapers(Conference conference);

	public abstract List<Paper> getRejectedPapers(Conference conference);

}
