/*
Given an array of integers arr[], the task is to find the maximum of the minimum values for every possible window size in the array, where the window size ranges from 1 to arr.size().

More formally, for each window size k, determine the smallest element in all windows of size k, and then find the largest value among these minimums where 1<=k<=arr.size().
*/
class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        
        // Arrays to store the previous smaller and next smaller elements for each element
        int[] nextsmaller = new int[n];
        int[] prevsmaller = new int[n];
        
        // Stack for finding previous smaller and next smaller elements
        Stack<Integer> stack = new Stack<>();
        
        // Calculate previous smaller element for each index
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            prevsmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        // Clear the stack to reuse for next smaller elements
        stack.clear();
        
        // Calculate next smaller element for each index
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nextsmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        // Initialize the answer array where we store the maximum values
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, Integer.MIN_VALUE));
        
        // Fill the answer array by finding the maximum for each window size
        for (int i = 0; i < n; i++) {
            int len = nextsmaller[i] - prevsmaller[i] - 1;
            ans.set(len - 1, Math.max(ans.get(len - 1), arr[i]));
        }
        
        // Update the answer array by ensuring that each element is the maximum of all subsequent elements
        for (int i = n - 2; i >= 0; i--) {
            ans.set(i, Math.max(ans.get(i), ans.get(i + 1)));
        }
        
        return ans;
    }
}
