//Partner #1: Mario Luja
//Partner #2: Coen Baker
//This program sets up a TicTacToe board and allows two people
//  to play the game
// https://en.wikipedia.org/wiki/Tic-tac-toe


import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.*;

public class TicTacToe extends Board
{
    public static Scanner in;
    public static String turn = "X";
	
	
    public static void main(String[] args) 
    {
		// instantiate a new TicTacToe object to call the start method
    	TicTacToe tictac = new TicTacToe();
        tictac.start();
    }
    
	// create empty board if there is a rematch
    public static void emptyBoard()
    {
    	board = new String[][]{
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"}};
    }
    
 // Change turn to the other player
    public void checkTurn() 
    {
    	
    	if (turn =="X") 
        {
            turn = "O";
        }
        else
        {
            turn = "X";
        }
         
    }
    
	// need a non-static method to be able to implement the abstract class
    public void start() 
    {
        Scanner in = new Scanner(System.in);
        String playAgain = "n";

        do {
            String winner = null;
            emptyBoard();

            System.out.println("Welcome to Multi-Player Tic-Tac-Toe!!!");
            System.out.println("--------------------------------------");

            super.printBoard();

            System.out.println();
            System.out.println("X plays first. Enter a space number to place X in:");

			// keep looping until a winner is discovered or the game is a draw
            while (winner == null) 
            {
            	int numInput;

                try {
                    numInput = in.nextInt();

                    if (!(numInput > 0 && numInput <= 9)) 
                    {
                        System.out.println("Error: Re-enter slot number:");
                        numInput = in.nextInt();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("InputMismatchException: Re-enter slot number:");
                    in.nextLine();
                    continue;
                }

                System.out.println();
                
                if (board[0][0].equals(String.valueOf(numInput))) 
                {
                	board[0][0] = turn;
                	super.printBoard();
                	checkTurn();
                	winner = checkWinner();
                }
                
                else if (board[0][1].equals(String.valueOf(numInput)))
                {
                	board[0][1]  = turn;      
                    super.printBoard();
                    checkTurn();
                    winner = checkWinner();

                } 
                
                
                else if (board[0][2].equals(String.valueOf(numInput)))
                {	
                	board[0][2] = turn;
                	super.printBoard();
                	checkTurn();
                    winner = checkWinner();
                }
                
                else if (board[1][0].equals(String.valueOf(numInput))) 
                {
                	
                	board[1][0] = turn;
                	super.printBoard();
                	checkTurn();
                	winner = checkWinner();

                } 
                else if (board[1][1].equals(String.valueOf(numInput)))
                {

                	board[1][1] = turn;
                	super.printBoard();
                	checkTurn();
                	winner = checkWinner();

                } 
                else if (board[1][2].equals(String.valueOf(numInput))) 
                {
                	board[1][2] = turn;
                	super.printBoard();
                	checkTurn();
                	winner = checkWinner();
                }
                else if (board[2][0].equals(String.valueOf(numInput)))
                {
                	board[2][0] = turn;
                	super.printBoard();
                	checkTurn();
                	winner = checkWinner();
             
                }
                else if (board[2][1].equals(String.valueOf(numInput))) 
                {
                	board[2][1] = turn;
                	super.printBoard();
                	checkTurn();
                	winner = checkWinner();
                }
                
                else if (board[2][2].equals(String.valueOf(numInput)))
                {
                	board[2][2] = turn;
                	super.printBoard();
                	checkTurn();
                	winner = checkWinner();
                	
                }
                else
                {
                    System.out.println("Slot already taken; re-enter slot number:");
                    continue;
                }
                
            }
            

			System.out.println();
            if (winner.equalsIgnoreCase("draw")) {
                System.out.println("It's a draw! Thanks for playing.");
            } else {
                System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
            }

            System.out.println();
            System.out.println("Would you like to do the greatest rematch of all time?");
            playAgain = in.next();
        } while(playAgain.equalsIgnoreCase("Y"));
    }


	// determines if there is a winner of the current board
    public String checkWinner() 
    {
    	// check each directional line of the board to see who wins - use ifs or switch
    	
    	String line = null;
        for (int i = 0; i < 8; i++)
        {
        	if(board[0][0].contains("X") && board[0][1].contains("X") &&
        	board[0][2].contains("X"))
            {
                line = "XXX";
            }
        	else if(board[1][0].contains("X") && board[1][1].contains("X") &&
            board[1][2].contains("X"))
            {
        		line = "XXX";
            }
        	
        	else if(board[2][0].contains("X") && board[2][1].contains("X") &&
            board[2][2].contains("X"))
            {
                line = "XXX";
            }
        	
        	else if(board[0][0].contains("X") && board[1][0].contains("X") &&
        	board[2][0].contains("X"))
        	{
        		line = "XXX";
        	}
        	
        	else if(board[0][1].contains("X") && board[1][1].contains("X") &&
                	board[2][1].contains("X"))
            {
                line = "XXX";
            }
        	
        	else if(board[0][2].contains("X") && board[1][2].contains("X") &&
                	board[2][2].contains("X"))
            {
                line = "XXX";
            }
        	
        	else if(board[0][2].contains("X") && board[1][2].contains("X") &&
                	board[2][2].contains("X"))
            {
                line = "XXX";
            }
        	
        	else if(board[0][0].contains("X") && board[1][1].contains("X") &&
                	board[2][2].contains("X"))
            {
                line = "XXX";
            }
        	
        	else if(board[0][2].contains("X") && board[1][1].contains("X") &&
                	board[2][0].contains("X"))
            {
                line = "XXX";
            }
        	
        	//O's wins
        	if(board[0][0].contains("O") && board[0][1].contains("O") &&
        	board[0][2].contains("O"))
        	{
        		line = "OOO";
            }
            else if(board[1][0].contains("O") && board[1][1].contains("O") &&
            board[1][2].contains("O"))
            {
            	line = "OOO";
            }
                	
            else if(board[2][0].contains("O") && board[2][1].contains("O") &&
            board[2][2].contains("O"))
            {
            	line = "OOO";
            }
        	
        	else if(board[0][0].contains("O") && board[1][0].contains("O") &&
        	board[2][0].contains("O"))
        	{
        		line = "OOO";
        	}
        	
        	else if(board[0][1].contains("O") && board[1][1].contains("O") &&
                	board[2][1].contains("O"))
            {
                line = "OOO";
            }
        	
        	else if(board[0][2].contains("O") && board[1][2].contains("O") &&
                	board[2][2].contains("O"))
            {
                line = "OOO";
            }
        	
        	else if(board[0][2].contains("O") && board[1][2].contains("O") &&
                	board[2][2].contains("O"))
            {
                line = "OOO";
            }
        	
        	else if(board[0][0].contains("O") && board[1][1].contains("O") &&
                	board[2][2].contains("O"))
            {
                line = "OOO";
            }
        	
        	else if(board[0][2].contains("O") && board[1][1].contains("O") &&
                	board[2][0].contains("O"))
            {
                line = "OOO";
            }
        	
        }
			// builds a String line representation to see if there is a winner
            if (line =="XXX")
            {
                return "X";
            }
            else if (line == "OOO") 
            {
                return "O";
            }

		//double check that the board is full and leads to a draw
        for (int i = 0;i < 9; i++) 
        {
            if (Arrays.asList(board[0]).contains(String.valueOf(i+1)))
            {
                break;
            }
            else if (Arrays.asList(board[1]).contains(String.valueOf(i+1)))
            {
                break;
            }
            else if (Arrays.asList(board[2]).contains(String.valueOf(i+1))) {
                break;
            }
            else if (i == 8)
            {
                return ("draw");
            }
        }

		System.out.println();
        System.out.println(turn + "'s turn; Enter a space number to place " + turn + " in:");
        return null;
    }
}
  
//Different code

// Disclaimer:
// The given assignment description, project files, code files and/or solution files
// should not be made available in a public form via methods such as online hosting
// in code repositories, educational resource hosting websites, etc. such as Course
// Hero and/or Chegg. Tracking information is embedded into the assignment files and
// any person found to be distributing files may be prosecuted. This includes
// notification to the college, any discipline it warrants and legal action if
// it is warranted.