import java.util.*;
class MaximalRectangleInBinaryMatrix {
    public static int maximalRectangle(char[][] matrix) {

        int[][] mat = new int[matrix.length][matrix[0].length];

        for(int i=0; i<mat[0].length; i++){
            if(matrix[0][i]=='0'){
                mat[0][i] =0;
            }else{
                mat[0][i] = 1;
            }
        }
        for(int i=1; i<matrix.length; i++){
            for(int j =0; j<matrix[0].length; j++){
                if(matrix[i][j]=='0'){
                    mat[i][j] = 0;
                }else{
                    mat[i][j] = mat[i-1][j] + Character.getNumericValue(matrix[i][j]);
                }
            }
        }
        int mx = 0;
        for(int i=0; i<mat.length; i++){
            mx = Math.max(mx, MAH(mat[i]));
        }
        return mx;
        
    }
    static int MAH(int[] arr){

        ArrayDeque<int[]> stack = new  ArrayDeque<>();
        int[] nsl, nsr;
        nsl = new int[arr.length];
        nsr = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            if(stack.size() ==0){
                nsl[i] = -1;
            }
            else if(stack.size() >0 && stack.peek()[0] < arr[i]){
                nsl[i] = stack.peek()[1];
            }else if(stack.size()>0 && stack.peek()[0] >= arr[i]){
                while(stack.size() > 0 && stack.peek()[0] >= arr[i]){
                    stack.pop();
                }
                if(stack.size()==0){
                    nsl[i] = -1;
                }else{
                    nsl[i] = stack.peek()[1];
                }
            }

            stack.push(new int[]{arr[i], i});
        }


        stack.clear();
        for(int i=arr.length -1; i >=0; i--){
            if(stack.size() ==0){
                nsr[i] = arr.length;
            }
            else if(stack.size() >0 && stack.peek()[0] < arr[i]){
                nsr[i] = stack.peek()[1];
            }else if(stack.size()>0 && stack.peek()[0] >= arr[i]){
                while(stack.size() > 0 && stack.peek()[0] >= arr[i]){
                    stack.pop();
                }
                if(stack.size()==0){
                    nsr[i] = arr.length;
                }else{
                    nsr[i] = stack.peek()[1];
                }
            }

            stack.push(new int[]{arr[i], i});
        }

        int ans =0;
        for(int i =0; i<arr.length; i++){
            int width = (nsr[i] - 1) - (nsl[i] + 1) +1;
            ans = Math.max(ans, width*arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };  
        System.out.println(maximalRectangle(matrix));
    }
}