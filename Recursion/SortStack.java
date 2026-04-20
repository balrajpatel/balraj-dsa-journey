import java.util.*;
public class SortStack {
    static void Sort(ArrayDeque<Integer> s){
        if(s.isEmpty())return;
        int last = s.pop();
        Sort(s);
        insert(s, last);

    }
    static void insert(ArrayDeque<Integer> s, int x){
        if(s.isEmpty() || s.peek()<=x){ //s.peek>=x stack becomes descending
            s.push(x);
            return;
        }
        int val = s.pop();
        insert(s,x);
        s.push(val);
    }
    public static void main(String[] args) {
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.push(4);
        s.push(1);
        s.push(8);
        s.push(-1);
        Sort(s);
        while (!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
}
