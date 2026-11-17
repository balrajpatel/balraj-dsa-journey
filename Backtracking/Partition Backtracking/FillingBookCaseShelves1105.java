import java.util.*;
public class FillingBookCaseShelves1105 {
    static int[] dp ;
    public static int minHeightShelves(int[][] books, int shelfWidth) {
        dp = new int[books.length + 1];
        Arrays.fill(dp, -1);
        return solve(0,books, shelfWidth);
    }
    // gives the minposible height from start to end;
    // for base condn
    // we reached the end so we don't requre any height; ==== return 0;
    static int solve(int start, int[][] books, int w){

        if(start==books.length){
            return dp[start] = 0;
        }
        if(dp[start]!= -1){
            return dp[start];
        }
        int tsum =0;
        int theight = 0;
        int localheight = 0;

        int minHeight = Integer.MAX_VALUE;
        // for min possible hieght;  // since start =0; 
        // therefore it will give min possible height from start to end;

        for(int end = start ; end<books.length; end++){
            tsum += books[end][0];
            localheight = Math.max(localheight, books[end][1]);

            if(tsum<= w){
                //for minhieght of each child(of start of method)
                theight = localheight + solve(end+1, books, w); 
            } else {
                break;
            }
            // comparing all child's hight then getting the overall min hight
            
            minHeight = Math.min(minHeight, theight);
        }
        return dp[start] = minHeight;
    }
    public static void main(String[] args) {

        int[][][] books = {
            // 1. Basic example
            {{1, 1}, {2, 3}, {2, 3}},

            // 2. All books fit on one shelf
            {{1, 2}, {2, 3}, {3, 4}},

            // 3. Every book requires a separate shelf
            {{2, 4}, {3, 5}, {4, 6}},

            // 4. Optimal partition is not greedy
            {{1, 3}, {2, 4}, {2, 2}, {1, 5}},

            // 5. Single book
            {{5, 7}},

            // 6. All books have equal heights
            {{1, 4}, {2, 4}, {3, 4}, {1, 4}},

            // 7. All books have equal widths
            {{2, 1}, {2, 5}, {2, 3}, {2, 4}},

            // 8. Alternating heights
            {{1, 10}, {1, 1}, {1, 9}, {1, 2}},

            // 9. Exact shelf width
            {{2, 3}, {3, 5}, {5, 2}},

            // 10. Multiple possible partitions
            {{1, 5}, {1, 2}, {1, 4}, {1, 3}, {1, 6}},

            // 11. Increasing heights
            {{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}},

            // 12. Decreasing heights
            {{1, 5}, {1, 4}, {1, 3}, {1, 2}, {1, 1}},

            // 13. Large shelf width
            {{3, 8}, {2, 5}, {4, 7}, {1, 2}},

            // 14. Two books cannot fit together
            {{4, 3}, {4, 6}, {4, 2}},

            // 15. Different widths and heights
            {{2, 7}, {3, 1}, {1, 5}, {2, 3}, {2, 6}}
        };

        int[] shelfWidths = {
            3, 10, 4, 3, 5,
            10, 4, 4, 5, 2,
            2, 2, 10, 4, 5
        };

        int[] expected = {
                6,
                4,
                15,
                9,
                7,
                4,
                9,
                10,
                7,
                15,
                9,
                9,
                8,
                11,
                13
            };

        for (int i = 0; i < books.length; i++) {

            int actual = minHeightShelves(books[i], shelfWidths[i]);

            System.out.println("------------------------------------");
            System.out.println("Test Case : " + (i + 1));
            System.out.println("Books     : " + Arrays.deepToString(books[i]));
            System.out.println("Width     : " + shelfWidths[i]);
            System.out.println("Expected  : " + expected[i]);
            System.out.println("Actual    : " + actual);
            System.out.println("Result    : " +
                    (actual == expected[i] ? "PASS" : "FAIL"));
        }
    }
    
}




/*
You are given an array books where books[i] = [thicknessi, heighti] indicates the thickness and height of the ith book. You are also given an integer shelfWidth.

We want to place these books in order onto bookcase shelves that have a total width shelfWidth.

We choose some of the books to place on this shelf such that the sum of their thickness is less than or equal to shelfWidth, then build another level of the shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down. We repeat this process until there are no more books to place.

Note that at each step of the above process, the order of the books we place is the same order as the given sequence of books.

For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.
Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.

 

Example 1:


Input: books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelfWidth = 4
Output: 6
Explanation:
The sum of the heights of the 3 shelves is 1 + 3 + 2 = 6.
Notice that book number 2 does not have to be on the first shelf.
Example 2:

Input: books = [[1,3],[2,4],[3,2]], shelfWidth = 6
Output: 4
 

Constraints:

1 <= books.length <= 1000
1 <= thicknessi <= shelfWidth <= 1000
1 <= heighti <= 1000
 
Seen this question in a real interview before?
1/6
Yes
No
Accepted
164,431/239.4K
Acceptance Rate
68.7%
*/