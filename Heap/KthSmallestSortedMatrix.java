import java.util.*;
class KthSmallestSortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
        return Integer.compare(b,a);
       });
       int idx = 0;
       for(int i=0; i < matrix.length; i++){
        for(int j =0; j < matrix[0].length; j++){
            if(k>idx){
                pq.offer(matrix[i][j]);
                idx++;
            }else{
                pq.offer(matrix[i][j]);
                pq.poll();
                
            }
        }
       }
       return pq.peek();

    }
    public static void main(String[] args) {
        int[][] mat1 = {
        {1, 2, 2},
        {2, 3, 3},
        {3, 4, 5}
        };
            int[][] mat2 = {
        {1, 5, 9},
        {10, 11, 13},
        {12, 13, 15}
        };

        System.out.println(kthSmallest(mat1,5));
        System.out.println(kthSmallest(mat2, 8));
    }


}