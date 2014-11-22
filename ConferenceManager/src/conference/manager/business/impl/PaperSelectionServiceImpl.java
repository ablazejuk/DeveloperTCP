package conference.manager.business.impl;

import conference.manager.business.PaperSelectionService;
import conference.manager.business.CommitteeAllocationService;
import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.data.Database;

import java.util.LinkedList;
import java.util.List;

public class PaperSelectionServiceImpl implements PaperSelectionService {

	private Database database;

	public PaperSelectionServiceImpl(Database database) {
		this.database = database;
	}

	public List<Conference> getConferences() throws NullPointerException {
		List<Conference> conferencias = database.getAllocatedConferences();
		if (conferencias != null){
			return conferencias;
		}else{
			throw new NullPointerException();
		}	
		
	}

	public List<Paper> getAcceptedPapers(Conference conference) /*throws NullPointerException*/  {
		//.isGraded()
			List<Paper> lista_de_papers = new LinkedList<Paper>();
			for (Paper paper: conference.getGradedPapers())
			{
				if (paper.isAccepted()){
					lista_de_papers.add(paper);
				}
			}
			return lista_de_papers;
		}

				
	

	public List<Paper> getRejectedPapers(Conference conference) /*throws NullPointerException*/ {
		//.isGraded()
			List<Paper> lista_de_papers = new LinkedList<Paper>();
			for (Paper paper: conference.getGradedPapers())
			{
				if (!paper.isAccepted() ){
					lista_de_papers.add(paper);
				}
			}
			return lista_de_papers;
		}
	
	
	



}
