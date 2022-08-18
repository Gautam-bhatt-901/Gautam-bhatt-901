import java.util.Random;
import java.util.Scanner;

public class Stone_Paper_Sissors {
    public static void main(String[] args) {
        System.out.println("Welocome To Stone | Paper | Sissors Game !");
        game();
    }
    static void game()
    {
        // making flag = true initially to keep running the game
        boolean flag = true;
        while(flag)
        {
            byte user_input = 0;
            Scanner in = new Scanner(System.in);
            Random rand = new Random();
            System.out.println("Enter A Number In which : \n0 = Stone\n1 = Paper\n2 = Sissor ");
            user_input = in.nextByte();
            System.out.println("You Have Choosen " + user_input);
            int random = rand.nextInt(3);
            // System.out.println("Random num is :"+ random);
            if(user_input>2)  // here we are checking if the user input is greater than 2 
            {
                System.out.println("You have Entered a wrong number , Try again!");
            }
            else if(user_input == 1 && random == 0 || user_input == 2 && random == 1 || user_input == 0 && random == 2)  // all possibilites/conditions to win the game
            {
                System.out.println("You have won the game!");
            }
            else if(user_input == 0 && random == 0 || user_input == 1 && random == 1 || user_input == 2 && random == 2)  // all possibilites/conditions of draw 
            {
                System.out.println("Draw !");
            }
            else
            {
                System.out.println("You have lost the game!");
            }
            System.out.print("Do you want to continue the game? Type `yes` or `no` : ");
            String cont = in.next();
            if(cont.equals("no") || cont.equals("n")) // here we are checking if the user want to continue or not if not then the flag variable will turn false and while loop will exit.
            {
                flag = false;
            }
        }
        
    }
}
