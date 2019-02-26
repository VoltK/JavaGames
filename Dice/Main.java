
import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {
		final int DICE_SIDES = 6;
		
		Dice compDice     = new Dice(DICE_SIDES);
		Dice playerDice   = new Dice(DICE_SIDES);
		
		
		String name       = JOptionPane.showInputDialog("What's your name?");
		double playerBank = Double.parseDouble(JOptionPane.showInputDialog("How much money do you have for the game?"));
		
		
		Player player   = new Player(name, playerBank);
		Player computer = new Player();

		
		while(player.getBank() > 0 && computer.getBank() > 0){
			
			compDice.roll();
			playerDice.roll();
			
			double bet = getBet(computer);
			
			calculateDice(player, computer, compDice, playerDice, bet);
			
			showBanks(player, computer);
			
		
		}
		
		whoWon(player, computer);
		
	}
	
	public static void showBanks(Player player, Player computer){
		String msg = String.format("%s has $%.2f in a bank\nComputer has $%.2f", player.getName(), player.getBank(), computer.getBank());
		JOptionPane.showMessageDialog(null, msg);
	}
	
	
	public static void whoWon(Player player, Player computer){
		
		double playerBank = player.getBank();
		String name = player.getName();
		String msg;
		
		if( playerBank == 0){
			JOptionPane.showMessageDialog(null, name + " you lost all your money");
		}
		else if( playerBank < 0){
			
			double debt = Math.abs(playerBank);
			msg = String.format("%s you lost all your money and now you are in debt.\nYou have to pay $%.2f", 
										name, debt);
			JOptionPane.showMessageDialog(null, msg);
		}
		else{
			msg = String.format("Congratulations!!! Now you have $%.2f", playerBank);
			JOptionPane.showMessageDialog(null, msg);
		}
		
		
	}
	
	
	public static double getBet(Player comp){
		
		while(true){
			double amount =0;
			String bet = JOptionPane.showInputDialog("Make a bet: ");
			
			if( bet.matches("[0-9]+")){
				amount = Double.parseDouble(bet);
			}
			else{ 
				JOptionPane.showMessageDialog(null,"Wrong bet. We accept only dollars. Don't offer your wife here!");
				continue;
			}
			
			
			if( amount > comp.getBank()){
				JOptionPane.showMessageDialog(null, "Computer doesn't have enough money to accept your bet." + 
													"Computer has: " + comp.getBank());
				
			}
			else return amount;
		}
		
	}
	
	public static void calculateDice(Player player, Player computer, Dice compDice, Dice playerDice, double bet){
		int computerDiceValue = compDice.getValue();
		int playerDiceValue  = playerDice.getValue();
		
		if(computerDiceValue > playerDiceValue){
			JOptionPane.showMessageDialog(null, "Computer wins this round with score: " + computerDiceValue
								+ "\nPlayer got: " + playerDiceValue);
			String msg = String.format("You lost your bet: $%.2f", bet);
			JOptionPane.showMessageDialog(null, msg);
			
			computer.WinToBank(bet);
			player.LoseToBank(bet);
			
		}
		else if(computerDiceValue < playerDiceValue){
			JOptionPane.showMessageDialog(null, player.getName() + " wins this round with score: "  
						+ playerDiceValue
						+ "\nComputer got: " + computerDiceValue);
			
			player.WinToBank(bet);
			computer.LoseToBank(bet);
			
			
		}else{
			JOptionPane.showMessageDialog(null, "Tie");
		}
	}

}
