/*
Given an integer array arr[]. Find the contiguous sub-array(containing at least one number) that has the maximum sum and return its sum.
*/
// User function Template for Java
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

        // Your code here
        int max_so_far = arr[0];
        int curr_max = arr[0];
        for(int i=1; i<arr.length; i++){
            curr_max = Math.max(arr[i], curr_max+arr[i]);
            
            max_so_far = Math.max(curr_max, max_so_far);
        }
        
        return max_so_far;
    }
}
