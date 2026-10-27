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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorderSerializeHelper(root, sb);
        return sb.toString();
    }

    private void preorderSerializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }

        sb.append(node.val + ",");
        preorderSerializeHelper(node.left, sb);
        preorderSerializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] index = {0};
        return preorderDeserializeHelper(vals, index);
    }

    private TreeNode preorderDeserializeHelper(String[] vals, int[] index) {
        if (vals[index[0]].equals("null")) {
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[index[0]]));
        index[0]++;
        node.left = preorderDeserializeHelper(vals, index);
        node.right = preorderDeserializeHelper(vals, index);

        return node;
    }
}
