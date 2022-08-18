import java.util.Random;
import java.util.Scanner;

class game {
    private int userInput, systemInput, noOfGuess = 0;

    public void takeUserInput() {
        Random random = new Random();
        int systemInput = random.nextInt(101);
        // System.out.println(systemInput);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Any number between 1-100 : ");
        userInput = scanner.nextInt();
        while (userInput != systemInput) {
            if(userInput>100)
            {
                System.out.println("You have choosen more than the range the range is 0 to 100");
                
            }
            else
            {
                if (userInput == systemInput) 
                {
                    System.out.println("Congratulations The number you chose is same as computer's number!");
                    break;
                } 
                else if (userInput > systemInput) 
                {
                    System.out.println("The number you chose is greater than computer's number ");
                    System.out.println("Enter Any number between 1-100 : again !");
                    userInput = scanner.nextInt();
                } 
                else if (systemInput > userInput) 
                {
                    System.out.println("The number you chose is smaller than computer's number ");
                    System.out.println("Enter Any number between 1-100 : again !");
                    userInput = scanner.nextInt();
                }
            }
            noOfGuess++;
        }
        System.out.println("You have guessed the number in " + noOfGuess + " attempts !");
    }
}

public class guess_the_num_ex_3 {
    public static void main(String[] args) {
        System.out.println("Welcome to Guess The Number Game !\n");
        game gautam = new game();
        gautam.takeUserInput();
    }
}
