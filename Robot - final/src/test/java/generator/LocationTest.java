package generator;

import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import util.Heading;
import util.Mode;

public class LocationTest extends TestCase {
	private Location location;

	@BeforeEach
	public void setUp() {
		ArraySheet arraysheet=new ArraySheet(3, 3);
		location = new Location(0, 0, Heading.NORTH, Mode.UP, arraysheet);
	}
	@Test
	public void testDerivedLocation() {
		location.setX(1);
		location.setY(2);
		location.setHeading(Heading.EAST);
		assertEquals(Heading.EAST, location.getHeading());
		assertEquals(1, location.getX());
		assertEquals(2, location.getY());
	}
	
	@Test
	public void testUpdateLocationXOutOfRange() {
		
		location.setMaxX(5);
		location.setMaxY(5);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		
		
		location.setX(5);
		location.setY(5);
		location.updateLocation(1, 0, 1);
		assertEquals(5, location.getX());
		assertEquals(5, location.getY());
		assertEquals("Invalid movement\r\n", outContent.toString());

		ByteArrayOutputStream secondoutContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(secondoutContent));
		location.setMaxX(5);
		location.setMaxY(5);
		location.setX(0);
		location.setY(0);
		location.updateLocation(-1, 0, 1);
		assertEquals(0, location.getX());
		assertEquals(0, location.getY());
		assertEquals("Invalid movement\r\n", secondoutContent.toString());
	}
	
	@Test
	public void testUpdateLocationYOutOfRange() {
		location.setMaxX(5);
		location.setMaxY(5);
		location.setX(5);
		location.setY(5);
		location.updateLocation(0, 1, 1);
		assertEquals(5, location.getX());
		assertEquals(5, location.getY());

		location.setMaxX(5);
		location.setMaxY(5);
		location.setX(0);
		location.setY(0);
		location.updateLocation(0, -1, 1);
		assertEquals(0, location.getX());
		assertEquals(0, location.getY());
	}
	
	@Test
	public void testUpdateLocationXYWithinRange() {
		location.setX(3);
		location.setY(2);
		location.setMaxX(5);
		location.setMaxY(5);
		location.updateLocation(1, 0, 1);
		assertEquals(4, location.getX());
		assertEquals(2, location.getY());
	}
	
	@Test
	public void testPrintToString() {
		String result = location.toString();
		assertEquals("0,0,NORTH,UP", result);
	}
	
	@Test
	public void testGetHeading() {
		assertEquals(Heading.NORTH, location.getHeading());
	
	}
	
	
	 @Test
	   public void testSetHeading() {
	     location.setHeading(Heading.EAST);
	     assertEquals(Heading.EAST, location.getHeading());
	    }
	 
	 @Test
		public void testGetMode() {
			assertEquals(Mode.UP, location.getMode());
		
		}
		
		
		 @Test
		   public void testSetMode() {
		     location.setMode(Mode.DOWN);
		     assertEquals(Mode.DOWN, location.getMode());
		    }
		 
		 @Test
			public void testGetX() {
				assertEquals(0, location.getX());
			
			}
						
			 @Test
			   public void testSetX() {
			     location.setX(5);
			     assertEquals(5, location.getX());
			    }
			 
			 @Test
				public void testGetY() {
					assertEquals(0, location.getY());
				
				}
							
				 @Test
				   public void testSetY() {
				     location.setY(5);
				     assertEquals(5, location.getY());
				    }
				 
				 @Test
					public void testGetMaxX() {
						assertEquals(0, location.getMaxX());
					
					}
				 
				 @Test
					public void testSetMaxX() {
					 ArraySheet mockarraysheet = EasyMock.createNiceMock(ArraySheet.class);
						EasyMock.expect(mockarraysheet.getRows()).andReturn(3);
						EasyMock.expect(mockarraysheet.getColumns()).andReturn(3);
						EasyMock.replay(mockarraysheet);
						location.setMaxX(mockarraysheet.getRows());
						assertEquals(3, location.getMaxX());
					
					}		
				 
				 @Test
					public void testGetMaxY() {
					 
						assertEquals(0, location.getMaxY());
					
					}
				 
				 @Test
					public void testSetMaxY() {
					 ArraySheet mockarraysheet = EasyMock.createNiceMock(ArraySheet.class);
						EasyMock.expect(mockarraysheet.getRows()).andReturn(3);
						EasyMock.expect(mockarraysheet.getColumns()).andReturn(3);
						EasyMock.replay(mockarraysheet);
						location.setMaxY(mockarraysheet.getColumns());
						assertEquals(3, location.getMaxY());
					
					}	
				 
	 
}







