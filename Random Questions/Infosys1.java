import java.util.*;
public class Infosys1 {
      public static long maxScore(int[][] grid, int k, int p) {
        long Osum = Long.MIN_VALUE;

        for(int start = 0; start<grid[0].length; start++){
            long sum = 0;

            int maxLeft = Integer.MIN_VALUE;
            int minRight = Integer.MAX_VALUE;

            for(int i = 0; i<grid.length; i++){
                long max = Long.MIN_VALUE;
    
                int left = -1;
                int right = -1;
                for(int j = start; j< Math.min(start + k + 1, grid[0].length); j++){
                    if (grid[i][j] > max) {
                    max = grid[i][j];
                    left = j;
                    right = j;
                    } 
                    else if (grid[i][j] == max) {
                        right = j;
                    }
                }
               
                sum += max;

                maxLeft = Math.max(maxLeft, left);
                minRight = Math.min(minRight, right);
            }
            int spread = Math.max(0, maxLeft - minRight);
            sum = sum - (spread)*p;
            Osum = Math.max(sum, Osum);

        }
        return Osum;

    }
    public static void main(String[] args){
        int[][] grid = {
            {5,10,3},
            {8,2,15},
            {7,12,4}
        };

        System.out.println(maxScore(grid,1,3));
    }
}