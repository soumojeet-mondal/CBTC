import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in); // Creating a Scanner object for user input

        int randomNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int score = 100;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("Guess the number between 1 and 100.");

        while (true) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt(); // Getting user's guess from console

            attempts++;

            if (guess == randomNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts. Your score is " + score + ".");
                break;
            } else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            score -= 10;

            if (attempts == 10) {
                System.out.println("Sorry, you've run out of attempts. The number was " + randomNumber + ". Better luck next time!");
                break;
            }
        }

        scanner.close(); // Closing the Scanner object
    }
}
