/*
Given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u,v] represents the edge between the vertices u and v. Determine whether a specific edge between two vertices (c, d) is a bridge.

Note:

An edge is called a bridge if removing it increases the number of connected components of the graph.
if there’s only one path between c and d (which is the edge itself), then that edge is a bridge.
*/


class Solution {
    int time = 0;

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Create the adjacency list
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        int[] disc = new int[V];  // discovery times
        int[] low = new int[V];   // low values

        // Start DFS
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, disc, low, adj, c, d)) {
                    return true; // bridge found
                }
            }
        }

        return false; // no bridge found
    }

    private boolean dfs(int u, int parent, boolean[] visited, int[] disc, int[] low,
                        List<List<Integer>> adj, int c, int d) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj.get(u)) {
            if (v == parent) continue;

            if (!visited[v]) {
                if (dfs(v, u, visited, disc, low, adj, c, d)) return true;

                low[u] = Math.min(low[u], low[v]);

                // Bridge condition
                if (low[v] > disc[u]) {
                    if ((u == c && v == d) || (u == d && v == c)) {
                        return true;
                    }
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        return false;

}
}
