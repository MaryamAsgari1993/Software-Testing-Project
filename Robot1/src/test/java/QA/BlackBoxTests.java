package QA;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import generator.ArraySheet;
import generator.Location;
import generator.Robot;
import util.Heading;
import util.Mode;

public class BlackBoxTests {
  @Test
	public void testRobotStatus() {
    Robot robot = new Robot();
    ArraySheet arraysheet = new ArraySheet(5, 5);
		robot.setLocation(new Location(2, 1, Heading.WEST, Mode.UP, arraysheet));
		ArrayList<String> expected = new ArrayList<>();
		expected.add("2,1,WEST,UP");
		assertEquals(expected, robot.report());
	}


  @Test
	public void rotateRobotNorthToWest() {
    Robot robot = new Robot();
    ArraySheet arraysheet = new ArraySheet(5, 5);
		robot.setLocation(new Location(2, 1, Heading.NORTH,  Mode.UP, arraysheet));
		robot.left();
		assertEquals(Heading.WEST, robot.getLocation().getHeading());
		assertEquals(2, robot.getLocation().getX());
		assertEquals(1, robot.getLocation().getY());
	}

	@Test
	public void rotateRobotNorthToEast() {
    Robot robot = new Robot();
    ArraySheet arraysheet = new ArraySheet(5, 5);
		robot.setLocation(new Location(1, 2, Heading.NORTH,  Mode.UP, arraysheet));
		robot.right();
		assertEquals(Heading.EAST, robot.getLocation().getHeading());
		assertEquals(1, robot.getLocation().getX());
		assertEquals(2, robot.getLocation().getY());
	}

  @Test
	public void rotateRobotEastToNorth() {
    Robot robot = new Robot();
    ArraySheet arraysheet = new ArraySheet(5, 5);
		robot.setLocation(new Location(1, 2, Heading.EAST,  Mode.UP, arraysheet));
		robot.left();
		assertEquals(Heading.NORTH, robot.getLocation().getHeading());
		assertEquals(1, robot.getLocation().getX());
		assertEquals(2, robot.getLocation().getY());
	}
  @Test
	public void rotateRobotEastToSouth() {
    Robot robot = new Robot();
    ArraySheet arraysheet = new ArraySheet(5, 5);
		robot.setLocation(new Location(1, 2, Heading.EAST,  Mode.UP, arraysheet));
		robot.right();
		assertEquals(Heading.SOUTH, robot.getLocation().getHeading());
		assertEquals(1, robot.getLocation().getX());
		assertEquals(2, robot.getLocation().getY());
	}

  @Test
	public void rotateRobotSouthToEast() {
    Robot robot = new Robot();
    ArraySheet arraysheet = new ArraySheet(5, 5);
		robot.setLocation(new Location(2, 1, Heading.SOUTH,  Mode.UP, arraysheet));
		robot.left();
		assertEquals(Heading.EAST, robot.getLocation().getHeading());
		assertEquals(2, robot.getLocation().getX());
		assertEquals(1, robot.getLocation().getY());
	}

  @Test
	public void rotateRobotSouthToWest() {
    Robot robot = new Robot();
    ArraySheet arraysheet = new ArraySheet(5, 5);
		robot.setLocation(new Location(1, 2, Heading.SOUTH,  Mode.UP, arraysheet));
		robot.right();
		assertEquals(Heading.WEST, robot.getLocation().getHeading());
		assertEquals(1, robot.getLocation().getX());
		assertEquals(2, robot.getLocation().getY());
	}


  @Test
	public void rotateRobotWestToSouth() {
    Robot robot = new Robot();
    ArraySheet arraysheet = new ArraySheet(5, 5);
		robot.setLocation(new Location(1, 2, Heading.WEST,  Mode.UP, arraysheet));
		robot.left();
		assertEquals(Heading.SOUTH, robot.getLocation().getHeading());
		assertEquals(1, robot.getLocation().getX());
		assertEquals(2, robot.getLocation().getY());
	}

  @Test
	public void rotateRobotWestToNorth() {
    Robot robot = new Robot();
    ArraySheet arraysheet = new ArraySheet(5, 5);
		robot.setLocation(new Location(1, 2, Heading.WEST,  Mode.UP, arraysheet));
		robot.right();
		assertEquals(Heading.NORTH, robot.getLocation().getHeading());
		assertEquals(1, robot.getLocation().getX());
		assertEquals(2, robot.getLocation().getY());
	}

  @Test
  public void moveRobotHorizontallyRight(){
    Robot robot = new Robot();
    ArraySheet arraysheet = new ArraySheet(5, 5);
    robot.setLocation(new Location(0, 0, Heading.NORTH,  Mode.UP, arraysheet)); // set the robot at the start of the grid
    robot.right(); // change the direction of the robot to facing east
    robot.move(1); // move 1 step to the right
		assertEquals(1, robot.getLocation().getX());
		assertEquals(0, robot.getLocation().getY()); 
  }

  @Test
  public void moveRobotHorizontallyLeft(){
    Robot robot = new Robot();
    ArraySheet arraysheet = new ArraySheet(5, 5);
    robot.setLocation(new Location(4, 0, Heading.NORTH,  Mode.UP, arraysheet)); // set the robot on the gourth cell
    robot.left(); // change the direction of the robot to facing east
    robot.move(1); // move 1 step to the left
		assertEquals(3, robot.getLocation().getX());
		assertEquals(0, robot.getLocation().getY()); 
  }

  @Test
  public void moveRobotVerticallyUp(){
    Robot robot = new Robot();
    ArraySheet arraysheet = new ArraySheet(5, 5);
    robot.setLocation(new Location(0, 0, Heading.NORTH,  Mode.UP, arraysheet)); // set the robot on the gourth cell
    robot.move(1); // move 1 step up
		assertEquals(0, robot.getLocation().getX());
		assertEquals(1, robot.getLocation().getY()); 
  }

  @Test
  public void moveRobotVerticallyDown(){
    Robot robot = new Robot();
    ArraySheet arraysheet = new ArraySheet(5, 5);
    robot.setLocation(new Location(0, 3, Heading.NORTH,  Mode.UP, arraysheet)); // set the robot on the gourth cell
    robot.move(1); // move 1 step up
		assertEquals(0, robot.getLocation().getX());
		assertEquals(2, robot.getLocation().getY()); 
  }


  @Test
  // test that the robvot can put the pen up
	public void testPenUp() {
    Robot robot = new Robot();
    ArraySheet arraysheet = new ArraySheet(5, 5);
		robot.setLocation(new Location(2, 1, Heading.WEST,  Mode.DOWN, arraysheet));
		robot.up();
		assertEquals(Mode.UP, robot.getLocation().getMode());	
	}

	@Test
  // Test that the robot can put the pen down
	public void testPenDowm() {
    Robot robot = new Robot();
    ArraySheet arraysheet = new ArraySheet(5, 5);
		robot.setLocation(new Location(1, 2, Heading.WEST,  Mode.UP, arraysheet));
		robot.down();
		assertEquals(Mode.DOWN, robot.getLocation().getMode());	
	}
    
}
