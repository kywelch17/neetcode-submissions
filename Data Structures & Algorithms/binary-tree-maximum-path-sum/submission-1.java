/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = root.val;
        dfs(root);
        return maxValue;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(0, dfs(node.left));
        int rightMax = Math.max(0, dfs(node.right));

        int sumOfPath = node.val + leftMax + rightMax;

        maxValue = Math.max(maxValue, sumOfPath);

        return node.val + Math.max(leftMax, rightMax);

    }
}
