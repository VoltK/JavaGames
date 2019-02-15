import java.util.Random;
import javax.swing.JOptionPane;

public class Main {
    private byte computerScore = 0;
    private byte playerScore = 0;

    public static void main(String[] args) {

        Main driver = new Main();
        Random random = new Random();

        JOptionPane.showMessageDialog(null, "Starting Game Rock-Paper-Scissors",
                "Game", JOptionPane.INFORMATION_MESSAGE);

        while (driver.getComputerScore() < 3 && driver.getPlayerScore() < 3) {
            int computerChoice = askComputer(random);
            int playerChoice = askPlayer();

            if (playerChoice <= 0 || playerChoice > 3) {
                JOptionPane.showMessageDialog(null, "Invalid input!\n" +
                                "To pick rock - 1; paper - 2; scissors - 3",
                            "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            String computerChoiceReadable = convert(computerChoice);

            JOptionPane.showMessageDialog(null, "Computer picked: " + computerChoiceReadable);

            driver.checkPlayersChoices(computerChoice, playerChoice);

            driver.tellScores();

        }

        driver.getWinner();

    }

    public void getWinner() {
        if (playerScore == 3) {
            JOptionPane.showMessageDialog(null, "You won!!!",
                    "Congratulations", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Computer won =(", "You Lost", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void tellScores() {
        String msg = "Computer: " + computerScore + "\nPlayer: " + playerScore;
        JOptionPane.showMessageDialog(null, msg, "Score", JOptionPane.INFORMATION_MESSAGE);
    }

    public void checkPlayersChoices(int computerChoice, int playerChoice) {

        if (computerChoice == 1 && playerChoice == 3) {
            JOptionPane.showMessageDialog(null, "Computer get a point");
            computerScore++;
        } else if (computerChoice == 3 && playerChoice == 1) {
            JOptionPane.showMessageDialog(null, "Player get a point");
            playerScore++;
        } else if (computerChoice == 2 && playerChoice == 3) {
            JOptionPane.showMessageDialog(null, "Player get a point");
            playerScore++;
        } else if (computerChoice == 3 && playerChoice == 2) {
            JOptionPane.showMessageDialog(null, "Computer get a point");
            computerScore++;
        } else if (computerChoice == 1 && playerChoice == 2) {
            JOptionPane.showMessageDialog(null, "Player get a point");
            playerScore++;
        } else if (computerChoice == 2 && playerChoice == 1) {
            JOptionPane.showMessageDialog(null, "Computer get a point");
            computerScore++;
        } else if (computerChoice == playerChoice) {
            JOptionPane.showMessageDialog(null, "Nobody get a point");
        }

    }

    public static int askPlayer() {

        try {
            return Integer.parseInt(JOptionPane.showInputDialog(null, "What's your choice?\n" +
                                                                        "1 - rock; 2 - paper; 3 - scissors",
                                                                    "Your Choice", JOptionPane.QUESTION_MESSAGE));
        } catch (NumberFormatException e) {
            return 0;
        }

    }

    public static int askComputer(Random random) {
        JOptionPane.showMessageDialog(null, "Computer made its choice",
                                                             "Computer", JOptionPane.INFORMATION_MESSAGE);
        return random.nextInt(3) + 1;
    }

    // convert number to human readable string
    public static String convert(int num) {
        switch (num) {
            case 1:
                return "rock";
            case 2:
                return "paper";
            case 3:
                return "scissors";
            default:
                return " ";
        }

    }

}