/*
Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get if we assume the array to be circular.
*/
class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    
    public int circularSubarraySum(int arr[]) {
        int n = arr.length;

        int maxKadane = kadane(arr);

        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i];
        }

        int minSubarraySum = -kadane(arr);

        for (int i = 0; i < n; i++) {
            arr[i] = -arr[i];
        }

        int maxCircular = totalSum - minSubarraySum;

        if (maxCircular == 0) {
            return maxKadane;
        }

        return Math.max(maxKadane, maxCircular);
    }

    private int kadane(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : arr) {
            sum = Math.max(num, sum + num);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
