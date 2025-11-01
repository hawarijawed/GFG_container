/*
You are given n courses, labeled from 0 to n - 1 and a 2d array prerequisites[][] where prerequisites[i] = [x, y] indicates that we need to take course  y first if we want to take course x.

Find the ordering of courses we should take to complete all the courses.

Note: There may be multiple correct orders, you just need to return any one of them. If it is impossible to finish all tasks, return an empty array. 
The Driver code will print true if you return any correct order of courses else it will print false. 
*/
class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        ArrayList<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);

            for (int next : graph.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        return order;
    }
}
