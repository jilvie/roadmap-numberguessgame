import java.util.Random;
import java.util.Scanner;

public class Game {
    private  final Scanner scanner;
    private final Random random ;
    public Game()
    {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }
    public void run()
    {
        welcome();
        int num=random.nextInt(100)+1;
        DifficultyLevel d=chooseDifficulty();
        if(d!=null)
        {
            startgame(d,num);
        }
        else{
            return;
        }
    }
    private   void welcome()
    {
        System.out.println("Welcome to the Number Guessing Game!\n" +
                "I'm thinking of a number between 1 and 100.\n" +
                "You have 5 chances to guess the correct number.");
    }
    private   DifficultyLevel chooseDifficulty()
    {
        System.out.println("Please select the difficulty level:\n" +
                "1. Easy (10 chances)\n" +
                "2. Medium (5 chances)\n" +
                "3. Hard (3 chances)\n" +
                "Enter your choice:");
        int choice =this.scanner.nextInt();
        DifficultyLevel difficultyLevel=DifficultyLevel.choice(choice);
        if(difficultyLevel==null)
        {
            System.out.println("Invalid difficulty level!");
            return null;
        }

        System.out.println("Great! You have selected the "
                +difficultyLevel.getNames()+
                " difficulty level.\n" +
                "Let's start the game!");
        return difficultyLevel;
    }
    private  void startgame(DifficultyLevel difficultyLevel,int num )
    {
        int attempts=0;
        int chance= difficultyLevel.getChances();
        while(chance > 0)
        {   attempts++;
            System.out.println("Enter your guess:");
            int guess =this.scanner.nextInt();
            chance--;
            if(guess==num)
            {
                System.out.println("Congratulations! You guessed the correct number in "+attempts+" attempts." );
                break;
            } else if (guess>num) {
                System.out.println("Incorrect! The number is less than "+guess+".");
            } else if (guess<num) {
                System.out.println("Incorrect! The number is greater than "+guess+".");
            }
        }
        if( chance == 0) {
            System.out.println("Sorry! No more attempts. You lose the game, try again.");
        }
    }

}
