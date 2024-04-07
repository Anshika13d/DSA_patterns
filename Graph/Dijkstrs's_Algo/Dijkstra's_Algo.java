in Dijkstra's we always require a priority queue and dist array


class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Create a PriorityQueue for storing the nodes as a pair {dist,node}
        // where dist is the distance from source to the node.
        // PriorityQueue stores the nodes in ascending order of the distances.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Initialising dist list with a large number to
        // indicate the nodes are unvisited initially.
        // This list contains distance from source to the nodes.
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Add source node with distance 0 to PriorityQueue
        pq.offer(new int[] { 0, S });
        dist[S] = 0;

        // Now, poll the minimum distance node first from the PriorityQueue
        // and traverse for all its adjacent nodes.
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int dis = node[0];
            int currentNode = node[1];

            // Check for all adjacent nodes of the polled element
            // whether the previous distance is larger than current or not.
            for (ArrayList<Integer> it : adj.get(currentNode)) {
                int adjNode = it.get(0);
                int edgW = it.get(1);

                if (dis + edgW < dist[adjNode]) {
                    // If current distance is smaller,
                    // update the distance and add to the PriorityQueue
                    dist[adjNode] = dis + edgW;
                    pq.offer(new int[] { dist[adjNode], adjNode });
                }
            }
        }
        // Return the array containing shortest distances
        // from source to all the nodes.
        return dist;
    }
}
