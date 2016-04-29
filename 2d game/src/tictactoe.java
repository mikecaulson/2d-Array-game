import java.util.Scanner;

public class tictactoe
	{
		static Scanner userInput = new Scanner(System.in);
		static int piece, opponent;
		static int row;
		static int col, with;
		static int i, j;
		static boolean turns, turns2, playerwin;
		static String response,Letter1,Letter2,Letter3,number1,number2,number3, cpur, cpuc, playerMove;
		static String Board[][]=new String [3][3];
		static String board1[][]=new String [3][3];
		public static void main(String[] args)
			{
				greetPlayer();

				askOpponent();
				fillarray();
				
				turns = true;
				
				while (turns)
					{
						generateBoard();
						choosefirstspot();

				
				checkForWin();
				
				cpuPlay();
				
				checkForWin();
					
					}
				generateBoard();
							

			}
		public static void greetPlayer()
		{
			
			System.out.println("What is your name?");
			String name = userInput.nextLine();
			System.out.println("Hello, "+name + " hope you like the game.");
			
		}
		public static void askPlayerpiece()
		{
			System.out.println("Would you like to be X's or O's?");
			System.out.println("Type the number.");
			System.out.println("(1) X");
			System.out.println("(2) O");
			piece = userInput.nextInt();
			while (!(piece==1 || piece ==2))
				{
					System.out.println("That is not an answer, please try again.");
					piece = userInput.nextInt();
				}
			
			if (piece==1)
				{
					response = "X";
							
				}
			else if (piece==2)
				{
					response = "O";
				}
		
			System.out.println("Ok, you chose, " + response);
		}
		public static void askOpponent()
		{
			System.out.println("Would you like to play against:");
			System.out.println("(1)  Michael");
			System.out.println("(2)  Jack");
			opponent = userInput.nextInt();
			while (opponent>2)
				{
					System.out.println("That is not a number, please type a 1 or a 2.");
					opponent = userInput.nextInt();
				}
			
		}
		public static void fillarray()
		{
			for (int i=0;i<3;i++)
				{
					for (int j=0;j<3;j++)
						{
							Board[i][j] = " ";
						}
				}
		}
		public static void generateBoard()
		{
			System.out.println("    1   2   3  ");
			System.out.println("A   " + Board[0][0] + " | "+Board[0][1]+ " | "+Board[0][2]);
			System.out.println("   ------------");
			System.out.println("B   "+ Board[1][0] + " | " +Board[1][1]+ " | "+Board[1][2]);
			System.out.println("   ------------");
			System.out.println("C   " + Board[2][0]+" | "+Board[2][1]+" | "+Board[2][2]);
			
		}
		public static void choosefirstspot()
		{
			boolean validPlay = true;
			Scanner userInput2 = new Scanner(System.in);
			while (validPlay)
				{
					
				
			System.out.println("Where would you like to go, type the letter. (E.g. A1)");
			
			playerMove = userInput2.nextLine();
				{
					
					playerMove.substring(0,1);
					switch (playerMove.substring(0,1))
					{
						case "a":
						case "A":
								{
									row = 0;
									break;
								}
						case "b":
						case "B":
								{
									row = 1;
									break;
								}
						case "c":
						case"C":
								{
									row = 2;
									break;
								}
					}
					col = Integer.parseInt(playerMove.substring(1))-1;
					
					
						{
							if (Board [row][col].equals(" "))
								{
									Board[row][col] = "X";
									validPlay = false;
								}
							else if (Board [row][col].equals("X"))
								{
									validPlay = true;
								}
							else if (Board [row][col].equals("O"))
								{
									validPlay=true;
								}
						}
					
					
				}	
				}
			
			
		}

		public static void cpuPlay()
		{
			Scanner userInput3 = new Scanner(System.in);
			boolean cpu = true;
			while (cpu)
				{
					int cpur = (int)(Math.random()*3);
					int cpuc = (int)(Math.random()*3);
					if (Board[cpur][cpuc].equals(" "))
						{
							Board[cpur][cpuc]="O";
							cpu = false;
						}
					else if ( Board[cpur][cpuc].equals("X"))
					{
							cpu = true;
					}
					else if ( Board[cpur][cpuc].equals("O"))
						{
							cpu = true;
						}

				}
		
			
		}
                


        public static void checkForWin()
                {
                        if ((Board[0][0].equals(Board[0][1]) && Board [0][1].equals(Board[0][2])) &&  Board[0][0].equals("X") ||
                                        ((Board[1][0].equals(Board[1][1]) && Board [1][1].equals(Board[1][2])) &&  Board[1][0].equals("X") ||
                                        ((Board[2][0].equals(Board[2][1]) && Board [2][1].equals(Board[2][2])) &&  Board[2][0].equals("X") ||

                                        ((Board[0][0].equals(Board[1][0]) && Board [1][0].equals(Board[2][0]))  &&  Board[0][0].equals("X")||
                                        ((Board[0][1].equals(Board[1][1]) && Board [1][1].equals(Board[2][1])) &&  Board[0][1].equals("X") ||
                                        ((Board[0][2].equals(Board[1][2]) && Board [1][2].equals(Board[2][2])) &&  Board[1][2].equals("X") ||

                                        ((Board[0][0].equals(Board[1][1]) && Board [1][1].equals(Board[2][2])) &&  Board[0][0].equals("X")))))||
                                        ((Board[2][0].equals(Board[1][1]) && Board [1][1].equals(Board[0][2])) &&  Board[2][0].equals("X")))))
                                {
                                		
                                		turns = false;
                                		System.out.println("Congrats, you won.");
                                		
                                }
                        else if (((Board[0][0].equals(Board[0][1]) && Board [0][1].equals(Board[0][2])) &&  Board[0][0].equals("O") ||
                                        ((Board[1][0].equals(Board[1][1]) && Board [1][1].equals(Board[1][2])) &&  Board[1][0].equals("O") ||
                                        ((Board[2][0].equals(Board[2][1]) && Board [2][1].equals(Board[2][2])) &&  Board[2][0].equals("O") ||

                                        ((Board[0][0].equals(Board[1][0]) && Board [1][0].equals(Board[2][0]))  &&  Board[0][0].equals("O")||
                                        ((Board[0][1].equals(Board[1][1]) && Board [1][1].equals(Board[2][1])) &&  Board[0][1].equals("O") ||
                                        ((Board[0][2].equals(Board[1][2]) && Board [1][2].equals(Board[2][2])) &&  Board[1][2].equals("O") ||

                                        ((Board[0][0].equals(Board[1][1]) && Board [1][1].equals(Board[2][2])) &&  Board[0][0].equals("O")))))||
                                        ((Board[2][0].equals(Board[1][1]) && Board [1][1].equals(Board[0][2])) &&  Board[2][0].equals("O"))))))
                        	{
                        		System.out.println("You lost, better luck next time.");
                        		turns = false;
                        	}
                }
        
        
		}

	
