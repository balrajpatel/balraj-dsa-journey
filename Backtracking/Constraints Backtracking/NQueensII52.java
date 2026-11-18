import java.util.*;
public class NQueensII52 {
    static int count ;
    public static int totalNQueens(int n) {
        count = 0;
        int[][] grid = new int[n][n];
        solve(0, n, grid);
        return count;
        
    }
    static void solve( int rowIdx, int n, int[][] grid){
        if(rowIdx==n){
            count++;
            return;
        }

        for(int colIdx = 0; colIdx <grid.length; colIdx++){

            if(isValidPlacement(rowIdx, colIdx, grid)){

                grid[rowIdx][colIdx] = 1;
                solve(rowIdx+1, n, grid);

                grid[rowIdx][ colIdx] = 0;

            }
        }
    }

    static boolean isValidPlacement(int rowIdx, int colIdx, int[][] grid){
        //check for same col

        for(int i = rowIdx-1; i>=0; i--){
            if(grid[i][colIdx] == 1){
                return false;
            }
        }

        // check for upper - left diagonal

        for(int i = rowIdx-1, j = colIdx-1; i>=0 && j >=0; i--, j--){
            if(grid[i][j] == 1){
                return false;
            }
        }

        for(int i = rowIdx-1, j= colIdx+1; i>=0 && j<grid.length; i--, j++){
            if(grid[i][j] == 1){
                return false;
            }
        }

        return true;
    }
    public static void  main(String[] args){
        System.out.println(totalNQueens(4));
        System.out.println(totalNQueens(1));

    }
}