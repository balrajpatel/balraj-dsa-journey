public class KthSymbolGrammar{
    static int solve(int n, int k){
        if(n==1 && k == 1){
            return 0;
        }
        int size = (int)Math.pow(2,n-1);
        int mid = size/2;
        if(k<=mid){
            int ans = solve(n-1, k);
            return ans;
        }else{
            int ans = solve(n-1, k-mid);
            return ans ==1?0:1;
        }
    }
    public static int kthGrammar(int n, int k) {
        return solve(n,k);
    }
    public static void main(String[] args){
        System.out.print(kthGrammar(30,43));
    }
}