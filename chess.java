import java.util.Scanner;


/**  This is the main game method, inside of the chess class. 
This method utilizes all of the methods inside of the method database, as well as the Piece class which represents each piece on the board. 
*/

public class chess {
    public static void game()
    {
        
        //This is the introduction, which prints the title, and uses a basic while loop to ask the user if they want the tutorial, which is a void method stored in the method database.
        
        //Creates the board
        Piece[][] board = methodDataBase.makeBoard();
        System.out.print("\n\n\n\n\n\n\n\n\n\n\nChess Master\nDesigned and Written by Saul Wolkove\n\n");
        Scanner scan = new Scanner(System.in); 
        System.out.print("Welcome to Chess Master. It is highly recommended that this game is played in full-screen mode and not closed for the duration of the game. Chess master has rules slightly different than real chess. \nIf you would like a brief tutorial on these rules, please press 1. If not, please press 0: ");
        
        //Keeps user in loop until they input a 0 to skip tutorial, or 1 which prints the tutorial.
        while(true){
            int oneOrZero = scan.nextInt();
            if(oneOrZero==0)
            {
                break;
            }
            else if(oneOrZero == 1)
            {
                methodDataBase.tutorial();
                break;
            }
            else
            {
                System.out.println("Please input either the number 1 or 0.");
            }

        }
        
        
        //This initiates the scanner, which is used to get input throughout the game.
        scan.nextLine();
        /**this block intakes player names using the Scanner object. It will record whatever the user inputs, 
        and if nothing is input, the name will default to set team names, done using an if statement. */
        System.out.print("\n\n\n\n\n\n\nBefore the game begins, please enter each user's name. If you would like leave this input blank, the name will automatically be 'White' or 'Black'.");
        System.out.print("\nEnter team white's name: ");
        String teamWhite = scan.nextLine();
        if(teamWhite.equals(""))
        {
            teamWhite = "White";
        }
        System.out.print("\nEnter team black's name: ");           
        String teamBlack = scan.nextLine();
        if(teamBlack.equals(""))
        {
            teamBlack = "Black";
        }

        System.out.print("\n\n\n");
        
        /* The object whitesTurn allows for white to begin, and will then alternate between turns to allow the program to know which pieces are allowed to be moved.
        forTeamCheck is ued for the method kingCheck in the method database to check if the game has ended because the king has been removed.
        winner is used once the winner is determined, in order to know which player has won, and subsequently print their name once the while loop has ended. */
        boolean whitesTurn = true;
        String forTeamCheck = "";
        String winner = "x";

        
        //This while loop will determine if it is white or black's turn, and will input this into the 
        while(true)
        {
            System.out.print(methodDataBase.printBoard(board));
            if(whitesTurn==true)
            {
                System.out.print("It is now "+teamWhite+"'s turn.");
                forTeamCheck = "B";
                board = methodDataBase.turn(board,scan, whitesTurn);
            }
            else
            {
                System.out.print("It is now "+teamBlack+"'s turn.");
                forTeamCheck = "W";
                board = methodDataBase.turn(board,scan, whitesTurn);
            }
            System.out.print("\033[H\033[2J");
            boolean turnResult = methodDataBase.checkForKing(board,forTeamCheck);
            if(turnResult==false)
            {
                if(whitesTurn==true)
                {
                    winner = teamWhite;
                    break;
                }
                else{
                    winner = teamBlack;
                    break;
                }
            }

            if(whitesTurn == true)
            {
                whitesTurn = false;
            }
            else
            {
                whitesTurn = true;
            }
        }
        System.out.println("\n\n\n\n\n\n\n\n\n"+ winner + " Has won the game! Thanks for playing!");
        scan.close();


        
    }




}
    

