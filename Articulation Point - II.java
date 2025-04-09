/*
You are given an undirected graph with V vertices and E edges. The graph is represented as a 2D array edges[][], where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v.
Your task is to return all the articulation points (or cut vertices) in the graph.
An articulation point is a vertex whose removal, along with all its connected edges, increases the number of connected components in the graph.

Note: The graph may be disconnected, i.e., it may consist of more than one connected component.
If no such point exists, return {-1}.
*/
class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        boolean[] isArticulation = new boolean[V];
        int[] timer = {0};

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, adj, vis, tin, low, timer, isArticulation);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isArticulation[i]) ans.add(i);
        }
        if (ans.size() == 0) ans.add(-1);
        return ans;
    }
    
    static void dfs(int u, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] tin, int[] low, int[] timer, boolean[] isArticulation) {
        vis[u] = true;
        tin[u] = low[u] = timer[0]++;
        int children = 0;
        
        for (int v : adj.get(u)) {
            if (v == parent) continue;
            if (!vis[v]) {
                dfs(v, u, adj, vis, tin, low, timer, isArticulation);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] >= tin[u] && parent != -1) {
                    isArticulation[u] = true;
                }
                children++;
            } else {
                low[u] = Math.min(low[u], tin[v]);
            }
        }
        if (parent == -1 && children > 1) {
            isArticulation[u] = true;
        }
    }
}
