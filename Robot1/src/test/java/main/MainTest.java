// package main;

// import static org.junit.jupiter.api.Assertions.*;

// import java.io.ByteArrayInputStream;
// import java.io.InputStream;

// import org.junit.jupiter.api.Test;

// class MainTest {
// 	/**
//      * Testing the main functionality . 
//      * @param args The user command. In this case, it is Q\n.
//      */
// 	@Test
// 	void testMainMethod() {
// 		String inputString = "Q\n";
// 		InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
// 		System.setIn(inputStream);
		
// 		Main.main(new String[]{});
		
// 		// No assertion is necessary because readInput() does not return a value
// 	}
// 	/**
//      * Testing the main functionality . 
//      */
// 	@Test
// 	void testMainClass() {
// 		Main main = new Main();
// 		// No assertion is necessary because the test will fail if an exception is thrown
// 	}

// }
