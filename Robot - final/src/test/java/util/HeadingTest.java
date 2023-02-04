package util;



import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


public class HeadingTest extends TestCase  {

	private Heading heading;
	@BeforeEach
	public void setUp() {
		heading = Heading.NORTH;
	}



	@Test
	public void testHeadingConstant() {
		assertEquals(Heading.EAST, Heading.from("EAST"));
		assertEquals(Heading.WEST, Heading.from("WEST"));
		assertEquals(Heading.NORTH, Heading.from("NORTH"));
		assertEquals(Heading.WEST, Heading.from("WEST"));
	}
	@Test
	public void testInvalidHeadingConstant() {
		assertNull(Heading.from("EASTWEST"));
	}
	@Test
	public void testChangeHeadingFromNorthToWest() {
		Heading newHeading = heading.changeHeading(-1);
		assertEquals(Heading.WEST, newHeading);
		
	}
	@Test
	public void testChangeHeadingFromNorthToEast() {
		Heading newHeading = heading.changeHeading(1);
		assertEquals(Heading.EAST, newHeading);
	}
	@Test
	public void testChangeHeadingFromWestToSouth() {
		Heading newHeading = heading.changeHeading(-1);
		newHeading = newHeading.changeHeading(-1);
		assertEquals(Heading.SOUTH, newHeading);
		
	}
	
	@Test
	public void testChangeHeadingFromEastToSouth() {
		Heading newHeading = heading.changeHeading(1);
		newHeading = newHeading.changeHeading(1);
		assertEquals(Heading.SOUTH, newHeading);
	}
	
	
	@Test
	public void testGetHeading_validHeading_returnsCorrectValue() {
		assertEquals("WEST", Heading.WEST.getHeading());
		assertEquals("EAST", Heading.EAST.getHeading());
		assertEquals("NORTH", Heading.NORTH.getHeading());
		assertEquals("SOUTH", Heading.SOUTH.getHeading());	
	}
	
	
}