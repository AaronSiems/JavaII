package weektwoassignment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMath {
	
	int x = 6;
	int y = 12;
	
	SimpleMath mat = new SimpleMath(x, y);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLength() {
		System.out.println("Testing addition");
		assertTrue(x+y == mat.addBoth());
	}
	
	@Test
	public void testNotNull() {
		System.out.println("Testing subtraction");
		assertTrue(x-y == mat.subTwoFromOne());
		
	}

}
