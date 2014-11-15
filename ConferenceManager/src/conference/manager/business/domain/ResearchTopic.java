package conference.manager.business.domain;

public class ResearchTopic {

	private String name;

	public ResearchTopic(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public boolean equals(ResearchTopic that) {
		return this.name.equals(that.name);
	}

}
