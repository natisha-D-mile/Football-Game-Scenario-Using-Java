import java.util.Random;
import java.util.Scanner;

public class FootballCompetition {
    public static void main(String[] args) {
        int[] team1 = new int[11];
        for (int i = 1; i <= 11; i++) {
            team1[i-1] = i;
        }
        
        // Shuffle the player numbers to randomize the selection
        Random rand = new Random();
        for (int i = 0; i < team1.length; i++) {
            int swapIndex = rand.nextInt(team1.length);
            int temp = team1[i];
            team1[i] = team1[swapIndex];
            team1[swapIndex] = temp;
        }
        
        // Select the first three players to get out
        int[] playersOut = new int[3];
        for (int i = 0; i < 3; i++) {
            playersOut[i] = team1[i];
        }
        
        // Get the coach's guess numbers
        Scanner sc = new Scanner(System.in);
        int[] coachGuesses = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter guess number " + (i+1) + " (between 1-11): ");
            coachGuesses[i] = sc.nextInt();
        }
        // Display the players to get out and how many guesses were correct
        System.out.println("------------------------------------");
        System.out.println("Randomly Selected Player Number from Team1:");
        System.out.println("------------------------------------");
        for (int playerNum : playersOut) {
            System.out.print(playerNum+"  ");
            
        }
        System.out.println();
        System.out.println("------------------------------------");
        // Check if any of the guesses match any of the selected players
        int numMatches = 0;
        for (int playerNum : playersOut) {
            for (int guess : coachGuesses) {
                if (playerNum == guess) {
                    numMatches++;      
                    System.out.println("Number Player to get out from Playing");
                    System.out.println("Random No : "+ playerNum + "    Coach Guess : "+guess);
                    break;
                }
            }
        }
        
        System.out.println("Number of correct guesses: " + numMatches);
    }
}
