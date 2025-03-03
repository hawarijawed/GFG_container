/*
Given an array of positive integers arr[] and a non-negative integer x, the task is to find the longest sub-array where the absolute difference between any two elements is not greater than x.
If multiple such subarrays exist, return the one that starts at the smallest index.
*/
class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        int n = arr.length;
        if (n == 0) {
            return new ArrayList<>(); // return empty list if input is empty
        }
        
        int left = 0, right = 0;
        int start = 0, maxLength = 0;
        
        // Deque to maintain the maximum and minimum of the current window
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        
        // Traverse the array with the right pointer
        while (right < n) {
            // Maintain the maximum deque
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);
            
            // Maintain the minimum deque
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);
            
            // If the condition is violated, move the left pointer
            while (arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x) {
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                left++;
            }
            
            // Update the result if we have found a longer valid subarray
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
            }
            
            right++;
        }
        
        // Create the result array list
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start; i < start + maxLength; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}
