import java.util.*;
public class NQueens71 {
     public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        int[][] grid = new int[n][n];

        // here we only pass 0th row, because 
        // for 0th it try every cell, and then next ==> this covers efvery possibility itself;
        //==> don't need to pass every row 
        //==> if lets say we pass ( row = 3) ==> how row 0 to 2 will be filled

        solve(0, n, grid, result);

        return result;
        
    }
                    // rowIdx== tells the row in which queen to be places
                    // == rowIdx-1 queen have been placed
    static void solve(int rowIdx, int n, int[][] grid, List<List<String>> result){
        if(rowIdx==n){
            // this avoids to adding ans in same list;
            List<String> ans = new ArrayList<>();

            for(int i =0; i< grid.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j< grid.length; j++){
                    if(grid[i][j] == 0){
                        sb.append('.');
                    }
                    else if(grid[i][j]==1){
                    sb.append('Q');
                    }
                }
                ans.add(sb.toString());
            }
            result.add(ans);
            return ;

        }


        for(int colIdx =0; colIdx < grid.length ; colIdx++){
            if(isValidPlacement(rowIdx, colIdx, grid)){


                grid[rowIdx][colIdx] = 1;
  

                solve(rowIdx +1, n, grid, result);

                grid[rowIdx][colIdx] = 0;

            }
        }

    }
    static boolean isValidPlacement(int rowIdx, int colIdx, int[][] grid){

        //check for same column;
        for(int i = rowIdx-1 ; i>=0; i--){
            if(grid[i][colIdx] == 1) return false;
        }

        //check for upper - left diagonal

        for(int i = rowIdx -1, j = colIdx-1; i>=0 && j >=0; i--,j--){
            if(grid[i][j] == 1) return false;
        }

        // check for upper - right diagonal
        for(int i = rowIdx-1 , j = colIdx+1; i>=0 && j <grid.length ; i--, j++){
            if(grid[i][j] == 1)return false;
        }

        return true;
    }

    static void printBoards(List<List<String>> result) {
        int solutionNo = 1;

        for (List<String> board : result) {
            System.out.println("Solution " + solutionNo++ + ":");

            for (String row : board) {
                for (char cell : row.toCharArray()) {
                    if (cell == 'Q') {
                        System.out.print(" ♛ ");
                    } else {
                        System.out.print(" . ");
                    }
                }
                System.out.println();
            }

            System.out.println();
        }
    }

     public static void main(String[] args) {

        // Example 1: n = 4
        int n1 = 4;
        List<List<String>> result1 = solveNQueens(n1);

        System.out.println("===== N = " + n1 + " =====");
        printBoards(result1);

        // Example 2: n = 1
        int n2 = 1;
        List<List<String>> result2 = solveNQueens(n2);

        System.out.println("===== N = " + n2 + " =====");
        printBoards(result2);
    }
}