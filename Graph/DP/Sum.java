
class Solution {
    long resultBaseNode = 0;
    int[] count;
    int N;

    public int dfsBase(HashMap<Integer, ArrayList<Integer>> adj, int currNode, int prevNode, int currDepth) {
        int totalNode = 1;

        resultBaseNode += currDepth;

        for (int child : adj.get(currNode)) {
            if (child == prevNode)
                continue;

            totalNode += dfsBase(adj, child, currNode, currDepth + 1);
        }

        // Store count of subtrees of each node
        count[currNode] = totalNode;

        return totalNode;
    }

    public void DFS(HashMap<Integer, ArrayList<Integer>> adj, int parentNode, int prevNode, int[] result) {

        for (int child : adj.get(parentNode)) {
            if (child == prevNode)
                continue;

            result[child] = result[parentNode] - count[child] + (N - count[child]);
            DFS(adj, child, parentNode, result);
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        N = n;
        count = new int[n];

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        resultBaseNode = 0;

        dfsBase(adj, 0, -1, 0);

        int[] result = new int[n];

        result[0] = (int) resultBaseNode;

        DFS(adj, 0, -1, result);

        return result;
    }
}
