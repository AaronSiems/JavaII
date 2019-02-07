package model;

public class GuessingGame {
	
	private int guess;
	private final int ANSWER = 77;
	
	
	
	public GuessingGame(int guess) {
		super();
		this.guess = guess;
	}
	
	public String getResult() {
		if(guess == ANSWER) {
			return "Your guess of " + guess + " was correct! If we had a cookie we would give you one.";
		} else if (guess > ANSWER) {
			return "Your guess of " + guess + " was too high!";
		} else {
			return "Your guess of " + guess + " was too low!";
		}
	}
	
	
	public GuessingGame() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getGuess() {
		return guess;
	}
	public void setGuess(int guess) {
		this.guess = guess;
	}
	
	

}
