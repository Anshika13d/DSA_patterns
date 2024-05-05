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

class Tuple {
    TreeNode node;
    int row;
    int col;

    Tuple(TreeNode _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;

            int x = tuple.row;
            int y = tuple.col;

            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> m : map.values()) {
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> p : m.values()) {
                while (!p.isEmpty()) {
                    ans.get(ans.size() - 1).add(p.poll());
                }
            }
        }

        return ans;

        // List<List<Integer>> ans = new ArrayList<List<Integer>>();

        // if (node == null) {
        // return ans;
        // }

        // int col = 0;

        // Queue<Map.Entry<TreeNode, Integer>> queue = new ArrayDeque<>();
        // Map<Integer, ArrayList<Integer>> map = new HashMap();

        // queue.offer(new AbstractMap.SimpleEntry<>(node, col));

        // int min = 0;
        // int max = 0;

        // while(!queue.isEmpty()) {
        // Map.Entry<TreeNode, Integer> removed = queue.poll();
        // node = removed.getKey();
        // col = removed.getValue();

        // if(node != null) {
        // if(!map.containsKey(col)) {
        // map.put(col, new ArrayList<Integer>());
        // }

        // map.get(col).add(node.val);

        // min = Math.min(min, col);
        // max = Math.max(max, col);

        // queue.offer(new AbstractMap.SimpleEntry<>(node.left, col-1));
        // queue.offer(new AbstractMap.SimpleEntry<>(node.right, col+1));
        // }
        // }

        // for(int i=min; i <= max; i++) {
        // ans.add(map.get(i));
        // }

        // return ans;
    }
}