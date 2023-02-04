package generator;
import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;



public class ArraySheetTest extends TestCase{
	
	private ArraySheet arraysheet;
	
	@BeforeEach
	public void setUp() {
		arraysheet = new ArraySheet(5, 5);
	}
	
	@Test
	public void testValidateLocationWithinRange() {
		Location mockLocation = EasyMock.createNiceMock(Location.class);
		EasyMock.expect(mockLocation.getX()).andReturn(3);
		EasyMock.expect(mockLocation.getY()).andReturn(4);
		EasyMock.replay(mockLocation);

		assertTrue(arraysheet.validateLocation(mockLocation));
	}
	
	@Test
	public void testValidateLocationOutOfRange() {
		Location mockLocation = EasyMock.createNiceMock(Location.class);
		EasyMock.expect(mockLocation.getX()).andReturn(3);
		EasyMock.expect(mockLocation.getY()).andReturn(6);
		EasyMock.replay(mockLocation);

		assertFalse(arraysheet.validateLocation(mockLocation));
	}
	
	 @Test
	    public void testInitializeLocation() {
	       
	        int[][] result = arraysheet.initializeLocation();
	        assertArrayEquals(new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}}, result);
	    }
	 
		@Test
		public void testGetRows() {
			assertEquals(5, arraysheet.getRows());
		
		}
		@Test
		public void testGetColumns() {
			assertEquals(5, arraysheet.getColumns());
		
		}

}
