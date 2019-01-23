package weektwoassignment;

public class SimpleMath {
	
	private int x;
	private int y;
	
	public SimpleMath(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int addBoth() {
		return(x+y);
	}
	
	public int subTwoFromOne() {
		return(x-y);
	}
	
	public String returnValues() {
		System.out.println("Your numbers are " + x + " & " + y);
		return("Your numbers are " + x + " & " + y);
	}
	
}
