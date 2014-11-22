package conference.manager.business.impl;

import java.util.LinkedList;
import java.util.List;

import Exceptions.UnallocatedConferencesException;
import Exceptions.UngradedPapersException;
import conference.manager.business.domain.Conference;
import conference.manager.data.*;
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


	@Test (expected = UnallocatedConferencesException.class)
	public void getConferencesNulltest() throws UnallocatedConferencesException{
		assertFalse(paperSelector.getConferences() == null);
	}
	@Test (expected = UngradedPapersException.class)
	public void getAcceptedpapersNulltest() throws UngradedPapersException{
		assertFalse(paperSelector.getAcceptedPapers(db.getAllocatedConferences().get(0)) == null);
	}
	@Test(expected = UngradedPapersException.class)
	public void getRejectedpapersNulltest() throws UngradedPapersException{
		assertFalse(paperSelector.getRejectedPapers(db.getAllocatedConferences().get(0)) == null);
	}
	
	

}
