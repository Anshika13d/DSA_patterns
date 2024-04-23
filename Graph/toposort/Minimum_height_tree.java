//observe 2 things
/*
 * 1. we should only take the non leaf node, as leaf node will always give max ansewer
 * 2. the answer min height tree will always be 1 or 2, not more than that.
 * 
 * 
 * to get the leaf node:
 * the node which has indegree = 1
 */

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();

        if (n == 1) {
            list.add(0);
            return list;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            indegree[v]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                q.offer(i);
            }
        }

        while (n > 2) {
            int size = q.size();
            n -= size;

            while (size > 0) {
                int node = q.poll();

                for (int adjNode : adj.get(node)) {
                    indegree[adjNode]--;
                    if (indegree[adjNode] == 1)
                        q.offer(adjNode);
                }

                size--;
            }
        }

        while (!q.isEmpty()) {
            list.add(q.poll());
        }

        return list;
    }
}g