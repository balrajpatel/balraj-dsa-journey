

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

public class DiameterOfBinaryTree {
    static int res;
    public static int diameterOfBinaryTree(TreeNode root) {
        res = Integer.MIN_VALUE;
        solve(root);
        return res-1;  // since our code measures diameter in terms of Node
        // but in question it is given in terms of edges
    }
    static int solve(TreeNode root){ // since solve returns temp and temp is max of l and r so it gives height;
        if(root ==null){
            return 0;
        }

        int left = solve(root.left);
        int right = solve(root.right);

        int temp = 1 + Math.max(left, right);
        int ans = Math.max(temp, 1 + left + right);

        res = Math.max(res, ans);
        return temp;
    }
/*


The return value (temp) defines the purpose of the recursive function.

For your code:

int solve(TreeNode root)

returns

temp = 1 + Math.max(left, right);

So you can read it as:

"solve(root) returns the height of the subtree rooted at root."


Whenever you write a recursive function, ask yourself before coding:

"What should this function return to its parent?"

That answer determines what temp should be.
*/



    /*
    temp = value returned to the parent.
    // temp goes to parent, means only one path would needed (either left or right)
    // if both taken and then parent added itself ==> would be wrong for the path

ans = answer through the current node.
res = global maximum.
*/

}

/*
Why is this DP?

Dynamic Programming has two requirements:

Optimal Substructure 
Overlapping Subproblems (or the potential for them) 

Your diameter algorithm has optimal substructure.

For every node, you compute:

leftHeight = solve(root.left);
rightHeight = solve(root.right);

Then use those answers to compute the answer for the current node.

You're building the solution of a larger problem from the solutions of smaller subproblems.





Diameter of Binary Tree

Every node is visited exactly once.

solve(root)

returns

height(root)

and while returning it updates

res = max(res, left + right + ...)

Each subtree is solved exactly one time.

Time Complexity:

O(n)

Space:

O(h) recursion stack

No extra DP table needed.
*/