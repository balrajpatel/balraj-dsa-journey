import java.util.*;
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} 
class MaxPathBtTwoLeaves
{
    static int res;
    public static int maxPathSum(Node root) {
        // code here
        res = Integer.MIN_VALUE;
        int temp = solve(root);
        if (root.left == null || root.right == null)
        return Math.max(res, temp);
        //After calling solve(root), check whether the root has only one child.

    return res;
        
    }
    static int solve(Node root){
        if(root==null)return 0;
    
        int l = solve(root.left);
        int r = solve(root.right);
    
    
        if (root.left == null)
            return r + root.data;
        
        if (root.right == null)
            return l + root.data;
        
        int temp = Math.max(l, r) + root.data;
        
        int ans = l + r + root.data;
        res = Math.max(res, ans);

    
        return temp;


    }
}

/*
The problem in your code

You wrote:

int ans = Math.max(temp, l + r + root.data);

For the "between two leaves" problem, this is wrong.

Why?

Suppose the tree is:

    10
   /
  5
 /
2

There is only one leaf (2).

There is no path between two leaves passing through 10.

But temp is:

10 + 5 + 2 = 17

If you do

ans = Math.max(temp, ...)

you are allowing a path that ends at a non-leaf, which violates the problem statement.

Correct logic

Only update res when both children exist.

if (root.left != null && root.right != null) {
    int ans = l + r + root.data;
    res = Math.max(res, ans);
}

Then return

return temp;
*/