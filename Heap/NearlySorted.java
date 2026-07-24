import java.util.*;
class NearlySorted {
    public static int[] nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx=0;
        for(int i=0;i<arr.length; i++){
            pq.offer(arr[i]);
            if(pq.size()>k){
                arr[idx++] = pq.poll();
            }
            
            
        }
        while(!pq.isEmpty()){
            arr[idx++] = pq.poll();
        }
        return arr;
        
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nearlySorted(new int[]{2,3,1,4},2)));
    }
}
