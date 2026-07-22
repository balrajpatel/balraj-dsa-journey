import java.util.*;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }
}
public class MaxPathSumBT {
    static int res;
    public static int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        solve(root);
        return res;
    }
    static int solve(TreeNode root){
        if(root==null)return 0;

        int l = solve(root.left);
        int r = solve(root.right);


        int temp = Math.max(Math.max(l,r)+ root.val, root.val);  //it gives max path so solve also gives max path
        int ans = Math.max(temp, l+r+root.val);
        res = Math.max(ans, res);

        return temp;


    }
}