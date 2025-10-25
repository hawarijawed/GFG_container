/*
Given an array arr[], find the minimum number of operations required to make the sum of its elements less than or equal to half of the original sum. In one operation, you may replace any element with half of its value (with floating-point precision).
*/
class Solution {
    public int minOperations(int[] arr) {
        // code 
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        double originalSum = 0;
        for (int val : arr) {
            originalSum += val;
            pq.add((double) val);
        }
        
        double currSum = originalSum;
        double target = originalSum / 2.0;
        int operations = 0;
        
        while (currSum > target) {
            double largest = pq.poll();
            double halved = largest / 2.0;
            
            // Subtract the difference (reduction) from current sum
            currSum -= (largest - halved);
            
            pq.add(halved);
            operations++;
        }
        
        return operations;
        
    }
}
