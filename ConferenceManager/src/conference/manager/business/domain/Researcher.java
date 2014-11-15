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
	
	public Researcher(int id, String name, University affiliation, List<ResearchTopic> interests, List<Paper> papers, Conference conference) {
		this.id = id;
		this.name = name;
		this.affiliation = affiliation;
		this.interests = interests;
		this.papers = papers;
		this.conference = conference;
	}
	
	public Researcher(int id, String name, University affiliation, List<ResearchTopic> interests) {
		this.id = id;
		this.name = name;
		this.affiliation = affiliation;
		this.interests = interests;
	}

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
	
	public void addPaper(Paper paper) {
		this.papers.add(paper);
	}
}
