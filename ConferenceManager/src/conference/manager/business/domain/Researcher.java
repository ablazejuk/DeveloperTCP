package conference.manager.business.domain;

import java.util.ArrayList;
import java.util.List;

public class Researcher {

	protected int id;

	private String name;

	private University affiliation;

	protected List<ResearchTopic> interests;

	private List<Paper> papers;

	public Researcher(int id, String name, University affiliation, List<ResearchTopic> interests, List<Paper> papers) {
		this.id = id;
		this.name = name;
		this.affiliation = affiliation;
		this.interests = interests;
		this.papers = papers;
	}
	
	public Researcher(int id, String name, University affiliation, List<ResearchTopic> interests) {
		this.id = id;
		this.name = name;
		this.affiliation = affiliation;
		this.interests = interests;
		this.papers = new ArrayList<>();
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
	
	public String toString(){
		return this.id + " - " + this.name;
	}
}
