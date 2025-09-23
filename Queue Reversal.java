/*
Given a queue q containing integer elements, your task is to reverse the queue.
*/

class Solution {
    public void reverseQueue(Queue<Integer> q) {
        // code here
        int n = q.size();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            int val = q.peek();
            q.poll();
            arr[i] = val;
        }
        
        for(int i=0; i<n; i++){
            q.add(arr[n-1-i]);
        }
    }
}
