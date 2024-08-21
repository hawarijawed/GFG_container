/*
You are given an Undirected Graph having unit weight of the edges, find the shortest path from src to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.
*/

class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Initialize the adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Populate the adjacency list with edges
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // Initialize distances
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // BFS initialization
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        // Perform BFS
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : adj.get(node)) {
                if (dist[node] + 1 < dist[neighbor]) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }
        
        // Convert unreachable nodes' distances to -1
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}
