package errortracker;

import junit.framework.TestCase;

import org.junit.Test;

public class BugReporterTest extends TestCase{
	
	@Test
    public void testBugReporter() {
        String expectedMessage = "This is a bug";
        BugReporter bugReporter = new BugReporter(expectedMessage);
        String actualMessage = bugReporter.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}
