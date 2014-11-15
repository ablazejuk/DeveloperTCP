package conference.manager.data;

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

	private List<Paper> papers;

	private List<Paper> ungradedPapers;

	public Database() {
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
		
		List<ResearchTopic> joaoInterests = new ArrayList<ResearchTopic>(3);
		joaoInterests.add(softwareProductLines);
		joaoInterests.add(softwareReuse);
		joaoInterests.add(modularity);
		
		List<ResearchTopic> anaInterests = new ArrayList<ResearchTopic>(3);
		anaInterests.add(softwareArchitecture);
		anaInterests.add(softwareReuse);
		anaInterests.add(modularity);
		
		List<ResearchTopic> manoelInterests = new ArrayList<ResearchTopic>(2);
		manoelInterests.add(softwareProductLines);
		manoelInterests.add(softwareTesting);
		
		List<ResearchTopic> joanaInterests = new ArrayList<ResearchTopic>(4);
		joanaInterests.add(softwareProductLines);
		joanaInterests.add(softwareReuse);
		joanaInterests.add(softwareArchitecture);
		joanaInterests.add(aspectOrientedProgramming);
		
		List<ResearchTopic> miguelInterests = new ArrayList<ResearchTopic>(3);
		miguelInterests.add(softwareTesting);
		miguelInterests.add(softwareArchitecture);
		miguelInterests.add(modularity);
		
		List<ResearchTopic> beatrizInterests = new ArrayList<ResearchTopic>(3);
		beatrizInterests.add(aspectOrientedProgramming);
		beatrizInterests.add(softwareReuse);
		beatrizInterests.add(softwareTesting);
		
		List<ResearchTopic> suzanaInterests = new ArrayList<ResearchTopic>(3);
		suzanaInterests.add(aspectOrientedProgramming);
		suzanaInterests.add(softwareReuse);
		suzanaInterests.add(modularity);
		
		List<ResearchTopic> natashaInterests = new ArrayList<ResearchTopic>(4);
		natashaInterests.add(softwareProductLines);
		natashaInterests.add(softwareReuse);
		natashaInterests.add(modularity);
		natashaInterests.add(softwareQuality);
		
		List<ResearchTopic> pedroInterests = new ArrayList<ResearchTopic>(2);
		pedroInterests.add(aspectOrientedProgramming);
		pedroInterests.add(softwareArchitecture);
		
		List<ResearchTopic> carlosInterests = new ArrayList<ResearchTopic>(3);
		carlosInterests.add(softwareTesting);
		carlosInterests.add(softwareReuse);
		carlosInterests.add(modularity);
		
		Researcher joao    = new Researcher(1, "João", ufrgs, joaoInterests);
		Researcher ana     = new Researcher(2, "Ana", usp, anaInterests);
		Researcher manoel  = new Researcher(3, "Manoel", ufrgs, manoelInterests);
		Researcher joana   = new Researcher(4, "Joana", ufrj, joanaInterests);
		Researcher miguel  = new Researcher(5, "Miguel", ufrgs, miguelInterests);
		Researcher beatriz = new Researcher(6, "Beatriz", ufrj, beatrizInterests);
		Researcher suzana  = new Researcher(7, "Suzana", ufrgs, suzanaInterests);
		Researcher natasha = new Researcher(8, "Natasha", ufrj, natashaInterests);
		Researcher pedro   = new Researcher(9, "Pedro", usp, pedroInterests);
		Researcher carlos  = new Researcher(10, "Carlos", usp, carlosInterests);
		
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
		
		List<Researcher> membersCommitteeICSE = new ArrayList<>();
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
		List<Researcher> membersCommitteeFSE = membersCommitteeICSE;
		
		List<Paper> unallocatedPapersFSE = new ArrayList<>();
		unallocatedPapersFSE.add(designPatterns);
		unallocatedPapersFSE.add(aspectJ);
		unallocatedPapersFSE.add(featureModel);
		unallocatedPapersFSE.add(architectureRecovery);
		unallocatedPapersFSE.add(functionalTesting);
		Conference fse  = new Conference("FSE", membersCommitteeFSE, unallocatedPapersFSE);
		// ------------------------------------------------------------------------------------------------------
		List<Researcher> membersCommitteeSBES = new ArrayList<>();
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
		
		this.unallocatedConferences.add(sbes);
		this.unallocatedConferences.add(fse);
		this.unallocatedConferences.add(icse);
		
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
		
		this.ungradedPapers.add(couplingAndCoesion);
		this.ungradedPapers.add(designPatterns);
		this.ungradedPapers.add(aspectJ);
		this.ungradedPapers.add(featureModel);
		this.ungradedPapers.add(architectureRecovery);
		this.ungradedPapers.add(functionalTesting);
		this.ungradedPapers.add(cots);
		this.ungradedPapers.add(pointcut);
		this.ungradedPapers.add(productDerivation);
		this.ungradedPapers.add(architectureComformance);
		this.ungradedPapers.add(structuralTesting);
	}

	public Database(Boolean initData) {

	}

	public List<University> getUniversities() {
		return universities;
	}

	public List<Conference> getUnallocatedConferences() {
		return unallocatedConferences;
	}

	public List<Paper> getUngradedPapers() {
		return ungradedPapers;
	}

	public List<ResearchTopic> getResearchTopics() {
		return researchTopics;
	}

	public List<Researcher> getResearchers() {
		return researchers;
	}

	public List<Paper> getPapers() {
		return papers;
	}

	public void setAllocated(Conference conference) {

	}

	public void setUngraded(Paper paper) {

	}

	public void setGraded(Paper paper) {

	}

}
