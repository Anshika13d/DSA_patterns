/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null)
            return null;

        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        helper(root, val, depth, 1);

        return root;
    }

    public void helper(TreeNode node, int val, int depth, int d) {
        if (node == null)
            return;

        if (d == depth - 1) {
            TreeNode leftSub = node.left;
            TreeNode rightSub = node.right;
            node.left = new TreeNode(val);
            node.right = new TreeNode(val);
            node.left.left = leftSub;
            node.right.right = rightSub;
            return;
        }

        helper(node.left, val, depth, d + 1);
        helper(node.right, val, depth, d + 1);
    }
}