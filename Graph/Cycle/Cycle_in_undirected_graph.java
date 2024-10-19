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