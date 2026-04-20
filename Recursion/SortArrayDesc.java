import java.util.*;
public class SortArrayDesc{
 static void sort(int[] A, int l){
        if(l==1)return;
        int last = A[l-1];
        sort(A,l-1);
        insert(A,l-1,last);
    }
    static void insert(int[] A,int l, int x){
        if(l==0 || A[l-1]>= x){
            A[l] = x;
            return;
        }
        int val = A[l-1];
        insert(A, l-1,x);
        A[l] = val;
    }
    public static void main(String[] args) {
        int[] A = {10,9,8,7,4,5,3};
        sort(A,A.length);
        System.out.print(Arrays.toString(A));
    }
}