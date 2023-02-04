package util;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


public class ModeTest extends TestCase{
	
	private Mode mode;
	@BeforeEach
	public void setUp() {
		mode = Mode.UP;
	}
	
	@Test
	public void testModeConstant() {
		assertEquals(Mode.UP, Mode.from("UP"));
		assertEquals(Mode.DOWN, Mode.from("DOWN"));

	}
	@Test
	public void testInvalidModeConstant() {
		assertNull(Mode.from("UPPP"));
	}
	@Test
	public void testChangeModeFromUpToDown() {
		Mode newMode = mode.changeMode(0);
		assertEquals(Mode.UP, newMode);
		
	}
	@Test
	public void testChangeModeFromDownToUp() {
		Mode newMode = mode.changeMode(1);
		assertEquals(Mode.DOWN, newMode);

	}
	@Test
	public void testGetWritingMode_validMode_returnsCorrectValue() {
		assertEquals("UP", Mode.UP.getWritingMode());
		assertEquals("UP", Mode.UP.getWritingMode());	
	}
	
	
	
	

}
