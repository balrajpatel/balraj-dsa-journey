import java.util.*;
// partial incorrrect solution

class SumBetwenk1k2Smallest {
    public static int sumBetweenK1K2(int[] arr, int k1, int k2) {
        // code here
        int n1 = kSmallest(arr, k1);
        int n2 = kSmallest(arr, k2);
        
        int sum=0;
        for(int x: arr){
            if(x>n1 && x<n2){
                sum += x;
            }
        }
        
        return sum;
        
        //similarly create kLargest the any combiations of questions can be asked;
    }
    static int kSmallest(int arr[] , int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x: arr){
            pq.offer(x);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}


//************** */
/*
class Solution {
    public int sumBetweenK1K2(int[] arr, int k1, int k2) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int x : arr)
            pq.offer(x);

        // Remove first k1 smallest elements
        for (int i = 0; i < k1; i++)
            pq.poll();

        int sum = 0;

        // Sum elements between k1-th and k2-th
        for (int i = k1 + 1; i < k2; i++)
            sum += pq.poll();

        return sum;
    }
}

*/