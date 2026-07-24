import java.util.*;
class MinCostToConnectRopes {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x: arr){
            pq.offer(x);
        }
        
        int cost =0;
        while(pq.size()>1){
            int r1 = pq.poll();
            int r2 = pq.poll();
            cost += r1 + r2;
            pq.offer(r1+ r2);
            
        }
        
        return cost;
    }
    public static void main(String[] args) {
        System.out.println(minCost(new int[]{4,3,2,6}));
    }
}