/*
Given a directed graph with V vertices numbered from 0 to V-1 and E directed edges, represented as a 2D array edges[][], where each element edges[i] = [u, v] represents a directed edge from vertex u to vertex v. Return all Safe Nodes of the graph.
A vertex with no outgoing edges is called a terminal node. A vertex is considered safe if every path starting from it eventually reaches a terminal node.
*/
class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
         int n = edges.length;
        int[] outdeg = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[V];
        
        for(int i = 0; i < V; i++) graph[i] = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            graph[v].add(u);
            outdeg[u]++;
        }
        
        for(int i = 0; i < V; i++) if(outdeg[i] == 0) q.add(i);
        
        while(!q.isEmpty()){
            int rem = q.remove();
            
            ans.add(rem);
            for(int neigh : graph[rem]){
                outdeg[neigh]--;
                if(outdeg[neigh] == 0) q.add(neigh);
            }
        }
        
        return ans;
    }
}
