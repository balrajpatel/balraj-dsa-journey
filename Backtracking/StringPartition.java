import java.util.*;

public class StringPartition {
    //**** piece == cut  chose the current cut and find the next cut****
    static void solve(String ip, int n, int start,
                      List<List<String>> result,
                      List<String> ans) {

        // Entire string has been consumed
        if (start == n) {
            result.add(new ArrayList<>(ans));
            return;
        }

        // Choose where the current piece ends
        for (int i = start; i < n; i++) {

            // took the piece
            String piece = ip.substring(start, i + 1);

            // Take  // add the piece to the current list
            ans.add(piece);

            // Move to the next unprocessed character
            solve(ip, n, i + 1, result, ans);

            // Undo
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {

        String ip = "ABCD";

        List<List<String>> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        solve(ip, ip.length(), 0, result, ans);

        for (var v : result) {
            System.out.println(v);
        }
    }
}

/*
start
  ↓
for every possible ending i
  ↓
choose substring(start, i+1)
  ↓
recurse from i+1
  ↓
undo
*/