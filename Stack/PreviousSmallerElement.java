import java.util.*;
class PreviousSmallerElement {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i =0; i<arr.length; i++){
            if(stack.size()==0){
                list.add(-1);
            }
            else if(stack.size()>0 && stack.peek() < arr[i]){
                list.add(stack.peek());
            }else if(stack.size()>0 && stack.peek() >= arr[i]){
                while(stack.size()>0 && stack.peek() >=arr[i]){
                    stack.pop();
                }
                if(stack.size()==0){
                    list.add(-1);
                }else{
                    list.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        return list;
    }
    public static void main(String[] args){
        int arr[] = new int[]{1,6,2};
        System.out.println(prevSmaller(arr));
    }
}