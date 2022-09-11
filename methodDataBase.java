import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Scanner;

public class methodDataBase{

//This is the method database, which holds nearly every method needed in the game class function. Using these methods the pieces can be created and maipulated.
    
    
    //This method creates the board, by declaring every Piece class object on the board, assigning it's properties, and placing it in the necessary spot on the 2D array.
    public static Piece[][] makeBoard(){
        
        /*Declaration of each object on the white team. The first parameter is the type (P for pawn, Q for queen, etc.) 
        The second is the team that piece is on (W for white, B for black.) */
        Piece PW1 = new Piece("P","W");
        Piece PW2 = new Piece("P","W");
        Piece PW3 = new Piece("P","W");
        Piece PW4 = new Piece("P","W");
        Piece PW5 = new Piece("P","W");
        Piece PW6 = new Piece("P","W");
        Piece PW7 = new Piece("P","W");
        Piece PW8 = new Piece("P","W");
        Piece RW1 = new Piece("R","W");
        Piece RW2 = new Piece("R","W");
        Piece kW1 = new Piece("k","W");
        Piece kW2 = new Piece("k","W");
        Piece BW1 = new Piece("B","W");
        Piece BW2 = new Piece("B","W");
        Piece KW = new Piece("K","W");
        Piece QW = new Piece("Q","W");
        
        
        //Same process, though changing the name, and the team parameter.
        Piece PB1 = new Piece("P","B");
        Piece PB2 = new Piece("P","B");
        Piece PB3 = new Piece("P","B");
        Piece PB4 = new Piece("P","B");
        Piece PB5 = new Piece("P","B");
        Piece PB6 = new Piece("P","B");
        Piece PB7 = new Piece("P","B");
        Piece PB8 = new Piece("P","B");
        Piece RB1 = new Piece("R","B");
        Piece RB2 = new Piece("R","B");
        Piece kB1 = new Piece("k","B");
        Piece kB2 = new Piece("k","B");
        Piece BB1 = new Piece("B","B");
        Piece BB2 = new Piece("B","B");
        Piece QB = new Piece("Q","B");
        Piece KB = new Piece("K","B");

        //Declares the "empt" type, which is used to identify an empty space.
        Piece empt = new Piece("N","N");

        
        /*The board is created as a 2D array, filled solely with the Piece object, which has been created in the Piece class file. Each bracketed section represents a row in the 
        array, and each index of the internal array is a part of that column. */
        Piece[][] board = {
            {RW1,kW1,BW1,QW,KW,BW2,kW2,RW2}, 
            {PW1,PW2,PW3,PW4,PW5,PW6,PW7,PW8},
            {empt,empt,empt,empt,empt,empt,empt,empt},
            {empt,empt,empt,empt,empt,empt,empt,empt},
            {empt,empt,empt,empt,empt,empt,empt,empt},
            {empt,empt,empt,empt,empt,empt,empt,empt},
            {PB1,PB2,PB3,PB4,PB5,PB6,PB7,PB8},
            {RB1,kB1,BB1,QB,KB,BB2,kB2,RB2}
        };
        
        //Once the board is made, it is returned as a Piece[][].
        return board;
    }

    
    //This method prints the board out in a visually pleasing and understanding way.
    public static String printBoard(Piece[][] b)
    {
        String prnt = "      a    b    c    d    e   f    g    h\n\n";
        prnt += "   -----------------------------------------\n";
        
        /* This nested for loop prints out the board as it currently exists. The internal loop runs through each row and column, with the external loop determining the array to
        choose from (1 - 8), and the internal loop prints each element of this array in order. This way each row is printed from top to bottom, running through the array elements.
        Some other symbols are printed before and after, as well as between each loop, to create a spacing out of the pieces, and ensuring the output looks like a chess board.  */
        int x = 1;
        for(int i = 0; i < 8; i++)
        {
            
            prnt += x + "  | ";
            for(int j = 0; j <8;j++)
            {
                //If the space is blank, print a few blank spaces.
                if(b[i][j].getType()=="N")
                {
                    prnt+= "  " + " | ";
                }
                else
                {
                    prnt+= b[i][j].getType() + b[i][j].getTeam() + " | ";
                }
            }
            prnt += " " + x;
            x += 1;

            prnt+="\n   -----------------------------------------\n";
        }
        prnt += "\n      a    b    c    d    e   f    g    h\n\n";
        return prnt;
    }

    
    //This method authorizes that the piece selected by the user is valid. It intakes the board, and the piece taken from the user, and ensures that the piece is valid and exists.
    public static boolean selectionCheck(Piece[][] b, String strt, String end, boolean whitesTurn)
    {
        
        //Converts the 
        String strt1 = String.valueOf(strt.charAt(0));
        int  strt2 = Character.getNumericValue(strt.charAt(1));

        
        if (strt.length() != 2 || (!strt1.equals("a") && !strt1.equals("b") && !strt1.equals("c") && !strt1.equals("d") && !strt1.equals("e") && !strt1.equals("f") && !strt1.equals("g") && !strt1.equals("h"))
        || (strt2 != 1  && strt2 != 2  && strt2 != 3  && strt2 != 4  && strt2 != 5  && strt2 != 6  && strt2 != 7  && strt2 != 8)) 
        {
            System.out.println("Invalid entry of starting piece.");
            return false;
        }

        int columnArray = 0;
        if(strt.charAt(0)=='a')
        {
            columnArray = 0;
        }
        if(strt.charAt(0)=='b')
        {
            columnArray = 1;
        }
        if(strt.charAt(0)=='c')
        {
            columnArray = 2;
        }
        if(strt.charAt(0)=='d')
        {
            columnArray = 3;
        }
        if(strt.charAt(0)=='e')
        {
            columnArray = 4;
        }
        if(strt.charAt(0)=='f')
        {
            columnArray = 5;
        }
        if(strt.charAt(0)=='g')
        {
            columnArray = 6;
        }
        if(strt.charAt(0)=='h')
        {
            columnArray = 7;
        }

        int rowArray = strt2 - 1;

        if(b[rowArray][columnArray].getType().equals("N"))
        {
            System.out.println("Cannot select empty space");
            return false;
        }

        if((whitesTurn == true) && (b[rowArray][columnArray].getTeam().equals("B")))
        {
            System.out.println("This piece is not on your team.");
            return false;
        }

        if((whitesTurn == false) && (b[rowArray][columnArray].getTeam().equals("W")))
        {
            System.out.println("This piece is not on your team.");
            return false;
        }

        String end1 = String.valueOf(end.charAt(0));
        int  end2 = Character.getNumericValue(end.charAt(1));

        
        if (end.length() != 2 || (!end1.equals("a") && !end1.equals("b") && !end1.equals("c") && !end1.equals("d") && !end1.equals("e") && !end1.equals("f") && !end1.equals("g") && !end1.equals("h"))
        || (end2 != 1  && end2 != 2  && end2 != 3  && end2 != 4  && end2 != 5  && end2 != 6  && end2 != 7  && end2 != 8)) 
        {
            System.out.println("Invalid entry of destination piece.");
            return false;
        }
        return true;






    }



    public static int columnStringToInt(String inputBoardLocation)
    {
        if(inputBoardLocation.charAt(0) == 'a')
        {
            return 0;
        }
        if(inputBoardLocation.charAt(0) == 'b')
        {
            return 1;
        }
        if(inputBoardLocation.charAt(0) == 'c')
        {
            return 2;
        }
        if(inputBoardLocation.charAt(0) == 'd')
        {
            return 3;
        }
        if(inputBoardLocation.charAt(0) == 'e')
        {
            return 4;
        }
        if(inputBoardLocation.charAt(0) == 'f')
        {
            return 5;
        }
        if(inputBoardLocation.charAt(0) == 'g')
        {
            return 6;
        }
        if(inputBoardLocation.charAt(0) == 'h')
        {
            return 7;
        }
        else{
            return 0;
        }

        
    }



    public static Piece[][] move(Piece[][] startBoard, String startLocation, String endingLocation)
    {
        System.out.println(endingLocation);
        int endRowArray = (endingLocation.charAt(1)-'0') - 1;
        int endColumnArray = columnStringToInt(endingLocation);
        int startRowArray = (startLocation.charAt(1)-'0') -1;
        int startColumnArray = columnStringToInt(startLocation);

        Piece pieceBeingMoved = startBoard[startRowArray][startColumnArray];
        startBoard[endRowArray][endColumnArray] = pieceBeingMoved;
        startBoard[startRowArray][startColumnArray] = new Piece("N","N");

        return startBoard;

        

    }



    public static Piece[][] turn(Piece[][] board, Scanner scan, boolean whitesTurn)
    {
        
        
        while(true)
        {
            System.out.print("\nEnter Starting Position: ");
            String startCoord = scan.nextLine();
            System.out.print("\nEnter Ending Location: ");           
            String endCoord = scan.nextLine();
            if((selectionCheck(board,startCoord, endCoord, whitesTurn)) && endCheckCentral(startCoord, endCoord, board))
            {
                return move(board, startCoord, endCoord);
            }


        }
        
        
        

        
    }



    public static void tutorial()
    {
        System.out.println("\n\nRules:\nThis version of chess is lacking certain elements. The altered rules are as follows:\n\n1. In this version of chess, there is no checkmate.\nThe game will end once a king has been taken down as any other piece would.\n\n2. Pawns who have crossed to the other side of the board are not able to transform into another piece.\n\n3. Pieces are selected using a binary code. The column is typed first, through letters 'a-h'. The row is typed \nsecond, through numbers 1-8. These values are shown on all four sides of the board to help you find the code for the spot you would like to move to.");
    }



    public static boolean checkForKing(Piece[][] board,String team)
    {
        Piece kingCheck = new Piece("K",team);
        for(int i = 0; i < board.length;i++)
        {
            for(int j = 0; j < 8;j++)
            {
                if(board[i][j].getType().equals("K") && board[i][j].getTeam().equals(team))
                {
                    return true;
                }
            }
        }
        return false;
    }

    
    public static boolean endCheckCentral(String starting, String ending, Piece[][] board)
    {
        int startRowArray = (starting.charAt(1)-'0') -1;
        int startColumnArray = columnStringToInt(starting);
        
        
        if(board[startRowArray][startColumnArray].getType() == "P")
        {
            return pawnMoveCheck(starting, ending, board);
        }

        if(board[startRowArray][startColumnArray].getType() == "R")
        {
            return rookMoveCheck(starting, ending, board);
        }
        if(board[startRowArray][startColumnArray].getType() == "k")
        {
            return knightMoveCheck(starting, ending, board);
        }
        if(board[startRowArray][startColumnArray].getType() == "B")
        {
            return bishopMoveCheck(starting, ending, board);
        }
        if(board[startRowArray][startColumnArray].getType() == "K")
        {
            return kingMoveCheck(starting, ending, board);
        }
        else
        {
            return queenMoveCheck(starting, ending, board);
        }
        
    }


    public static boolean pawnMoveCheck(String starting, String ending, Piece[][] board)
    {
        int endRowIndex = (ending.charAt(1)-'0') - 1;
        int endColumnIndex = columnStringToInt(ending);
        int startRowIndex = (starting.charAt(1)-'0') -1;
        int startColumnIndex = columnStringToInt(starting);

        if(board[endRowIndex][endColumnIndex].getTeam().equals(board[startRowIndex][startColumnIndex].getTeam()))
            {
                System.out.println("You cannot attack your own team.");
                return false;
            }
        if(board[startRowIndex][startColumnIndex].getTeam().equals("W"))
        {
            if(endRowIndex-startRowIndex!=1)
            {
                System.out.println("This move is outside the pawn's moveset.");
                return false;
            }
            if(((endColumnIndex-startColumnIndex == 1) || (endColumnIndex-startColumnIndex == -1)) && !(board[endRowIndex][endColumnIndex].getTeam().equals(board[startRowIndex][startColumnIndex].getTeam())) && !(board[endRowIndex][endColumnIndex].getType().equals("N")))
            {
            return true;
            }
            
            if((endRowIndex-startRowIndex==1) && (board[endRowIndex][endColumnIndex].getType().equals("N")))
            {
                return true;
            }
            
        }
        if(board[startRowIndex][startColumnIndex].getTeam().equals("B"))
        {
            if(endRowIndex-startRowIndex != -1)
            {
                System.out.println("This move is outside the pawn's moveset.");
                return false;
            }
            if(((endColumnIndex-startColumnIndex == 1) || (endColumnIndex-startColumnIndex == -1)) && !(board[endRowIndex][endColumnIndex].getTeam().equals(board[startRowIndex][startColumnIndex].getTeam())) && !(board[endRowIndex][endColumnIndex].getType().equals("N")))
            {
            return true;
            }
            
            if((endRowIndex-startRowIndex== -1) && (board[endRowIndex][endColumnIndex].getType().equals("N")))
            {
                return true;
            }
            System.out.print("Invalid entry.");
            return false;
        }
        return true;
    }
    public static boolean rookMoveCheck(String starting, String ending, Piece[][] board)
    {
        int endRowIndex = (ending.charAt(1)-'0') - 1;
        int endColumnIndex = columnStringToInt(ending);
        int startRowIndex = (starting.charAt(1)-'0') -1;
        int startColumnIndex = columnStringToInt(starting);

        if(board[endRowIndex][endColumnIndex].getTeam().equals(board[startRowIndex][startColumnIndex].getTeam()))
        {
            System.out.println("You cannot attack your own team.");
            return false;
        }
        
        if((endRowIndex != startRowIndex)&&(endColumnIndex != startColumnIndex))
        {
            System.out.println("Invalid move.");
            return false;
        }

        if(endRowIndex > startRowIndex)
        {
            for(int i = startRowIndex+1; i < endRowIndex;i++)
            {
                if(!(board[i][endColumnIndex].getType().equals("N")))
                {
                    System.out.println("There is a piece in the way.");
                    return false;
                }
            }
        }
        if(endRowIndex < startRowIndex)
        {
            for(int i = endRowIndex+1; i < startRowIndex;i++)
            {
                if(!(board[i][endColumnIndex].getType().equals("N")))
                {
                    System.out.println("There is a piece in the way.");
                    return false;
                }
            }
        }
        if(endColumnIndex > startColumnIndex)
        {
            for(int i = startColumnIndex+1; i < endColumnIndex;i++)
            {
                if(!(board[endRowIndex][i].getType().equals("N")))
                {
                    System.out.println("There is a piece in the way");
                    return false;
                }
            }
        }
        if(endColumnIndex < startColumnIndex)
        {
            for(int i = endColumnIndex+1; i < endColumnIndex;i++)
            {
                if(!(board[i][endColumnIndex].getType().equals("N")))
                {
                    System.out.println("There is a piece in the way");
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean knightMoveCheck(String starting, String ending, Piece[][] board)
    {
        int endRowIndex = (ending.charAt(1)-'0') - 1;
        int endColumnIndex = columnStringToInt(ending);
        int startRowIndex = (starting.charAt(1)-'0') -1;
        int startColumnIndex = columnStringToInt(starting);
        int rowChangeInt = endRowIndex-startRowIndex;
        if(rowChangeInt < 0)
        {
            rowChangeInt = (rowChangeInt * -1);
        }
        int columnChangeInt = endColumnIndex-startColumnIndex;
        if(columnChangeInt < 0)
        {
            columnChangeInt = (columnChangeInt * -1);
        }


        if(board[endRowIndex][endColumnIndex].getTeam().equals(board[startRowIndex][startColumnIndex].getTeam()))
        {
            System.out.println("You cannot attack your own team.");
            return false;
        }

        if(((rowChangeInt == 2) && (columnChangeInt == 1)) || ((columnChangeInt == 2) && (rowChangeInt == 1)))
        {
            return true;
        }
        System.out.println("Invalid move for a knight.");
        return false;

    }
    public static boolean bishopMoveCheck(String starting, String ending, Piece[][] board)
    {
        int endRowIndex = (ending.charAt(1)-'0') - 1;
        int endColumnIndex = columnStringToInt(ending);
        int startRowIndex = (starting.charAt(1)-'0') -1;
        int startColumnIndex = columnStringToInt(starting);
        int rowChangeInt = endRowIndex-startRowIndex;

        if(rowChangeInt < 0)
        {
            rowChangeInt = (rowChangeInt * -1);
        }
        int columnChangeInt = endColumnIndex-startColumnIndex;
        if(columnChangeInt < 0)
        {
            columnChangeInt = (columnChangeInt * -1);
        }

        if(board[endRowIndex][endColumnIndex].getTeam().equals(board[startRowIndex][startColumnIndex].getTeam()))
        {
            System.out.println("You cannot attack your own team.");
            return false;
        }

        if(columnChangeInt != rowChangeInt)
        {
            System.out.println("Invalid move.");
            return false;
        }

        //Making sure there are no pieces in the way

        //Bishops moving right/down
        if((endRowIndex > startRowIndex) && (endColumnIndex > startColumnIndex))
        {
            int j = startColumnIndex;
            for(int i = startRowIndex+1; i < endRowIndex;i++)
            {
                j += 1; 
                if(!(board[i][j].getType().equals("N")))
                {
                    System.out.println("There is a piece in the way.");
                    return false;
                }
            }
        }
        
        //Bishops moving left/down
        if((endRowIndex > startRowIndex) && (endColumnIndex < startColumnIndex))
        {
            int j = startColumnIndex;
            for(int i = startRowIndex+1; i < endRowIndex;i++)
            {
                j -= 1;
                if(!(board[i][j].getType().equals("N")))
                {
                    System.out.println("There is a piece in the way.");
                    return false;
                }
            }
        }
        
        //Bishops moving right/up
        if((endRowIndex < startRowIndex) && (endColumnIndex > startColumnIndex))
        {
            int j = startColumnIndex;
            for(int i = startRowIndex-1; i > endRowIndex;i--)
            {
                j += 1;
                if(!(board[i][j].getType().equals("N")))
                {
                    System.out.println("There is a piece in the way");
                    return false;
                }
            }
        }
        
        //Bishop moving left/up
        if((endColumnIndex < startColumnIndex) && (endRowIndex < startRowIndex))
        {
            int j = startColumnIndex;
            for(int i = startRowIndex-1; i > endColumnIndex;i--)
            {
                j -= 1;
                if(!(board[i][j].getType().equals("N")))
                {
                    System.out.println("There is a piece in the way");
                    return false;
                }
            }
        }
        return true;
        
    }
    public static boolean kingMoveCheck(String starting, String ending, Piece[][] board)
    {
        int endRowIndex = (ending.charAt(1)-'0') - 1;
        int endColumnIndex = columnStringToInt(ending);
        int startRowIndex = (starting.charAt(1)-'0') -1;
        int startColumnIndex = columnStringToInt(starting);
        
        int rowChangeInt = endRowIndex-startRowIndex;
        if(rowChangeInt < 0)
        {
            rowChangeInt = (rowChangeInt * -1);
        }
        
        int columnChangeInt = endColumnIndex-startColumnIndex;
        if(columnChangeInt < 0)
        {
            columnChangeInt = (columnChangeInt * -1);
        }

        if(board[endRowIndex][endColumnIndex].getTeam().equals(board[startRowIndex][startColumnIndex].getTeam()))
        {
            System.out.println("You cannot attack your own team.");
            return false;
        }

        if((rowChangeInt > 1) || (columnChangeInt > 1))
        {
            System.out.println("Invalid move.");
            return false;
        }
        return true;



    }
    public static boolean queenMoveCheck(String starting, String ending, Piece[][] board)
    {
        int endRowIndex = (ending.charAt(1)-'0') - 1;
        int endColumnIndex = columnStringToInt(ending);
        int startRowIndex = (starting.charAt(1)-'0') -1;
        int startColumnIndex = columnStringToInt(starting);
        
        
        int rowChangeInt = endRowIndex-startRowIndex;
        if(rowChangeInt < 0)
        {
            rowChangeInt = (rowChangeInt * -1);
        }
        
        
        int columnChangeInt = endColumnIndex-startColumnIndex;
        if(columnChangeInt < 0)
        {
            columnChangeInt = (columnChangeInt * -1);
        }

        if(board[endRowIndex][endColumnIndex].getTeam().equals(board[startRowIndex][startColumnIndex].getTeam()))
        {
            System.out.println("You cannot attack your own team.");
            return false;
        }

        //Diagonal moving
        //Queen moving right/down
        if(rowChangeInt==columnChangeInt)
        {
            if((endRowIndex > startRowIndex) && (endColumnIndex > startColumnIndex))
            {
                int j = startColumnIndex;
                for(int i = startRowIndex+1; i < endRowIndex;i++)
                {
                    j += 1; 
                    if(!(board[i][j].getType().equals("N")))
                    {
                        System.out.println("There is a piece in the way.");
                        return false;
                    }
                }
            }
            
            //Queen moving left/down
            if((endRowIndex > startRowIndex) && (endColumnIndex < startColumnIndex))
            {
                int j = startColumnIndex;
                for(int i = startRowIndex+1; i < endRowIndex;i++)
                {
                    j -= 1;
                    if(!(board[i][j].getType().equals("N")))
                    {
                        System.out.println("There is a piece in the way.");
                        return false;
                    }
                }
            }
            
            //Queen moving right/up
            if((endRowIndex < startRowIndex) && (endColumnIndex > startColumnIndex))
            {
                int j = startColumnIndex;
                for(int i = startRowIndex-1; i > endRowIndex;i--)
                {
                    j += 1;
                    if(!(board[i][j].getType().equals("N")))
                    {
                        System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            }
            
            //Queen moving left/up
            if((endColumnIndex < startColumnIndex) && (endRowIndex < startRowIndex))
            {
                int j = startColumnIndex;
                for(int i = startRowIndex-1; i > endColumnIndex;i--)
                {
                    j -= 1;
                    if(!(board[i][j].getType().equals("N")))
                    {
                        System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            }
            return true;
        }

        //For parallel Movement
        if(columnChangeInt != rowChangeInt)
        {
            if(endRowIndex > startRowIndex)
            {
                for(int i = startRowIndex+1; i < endRowIndex;i++)
                {
                    if(!(board[i][endColumnIndex].getType().equals("N")))
                    {
                        System.out.println("There is a piece in the way.");
                        return false;
                    }
                }
            }
            if(endRowIndex < startRowIndex)
            {
                for(int i = endRowIndex+1; i < startRowIndex;i++)
                {
                    if(!(board[i][endColumnIndex].getType().equals("N")))
                    {
                        System.out.println("There is a piece in the way.");
                        return false;
                    }
                }
            }
            if(endColumnIndex > startColumnIndex)
            {
                for(int i = startColumnIndex+1; i < endColumnIndex;i++)
                {
                    if(!(board[endRowIndex][i].getType().equals("N")))
                    {
                        System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            }
            if(endColumnIndex < startColumnIndex)
            {
                for(int i = endColumnIndex+1; i < endColumnIndex;i++)
                {
                    if(!(board[i][endColumnIndex].getType().equals("N")))
                    {
                        System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            }
            return true;
        }
        return false;


    }





}
    
    


