Closest Neighbour in BST
Difficulty: EasyAccuracy: 36.98%Submissions: 60K+Points: 2
Given the root of a binary search tree and a number k, find the greatest number in the binary search tree that is less than or equal to k.

Examples:

 

Input: root = [10, 7, 15, 2, 8, 11, 16], k = 14

Output: 11
Explanation: The greatest element in the tree which is less than or equal to 14, is 11.
Input: root = [5, 2, 12, 1, 3, 9, 21, N, N, N, N, N, N, 19, 25], k = 24

Output: 21
Explanation: The greatest element in the tree which is less than or equal to 24, is 21. 
Input: root = [5, 2, 12, 1, 3, 9, 21, N, N, N, N, N, N, 19, 25], k = 4

Output: 3
Explanation: The greatest element in the tree which is less than or equal to 4, is 3.
Constraints:
1 <= number of nodes <= 105
1 <= node->data, k <= 105
All nodes are unique in the BST

Expected Complexities
Time Complexity: O(h)
Auxiliary Space: O(h)

  class Solution {
    public void bfs(int startNode, int[] edges, int[] dist) {
        int n = edges.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);

        Boolean[] visit = new Boolean[n];
        Arrays.fill(visit, Boolean.FALSE);
        dist[startNode] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            if (visit[node]) {
                continue;
            }

            visit[node] = true;
            int neighbor = edges[node];
            if (neighbor != -1 && !visit[neighbor]) {
                dist[neighbor] = 1 + dist[node];
                q.offer(neighbor);
            }

        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n], dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        bfs(node1, edges, dist1);
        bfs(node2, edges, dist2);

        int minDistNode = -1, minDistTillNow = Integer.MAX_VALUE;
        for (int currNode = 0; currNode < n; currNode++) {
            if (minDistTillNow > Math.max(dist1[currNode], dist2[currNode])) {
                minDistNode = currNode;
                minDistTillNow = Math.max(dist1[currNode], dist2[currNode]);
            }
        }

        return minDistNode;
    }
}
