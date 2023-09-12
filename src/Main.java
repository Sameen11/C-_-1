import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 7;
        int maxRange = 100;
        int totalRounds = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int answer = random.nextInt(maxRange) + 1;
            int attempts = 0;

            System.out.println("Guess a number between 1 and 100: ");

            while (attempts < maxAttempts) {
                int guess = input.nextInt();
                attempts++;

                if (guess > answer) {
                    System.out.println("Too high! Attempts left: " + (maxAttempts - attempts));
                } else if (guess < answer) {
                    System.out.println("Too low! Attempts left: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Congratulations, you guessed the number!");
                    roundsWon++;
                    break;
                }

                if (attempts == maxAttempts) {
                    System.out.println("Out of attempts. The correct answer was " + answer);
                }
            }

            totalRounds++;

            System.out.println("Rounds played: " + totalRounds);
            System.out.println("Rounds won: " + roundsWon);
            System.out.println("Your success rate: " + (roundsWon * 100.0 / totalRounds) + "%");

            System.out.println("Do you want to play again? (yes/no): ");
            String playAgainResponse = input.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
        input.close();
    }
}
