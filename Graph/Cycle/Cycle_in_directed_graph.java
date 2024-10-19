//using DFS

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[n];
        boolean[] inRec = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(dfs(adj, vis, inRec, i)) return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] inRec, int node){
        vis[node] = true;
        inRec[node] = true;
        
        for(int neigh: adj.get(node)){
            if(vis[neigh] == true && inRec[neigh] == true) return true;
            if(dfs(adj, vis, inRec, neigh)) return true;
        }
        
        inRec[node] = false;
        return false;
    }
}


//using bfs
