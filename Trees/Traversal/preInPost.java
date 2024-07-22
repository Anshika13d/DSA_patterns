class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if (root == null)
            return preorder;
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();

        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);

        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            TreeNode noodie = pair.node;
            int number = pair.num;

            if (number == 1) {
                preorder.add(noodie.val);
                pair.num++;
                stack.push(pair);

                if (noodie.left != null) {
                    stack.push(new Pair(noodie.left, 1));
                }
            } else if (number == 2) {
                inorder.add(noodie.val);
                pair.num++;
                stack.push(pair);

                if (noodie.right != null) {
                    stack.push(new Pair(noodie.right, 1));
                }
            } else {
                postorder.add(noodie.val);
            }
        }

        return inorder;
    }
}