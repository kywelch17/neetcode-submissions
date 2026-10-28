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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            TreeNode pNode = queue.poll();
            TreeNode qNode = queue.poll();

            if (pNode == null && qNode == null) {
                continue;
            }
            if (pNode == null || qNode == null || pNode.val != qNode.val) {
                return false;
            }

                queue.add(pNode.left);
                queue.add(qNode.left);


                queue.add(pNode.right);
                queue.add(qNode.right);
        }

        return true;
    }
}
