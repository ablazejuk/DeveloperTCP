package conference.manager.data;

import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {
	
	private Database database;
	
	@Before
	public void setUp() {
		this.database = new Database();
	}
	
	@Test
	public void testGetUniversities() {
		this.database.getUniversities();
	}

}
