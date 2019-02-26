import java.util.Random;

public class Dice {
	private int sides;
	private int value;
	
	Dice(int sides){
		this.sides = sides;
	}
	
	
	public void roll(){
		value = new Random().nextInt(sides) + 1;
	}
	
	
	public int getValue(){
		return value;
	}
	

}
