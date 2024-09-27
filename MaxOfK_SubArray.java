/*
Given an array arr[] and an integer k. Find the maximum for each and every contiguous subarray of size k.
*/
// User function template for JAVA
class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        // Your code here
        ArrayList<Integer> maxValues = new ArrayList<>();
        Deque<Integer> deq = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            // Remove indices that are out of the current window
            if (!deq.isEmpty() && deq.peekFirst() < i - k + 1) {
                deq.pollFirst();
            }

            // Remove indices whose values are less than the current element
            while (!deq.isEmpty() && arr[deq.peekLast()] <= arr[i]) {
                deq.pollLast();
            }

            // Add current index to the deque
            deq.offerLast(i);

            // If we've reached at least the first full window
            if (i >= k - 1) {
                maxValues.add(arr[deq.peekFirst()]);
            }
        }

        return maxValues;
    }
}
