/*
Given an array of integers arr, the task is to find and return the maximum sum of the smallest and second smallest element among all possible subarrays of size greater than one. 
If it is not possible, then return -1.

Approach______________
1. Maintain a sub array of size 2
2. calculate the sum of sub array
3. keep the max sum updated with the maximum sum value
4. return the max sum
*/
class Solution {
    public int pairWithMaxSum(int[] arr) {
        // code here
        int max_sum = -1;
        int size = arr.length;
        if(size == 1){
            return max_sum;
        }
        
        int left = 0;
        int right = 1;
        while(left < right && right < size){
            int sum = arr[left] + arr[right];
            max_sum = Math.max(max_sum, sum);
            left++;
            right++;
        }
        
        return max_sum;
    }
}
