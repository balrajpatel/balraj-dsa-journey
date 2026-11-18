import java.util.*;
public class RatInAMaze {
    public static ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> result = new ArrayList<>();
        if(maze[0][0]==0)return result;
        
        boolean[][] visited = new boolean[maze.length][ maze[0].length];
        solve(0,0, maze,"", result, visited);
        
        Collections.sort(result);
        return result;
    }
    
    static void solve(int row, int col, int[][] maze, String ans, ArrayList<String> result , boolean[][] visited){
        if(row == maze.length-1 && col ==maze[0].length-1){
            result.add(ans);
            return ;
        }
        // here we consider the row and col are to be visited  // since inside the neighbour
        // its validitiy.
        // so starting cell we have to check whether it is blocked or not;
        
        
        visited[row][col] = true;
        
        int[] delr = {0, -1, 0, +1};
        int[] delc = {-1, 0, +1, 0};
        char[] dir = {'L', 'U', 'R', 'D'};
        for(int d = 0; d<4; d++){
            int nrow = delr[d] + row;
            int ncol = delc[d] + col;
            char nD = dir[d];
            
            if(isValid(nrow, ncol, maze, visited)){
                
                //here adding the directions
                solve(nrow, ncol, maze, ans + nD, result, visited);
            }
        }
        
        visited[row][col] = false;
    }
    
    static boolean isValid(int nrow, int ncol, int[][] maze, boolean[][] visited){
        return nrow >=0 && ncol >=0 
                && nrow <maze.length && ncol <maze[0].length
                && maze[nrow][ncol] == 1
                && !visited[nrow][ncol];
    }


    public static void main(String[] args) {

        // Test Case 1
        int[][] maze1 = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        ArrayList<String> result1 = ratInMaze(maze1);

        System.out.println("Test Case 1:");
        System.out.println("Input Maze:");
        for (int[] row : maze1) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Output: " + result1);
        System.out.println();


        // Test Case 2
        int[][] maze2 = {
            {1, 0},
            {1, 0}
        };

        ArrayList<String> result2 = ratInMaze(maze2);

        System.out.println("Test Case 2:");
        System.out.println("Input Maze:");
        for (int[] row : maze2) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Output: " + result2);
    }
}


/*
Rat in Maze
Solved
Difficulty: MediumAccuracy: 35.75%Submissions: 455K+Points: 4Average Time: 25m
Given a square binary matrix maze[][] containing values 0 and 1, find all possible paths for a rat to travel from the top-left cell to the bottom-right cell. The rat can move in four directions: up(U), down(D), left(L), and right(R).

1 represents an open cell through which the rat can move.
0 represents a blocked cell that cannot be traversed.
The rat can move only through open cells and cannot visit the same cell more than once in a path. Return all valid paths as strings consisting of 'U', 'D', 'L', and 'R', representing the sequence of moves taken by the rat.

Note: Return the paths in lexicographically increasing order. If no valid path exists, return an empty list.

Examples:

Input: maze[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
Explanation: There are two valid paths from the source cell (0, 0) to the destination cell (3, 3).

Input: maze[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists as the destination cell (1, 1) is blocked.
Constraints:

2 ≤ mat.size() ≤ 5
0 ≤ mat[i][j] ≤ 1
mat[i].size() = mat.size()
*/