import java.util.Random;
import javax.swing.JOptionPane;

public class Intuition {

    private String [] colors= {"Red", "Green", "Blue", "Orange", "Yellow"};
    private Random random = new Random();
    private byte guessed = 0;

    public static void main(String[] args) {
        Intuition driver = new Intuition();

        JOptionPane.showMessageDialog(null, "This game will check your intuition\n"+
                                                "You will guess colors which computer picks randomly\n" +
                                                "Press OK to start");
        int x = 0;
        while(x < 10){

            String computerColor = driver.computerPick();
            String playerColor   = driver.playerPick();

            driver.checkGuess(computerColor, playerColor);

            String msg = "You score is " + driver.guessed + " after " + (x+1) + " tries";
            JOptionPane.showMessageDialog(null, msg);

            x++;
        }

        driver.result();

    }

    private String computerPick(){
        int index = random.nextInt(colors.length-1);
        return colors[index];
    }

    private String playerPick(){
        String msg = "Every number represents color, enter number to choose your color\n" +
                     "0 - Red; 1 - Green; 2 - Blue; 3 - Orange; 4 - Yellow";

        String choice = JOptionPane.showInputDialog(null, msg,
                "Your Guess", JOptionPane.INFORMATION_MESSAGE);

        int index = 0;
        if (choice.matches("[0-4]+")) {
            index = Integer.parseInt(choice);
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid input. We will guess for you randomly!");
            computerPick();
        }

        return colors[index];

    }

    private void checkGuess(String computer, String playerGuess){
        JOptionPane.showMessageDialog(null, "Computer picked: " + computer);

        if (computer.equals(playerGuess)){
            JOptionPane.showMessageDialog(null, "You guessed computer's choice: " + playerGuess,
                    "Guessed", JOptionPane.INFORMATION_MESSAGE);
            guessed++;
        }
        else{
            JOptionPane.showMessageDialog(null, "Wrong guess. You picked: " + playerGuess,
                    "Wrong", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void result(){
        switch(guessed){
            case 1:

            case 2:

            case 3:
                JOptionPane.showMessageDialog(null, "You have bad developed intuition\n"+
                                                                            guessed + " out of 10");
                break;

            case 4:

            case 5:

            case 6:
                JOptionPane.showMessageDialog(null, "You have medium intuition\n"+
                        guessed + " out of 10");
                break;
            case 7:
            case 8:
            case 9:
                JOptionPane.showMessageDialog(null, "You have great intuition\n"+
                        guessed + " out of 10");
                break;
            case 10:
                JOptionPane.showMessageDialog(null, "Are you a robot?\n"+
                        guessed + " out of 10");
                break;
        }


    }

}
