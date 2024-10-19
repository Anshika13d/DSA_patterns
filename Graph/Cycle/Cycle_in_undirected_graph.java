//using DFS

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj){
    	int n = adj.size();
        boolean[] vis = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(dfs(adj, vis, i, -1)) return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int src, int parent){
    	vis[src] = true;
    	
    	for(int neigh: adj.get(src)){
    		if(neigh == parent) continue;
    		if(vis[neigh]) return true;
    		if(dfs(adj, vis, neigh, src)) return true;
        }
        
        return false;
    }

}



//using BFS

class Pair{
    int node;
    int parent;
    Pair(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj){
    	int n = adj.size();
        boolean[] vis = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(bfs(adj, vis, i)) return true;
            }
        }
        
        return false;
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int curr){

        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(curr, -1));
        
        vis[curr] = true;
        
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int node = pair.node;
            int parent = pair.parent;
            
            for(int neigh: adj.get(node)){
                if(neigh == parent) continue;
                if(vis[neigh]) return true;
                q.offer(new Pair(neigh, node));
                vis[neigh] = true;
            }
        }
        
        return false;
    }
}