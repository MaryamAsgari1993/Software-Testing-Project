package input;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.easymock.EasyMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.verify;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

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
	  public void testValidateCommand_MissingArgumentsForCommandI() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("I");
	    assertFalse(result);
	    result = inputReader.validateCommand("I 1");
	    assertFalse(result);
	    result = inputReader.validateCommand("I 101");
	    assertFalse(result);
	  }
	  @Test
	  public void testValidateCommand_TooManyArguments() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("I 10 20");
	    assertFalse(result);
	  }
	  @Test
	  public void testValidateCommand_NoArguments() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("");
	    assertFalse(result);
	  }

	  @Test
	  public void testValidateCommand_InvalidArgument() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("I 0");
	    assertFalse(result);
	  }
	  @Test
	  public void testValidateCommandQ() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("Q");
	    assertTrue(result);
	  }
	  @Test
	  public void testCommandWithSimulatorNullAndCommandNotI() {
		  InputReader inputReader = EasyMock.createMock(InputReader.class);
		     inputReader = new InputReader();
		     inputReader.simulator=null;
	    
	    boolean result = inputReader.validateCommand("M 2");
	    assertFalse(result);
	  }
	  
	  @Test
	  public void testValidateCommand_MissingArgumentsForCommandM() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("M");
	    assertFalse(result);
	    result = inputReader.validateCommand("M 0");
	    assertFalse(result);
	  }
	
	  
	  
	  
}
