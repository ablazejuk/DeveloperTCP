package conference.manager.ui.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class UIUtils {

	public static final UIUtils INSTANCE = new UIUtils();

	private UIUtils() {
	}

	public UIUtils getInstance() {
		return UIUtils.INSTANCE;
	}

	public String propertyToString(String field, Date value) {
		return null;
	}

	public String propertyToString(String field, double value) {
		return null;
	}

	public String propertyToString(String field, int value) {
		return null;
	}

	public String propertyToString(String field, long value) {
		return null;
	}

	public String propertyToString(String field, String value) {
		return null;
	}

	public Double readDouble(String field) {
		System.out.println(field);
	
		String input = null;
	    Double number = new Double(0);
		
		try {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        input = bufferedReader.readLine();
	        number = Double.parseDouble(input);
	    } catch (NumberFormatException ex) {
	       System.out.println("Not a number!");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		return number;
	}

	public Integer readInteger(String field) {
		System.out.println(field);
		
		String input = null;
	    int number = 0;
		
		try {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        input = bufferedReader.readLine();
	        number = Integer.parseInt(input);
	    } catch (NumberFormatException ex) {
	       System.out.println("Not a number!");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		return number;
	}

	public Integer readInteger(String field, int min, int max) {
		int number;
		String input;
		
		do{
			System.out.print(field);
			System.out.println("[" + min + ", " + max + "]");
			
			input = null;
		    number = 0;
	    
			try {
		        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		        input = bufferedReader.readLine();
		        number = Integer.parseInt(input);
		    } catch (NumberFormatException ex) {
		       System.out.println("Not a number!");
		    } catch (IOException e) {
		        e.printStackTrace();
		    } 
	    } while(!isNotOutOfBounds(number, min, max));
		
		return number;
	}

	public Long readLong(String field) {
		System.out.println(field);
		
		String input = null;
	    Long number = new Long(0);
		
		try {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        input = bufferedReader.readLine();
	        number = Long.parseLong(input);
	    } catch (NumberFormatException ex) {
	       System.out.println("Not a number!");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		return number;
	}

	public String readString(String field) {
		System.out.println(field);
		
		String input = null;
		
		try {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        input = bufferedReader.readLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		return input;
	}
	
	private boolean isNotOutOfBounds(int number, int min, int max){
		
		if(number >= min && number <= max){
			return true;
		}
		
		System.out.println("Value out of bounds!");
		return false;
	}

}
