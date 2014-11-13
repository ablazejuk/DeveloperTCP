package conference.manager.business.domain;

public class University {

	private String name;
	
	public University(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public boolean equals(University that) {
		return (this.name).equals(that.name);
	}

}
