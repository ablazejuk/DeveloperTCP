package conference.manager.business.impl;

import java.util.LinkedList;
import java.util.List;

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

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void getConferencesNulltest(){
		assertFalse(paperSelector.getConferences() == null);
	}
	@Test
	public void getAcceptedpapersNulltest(){
		assertFalse(paperSelector.getAcceptedPapers(db.getAllocatedConferences().get(0)) == null);
	}
	@Test
	public void getRejectedpapersNulltest(){
		assertFalse(paperSelector.getRejectedPapers(db.getAllocatedConferences().get(0)) == null);
	}
	
	

}
