import java.util.*;
class KthSmallestElement {
    public static int kthSmallest(int[] arr, int k) {
        // Code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(b,a);
        });
        
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            if(k>idx){
                pq.offer(arr[i]);
                idx++;
            }else if(k==idx){
                pq.offer(arr[i]);
                pq.poll();
            }
        }
        return pq.peek();
        
    }
    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[]{10,5,4,3,48,6,2,33,53,10},4));
    }
}
