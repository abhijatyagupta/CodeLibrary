/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int[] recoverTree(TreeNode A) {
        int[] ans = new int[3]; // first two indices will store the required answer and the third index will store previous visited element while traversing
        recovery(A, ans);   // call to actual shit
        return Arrays.copyOfRange(ans, 0, 2);
    }

    static void recovery(TreeNode node, int[] ans) {    //inorder traversal (as the elements should be in ascending order, the misplaced elements will be spotted)
        if (node == null) return;
        recovery(node.left, ans);
        if (ans[2] != 0 && ans[2] > node.val) { // if the previous element is not null and is larger than the current element, means it is misplaced
            if (ans[1] == 0) ans[1] = ans[2];   // store the misplaced element (the previous element), if not already present
            ans[0] = node.val;  // store the current element as well
        }
        ans[2] = node.val;  // mark the current element as previous element for further traversal
        recovery(node.right, ans);
    }
}
