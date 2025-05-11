/*
Given an array arr[] of size n, find the sum of the K-th largest sum among all contiguous subarrays. 
In other words, identify the K-th largest sum from all possible subarrays and return it.
*/
class Solution {
    public static int kthLargest(int[] arr, int k) {
        // code here
        int n = arr.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += arr[j];
                if(q.size() < k){
                    q.offer(sum);
                }
                else{
                    if(sum > q.peek()){
                        q.poll();
                        q.offer(sum);
                    }
                }
            }
        }
        
        return q.peek();
    }
}
