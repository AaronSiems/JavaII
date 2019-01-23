package weektwoassignment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMessage {
	
	int x = 50;
	int y = 0;
	SimpleMath mat = new SimpleMath(x, y);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMessageXY() {
		System.out.println("Testing message");
		String text = ("Your numbers are " + x + " & " + y);
		assertEquals(text, mat.returnValues());
	}
	
	@Test
	public void testMessageNotYX() {
		System.out.println("Testing message is not y + x");
		String text = ("Your numbers are " + y + " & " + x);
		assertNotEquals(text, mat.returnValues());
	}
	


}
