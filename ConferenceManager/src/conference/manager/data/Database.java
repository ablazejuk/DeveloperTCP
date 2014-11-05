package conference.manager.data;

import conference.manager.business.domain.University;
import conference.manager.business.domain.ResearchTopic;
import conference.manager.business.domain.Researcher;
import conference.manager.business.domain.Conference;
import java.util.List;
import conference.manager.business.domain.Paper;

public class Database {

	private List<Conference> allocatedConferences;

	private List<Conference> unallocatedConferences;

	private List<University> universities;

	private List<ResearchTopic> researchTopics;

	private List<Researcher> researchers;

	private List<Paper> papers;

	private List<Paper> ungradedPapers;

	/**
	 *  
	 *  
	 */
	public Database() {

	}

	/**
	 *  
	 */
	public Database(Boolean initData) {

	}

	public List<University> getUniversities() {
		return null;
	}

	public List<Conference> getConferences() {
		return null;
	}

	public List<Conference> getUnallocatedConferences() {
		return null;
	}

	public List<Paper> getUngradedPapers() {
		return null;
	}

	public List<ResearchTopic> getResearchTopics() {
		return null;
	}

	public List<Researcher> getResearchers() {
		return null;
	}

	public List<Paper> getPapers() {
		return null;
	}

	public void setAllocated(Conference conference) {

	}

	/**
	 *  
	 */
	public void setUngraded(Paper paper) {

	}

	/**
	 *  
	 */
	public void setGraded(Paper paper) {

	}

}
