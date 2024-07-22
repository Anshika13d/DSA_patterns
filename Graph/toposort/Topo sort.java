class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] vis = new int[V];
        int[] ans = new int[V];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<V;i++){
            if(vis[i] != 1){
                dfs(i, V, vis, stack, adj);
            }
        }
        
        int i = 0;
        
        while(!stack.isEmpty()){
            ans[i] = stack.pop();
            i++;
        }
        
        return ans;
    }
    
    static void dfs(int node, int V, int[] vis, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        
        for(int it: adj.get(node)){
            if(vis[it] != 1){
                dfs(it, V, vis, stack, adj);
            }
        }
        
        stack.push(node);
    }
}
