package Exceptions;

public class UngradedPapersException extends Exception {

	private static final long serialVersionUID = 1L;

	public String toString(){
		return "There are papers left ungraded!";
	}

}
