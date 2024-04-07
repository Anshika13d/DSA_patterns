class Pair {
    long first; // Change int to long
    int second;

    Pair(long first, int second) { // Adjust constructor accordingly
        this.first = first;
        this.second = second;
    }
}

class Solution {
    static int countPaths(int n, List<List<Integer>> roads) {
        List<List<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        int m = roads.size();
        for (int i = 0; i < m; i++) {
            adjList.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(2), roads.get(i).get(1))); // Change order of
                                                                                                      // parameters
            adjList.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(2), roads.get(i).get(0))); // Change order of
                                                                                                      // parameters
        }

        long[] dist = new long[n];
        int[] ways = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.first, y.first)); // Compare long values
        pq.add(new Pair(0, 0));

        int mod = (int) (1e9 + 7);

        while (!pq.isEmpty()) {
            long di = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for (Pair it : adjList.get(node)) {
                int edN = it.second;
                long edW = it.first;

                if (dist[node] + edW < dist[edN]) {
                    dist[edN] = dist[node] + edW;
                    ways[edN] = ways[node];
                    pq.add(new Pair(dist[edN], edN));
                } else if (dist[node] + edW == dist[edN]) {
                    ways[edN] = (ways[edN] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }
}g