/*
You are given an undirected connected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each element edges[i] = [u, v] represents an undirected edge between vertex u and vertex v.
Find the diameter of the graph.
The diameter of a graph (sometimes called the width) is the number of edges on the longest path between two vertices in the graph.

Note: Graph do not contains any cycle.
*/
class Solution {
    public int diameter(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int [] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // Step 1: BFS from any node (say 0) to find farthest node A
        int farthestNodeA = bfsFarthestNode(0, adj, V)[0];

        // Step 2: BFS from A to find farthest node B and its distance (diameter)
        int[] result = bfsFarthestNode(farthestNodeA, adj, V);

        // result[1] is the distance (diameter)
        return result[1];
    }
    
    private static int[] bfsFarthestNode(int start, List<List<Integer>> adj, int V) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];

        queue.offer(start);
        visited[start] = true;

        int farthestNode = start;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.offer(neighbor);
                    if (distance[neighbor] > distance[farthestNode]) {
                        farthestNode = neighbor;
                    }
                }
            }
        }

        return new int[]{farthestNode, distance[farthestNode]};
    }

}
