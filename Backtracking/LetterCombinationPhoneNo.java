import java.util.*;
class LetterCombinationPhoneNo {
    static HashMap<Integer, String> map;
    public static ArrayList<String> possibleWords(int[] arr) {
        // code here
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        ArrayList<String> ans = new ArrayList<>();
        solve(arr,0, new StringBuilder(),ans);
        return ans;
        
    }
    static void solve(int[] arr, int n, StringBuilder temp, ArrayList<String> ans){
        if(n==arr.length){ // since we want to process a[n-1] and then if n= length print the ans
            ans.add(temp.toString());
            return;
        }
        if (arr[n] == 0 || arr[n] == 1) {
        solve(arr, n + 1, temp, ans);
        return;
        }
        
        String s = map.get(arr[n]);

        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            temp.append(c);
            
            solve(arr, n+1,temp,ans);
            
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public static void main(String[] args) {
        for(var s: possibleWords(new int[]{8,8,1})){
            System.out.print(s+" ");
        }
    }
}
/*
lass Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");


        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(map,0,sb,ans,digits);
        return ans;

    }
    static void solve(Map<Character,String> map, int n, StringBuilder temp, List<String> ans,String digits){
        if(n==digits.length()){
            ans.add(temp.toString());
            return;
        }
        for(char c: map.get(digits.charAt(n)).toCharArray()){
            temp.append(c);
            solve(map,n+1,temp,ans,digits);
            temp.deleteCharAt(temp.length()-1);
        }
    return;
    }
} 
 */