package util;

import junit.framework.TestCase;
import org.junit.Test;


public class CommandTest extends TestCase{
	
	@Test
	public void testIsCommand_validCommand_returnsTrue() {
		assertTrue(Command.isCommand("U"));
		assertTrue(Command.isCommand("D"));
		assertTrue(Command.isCommand("R"));
		assertTrue(Command.isCommand("L"));
		assertTrue(Command.isCommand("M"));
		assertTrue(Command.isCommand("P"));
		assertTrue(Command.isCommand("C"));
		assertTrue(Command.isCommand("Q"));
		assertTrue(Command.isCommand("I"));
		assertTrue(Command.isCommand("i"));
	}
	
	@Test
	public void testIsCommand_invalidCommand_returnsFalse() {
		assertFalse(Command.isCommand("Z"));
		assertFalse(Command.isCommand("Foo"));
		assertFalse(Command.isCommand("Bar"));
	}
	
	@Test
	public void testGetValue_validCommand_returnsCorrectValue() {
		assertEquals("U", Command.U.getValue());
		assertEquals("D", Command.D.getValue());
		assertEquals("M", Command.M.getValue());
		assertEquals("P", Command.P.getValue());
		assertEquals("C", Command.C.getValue());
		assertEquals("Q", Command.Q.getValue());
		assertEquals("I", Command.I.getValue());
		assertEquals("L", Command.L.getValue());
		assertEquals("R", Command.R.getValue());
	}
}