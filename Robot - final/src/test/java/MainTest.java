import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.Test;

import input.InputReader;
public class MainTest extends TestCase {
	
	@Test
    public void testMain() {
		InputReader input = EasyMock.createNiceMock(InputReader.class);
        input.readInput();
        EasyMock.expectLastCall().once();
        EasyMock.replay(input);
        Main.main(new String[] {});
        EasyMock.verify(input);
    }

}
