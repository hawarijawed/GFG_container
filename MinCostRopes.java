/*
Given an array arr containing the lengths of the different ropes, we need to connect these ropes to form one rope.
The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost.
*/
//Back-end complete function Template for Java
class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
        // code here
    PriorityQueue<Long> pq = new PriorityQueue<>();
    for(long a: arr){
        pq.add(a);
    }
    
    long ans = 0;
    
    while(pq.size()>1){
        long first = pq.poll();
        long second = pq.poll();
        long sum = first + second;
        ans += sum;
        pq.add(sum);
    }
    
    return ans;
    }
}
