package conference.manager.business.impl;


import conference.manager.data.*;
import conference.manager.exceptions.AllocatedConferencesException;
import conference.manager.exceptions.UngradedPapersException;
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


	@Test (expected = AllocatedConferencesException.class)
	public void getConferencesNulltest() throws AllocatedConferencesException{
		assertFalse(paperSelector.getConferences() == null);
	}
	@Test (expected = UngradedPapersException.class)
	public void getAcceptedpapersNulltest() throws UngradedPapersException, AllocatedConferencesException{
		assertFalse(paperSelector.getAcceptedPapers(db.getAllocatedConferences().get(0)) == null);
	}
	@Test(expected = UngradedPapersException.class)
	public void getRejectedpapersNulltest() throws UngradedPapersException, AllocatedConferencesException{
		assertFalse(paperSelector.getRejectedPapers(db.getAllocatedConferences().get(0)) == null);
	}
	
	

}
