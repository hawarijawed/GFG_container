/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from verticex u to v.
*/
class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> graphs = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            graphs.add(new ArrayList<>());
        }
        
        for(int[] num: edges){
            graphs.get(num[0]).add(num[1]);
        }
        
        int[] vis = new int[V];
        
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                if(dfs(graphs, vis, i)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(List<List<Integer>> graph, int[] vis, int node){
        
        //Mark the curr node as visiting node
        vis[node] = 1;
        
        for(int neighbor: graph.get(node)){
            if(vis[neighbor] == 1){
                return true;
            }
            
            //Check for un visited neighbor
            if(vis[neighbor] == 0 && dfs(graph, vis, neighbor)){
                return true;
            }
        }
        vis[node] = 2;
        return false;
        
    }
}
