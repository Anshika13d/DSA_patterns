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
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        helper(root, list, sb);

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int num = Integer.parseInt(list.get(i));
            sum += num;
        }

        return sum;
    }

    public void helper(TreeNode node, List<String> list, StringBuilder sb) {
        if (node == null)
            return;

        sb.append(Integer.toString(node.val));
        if (node.left == null && node.right == null) {
            list.add(sb.toString());
        }

        helper(node.left, list, new StringBuilder(sb));
        helper(node.right, list, new StringBuilder(sb));
    }
}

// -------------------******---------------*******----------------------------

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
    int gSum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        helper2(root, 0);
        return gSum;
    }

    public void helper2(TreeNode node, int sum) {
        if (node == null)
            return;

        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            gSum += sum;
        }

        helper2(node.left, sum);
        helper2(node.right, sum);
    }

    public void helper(TreeNode node, List<String> list, StringBuilder sb) {
        if (node == null)
            return;

        sb.append(Integer.toString(node.val));
        if (node.left == null && node.right == null) {
            list.add(sb.toString());
        }

        helper(node.left, list, new StringBuilder(sb));
        helper(node.right, list, new StringBuilder(sb));
    }
}