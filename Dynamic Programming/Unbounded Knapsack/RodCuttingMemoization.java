import java.util.*;

class RodCuttingMemoization {
    static int[][] t;

    public static int cutRod(int[] price) {
        int n = price.length;

        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = i + 1;
        }

        t = new int[n + 1][n + 1];

        for (int i = 0; i < t.length; i++) {
            Arrays.fill(t[i], -1);
        }

        return maxPrice(price, len, n, n);
    }

    static int maxPrice(int[] price, int[] len, int n, int rodLen) {

        // base case
        if (n == 0 || rodLen == 0) {
            return 0;
        }

        if (t[n][rodLen] != -1) return t[n][rodLen];

        if (len[n - 1] <= rodLen) {
            return t[n][rodLen] = Math.max(
                price[n - 1] + maxPrice(price, len, n, rodLen - len[n - 1]), // take (unbounded)
                maxPrice(price, len, n - 1, rodLen) // skip
            );
        } else {
            return t[n][rodLen] = maxPrice(price, len, n - 1, rodLen);
        }
    }
    public static void main(String[] args){
        int price[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price));
    }
}