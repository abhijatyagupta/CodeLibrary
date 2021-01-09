/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        int[] sum = new int[1];
        sum[0] = 0;
        traversal(root, sum);
        return sum[0];
    }
    
    static void traversal(TreeNode node, int[] sum) {
        if(node == null) return;
        if (node.val % 2 == 0) {
            sum[0] += safeSum(node.left);
            sum[0] += safeSum(node.right);
        }
        traversal(node.left, sum);
        traversal(node.right, sum);
    }
    
    static int safeSum(TreeNode node) {
        if (node == null) return 0;
        int tempSum = 0;
        if(node.left != null) tempSum += node.left.val;
        if(node.right != null) tempSum += node.right.val;
        return tempSum;
    }
}
