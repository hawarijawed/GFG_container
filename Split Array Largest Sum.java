/*
Given an array arr[] and an integer k, divide the array into k contiguous subarrays such that the maximum sum among these subarrays is minimized. Find this minimum possible maximum sum.
*/

class Solution {
    public int splitArray(int[] arr, int k) {
        // code here
        int max = 0, sum = 0;
        for (int num : arr) {
            max = Math.max(max, num);
            sum += num;
        }
        
        int low = max, high = sum;
        int result = sum;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
    
    private boolean isValid(int[] arr, int k, int maxSum) {
        int currentSum = 0;
        int subarrays = 1;
        
        for (int num : arr) {
            if (currentSum + num > maxSum) {
                subarrays++;
                currentSum = num;
                if (subarrays > k) return false;
            } else {
                currentSum += num;
            }
        }
        return true;
    }
};
