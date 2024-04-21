class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int m = edges.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int v = edges[i][0];
            int e = edges[i][1];
            adj.get(v).add(e);
            adj.get(e).add(v);
        }

        boolean[] vis = new boolean[n];

        return bfs(source, destination, adj, vis);

        // return dfs(source, destination, adj, vis);
    }

    public boolean bfs(int src, int dest, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        vis[src] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            vis[node] = true;
            if (node == dest)
                return true;

            for (int adjNode : adj.get(node)) {
                if (!vis[adjNode]) {
                    q.offer(adjNode);
                    vis[adjNode] = true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int src, int dest, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        if (src == dest) {
            return true;
        }

        vis[src] = true;

        for (int neigh : adj.get(src)) {
            if (!vis[neigh]) {
                if (dfs(neigh, dest, adj, vis)) {
                    return true;
                }
            }
        }

        return false;
    }
}