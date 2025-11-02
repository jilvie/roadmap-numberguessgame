import java.util.Scanner;

public class Main {
    private static  void welcome()
    {
        System.out.println("Welcome to the Number Guessing Game!\n" +
                "I'm thinking of a number between 1 and 100.\n" +
                "You have 5 chances to guess the correct number.");
    }
    private  static int difficultlevelchoose()
    {
        System.out.println("Please select the difficulty level:\n" +
                "1. Easy (10 chances)\n" +
                "2. Medium (5 chances)\n" +
                "3. Hard (3 chances)\n" +
                "Enter your choice:");
        int choice = new Scanner(System.in).nextInt();
        int chance=0;
        String dl=new String();
        switch (choice)
        {
            case 1:
                dl="Easy";
                chance=10;
                break;
            case 2:
                dl="Medium";
                chance=5;
                break;
            case 3:
                dl="Hard";
                chance=3;
                break;
            default:
                System.out.println("Invalid choice");
                return 0;
        }
        System.out.println("Great! You have selected the "+dl+" difficulty level.\n" +
                "Let's start the game!");
        return chance;
    }
    private static void gamebegin(int chance,int num )
    {
        int attemp=0;
        while(chance > 0)
        {   attemp++;
            System.out.println("Enter your guess:");
            int guess = new Scanner(System.in).nextInt();
            chance--;
            if(guess==num)
            {
                System.out.println("Congratulations! You guessed the correct number in "+attemp+" attempts." );
                break;
            }
            if (guess>num) {
                System.out.println("Incorrect! The number is less than "+guess+".");
            }
            if(guess<num) {
                System.out.println("Incorrect! The number is greater than "+guess+".");
            }
        }
        if( chance == 0) {
            System.out.println("Sorry! No more attempts. You lose the game, try again.");
        }
    }
    public static void main(String[] args) {
        welcome();
        int num=(int)(Math.random()*100)+1;
        gamebegin(difficultlevelchoose(),num);

    }
}
