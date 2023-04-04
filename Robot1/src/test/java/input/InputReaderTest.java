// /**
//  * Test class for testing the functionality of the InputReader method.
//  * @author Maryam Asgari and Shima Omidvar 
//  * @since 2023-02-04
//  */
// package input;

// import junit.framework.TestCase;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;
// import org.apache.http.impl.execchain.MainClientExec;
// import org.easymock.EasyMock;
// import static org.easymock.EasyMock.expect;
// import static org.easymock.EasyMock.verify;

// import java.io.ByteArrayInputStream;
// import java.io.ByteArrayOutputStream;
// import java.io.InputStream;
// import java.io.PrintStream;
// import java.util.Scanner;
// import junit.framework.TestCase; 
// import static org.junit.Assert.*;
// import static org.junit.jupiter.api.Assertions.assertEquals;

// import generator.Simulator;

// public class InputReaderTest extends TestCase{
// 	private final InputStream systemIn = System.in;
// 	private final PrintStream systemOut = System.out;

// 	private InputStream testIn;
// 	private ByteArrayOutputStream testOut;



// 	private void provideInput(String data) {
// 	    testIn = new ByteArrayInputStream(data.getBytes());
// 	    System.setIn(testIn);
// 	}

// 		/**
// 		 * Test the ShowHelpCommand functionality with invalid command.
// 	     * @return true.
// 	     * 
// 	     */ 



// 	@Test 
//     public void testShowHelpCommand() { 
//         final String testString = "\033[1;35m Command	 Meaning\033[0"; 
//         provideInput("F\nQ\n"); 
//         testOut = new ByteArrayOutputStream(); 
//         PrintStream ps = new PrintStream(testOut); 
//         PrintStream old = System.out; 
//         System.setOut(ps); 
//         InputReader.readInput(); 
//         System.out.flush(); 
//         System.setOut(old); 
//         String temp = testOut.toString().split("\n")[1];  
//         assertEquals(testString.toString(), testOut.toString().split("\n")[1].substring(0,27)); 
 
//     }
// 	/**
// 	 * Test the readInput functionality with M and invalid second arg acommand.
//      * 
//      * 
//      */ 
// 	@Test 
//     public void testgoOutOfRangeCommand() { 
//         final String testString = "Invalid movement"; 
//         provideInput("I 3\nM 4\nQ\n"); 
//         testOut = new ByteArrayOutputStream(); 
//         PrintStream ps = new PrintStream(testOut); 
//         PrintStream old = System.out; 
//         System.setOut(ps); 
//         InputReader.readInput();
//         System.out.flush(); 
//         System.setOut(old); 
//         String temp = testOut.toString().split("\n")[2];  
//         assertEquals(testString.toString(), testOut.toString().split("\n")[2].substring(0,16)); 
 
//     }
// 	/**
// 	 * Test the readInput functionality with I command.
//      * 
//      * 
//      */ 
// 	@Test 
//     public void testInsertI() { 
//         final String testString = "0,0,NORTH,UP"; 
//         provideInput("I 2\nC\nQ\n"); 
//         testOut = new ByteArrayOutputStream(); 
//         PrintStream ps = new PrintStream(testOut); 
//         PrintStream old = System.out; 
//         System.setOut(ps); 
//         InputReader.readInput();; 
//         System.out.flush(); 
//         System.setOut(old); 
//         String temp = testOut.toString().split("\n")[2];  
//         systemOut.print(temp.length());
//         systemOut.print(temp);
//         assertEquals(testString.toString(), testOut.toString().split("\n")[2].substring(0,12)); 
 
//     }
// 	/**
// 	 * Test the readInput functionality with M command and valid Argument.
//      * 
//      * 
//      */ 
// 	@Test 
//     public void testInsertM() { 
//         final String testString = "0,1,NORTH,UP"; 
//         provideInput("I 2\nM 1\nC\nQ\n"); 
//         testOut = new ByteArrayOutputStream(); 
//         PrintStream ps = new PrintStream(testOut); 
//         PrintStream old = System.out; 
//         System.setOut(ps); 
//         InputReader.readInput();; 
//         System.out.flush(); 
//         System.setOut(old); 
//         String temp = testOut.toString().split("\n")[3];  
//         systemOut.print(temp.length());
//         systemOut.print(temp);
//         assertEquals(testString.toString(), testOut.toString().split("\n")[3].substring(0,12)); 
 
//     }
// 		/**
// 		 * Test the validateCommand functionality with invalid extra argument command.
// 	     * @param line The command that user enters.In this case, It is "M 2 2"
// 	     * @return true or false. In this case, it returns false.
// 	     * 
// 	     */ 
// 	  @Test
// 	  public void testValidateCommand_InvalidExtraArgumentForM() {
// 	    InputReader inputReader = new InputReader();
// 	    boolean result = inputReader.validateCommand("M 2 2");
// 	    assertFalse(result);
// 	  }
// 		/**
// 		 * Test the validateCommand functionality with invalid and less than 1 argument command.
// 	     * @param line The command that user enters.In this case, It is ""
// 	     * @return true or false. In this case, it returns false.
// 	     * 
// 	     */  

// 	  @Test
// 	  public void testValidateCommand_Invalidless1Argument() {
// 	    InputReader inputReader = new InputReader();
// 	    boolean result = inputReader.validateCommand("");
// 	    assertFalse(result);
// 	  }

// 	/**
// 	 * Before adjusting the location, it is imperative to ensure that the new position does not exceed the boundaries of the floor space.
//      * @param row The row in which the robot is located. In this test case, we set it 5.
//      * @param column The row in which the robot is located. In this test case, we set it 5.
//      * @return simulator Simulator object.
//      * 
//      */ 

//  	  @Test
// 	  public void testCreateRobotSimulator() {
// 	    InputReader inputReader = new InputReader();
// 	    Simulator simulator = inputReader.createRobotSimulator(5, 5);
// 	    assertNotNull(simulator);
// 	  }
	  
//  		/**
//  		 * Test the validateCommand functionality with invalid command.
//  	     * @param line The command that user enters.In this case, It is "II 23"
//  	     * @return true or false. In this case, it returns false.
//  	     * 
//  	     */ 
	  
// 	  @Test
// 	  public void testValidateCommand_InvalidCommand() {
// 	    InputReader inputReader = new InputReader();
// 	    boolean result = inputReader.validateCommand("II 23");
	 
// 	    assertFalse(result);
		
// 	  }
	  
// 		/**
// 		 * Test the validateCommand functionality with valid command.
// 	     * @param line The command that user enters.In this case, It is I 23
// 	     * @return true or false. In this case, it returns True.
// 	     * 
// 	     */ 

// 	  @Test
// 	  public void testValidateCommand_ValidCommand() {
// 	    InputReader inputReader = new InputReader();
// 	    boolean result = inputReader.validateCommand("I 5");
// 	    assertTrue(result);
// 	  }
// 		/**
// 		 * Test the validateCommand functionality with the command I but a part of the command was missed.
// 	     * @param line The command that user enters.In this case, It is I
// 	     * @return true or false. In this case, it returns Flase.
// 	     * 
// 	     */ 
// 	  @Test
// 	  public void testValidateCommand_MissingArgumentsForCommandI() {
// 	    InputReader inputReader = new InputReader();
// 	    boolean result = inputReader.validateCommand("I");
// 	    assertFalse(result);
// 	    result = inputReader.validateCommand("I 1");
// 	    assertFalse(result);
// 	    result = inputReader.validateCommand("I 101");
// 	    assertFalse(result);
// 	  }
// 		/**
// 		 * Test the validateCommand functionality with the command I but a part of the command was extra.
// 	     * @param line The command that user enters.In this case, It is I 10 20
// 	     * @return true or false. In this case, it returns Flase.
// 	     * 
// 	     */ 
	
// 	  @Test
// 	  public void testValidateCommand_less1Arguments() {
// 	    InputReader inputReader = new InputReader();
// 	    boolean result = inputReader.validateCommand("");
// 	    assertFalse(result);
// 	  }

// 		/**
// 		 * Test the validateCommand functionality with the command " ".
// 	     * @param line The command that user enters.In this case, It is " "
// 	     * @return true or false. In this case, it returns Flase.
// 	     * 
// 	     */ 
	
// 	  @Test
// 	  public void testValidateCommand_NoArguments() {
// 	    InputReader inputReader = new InputReader();
// 	    boolean result = inputReader.validateCommand("");
// 	    assertFalse(result);
// 	  }
// 		/**
// 		 * Test the validateCommand functionality with the command I but a part of the command is invalid.
// 	     * @param line The command that user enters.In this case, It is "I 0"
// 	     * @return true or false. In this case, it returns Flase.
// 	     * 
// 	     */ 
// 	  @Test
// 	  public void testValidateCommand_InvalidArgument() {
// 	    InputReader inputReader = new InputReader();
// 	    boolean result = inputReader.validateCommand("I 0");
// 	    assertFalse(result);
// 	  }
// 		/**
// 		 * Test the validateCommand functionality with the command Q.
// 	     * @param line The command that user enters.In this case, It is Q
// 	     * @return true or false. In this case, it returns True.
// 	     * 
// 	     */ 
// 	  @Test
// 	  public void testValidateCommandQ() {
// 	    InputReader inputReader = new InputReader();
// 	    boolean result = inputReader.validateCommand("Q");
// 	    assertTrue(result);
// 	  }
// 		/**
// 		 * Test the validateCommand functionality with null simulator and the command M.
// 	     * @param line The command that user enters.In this case, It is M 2
// 	     * @return true or false. In this case, it returns False.
// 	     * 
// 	     */ 
// 	  @Test
// 	  public void testCommandWithSimulatorNullAndCommandNotI() {
// 		  InputReader inputReader = EasyMock.createMock(InputReader.class);
// 		     inputReader = new InputReader();
// 		     inputReader.simulator=null;
	    
// 	    boolean result = inputReader.validateCommand("M 2");
// 	    assertFalse(result);
// 	  }
// 		/**
// 		 * Test the validateCommand functionality with the command M but a part of the command was missed.
// 	     * @param line The command that user enters.In this case, It is M
// 	     * @return true or false. In this case, it returns False.
// 	     * 
// 	     */ 
// 	  @Test
// 	  public void testValidateCommand_MissingArgumentsForCommandM() {
// 	    InputReader inputReader = new InputReader();
// 	    boolean result = inputReader.validateCommand("M");
// 	    assertFalse(result);
// 	    result = inputReader.validateCommand("M 0");
// 	    assertFalse(result);
// 	  }
	  
// 	  /**
// 		 * Test the validateCommand functionality with the command I but a second arg  of the command was not integer.
// 	     * @param line The command that user enters.In this case, It is I i
// 	     * @return true or false. In this case, it returns False.
// 	     * 
// 	     */ 
	  
	  
// 	  @Test
// 	  public void testValidateCommand_InvalidSecondArgumentForI() {
// 	    InputReader inputReader = new InputReader();
// 	    boolean result = inputReader.validateCommand("I i");
// 	    assertFalse(result);
// 	  }
	  
	  
// 	  /**
// 			 * Test the validateCommand functionality with the command M but a second arg  of the command was not integer.
// 		     * @param line The command that user enters.In this case, It is M m
// 		     * @return true or false. In this case, it returns False.
// 		     * 
// 		     */ 
// 	  @Test
// 	  public void testValidateCommand_InvalidSecondArgumentForM() {
// 	    InputReader inputReader = new InputReader();
// 	    boolean result = inputReader.validateCommand("M m");
// 	    assertFalse(result);
// 	  }

	  
// }
