import java.util.*;
public class ReverseStack{
    static void reverse(ArrayDeque<Integer> s){
        if(s.size()==1){
            return;
        }
        int last = s.pop();
        reverse(s);
        insert(s,last);
    }
    static void insert(ArrayDeque<Integer> s, int x){
        if(s.size()==0){
            s.push(x);
            return;
        }
        int val = s.pop();
        insert(s, x);
        s.push(val);
    }
    public static void main(String[] args) {
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.push(4);
        s.push(1);
        s.push(8);
        s.push(-1);
        reverse(s);
        while (!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
      
    }
}