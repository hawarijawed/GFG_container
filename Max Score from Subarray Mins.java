/*
You are given an array arr[] of integers. Your task is to find the maximum sum of the smallest and second smallest elements across all subarrays (of size >= 2) of the given array.
*/

class Solution {
    public int maxSum(int arr[]) {
        // code here
         int n = arr.length;
        int ans = 0;
        for(int i=0;i<n-1;i++){
            int sum = arr[i]+arr[i+1];
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
