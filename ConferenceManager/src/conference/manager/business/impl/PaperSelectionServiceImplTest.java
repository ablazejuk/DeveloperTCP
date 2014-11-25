package conference.manager.business.impl;


import conference.manager.data.*;
import conference.manager.exceptions.AllocatedConferencesException;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;


public class PaperSelectionServiceImplTest {
	
	PaperSelectionServiceImpl paperSelector;
	Database db;
	
	@Before
	public void setUp(){
		db = new Database();
		paperSelector = new PaperSelectionServiceImpl(db);
	}


	@Test 
	public void getConferencesNulltest() {
		try {
			assertFalse(paperSelector.getConferences() == null);
		} catch (AllocatedConferencesException e) {
			e.printStackTrace();
		}
	}


}
