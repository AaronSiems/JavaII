package dmacc.beans;

import java.util.Random;

public class Game {
	
	private String player1;
	private String computerPlayer;
	private String winner;
	
	public Game() {
		super();
	}
	
	public Game(String player1) {
		super();
		this.player1 = player1;
		this.setComputerPlayer();
		this.determineWinner();
	}

	private void determineWinner() {
		if (player1.contentEquals(computerPlayer)) { //tie
			this.winner = "Tie";
		} else if (player1.equals("rock")) { //player picks rock
			if (computerPlayer.equals("paper")) {
				this.winner = "Computer"; // lose
			} else {
				this.winner = "Player"; //win
			}
		} else if (player1.equals("paper")) { //player picks paper
			if (computerPlayer.equals("scissors")) {
				this.winner = "Computer"; //lose
			} else {
				this.winner = "Player"; //win
			}
		} else if (player1.equals("scissors")) { //player picks scissors
			if (computerPlayer.equals("rock")) {
				this.winner = "Computer"; //lose
			} else {
				this.winner = "Player"; //win
			}
		} else { //error
			this.winner = "Error";
		}
		
	}

	private void setComputerPlayer() {
		String choice;
		Random rand = new Random();
		int i = rand.nextInt(3);
		if (i == 0) {
			choice = "rock";
		} else if (i == 1) {
			choice = "scissors";
		} else {
			choice = "paper";
		}
		this.computerPlayer = choice;
		
	}

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getComputerPlayer() {
		return computerPlayer;
	}

	public void setComputerPlayer(String computerPlayer) {
		this.computerPlayer = computerPlayer;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	

}
