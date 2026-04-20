import java.util.*;
public class DeleteMidElementStack {
    static void deleteMid(ArrayDeque<Integer> stack, int k){
        if(k==1) {
            stack.pop();
            return;
        }
        int value = stack.pop();

        deleteMid(stack, k-1);
        stack.push(value);
    }
    public static void main(String[] args) {
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.push(4);
        s.push(1);
        s.push(8);
        s.push(-1);
        s.push(0);
        int k = s.size()/2 +1;
        deleteMid(s,k);
        while (!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
}
