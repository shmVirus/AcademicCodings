import java.util.Scanner;
import java.util.Arrays;

public class SudokuPuzzle extends Exception {
	int board[][];
	int gridSize;
	int sqrt;
	int removeElements;
	int solutionBoard[][];
	int checkWin;

	SudokuPuzzle(String error) {
		super(error);
	}
	SudokuPuzzle(int gridSize, int removeElements) {
		this.gridSize = gridSize;
		this.removeElements = removeElements;
		sqrt = (int) Math.sqrt(gridSize);
		board = new int[gridSize][gridSize];
		solutionBoard = new int[gridSize][gridSize];
	}

	public void fillValues() {
		fillDiagonal();
		fillRemaining(0, sqrt);
		for (int i = 0; i < gridSize; ++i) {
			System.arraycopy(board[i], 0, solutionBoard[i], 0, gridSize);
		}
		removeKDigits();
	}

	void fillDiagonal() {
		for (int i = 0; i < gridSize; i = i + sqrt) {
			fillBox(i, i);
		}
	}

	void fillBox(int row, int col) {
		int num;
		for (int i = 0; i < sqrt; i++) {
			for (int j = 0; j < sqrt; j++) {
				do {
					num = randomGenerator(gridSize);
				} while (!unUsedInBox(row, col, num));
				board[row + i][col + j] = num;
			}
		}
	}

	boolean unUsedInBox(int rowStart, int colStart, int num) {
		for (int i = 0; i < sqrt; i++)
			for (int j = 0; j < sqrt; j++)
				if (board[rowStart + i][colStart + j] == num)
					return false;

		return true;
	}

	int randomGenerator(int num) {
		return (int) Math.floor((Math.random() * num + 1));
	}

	boolean CheckIfSafe(int i, int j, int num) {
		return (unUsedInRow(i, num) && unUsedInCol(j, num) && unUsedInBox(i - i % sqrt, j - j % sqrt, num));
	}

	boolean unUsedInRow(int i, int num) {
		for (int j = 0; j < gridSize; j++)
			if (board[i][j] == num)
				return false;
		return true;
	}

	boolean unUsedInCol(int j, int num) {
		for (int i = 0; i < gridSize; i++)
			if (board[i][j] == num)
				return false;
		return true;
	}

	boolean fillRemaining(int row, int col) {
		if (col >= gridSize && row < gridSize - 1) {
			row = row + 1;
			col = 0;
		}
		if (row >= gridSize && col >= gridSize) {
			return true;
		}
		if (row < sqrt && col < sqrt) {
			col = sqrt;
		} else if (row < gridSize - sqrt) {
			if (col == (int) (row / sqrt) * sqrt)
				col = col + sqrt;
		} else {
			if (col == gridSize - sqrt) {
				row = row + 1;
				col = 0;
				if (row >= gridSize)
					return true;
			}
		}
		for (int num = 1; num <= gridSize; num++) {
			if (CheckIfSafe(row, col, num)) {
				board[row][col] = num;
				if (fillRemaining(row, col + 1)) {
					return true;
				}
				board[row][col] = 0;
			}
		}
		return false;
	}

	public void removeKDigits() {
		int count = removeElements;
		while (count != 0) {
			int cellId = randomGenerator(gridSize * gridSize);
			int i = (cellId / gridSize);
			int j = (cellId % gridSize);
			if (i < gridSize && j < gridSize) {
				if (j != 0)
					j = j - 1;
				if (board[i][j] != 0) {
					count--;
					board[i][j] = 0;
				}
			}
		}
	}

	public void printSudoku() {
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				if (j == 0) System.out.print("\t\t\t");
				else if (j == 3 || j == 6) System.out.print("| ");
				if (board[i][j] != 0)
					System.out.print(board[i][j] + " ");
				else
					System.out.print(". ");
			}
			if (i==2 || i==5) System.out.println("\n\t\t\t---------------------");
			else System.out.println();
		}
		System.out.println();
	}

	boolean isMistake() {
		checkWin = 0;
		boolean doneMistake = false;
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				if (board[i][j] != 0 && board[i][j] != solutionBoard[i][j]) {
					board[i][j] = 0;
					doneMistake = true;
				}
				checkWin += board[i][j];
			}
		}
		return doneMistake;
	}

	void gamePlay() {
		int chances = 3, inRow, inCol, insertData, userChoice;
		System.out.println("Chances will be reducing if you make a Mistake.");
		System.out.println("Chances Remaining: " + chances);
		System.out.println("Your Sudoku Puzzle:");
		printSudoku();
		Scanner input = new Scanner(System.in);
		while (chances != 0) {
			while (true) {
				System.out.print("Enter in Row: ");
				inRow = input.nextInt();
				try {
					if (inRow >= 1 && inRow <= 9) {
						break;
					} else {
						throw new SudokuPuzzle("Row must be in between 1 to 9.");
					}
				} catch (Exception exception) {
					System.out.println("Exception Message: " + exception.getMessage());
					System.out.println("Try again with Valid Row.");
				}
			}
			inRow--;
			while (true) {
				System.out.print("Enter in Coloum: ");
				inCol = input.nextInt();
				try {
					if (inCol >= 1 && inCol <= 9) {
						break;
					} else {
						throw new SudokuPuzzle("Coloum must be in between 1 to 9.");
					}
				} catch (Exception exception) {
					System.out.println("Exception Message: " + exception.getMessage());
					System.out.println("Try again with Valid Coloum.");
				}
			}
			inCol--;
			while (true) {
				System.out.print("Insert Number: ");
				insertData = input.nextInt();
				try {
					if (insertData >= 1 && insertData <= 9) {
						break;
					} else {
						throw new SudokuPuzzle("Number must be in between 1 to 9.");
					}
				} catch (Exception exception) {
					System.out.println("Exception Message: " + exception.getMessage());
					System.out.println("Try again with Valid Number.");
				}
			}
			board[inRow][inCol] = insertData;
			while (true) {
				System.out.print("Pizzle Menu:\n\t1. Continue\n\t2. Check Puzzle\n\t3. Accept Defeat\nSelect: ");
				userChoice = input.nextInt();
				try {
					if (userChoice == 1 || userChoice == 2 || userChoice == 3) {
						break;
					} else {
						throw new SudokuPuzzle("Choice must be in between 1 to 3.");
					}
				} catch (Exception exception) {
					System.out.println("Exception Message: " + exception.getMessage());
					System.out.println("Try again with Valid Chioce.");
				}
			}
			if (userChoice == 1) {
				continue;
			} else if (userChoice == 2) {
				if (isMistake()) {
					chances--;
				}
				if (!(isMistake()) && checkWin == 405) {
					System.out.println("You won the Challenge!");
					System.out.println("Your Sudoku Solution:");
					printSudoku();
					break;
				}
				if (chances == 0) {
					System.out.println("You Loose the Challenge!");
					System.out.println("Your Sudoku Solution:");
					printSudoku();
					break;
				} else {
					System.out.println("Chances Remaining: " + chances);
					System.out.println("Your Sudoku Puzzle:");
					printSudoku();
				}
			} else if (userChoice == 3) {
				board = solutionBoard;
				System.out.println("Your Sudoku Solution:");
				printSudoku();
				break;
			}
		}
		input.close();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("===============================================================");
		System.out.println("꧁         Welcome to Sudoku - Test your Brain Puzzle         ꧂");
		System.out.println("●▬▬▬▬▬▬▬▬▬▬▬▬▬▬๑۩  Code written by @shmVirus  ۩๑▬▬▬▬▬▬▬▬▬▬▬▬▬▬●");
		System.out.println("===============================================================\n");
		while (true) {
			System.out.print("Menu:\n\t1. Start Solving\n\t2. Exit Puzzle\nSelect: ");
			int userChoice = input.nextInt();
			try {
				if (userChoice == 1) {
					while (true) {
						System.out.print("Difficulty:\n\t1. Easy\n\t2. Hard\nSelect: ");
						userChoice = input.nextInt();
						try {
							if (userChoice == 1) {
								int gridSize = 9;
								int removeElements = 15;
								SudokuPuzzle sudoku = new SudokuPuzzle(gridSize, removeElements);
								sudoku.fillValues();
								sudoku.gamePlay();
							} else if (userChoice == 2) {
								int gridSize = 9;
								int removeElements = 45;
								SudokuPuzzle sudoku = new SudokuPuzzle(gridSize, removeElements);
								sudoku.fillValues();
								sudoku.gamePlay();
							} else {
								throw new SudokuPuzzle("Choice is Invalid.");
							}
							break;
						} catch (Exception exception) {
							System.out.println("Exception Message: " + exception.getMessage());
							System.out.println("Try again with Valid Choice.");
						}
					}
				} else if (userChoice == 2) {
					return;
				} else {
					throw new SudokuPuzzle("Choice is Invalid.");
				}
				break;
			} catch (Exception exception) {
				System.out.println("Exception Message: " + exception.getMessage());
				System.out.println("Try again with Valid Choice.");
			}
		}
		input.close();
	}
}
