import java.util.*;
public class WordSearch79 {
    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean ans =false;

        //*****since the word can start from any cell*******
        for(int i =0; i< board.length; i++){
            for(int j =0; j<board[0].length; j++){
                if(solve(i,j,"", board, word, visited)){
                    return true;
                }
            }
        }
        return false;
        
    }

    // it returns whether a valid path exists from the current state that completes the target word.
    static boolean solve(int row, int col, String cWord, char[][] board, String word,boolean[][] visited){
        cWord = cWord + board[row][col];  
        // this created new subString everytime=== no backtrack needed


        visited[row][col] = true;

        if(word.equals(cWord)){            
            return true;
        }
        if(!word.startsWith(cWord)){
            // since going to the parent(backtrack) == undo the change
            visited[row][col] = false;
            return false;
            // so that we can't recurse
            // move to the parent(calling fun)
            // so that parent function can call other neightbour
        }

        int[] delr = {0, -1, 0, +1};
        int[] delc = {-1, 0, +1, 0};
        for(int d = 0; d< 4; d++){
            int nrow = row + delr[d];
            int ncol = col + delc[d];
            if(isValid(nrow, ncol, board,visited)){
                if(solve(nrow, ncol, cWord, board, word, visited)){
                return true;
                }
            }
        }

        visited[row][col] = false;
        cWord = cWord.substring(0, cWord.length()-1);

        return false;
    }
    static boolean isValid(int nrow, int ncol, char[][] board, boolean visited[][]){
        return nrow >=0 && ncol >= 0 && nrow <board.length && ncol < board[0].length
                && !visited[nrow][ncol];
    }

    public static void main(String[] args){
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        String word1 = "ABCCED";  // Expected: true
        String word2 = "SEE";     // Expected: true
        String word3 = "ABCB";    // Expected: false
        System.out.println(exist(board, word1)); // true
        System.out.println(exist(board, word2)); // true
        System.out.println(exist(board, word3)); // false
    }
}

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?

 
Seen this question in a real interview before?
1/6
Yes
No
Accepted
2,718,898/5.6M
Acceptance Rate
48.4%
*/