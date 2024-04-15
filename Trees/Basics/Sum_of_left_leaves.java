/**
*  Definition for a binary tree node.
*  public class TreeNode {
*       int val;
*       TreeNode left;
*       TreeNode right;
*       TreeNode() {}
*       TreeNode(int val) { this.val = val; }
*       TreeNode(int val, TreeNode left, TreeNode right) {
*       this.val = val;
*       this.left = left;
*       this.right = right;
 *   }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper2(root, false);
        // return helper(root, null);
    }

    public int helper2(TreeNode node, boolean isLeft) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null && isLeft) {
            return node.val;
        }

        return helper2(node.left, true) + helper2(node.right, false);
    }

    public int helper(TreeNode node, TreeNode parent) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null) {
            if (parent != null && parent.left == node) {
                return node.val;
            }
        }

        int left = helper(node.left, node);
        int right = helper(node.right, node);

        return left + right;
    }
}