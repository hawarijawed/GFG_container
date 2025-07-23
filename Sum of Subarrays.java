/*
Given an array arr[], find the sum of all the subarrays of the given array.

Note: It is guaranteed that the total sum will fit within a 32-bit integer range.
*/
class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int res = 0, n = arr.length;
        for(int i=0;i<n;i++){
            res += arr[i] * (i+1) * (n-i);
        }
        return res;
        
    }
}
