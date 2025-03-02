/*
Given an array arr[] of integers and an integer k, your task is to find the maximum value for each contiguous subarray of size k. 
The output should be an array of maximum values corresponding to each contiguous subarray.
*/
class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // code here
        int n = arr.length;
        ArrayList<Integer> lst = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        
        // Process the first k elements
        for (int i = 0; i < k; i++) {
            // Remove elements smaller than the current element from the deque
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        
        // Add the maximum of the first window
        lst.add(arr[dq.peek()]);
        
        // Process the rest of the elements
        for (int i = k; i < n; i++) {
            // Remove elements that are out of the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }
            
            // Remove elements smaller than the current element from the deque
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.removeLast();
            }
            
            // Add the current element's index to the deque
            dq.addLast(i);
            
            // Add the maximum of the current window
            lst.add(arr[dq.peek()]);
        }
        
        return lst;
    }
}
