import java.util.*;

class Pair{
    int close;
    int no;
    Pair(int c, int n){
        this.close = c;
        this.no = n;
    }
}
public class KClosestNumbers {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
        (p1,p2)->{
            if(p1.close == p2.close) return Integer.compare(p2.no, p1.no);
            return Integer.compare(p2.close, p1.close);
        });
        for(int i=0; i<arr.length; i++){
            pq.offer(new Pair(Math.abs(arr[i]-x), arr[i]));
            if(pq.size()>k){
                pq.poll();
            }
        }

        List<Integer> l = new ArrayList<>();
        while(!pq.isEmpty()){
            l.add(pq.poll().no);
        }
        Collections.sort(l);
        return l;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(findClosestElements(arr,4,3));
    }

    
}
//   pq.offer(new Pair(Math.abs(arr[i]-x), arr[i]));
// removing x from every no to get closest to x for ever no.
// then use pq;
