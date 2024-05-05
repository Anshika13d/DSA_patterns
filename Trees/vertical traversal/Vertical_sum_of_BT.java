/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/

class Tuple {
    int col;
    Node node;

    Tuple(Node node, int col) {
        this.col = col;
        this.node = node;
    }
}

class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0));

        while (!q.isEmpty()) {
            Tuple tup = q.poll();
            int col = tup.col;
            Node node = tup.node;

            map.put(col, map.getOrDefault(col, 0) + node.data);

            if (node.left != null) {
                q.offer(new Tuple(node.left, col - 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, col + 1));
            }
        }

        for (int vals : map.values()) {
            ans.add(vals);
        }

        return ans;
    }
}