package guessthenumbergame;

import javax.swing.*;
import java.util.Random;

public class GuessTheNumberGame {

    private static int maxAttempts = 5;
    private static int rounds = 3;      
    private static int score = 0;       

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to the Guess the Number Game!");

        for (int round = 1; round <= rounds; round++) {
            playRound(round);
        }

       
        JOptionPane.showMessageDialog(null, "Game Over!\nYour total scoreJ is: " + score);
    }

   
    private static void playRound(int roundNumber) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; 
        int attempts = 0;
        boolean guessedCorrectly = false;

        JOptionPane.showMessageDialog(null, "Round " + roundNumber + ": Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

       
        while (attempts < maxAttempts && !guessedCorrectly) {
            String guessString = JOptionPane.showInputDialog(null, "Enter your guess:");

            if (guessString == null) {
                JOptionPane.showMessageDialog(null, "Game canceled.");
                System.exit(0);
            }

            int guess;
            try {
                guess = Integer.parseInt(guessString);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                continue; 
            }

            attempts++;

            if (guess == numberToGuess) {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number.");
                guessedCorrectly = true;
                score += calculatePoints(attempts);
            } else if (guess < numberToGuess) {
                JOptionPane.showMessageDialog(null, "Too low! Try again.");
            } else {
                JOptionPane.showMessageDialog(null, "Too high! Try again.");
            }
        }

        if (!guessedCorrectly) {
            JOptionPane.showMessageDialog(null, "Sorry, you're out of attempts! The correct number was " + numberToGuess);
        }

        JOptionPane.showMessageDialog(null, "Round " + roundNumber + " over! Your score: " + score);
    }

    
    private static int calculatePoints(int attempts) {
        return (maxAttempts - attempts + 1) * 10; 
    }
}
