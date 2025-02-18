/*
Given an array of points where each point is represented as points[i] = [xi, yi] on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance, defined as: 

sqrt( (x2 - x1)2 + (y2 - y1)2 )

Note: You can return the k closest points in any order, driver code will sort them before printing.
*/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Result array to store k closest points
        int[][] res = new int[k][2];
        
        // PriorityQueue to store points sorted by their squared distance to the origin
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> 
            Integer.compare(a.a * a.a + a.b * a.b, b.a * b.a + b.b * b.b)
        );
        
        // Add each point to the priority queue
        for (int[] arr : points) {
            int a = arr[0];
            int b = arr[1];
            q.add(new Pair(a, b));
        }
        
        // Extract k closest points from the priority queue
        for (int i = 0; i < k; i++) {
            Pair p = q.remove();
            res[i][0] = p.a;
            res[i][1] = p.b;
        }
        
        return res;
    }
    
    // Pair class to represent a point
    class Pair {
        int a; // x coordinate
        int b; // y coordinate
        
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
