import java.util.*;
class SuperEggDropMemo {
    static int t[][];
    public static int superEggDrop(int k, int n) {
        t = new int[k+1][n+1];
        for(int i =0; i<t.length; i++){
            Arrays.fill(t[i], -1);
        }
    return solve(k,n);    
    }

    static int solve(int eggs, int floor){
        if(floor == 0 || floor == 1)return t[eggs][floor] = floor ;

        if(eggs==1)return t[1][floor] = floor; // in worst case all floor checks;
        if(t[eggs][floor]!= -1) return t[eggs][floor];
        int mn = Integer.MAX_VALUE;
        for(int k = 1; k <= floor; k++){
            int low, high;
            if(t[eggs-1][k-1]!= -1) low = t[eggs-1][k-1];
            else {
                low = solve(eggs-1,k-1);
                t[eggs-1][k-1] = low;
            }
            if(t[eggs][floor-k]!= -1) high = t[eggs][floor-k];
            else{
                high = solve(eggs,floor-k);
                t[eggs][floor-k] = high;
            }
            int temp = 1 + Math.max(low,
                                high);
                            // max to find out in worst case;
                            //1 for the current floor;
                
            mn = Math.min(temp, mn);
        }
        return t[eggs][floor] = mn; 
    }
    public static void main(String[] args) {
        System.out.println(superEggDrop(1,2));
        System.out.println(superEggDrop(2,6));
        System.out.println(superEggDrop(3,14));
    }
}