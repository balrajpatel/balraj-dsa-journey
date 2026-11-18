import java.util.*;
public class SudokuSolver37 {
    public static void solveSudoku(char[][] board) {
        solve(0,0,board);
    }

    // we used boolean so that whenever we found a one solution 
    // we immediately return and don't change the found soln through backtracking

    // also we use boolean to know whether a solution exits, so we used that
    static boolean solve(int row, int col, char[][] board){
       if(row ==9){
        return true; 
       }

       if(col ==9){
        return solve(row+1, 0, board);
       }

        if(board[row][col] == '.'){
            for(int i =1; i<10; i++){
                    if(isValidPlacement(row, col, i,  board)){
                        
                        board[row][col] = (char)('0' + i);

                        if(true == solve(row, col+1, board)){
                            return true;
                        }

                        board[row][col] = '.';
                    }
            }
        }else{
            return solve(row, col+1, board);
        }

        return false;
    }
    static boolean isValidPlacement(int row, int col, int number, char[][] board){
        
        // check in col
        for(int i =0; i<9; i++){
            if(board[row][i] - '0' == number){
                return false;
            }
        }

        // check in row 
        for(int i =0; i<9; i++){
            if(board[i][col] - '0' == number ){
                return false;
            }
        }

        int gridIdx = 0;
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] - '0' == number ){
                    return false;     
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {

        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };


        System.out.println("Initial Sudoku:");
        printBoard(board);

        solveSudoku(board);

        System.out.println("\nSolved Sudoku:");
        printBoard(board);
    }

    static void printBoard(char[][] board) {

        System.out.println("+-------+-------+-------+");

        for (int i = 0; i < 9; i++) {

            System.out.print("| ");

            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");

                if ((j + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }

            System.out.println();

            if ((i + 1) % 3 == 0) {
                System.out.println("+-------+-------+-------+");
            }
        }
    }
}