package conference.manager.business.domain;

import java.util.List;
import java.util.Collection;

public class Researcher {

	private int id;

	private String name;

	private University affiliation;

	private List<ResearchTopic> interests;

	private List<Paper> papers;

	private Collection<Paper> paper;

	private Collection<ResearchTopic> researchTopic;

	private Conference conference;

	private University university;

	/**
	 *  
	 */
	public int getId() {
		return 0;
	}

	/**
	 *  
	 */
	public String getName() {
		return null;
	}

	/**
	 *  
	 */
	public University getAffiliation() {
		return null;
	}

	/**
	 *  
	 */
	public List<ResearchTopic> getInterests() {
		return null;
	}

	public List<Paper> getPapers() {
		return null;
	}

	public boolean equals(Researcher researcher) {
		return false;
	}

}
