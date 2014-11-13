package conference.manager.business.domain;

import java.util.List;
import java.util.Collection;

public class Researcher {

	private int id;

	private String name;

	private University affiliation;

	private List<ResearchTopic> interests;

	private List<Paper> papers;

	private Conference conference;

	private University university;

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public University getAffiliation() {
		return this.affiliation;
	}

	public List<ResearchTopic> getInterests() {
		return this.interests;
	}

	public List<Paper> getPapers() {
		return this.papers;
	}

	public boolean equals(Researcher researcher) {
		return this.id == researcher.getId();
	}

}
