package conference.manager.ui.text.command;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import conference.manager.business.CommitteeAllocationService;
import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.business.domain.Reviewer;
import conference.manager.business.impl.CommitteeAllocationServiceImpl;
import conference.manager.data.Database;
import conference.manager.ui.text.ConferenceManagerTextUI;
import conference.manager.ui.text.UIUtils;

public class AllocateCommitteeCommand extends Command {

	private CommitteeAllocationService committeeAllocationService;
	private String logFilePath;
	private PrintWriter logWriter;

	public AllocateCommitteeCommand(ConferenceManagerTextUI ConferenceManagerInterface,
			Database database) {
		this.ConferenceManagerInterface = ConferenceManagerInterface;
		this.committeeAllocationService = new CommitteeAllocationServiceImpl(database);

		this.logFilePath = "log.txt";

	}

	public void execute() {
		createNewLogFile();

		List<Conference> unallocatedConferences = this.getUnallocatedConferences();

		if (!unallocatedConferences.isEmpty()) {
			ConferenceManagerInterface.showUnallocatedConferences(unallocatedConferences);

			Conference selectedConference = selectConference();
			int numReviewers = askNumberReviewers();

			addLogEntry("Initializing Allocation");

			List<Paper> allocatedPapers = allocatePapers(selectedConference, numReviewers);

			addLogEntry(allocatedPapers);
			addLogEntry("End of Allocation");
			closeLogFile();

			ConferenceManagerInterface.showAllocatedPapers(allocatedPapers);
			ConferenceManagerInterface.printLog(logFilePath);
		} else {
			System.out.println("\nNo more Conferences to allocate.\n");
		}

		ConferenceManagerInterface.createAndShow();
	}

	public List<Conference> getUnallocatedConferences() {
		return this.committeeAllocationService.getUnallocatedConferences();
	}

	public List<Paper> getUnallocatedPapers(Conference conference) {
		return conference.getUnallocatedPapers();
	}

	public List<Paper> allocatePapers(Conference conference, int numReviewers) {
		return committeeAllocationService.allocatePapers(conference, numReviewers);
	}

	private void addLogEntry(String entry) {
		logWriter.println(entry);
	}

	private void addLogEntry(List<Paper> allocatedPapers) {
		for (Paper p : allocatedPapers) {
			for (Reviewer r : p.getReviewers()) {
				logWriter.println("Paper " + p + " allocated to the reviewer " + r);
			}
		}
	}

	private Conference selectConference() {
		int numOfUnallocatedConferences = committeeAllocationService.getUnallocatedConferences()
				.size();
		int conferenceNumber = UIUtils.getInstance().readInteger("Insert Conference Number: ", 1,
				numOfUnallocatedConferences);

		Conference selectedConference = committeeAllocationService
				.getUnallocatedConferenceByIndex(conferenceNumber - 1);

		return selectedConference;
	}

	private int askNumberReviewers() {
		return UIUtils.getInstance().readInteger("Select the number of reviewers: ", 2, 5);
	}

	private void createNewLogFile() {
		try {

			logWriter = new PrintWriter(logFilePath, "utf-8");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	private void closeLogFile() {
		logWriter.close();
	}
}
