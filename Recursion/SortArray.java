import java.util.*;
public class SortArray{
// remember l always represent no of elements on both
//sort is length based
// insert is index based(position)
    static void sort(int[] A, int l){
        if(l==1){
            return;
        }
        int val = A[l-1];
        sort(A, l-1);
        insert(A,l-1,val);
    }
    static void insert(int[] A, int l, int x){
        if(l==0 || A[l-1] <= x){
            // l represents no of elements , if l ==0 means no element left
            //  if l== 0 means array empty just insert
            // if last element of A <= x (to be insert element) just directly insert
            // since our array is already sort we are just inserting in it
            A[l] = x;
            return;
        }
        int val = A[l-1];

        // we call the insert on smaller input // since we know last element is > x (otherwise if condn executes)
        insert(A,l-1,x);

        // just append the last element in the array after inserting;
        A[l] = val;
    }
    public static void main(String[] args){
        int[] A = {10,9,8,4,4,5,3};
        sort(A,A.length);
        System.out.print(Arrays.toString(A));

    }

}