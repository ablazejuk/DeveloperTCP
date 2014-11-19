package conference.manager.ui.text;

import java.util.Date;
import java.util.Scanner;

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
	
		Scanner reader = new Scanner(System.in);
		double num = reader.nextDouble();
		reader.close();
		return num;
	}

	public Integer readInteger(String field) {
		System.out.println(field);
		
		Scanner reader = new Scanner(System.in);
		int num = reader.nextInt();
		reader.close();
		return num;
	}

	public Integer readInteger(String field, int min, int max) {
		System.out.print(field);
		System.out.println("[" + min + ", " + max + "]");
		
		Scanner reader = new Scanner(System.in);
		int num = reader.nextInt();
		reader.close();
		return num;
	}

	public Long readLong(String field) {
		return null;
	}

	public String readString(String field) {
		return null;
	}

}
