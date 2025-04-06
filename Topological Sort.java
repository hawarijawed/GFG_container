/*
Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][], where each entry edges[i] = [u, v] denotes an directed edge u -> v. Return topological sort for the given graph.

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.
*/
class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[V];
        
        // Build the adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }
        
        // Queue to store vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        
        // Add all vertices with in-degree 0 to the queue
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // List to store the topological sort
        ArrayList<Integer> topoOrder = new ArrayList<>();
        
        // Process the graph
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);
            
            // Decrease in-degree of all adjacent nodes
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                // If in-degree of neighbor becomes 0, add it to the queue
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If the topological sort contains all vertices, return it
        if (topoOrder.size() == V) {
            return topoOrder;
        } else {
            // Cycle detected, no valid topological sort
            return new ArrayList<>();
        }
    }
}
