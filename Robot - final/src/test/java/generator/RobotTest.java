package generator;

import errortracker.BugReporter;
import junit.framework.TestCase;
import util.Mode;
import util.Heading;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import java.util.ArrayList;



public class RobotTest extends TestCase {
	
	private Robot robot;
	private ArraySheet arraysheet;

	@BeforeEach
	public void setUp() {
		robot = new Robot();
		arraysheet = new ArraySheet(5, 5);
	}
	
	@Test
	public void testPlaceRobotInNullTable() {
		try {
			robot.placeRobot(new Location(0, 0, Heading.NORTH, Mode.UP, arraysheet), null);
		} catch (BugReporter ex) {
			assertEquals("Table not found", ex.getMessage());
		}
	}
	@Test
	public void testPlaceRobotInNullLocation() {
		try {
			robot.placeRobot(null, arraysheet);
		} catch (BugReporter ex) {
			assertEquals("Location not found", ex.getMessage());
		}
	}
	@Test
	public void testPlaceRobotInLocationOutOfBoundary() {
		try {
			robot.placeRobot(new Location(4, 6, Heading.NORTH, Mode.UP, arraysheet), arraysheet);
		} catch (BugReporter ex) {
			assertEquals("Invalid location", ex.getMessage());
		}
	}
	@Test
	public void testPlaceRobotInValidLocation() {
		try {
			robot.placeRobot(new Location(2, 3, Heading.NORTH, Mode.UP, arraysheet), arraysheet);
		} catch (BugReporter ex) {
			// Ignore
		}
	}
	@Test
	public void testMoveCommandInNorthHeading() {
		robot.placeRobot(new Location(0, 0, Heading.NORTH, Mode.UP, arraysheet), arraysheet);
		robot.move(1);
		assertEquals(Heading.NORTH, robot.getLocation().getHeading());
		assertEquals(0, robot.getLocation().getX());
		assertEquals(1, robot.getLocation().getY());
	}
	@Test
	public void testMoveCommandInSouthHeading() {
		robot.placeRobot(new Location(0, 1, Heading.SOUTH, Mode.UP, arraysheet), arraysheet);
		robot.move(1);
		assertEquals(Heading.SOUTH, robot.getLocation().getHeading());
		assertEquals(0, robot.getLocation().getX());
		assertEquals(0, robot.getLocation().getY());
	}
	@Test
	public void testMoveCommandInEastHeading() {
		robot.placeRobot(new Location(0, 0, Heading.EAST, Mode.UP, arraysheet), arraysheet);
		robot.move(1);
		assertEquals(Heading.EAST, robot.getLocation().getHeading());
		assertEquals(1, robot.getLocation().getX());
		assertEquals(0, robot.getLocation().getY());
	}
	@Test
	public void testMoveCommandInWestHeading() {
		robot.placeRobot(new Location(1, 0, Heading.WEST, Mode.UP, arraysheet), arraysheet);
		robot.move(1);
		assertEquals(Heading.WEST, robot.getLocation().getHeading());
		assertEquals(0, robot.getLocation().getX());
		assertEquals(0, robot.getLocation().getY());
	}
	@Test
	public void testRobotMoveToOutsideofBoundary() {
		robot.placeRobot(new Location(5, 5, Heading.NORTH, Mode.UP, arraysheet), arraysheet);
		robot.move(6);
		assertEquals(Heading.NORTH, robot.getLocation().getHeading());
		assertEquals(5, robot.getLocation().getX());
		assertEquals(5, robot.getLocation().getY());
		
		
	}
	@Test
	public void testRobotToLeft() {
		robot.setLocation(new Location(2, 1, Heading.WEST,  Mode.UP, arraysheet));
		robot.left();
		assertEquals(Heading.SOUTH, robot.getLocation().getHeading());
		assertEquals(2, robot.getLocation().getX());
		assertEquals(1, robot.getLocation().getY());
	}
	@Test
	public void testRobotToRight() {
		robot.setLocation(new Location(2, 1, Heading.WEST,  Mode.UP, arraysheet));
		robot.right();
		assertEquals(Heading.NORTH, robot.getLocation().getHeading());
		assertEquals(2, robot.getLocation().getX());
		assertEquals(1, robot.getLocation().getY());
	}
	
	@Test
	public void testRobotToUp() {
		robot.setLocation(new Location(2, 1, Heading.WEST,  Mode.DOWN, arraysheet));
		robot.up();
		assertEquals(Mode.UP, robot.getLocation().getMode());	
	}
	
	@Test
	public void testRobotToDowm() {
		robot.setLocation(new Location(2, 1, Heading.WEST,  Mode.UP, arraysheet));
		robot.down();
		assertEquals(Mode.DOWN, robot.getLocation().getMode());	
	}
	@Test
	public void testRobotReport() {
		robot.setLocation(new Location(2, 1, Heading.WEST, Mode.UP, arraysheet));
		ArrayList<String> expected = new ArrayList<>();
		expected.add("2,1,WEST,UP");
		assertEquals(expected, robot.report());
	}
	
	 @Test
	   public void testPrint() {
		
		robot.placeRobot(new Location(0, 0, Heading.NORTH, Mode.UP, arraysheet), arraysheet);
		robot.down();
		robot.right();
		robot.move(1);
		robot.report();
		ArrayList<String> expected = new ArrayList<>();
	    expected.add(" ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , *, *,  ,  ,  ");
	    assertEquals(expected.toString(), robot.print().toString());
	   }
	
}
