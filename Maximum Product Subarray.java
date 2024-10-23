/*
Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr.

Note: It is guaranteed that the output fits in a 64-bit integer.
*/
class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr) {
        // code here
        long max = arr[0];
        long min = arr[0];
        long res = arr[0];
        for(int i=1; i<arr.length; i++){
            
            long temp1 = arr[i]*max;
            long temp2 = arr[i]*min;
            max = Math.max(temp1, temp2);
            max = Math.max(max, arr[i]);
            min = Math.min(temp1, temp2);
            min = Math.min(min, arr[i]);
            res = Math.max(res, max);
            if(arr[i] == 0){
                max = 1;
                min = 1;
                continue;
            }
        }
        
        return res;
    }
}
