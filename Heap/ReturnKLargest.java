import java.util.*;
class ReturnKLargest {
    public static ArrayList<Integer> kLargest(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            pq.offer(arr[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
            while(!pq.isEmpty()){
            al.add(pq.poll());
            
        }
        Collections.sort(al, Collections.reverseOrder());
        return al;
    }
    public static void main(String[] args) {
        System.out.println(kLargest(new int[]{12,5,787, 1, 23},2));
    }
}
