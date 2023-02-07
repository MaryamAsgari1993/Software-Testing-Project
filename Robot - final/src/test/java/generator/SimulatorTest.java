package generator;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.easymock.EasyMock;
import util.Command;
import util.Heading;
import util.Mode;
import java.util.ArrayList;

public class SimulatorTest extends TestCase {
	
	private Simulator simulator;
	private Robot robot;
	private ArraySheet arraysheet;
	Location initialPosition;
	@BeforeEach
	public void setUp() {
		simulator = new Simulator();
		robot = new Robot();
		arraysheet = new ArraySheet(5, 5);
		simulator.initSimulator(robot, arraysheet);
		initialPosition = new Location(0, 0, Heading.NORTH, Mode.UP, arraysheet);
		robot.placeRobot(initialPosition, arraysheet);
	}
	
	 @Test
	    public void testPlaceCommandInnerFunctionality() {
	        ArraySheet.floor= arraysheet.initializeLocation();
	        Location location = new Location(0, 0, Heading.NORTH, Mode.UP, arraysheet);
	        robot.placeRobot(location, arraysheet);
	        assertEquals(location, robot.getLocation());
	        
	    }
	 
	 
	 @Test
	 public void testPlaceCommand() {

		 
		 simulator.placeCommand();
			
		 assertEquals(Heading.NORTH, robot.location.getHeading());
		 assertEquals(Mode.UP, robot.location.getMode());
		 assertEquals("0,0,NORTH,UP", robot.getLocation().toString());
		
		
	 }


	 	@Test
	    public void testMoveCommand() {

	        simulator.moveCommand(4);
	        Location finalPosition = robot.getLocation();
	        assertEquals(finalPosition.getX(), 0);
	        assertEquals(finalPosition.getY(), 4);
	        assertEquals(finalPosition.getHeading(), Heading.NORTH);
	 }
	 	
	
	 
	 @Test
	 public void testOtherCommandCHangeDirectionToLeft() {
		 
		 simulator.otherCommand(Command.L);
	     assertEquals("WEST", robot.getLocation().getHeading().toString());
	   
	 }
	 
	 @Test
	 public void testOtherCommandCHangeDirectionToRight() {
		 
		 simulator.otherCommand(Command.R);
	     assertEquals("EAST", robot.getLocation().getHeading().toString());
	   
	 }
	 
	 @Test
	 public void testOtherCommandCHangeWritingModeToUp() {
			initialPosition = new Location(0, 0, Heading.NORTH, Mode.DOWN, arraysheet);
			robot.placeRobot(initialPosition, arraysheet);
			simulator.otherCommand(Command.U);
			assertEquals("UP", robot.getLocation().getMode().toString());
	   
	 }
	 
	 @Test
	 public void testOtherCommandCHangeWritingModeToDown() {
			
			simulator.otherCommand(Command.D);
			assertEquals("DOWN", robot.getLocation().getMode().toString());
	   
	 }
	 
	 @Test
		public void testOtherCommandReport() {
			ArrayList<String> expected = new ArrayList<>();
			expected.add("0,0,NORTH,UP");
			assertEquals(expected, simulator.otherCommand(Command.C));
			
		}
	 @Test
	   public void testOtherCommandPrint() {
		
		ArrayList<String> expected = new ArrayList<>();
	    expected.add(" ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ");
	    assertEquals(expected.toString(), simulator.otherCommand(Command.P).toString());
	   }
	 
	 @Test
	 public void testGetRobot() {
	
	     assertEquals(robot, simulator.getRobot());
	 }







	

	
}
