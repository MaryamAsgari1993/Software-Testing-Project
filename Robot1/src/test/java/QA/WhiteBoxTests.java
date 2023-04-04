package QA;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;

import generator.ArraySheet;
import generator.Location;
import generator.Robot;
import generator.Simulator;
import input.InputReader;
import util.Mode;
import util.Heading;

public class WhiteBoxTests {
    private Robot robot;


    Heading head;
    Mode mode; 
    ArraySheet arraysheet;
    // Sample tests
    @Test
    public void sampleTest(){

        assertEquals(true,true);
    }

    @Test 
    public void locationsTest(){
        arraysheet = new ArraySheet(3, 3);

        Location loc = new Location(0, 1, null, null, arraysheet);
        loc.setHeading(Heading.NORTH);
        loc.setMode(Mode.UP);
        assertEquals("NORTH",loc.getHeading().getHeading());
        assertEquals("UP", loc.getMode().getWritingMode());
        assertEquals(0, loc.getX());
        assertEquals(1,loc.getY());
    }
    // Decision coverage tests
    @Test
    public void testMoveRobotNull(){
        robot = new Robot();
        arraysheet = new ArraySheet(0, 0);
        Location loc = new Location(0, 0, null, null, null);
        loc.setHeading(Heading.NORTH);
        loc.setMode(Mode.UP);
        robot.placeRobot(loc, arraysheet);
		robot.move(1);
        assertEquals(Heading.NORTH, robot.getLocation().getHeading());
        assertEquals(0, robot.getLocation().getX());
        assertEquals(0, robot.getLocation().getY());
    } 
    @Test
    public void testMoveRobotNorth(){
        robot = new Robot();
        arraysheet = new ArraySheet(3, 3);
        Location loc = new Location(0, 1, null, null, null);
        loc.setHeading(Heading.NORTH);
        loc.setMode(Mode.UP);
        robot.placeRobot(loc, arraysheet);
		robot.move(1);
        assertEquals(Heading.NORTH, robot.getLocation().getHeading());
        assertEquals(0, robot.getLocation().getX());
        assertEquals(2, robot.getLocation().getY());

    }
    @Test
    public void testMoveRobotSouth(){
        robot = new Robot();
        arraysheet = new ArraySheet(3, 3);
        Location loc = new Location(0, 1, null, null, null);
        loc.setHeading(Heading.SOUTH);
        loc.setMode(Mode.UP);
        robot.placeRobot(loc, arraysheet);
		robot.move(1);
        assertEquals(Heading.SOUTH, robot.getLocation().getHeading());
        assertEquals(0, robot.getLocation().getX());
        assertEquals(0, robot.getLocation().getY());

    }
    @Test
    public void testMoveRobotEast(){
        robot = new Robot();
        arraysheet = new ArraySheet(3, 3);
        Location loc = new Location(0, 1, null, null, null);
        loc.setHeading(Heading.EAST);
        loc.setMode(Mode.UP);
        robot.placeRobot(loc, arraysheet);
		robot.move(1);
        assertEquals(Heading.EAST, robot.getLocation().getHeading());
        assertEquals(1, robot.getLocation().getX());
        assertEquals(1, robot.getLocation().getY());

    }
    @Test
    public void testMoveRobotWest(){
        robot = new Robot();
        arraysheet = new ArraySheet(3, 3);
        Location loc = new Location(2, 1, null, null, null);
        loc.setHeading(Heading.WEST);
        loc.setMode(Mode.UP);
        robot.placeRobot(loc, arraysheet);
		robot.move(1);
        assertEquals(Heading.WEST, robot.getLocation().getHeading());
        assertEquals(1, robot.getLocation().getX());
        assertEquals(1, robot.getLocation().getY());

    }
    @Test
    public void testPrintRobot(){
        robot = new Robot();
        arraysheet = new ArraySheet(3, 3);
        Location loc = new Location(2, 1, null, null, null);
        loc.setHeading(Heading.WEST);
        loc.setMode(Mode.UP);
        robot.placeRobot(loc, arraysheet);
		robot.move(1);
        ArrayList<String> expected = new ArrayList<>();
	    expected.add(" ,  ,  ,  ,  ,  ,  ,  ,  ");
	    assertEquals(expected.toString(), robot.print().toString());
    }
    @Test 
    public void simulatorTest(){
        arraysheet = new ArraySheet(3, 3);
        Robot robber = new Robot();
        Simulator simmy = new Simulator();
        simmy.initSimulator(robber, arraysheet);
        assertEquals(robber, simmy.getRobot());
    }

    // @Test 
    public void validateCommandTestNullInput(){
        assertDoesNotThrow(() -> InputReader.validateCommand(null));
    }

    @Test 
    public void validateCommandTestCommandLength(){
        boolean actual = InputReader.validateCommand("I I I I");
        boolean expected = false;
        assertEquals(expected, actual);

        actual = InputReader.validateCommand("");
        expected = false;
        assertEquals(expected, actual);

        actual = InputReader.validateCommand("Q 1");
        expected = true;
        assertEquals(expected, actual);
    }

    @Test 
    public void validateCommandTest_InvalidCommand(){
        // Used to initialize simulator object
        String input = "I 3";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        InputReader.readInput();
        
        boolean actual = InputReader.validateCommand("G 3");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test 
    public void validateCommandTest_InvalidCommandI(){
        // Used to initialize simulator object
        String input = "I 3";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        InputReader.readInput();

        boolean actual = InputReader.validateCommand("I");
        boolean expected = false;
        assertEquals(expected, actual);

    }

    @Test 
    public void validateCommandTest_ValidM(){
        // Used to initialize simulator object
        String input = "I 3";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        InputReader.readInput();

        boolean actual = InputReader.validateCommand("M");
        boolean expected = false;
        assertEquals(expected, actual);

    }

    @Test 
    public void validateCommandTest_Value100Or1(){
        // Used to initialize simulator object
        String input = "I 3";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        InputReader.readInput();

        boolean actual = InputReader.validateCommand("I 101");
        boolean expected = false;
        assertEquals(expected, actual);

        actual = InputReader.validateCommand("I 1");
        expected = false;
        assertEquals(expected, actual);

        actual = InputReader.validateCommand("I a");
        expected = false;
        assertEquals(expected, actual);


    }
    // @RunWith(MockitoJUnitRunner.class)

    // @RunWith(MockItoJunit)
    
}
