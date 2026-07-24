import java.util.*;
class Pair1{
    int freq;
    int no;
    Pair1(int f, int no){
        this.freq = f;
        this.no = no;
    }
}
class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair1> pq = new PriorityQueue<>(
            (p1,p2)->{
                if(p1.freq == p2.freq)return Integer.compare(p1.no, p2.no);
                return Integer.compare(p1.freq, p2.freq);
            }
        );

        for(int i=0; i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
        for(var x: map.entrySet()){
            pq.offer(new Pair1(x.getValue(), x.getKey()));
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] ans = new int[pq.size()];
        int i=0;
        while(!pq.isEmpty()){
            ans[i++]=pq.poll().no;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,3};
        int k =2;
        System.out.println(Arrays.toString(topKFrequent(arr,k)));
    }
}


/*
347. Top K Frequent Elements
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]

 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 */