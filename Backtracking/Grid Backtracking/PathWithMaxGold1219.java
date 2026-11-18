import java.util.*;
public class PathWithMaxGold1219 {
    static int MAX ;
    public static int getMaximumGold(int[][] grid) {
        MAX = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++){
            for(int j =0; j<grid[0].length; j++){
                if(grid[i][j]!=0){
                    solve(i,j,grid[i][j],grid, visited);
                }
            }
        }
        return MAX;
    }
    static void solve(int row, int col,int count, int[][] grid, boolean[][] visited){
        if(row == grid.length && col == grid[0].length){
            return;
        }

        visited[row][col] = true;

        int delr[] = {0, -1, 0, +1};
        int delc[] = {-1, 0, +1, 0};
        for(int d = 0; d<4; d++){
            int nrow = row+ delr[d];
            int ncol = col + delc[d];
            if(isValid(nrow, ncol, grid, visited)){
                solve(nrow, ncol, count + grid[nrow][ncol], grid, visited);
            }

        }
        visited[row][col] = false;
        MAX = Math.max(MAX, count);

    }
    static boolean isValid(int nrow, int ncol, int[][] grid, boolean[][] visited){
        return nrow >=0 && ncol >=0
                && nrow <grid.length && ncol<grid[0].length
                && !visited[nrow][ncol]
                && grid[nrow][ncol] !=0
        ;
    }
    public static void main(String[] args){
        int[][] grid = new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        int[][] grid1 = new int[][]{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}};
        System.out.println(getMaximumGold(grid));   // ans = 24
        System.out.println(getMaximumGold(grid1));  // ans = 28

    }

}

/*
In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 

Example 1:

Input:
int[][] grid = new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};

Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.
Example 2:

Input:
int[][] grid = new int[][]{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}};

Output: 28
Explanation:
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 15
0 <= grid[i][j] <= 100
There are at most 25 cells containing gold.
 
Seen this question in a real interview before?
1/6
Yes
No
Accepted
266,788/388.5K
Acceptance Rate
68.7%
*/