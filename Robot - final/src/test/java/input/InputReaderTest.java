package input;

import junit.framework.TestCase;
import org.junit.Test;

import generator.Simulator;

public class InputReaderTest extends TestCase{

	
	  @Test
	  public void testCreateRobotSimulator() {
	    InputReader inputReader = new InputReader();
	    Simulator simulator = inputReader.createRobotSimulator(5, 5);
	    assertNotNull(simulator);
	  }
	  @Test
	  public void testValidateCommand_InvalidCommand() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("II 23");
	    assertFalse(result);
	  }

	  @Test
	  public void testValidateCommand_ValidCommand() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("I 5");
	    assertTrue(result);
	  }

	  @Test
	  public void testValidateCommand_MissingArguments() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("I");
	    assertFalse(result);
	  }

	  @Test
	  public void testValidateCommand_InvalidArgument() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("I 0");
	    assertFalse(result);
	  }
}
