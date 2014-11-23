package Exceptions;

public class UnallocatedConferencesException extends Exception {


	private static final long serialVersionUID = 1L;
	
	public String toString(){
		return "There are no allocated Conferences.";
	}

}
