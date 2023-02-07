/**
 * Test class for testing the functionality of the calculateSum method.
 * 
 * @author Maryam Asgari
 * @since 2023-02-01
 */


package errortracker;



import junit.framework.TestCase;

import org.junit.Test;

public class BugReporterTest extends TestCase{
	
	/**
     * Test case for verifying the BugReporter functionality.
     * 
     * @param an instance error message
     * @throws Exception if any error occurs during the program
     */
	
	@Test
    public void testBugReporter() {
        String expectedMessage = "This is a bug";
        BugReporter bugReporter = new BugReporter(expectedMessage);
        String actualMessage = bugReporter.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}
