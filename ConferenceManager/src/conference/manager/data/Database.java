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
	
	// New variable *conferences*
	// Since the conferences won't change during the program, it is wise to store the data. 
	private List<Conference> conferences;

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
		return universities;
	}

	public List<Conference> getConferences() {
		return conferences;
	}

	public List<Conference> getUnallocatedConferences() {
		return unallocatedConferences;
	}

	public List<Paper> getUngradedPapers() {
		return ungradedPapers;
	}

	public List<ResearchTopic> getResearchTopics() {
		return researchTopics;
	}

	public List<Researcher> getResearchers() {
		return researchers;
	}

	public List<Paper> getPapers() {
		return papers;
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
