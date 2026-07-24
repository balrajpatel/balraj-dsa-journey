import java.util.*;
class MedianFinder {
    PriorityQueue<Integer> lmax;
    PriorityQueue<Integer> rmin;

    public MedianFinder() {
        
        lmax = new PriorityQueue<>(Collections.reverseOrder());
        rmin = new PriorityQueue<>();

    }
    
    // elemens(lmax) <= elements(rmax)
    // noofelements(lmax) >= noofelements(rmax) at most one;
            // so that even no is odd we pick from lmin  -=-    1,2,3    4,5  odd elements so 4 as median
    public void addNum(int num) {
        // Add new element to 
        if(lmax.isEmpty() || num <=lmax.peek()){
            lmax.offer(num);
        }else{
            rmin.offer(num);
        }
        if(lmax.size() - rmin.size() > 1){ // lmax can be 1 bigger
            rmin.offer(lmax.poll());
        }
        if(rmin.size() - lmax.size()>0){ // we don't want rmin bigger
            lmax.offer(rmin.poll());
        }

    }
    
    public double findMedian() {
        if((lmax.size()+rmin.size())%2==0){
            return (lmax.peek()+ rmin.peek())/2.0;
        }else{
            return lmax.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/*
Complete Algorithm
Initialize:
    left = MaxHeap
    right = MinHeap

addNum(x):

    if left is empty OR x <= left.peek()
         insert into left
    else
         insert into right

    // Balance heaps
    if left.size() > right.size() + 1
         right.add(left.poll())

    if right.size() > left.size()
         left.add(right.poll())

findMedian():

    if left.size() == right.size()
         return (left.peek() + right.peek()) / 2.0

    return left.peek()
*/


   

/*
class MedianFinder {
    List<Integer> ls;
    PriorityQueue<Integer> pq;

    public MedianFinder() {
        ls= new ArrayList<>();
        pq = new PriorityQueue<>(Collections.reverseOrder());

    }
    
    public void addNum(int num) {
        pq.add(num);
    }
    
    public double findMedian() {
        if(pq.size()%2!=0){
            int k = (pq.size()+1)/2;
            return kSmallestO(k);
        }else{
            int k = pq.size()/2;
            k++;
            return kSmallestE(k);
        }
    }
    public double kSmallestO(int k){
        while(pq.size()>k){
            ls.add(pq.poll());
        }
        int median = pq.peek();
        while(ls.size()>0){
            pq.offer(ls.remove(ls.size()-1));
        }
        return (double)median;
    }
    public double kSmallestE(int k){
        while(pq.size()>k){
            ls.add(pq.poll());

        }
        int s1 = pq.poll();
        int s2 = pq.poll();
        pq.offer(s1);
        pq.offer(s2);
        while(ls.size()>0){
            pq.offer(ls.remove(ls.size()-1));
        }
        return  (s1 + (double)s2)/2;
    }
}*/   //***** GIVES TLE