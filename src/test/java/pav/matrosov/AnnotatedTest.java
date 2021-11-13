package pav.matrosov;

import org.junit.jupiter.api.Test;
import pav.matrosov.steps.Steps;

public class AnnotatedTest {

    private static final String URL = "https://github.com/Matrosov1811";
    private static final String REPOSITORY = "qa-guru.hw6";
    private static final String TAB_NAME = "Issue";
    private static final int ISSUE_NUMBER = 1;

    Steps step = new Steps();

    @Test
    public void issueAnnotatedTest () {
        step.openRepositoryPage(URL);
        step.searchRepo(REPOSITORY);
        step.openRepo(REPOSITORY);
        step.openTab(TAB_NAME);
        step.checkIssue(ISSUE_NUMBER);
    }

}
