package conference.manager.data;

import Exceptions.UnallocatedConferencesException;
import conference.manager.business.domain.Reviewer;
import conference.manager.business.domain.University;
import conference.manager.business.domain.ResearchTopic;
import conference.manager.business.domain.Researcher;
import conference.manager.business.domain.Conference;

import java.util.ArrayList;
import java.util.List;

import conference.manager.business.domain.Paper;

public class Database {

	private List<Conference> allocatedConferences;

	private List<Conference> unallocatedConferences;

	private List<University> universities;

	private List<ResearchTopic> researchTopics;

	private List<Researcher> researchers;
	
	private List<Paper> unallocatedPapers;

	private List<Paper> gradedPapers;

	private List<Paper> ungradedPapers;

	public Database() {
		this.allocatedConferences = new ArrayList<>();
		this.unallocatedConferences = new ArrayList<>();
		this.universities = new ArrayList<>();
		this.researchTopics = new ArrayList<>();
		this.researchers = new ArrayList<>();
		this.unallocatedPapers = new ArrayList<>();
		this.ungradedPapers = new ArrayList<>();
		this.gradedPapers = new ArrayList<>();
		
		ResearchTopic softwareProductLines      = new ResearchTopic("Software Product Lines");
		ResearchTopic softwareReuse             = new ResearchTopic("Software Reuse");
		ResearchTopic modularity                = new ResearchTopic("Modularity");
		ResearchTopic softwareArchitecture      = new ResearchTopic("Software Architecture");
		ResearchTopic softwareTesting           = new ResearchTopic("Software Testing");
		ResearchTopic aspectOrientedProgramming = new ResearchTopic("Aspect-oriented Programming");
		ResearchTopic softwareQuality           = new ResearchTopic("Software Quality");
		
		University ufrgs = new University("UFRGS");
		University usp   = new University("USP");
		University ufrj  = new University("UFRJ");
		
		List<ResearchTopic> joaoInterests = new ArrayList<ResearchTopic>();
		joaoInterests.add(softwareProductLines);
		joaoInterests.add(softwareReuse);
		joaoInterests.add(modularity);
		
		List<ResearchTopic> anaInterests = new ArrayList<ResearchTopic>();
		anaInterests.add(softwareArchitecture);
		anaInterests.add(softwareReuse);
		anaInterests.add(modularity);
		
		List<ResearchTopic> manoelInterests = new ArrayList<ResearchTopic>();
		manoelInterests.add(softwareProductLines);
		manoelInterests.add(softwareTesting);
		
		List<ResearchTopic> joanaInterests = new ArrayList<ResearchTopic>();
		joanaInterests.add(softwareProductLines);
		joanaInterests.add(softwareReuse);
		joanaInterests.add(softwareArchitecture);
		joanaInterests.add(aspectOrientedProgramming);
		
		List<ResearchTopic> miguelInterests = new ArrayList<ResearchTopic>();
		miguelInterests.add(softwareTesting);
		miguelInterests.add(softwareArchitecture);
		miguelInterests.add(modularity);
		
		List<ResearchTopic> beatrizInterests = new ArrayList<ResearchTopic>();
		beatrizInterests.add(aspectOrientedProgramming);
		beatrizInterests.add(softwareReuse);
		beatrizInterests.add(softwareTesting);
		
		List<ResearchTopic> suzanaInterests = new ArrayList<ResearchTopic>();
		suzanaInterests.add(aspectOrientedProgramming);
		suzanaInterests.add(softwareReuse);
		suzanaInterests.add(modularity);
		
		List<ResearchTopic> natashaInterests = new ArrayList<ResearchTopic>();
		natashaInterests.add(softwareProductLines);
		natashaInterests.add(softwareReuse);
		natashaInterests.add(modularity);
		natashaInterests.add(softwareQuality);
		
		List<ResearchTopic> pedroInterests = new ArrayList<ResearchTopic>();
		pedroInterests.add(aspectOrientedProgramming);
		pedroInterests.add(softwareArchitecture);
		
		List<ResearchTopic> carlosInterests = new ArrayList<ResearchTopic>();
		carlosInterests.add(softwareTesting);
		carlosInterests.add(softwareReuse);
		carlosInterests.add(modularity);
		
		Reviewer joao    = new Reviewer(1, "Jo�o", ufrgs, joaoInterests);
		Reviewer ana     = new Reviewer(2, "Ana", usp, anaInterests);
		Reviewer manoel  = new Reviewer(3, "Manoel", ufrgs, manoelInterests);
		Reviewer joana   = new Reviewer(4, "Joana", ufrj, joanaInterests);
		Reviewer miguel  = new Reviewer(5, "Miguel", ufrgs, miguelInterests);
		Reviewer beatriz = new Reviewer(6, "Beatriz", ufrj, beatrizInterests);
		Reviewer suzana  = new Reviewer(7, "Suzana", ufrgs, suzanaInterests);
		Reviewer natasha = new Reviewer(8, "Natasha", ufrj, natashaInterests);
		Reviewer pedro   = new Reviewer(9, "Pedro", usp, pedroInterests);
		Reviewer carlos  = new Reviewer(10, "Carlos", usp, carlosInterests);
		
		Paper couplingAndCoesion      = new Paper(1, "Coupling and Coesion", joao, modularity);
		Paper designPatterns          = new Paper(2, "Design Patterns", beatriz, softwareReuse);
		Paper aspectJ                 = new Paper(3, "AspectJ", suzana, aspectOrientedProgramming);
		Paper featureModel            = new Paper(4, "Feature Model", natasha, softwareProductLines);
		Paper architectureRecovery    = new Paper(5, "Architecture Recovery", pedro, softwareArchitecture);
		Paper functionalTesting       = new Paper(6, "Funcional Testing", carlos, softwareTesting);
		Paper cots                    = new Paper(7, "COTs", beatriz, softwareReuse);
		Paper pointcut                = new Paper(8, "Pointcut", suzana, aspectOrientedProgramming);
		Paper productDerivation       = new Paper(9, "Product Derivation", natasha, softwareProductLines);
		Paper architectureComformance = new Paper(10, "Architecture Comformance", pedro, softwareArchitecture);
		Paper structuralTesting       = new Paper(11, "Structural Testing", carlos, softwareTesting);
		
		joao.addPaper(couplingAndCoesion);
		beatriz.addPaper(designPatterns);
		beatriz.addPaper(cots);
		suzana.addPaper(aspectJ);
		suzana.addPaper(pointcut);
		natasha.addPaper(featureModel);
		natasha.addPaper(productDerivation);
		pedro.addPaper(architectureRecovery);
		pedro.addPaper(architectureComformance);
		carlos.addPaper(functionalTesting);
		carlos.addPaper(structuralTesting);
		
		List<Reviewer> membersCommitteeICSE = new ArrayList<>();
		membersCommitteeICSE.add(joao);
		membersCommitteeICSE.add(ana);
		membersCommitteeICSE.add(manoel);
		membersCommitteeICSE.add(joana);
		membersCommitteeICSE.add(miguel);
		membersCommitteeICSE.add(beatriz);
		membersCommitteeICSE.add(suzana);
		
		List<Paper> unallocatedPapersICSE = new ArrayList<>();
		unallocatedPapersICSE.add(cots);
		unallocatedPapersICSE.add(pointcut);
		unallocatedPapersICSE.add(productDerivation);
		unallocatedPapersICSE.add(architectureComformance);
		unallocatedPapersICSE.add(structuralTesting);
		Conference icse = new Conference("ICSE", membersCommitteeICSE, unallocatedPapersICSE);
		// ------------------------------------------------------------------------------------------------------
		List<Reviewer> membersCommitteeFSE = membersCommitteeICSE;
		
		List<Paper> unallocatedPapersFSE = new ArrayList<>();
		unallocatedPapersFSE.add(designPatterns);
		unallocatedPapersFSE.add(aspectJ);
		unallocatedPapersFSE.add(featureModel);
		unallocatedPapersFSE.add(architectureRecovery);
		unallocatedPapersFSE.add(functionalTesting);
		Conference fse  = new Conference("FSE", membersCommitteeFSE, unallocatedPapersFSE);
		// ------------------------------------------------------------------------------------------------------
		List<Reviewer> membersCommitteeSBES = new ArrayList<>();
		membersCommitteeSBES.add(joana);
		membersCommitteeSBES.add(miguel);
		membersCommitteeSBES.add(beatriz);
		membersCommitteeSBES.add(suzana);
		membersCommitteeSBES.add(natasha);
		membersCommitteeSBES.add(pedro);
		membersCommitteeSBES.add(carlos);
		
		List<Paper> unallocatedPapersSBES = new ArrayList<>();
		unallocatedPapersSBES.add(couplingAndCoesion);
		Conference sbes = new Conference("SBES", membersCommitteeSBES, unallocatedPapersSBES);
		// -------------------------------------------------------------------------------------------------------
		couplingAndCoesion.addConference(sbes);     
		designPatterns.addConference(fse);
		aspectJ.addConference(fse);                
		featureModel.addConference(fse);           
		architectureRecovery.addConference(fse);   
		functionalTesting.addConference(fse);      
		cots.addConference(icse);                   
		pointcut.addConference(icse);               
		productDerivation.addConference(icse);      
		architectureComformance.addConference(icse);
		structuralTesting.addConference(icse);
		
		this.researchTopics.add(softwareProductLines);
		this.researchTopics.add(softwareReuse);
		this.researchTopics.add(modularity);
		this.researchTopics.add(softwareArchitecture);
		this.researchTopics.add(softwareTesting);
		this.researchTopics.add(aspectOrientedProgramming);
		this.researchTopics.add(softwareQuality);
		
		this.unallocatedConferences.add(icse);
		this.unallocatedConferences.add(sbes);
		this.unallocatedConferences.add(fse);
		
		
		this.universities.add(ufrgs);
		this.universities.add(usp);
		this.universities.add(ufrj);
		
		this.researchers.add(joao);
		this.researchers.add(ana);
		this.researchers.add(manoel);
		this.researchers.add(joana);
		this.researchers.add(miguel);
		this.researchers.add(beatriz);
		this.researchers.add(suzana);
		this.researchers.add(natasha);
		this.researchers.add(pedro);
		this.researchers.add(carlos);
		
		
		this.unallocatedPapers.add(productDerivation);
		this.unallocatedPapers.add(cots);
		this.unallocatedPapers.add(aspectJ);
		this.unallocatedPapers.add(featureModel);
		this.unallocatedPapers.add(architectureRecovery);
		this.unallocatedPapers.add(designPatterns);
		this.unallocatedPapers.add(functionalTesting);
		this.unallocatedPapers.add(architectureComformance);
		this.unallocatedPapers.add(couplingAndCoesion);
		this.unallocatedPapers.add(structuralTesting);
		this.unallocatedPapers.add(pointcut);
	}

	public List<University> getUniversities() {
		return universities;
	}

	public List<Conference> getUnallocatedConferences() {
		return this.unallocatedConferences;
	}
	
	public List<Conference> getAllocatedConferences() throws UnallocatedConferencesException {		
		if(this.unallocatedConferences.isEmpty()){
			return this.allocatedConferences;
		} else {
			throw new UnallocatedConferencesException();
		}	
	}
	
	public List<ResearchTopic> getResearchTopics() {
		return this.researchTopics;
	}

	public List<Researcher> getResearchers() {
		return this.researchers;
	}
	
	public List<Paper> getUnallocatedPapers() {
		return this.unallocatedPapers;
	}

	public List<Paper> getUngradedPapers() {
		return this.ungradedPapers;
	}
	
	public List<Paper> getGradedPapers() {
		return this.gradedPapers;
	}
	
	public void setAllocated(Conference conference) {
		this.allocatedConferences.add(conference);
		
		List<Conference> newUnallocatedConferences = new ArrayList<>();
		
		for (int i = 0; i < this.unallocatedConferences.size(); i++) {
			if (this.unallocatedConferences.get(i).equals(conference)) {
				this.unallocatedConferences.remove(i);
			}
		}
		
		this.unallocatedConferences = newUnallocatedConferences;
	}

	public void setUngraded(Paper paper) {
		this.ungradedPapers.add(paper);
		
		for (int i = 0; i < this.unallocatedPapers.size(); i++) {
			if (this.unallocatedPapers.get(i).equals(paper)) {
				this.unallocatedPapers.remove(i);
			}
		}
	}

	public void setGraded(Paper paper) {
		this.gradedPapers.add(paper);
		
		for (int i = 0; i < this.ungradedPapers.size(); i++) {
			if (this.ungradedPapers.get(i).equals(paper)) {
				this.ungradedPapers.remove(i);
			}
		}
	}

}
