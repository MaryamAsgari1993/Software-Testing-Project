package QA;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import generator.ArraySheet;
import generator.Location;
import generator.Robot;
import util.Heading;
import util.Mode;

import static org.junit.Assert.assertEquals;

// mvn test-compile org.pitest:pitest-maven:mutationCoverage
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class MutationRobot {

    ArraySheet arraySheet;

    @InjectMocks
    Robot robot;

    @Test
    public void TestMutantRobotFromFuture(){
        robot = new Robot();

        arraySheet = new ArraySheet(3, 3);

        Location loc = new Location(1, 1, null, null, arraySheet);
        loc.setHeading(Heading.NORTH);
        loc.setMode(Mode.UP);
        assertEquals("NORTH",loc.getHeading().getHeading());
        assertEquals("UP", loc.getMode().getWritingMode());
        assertEquals(1, loc.getX());    //mutation survives because PIT replaces getX return value as 0, but the actually happens to be 0 in the test
        assertEquals(1,loc.getY());
        }

        
    }