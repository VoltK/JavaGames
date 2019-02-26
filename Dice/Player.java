
public class Player {
	private final double COMPUTER_BANK = 10000;
	private String name;
	private double bank;

	Player(){
		name = "Computer";
		bank = COMPUTER_BANK;
	}
	
	Player(String name, double bank){
		this.name = name;
		this.bank = bank;
	}
	
	
	public void WinToBank(double win){
		bank += win;
	}
	
	public void LoseToBank(double lose){
		bank -= lose;
	}
	
	public double getBank(){
		return bank;
	}
	
	public String getName(){
		return name;
	}
	
	
}
