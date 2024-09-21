/*
Given an array arr containing n integers and an integer k. Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value k.
*/
class Solution {
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int A[], int N, int K) {
        // Complete the function
       // Map to store the cumulative sum and its first occurrence index
    HashMap<Integer, Integer> sumMap = new HashMap<>();
    int sum = 0; // Cumulative sum
    int maxLength = 0; // To track the maximum length

    for (int i = 0; i < N; i++) {
        sum += A[i]; // Update the cumulative sum

        // Check if the cumulative sum is equal to K
        if (sum == K) {
            maxLength = i + 1; // Update maxLength if the entire subarray from 0 to i sums to K
        }

        // Check if there exists a subarray with sum equal to (sum - K)
        if (sumMap.containsKey(sum - K)) {
            maxLength = Math.max(maxLength, i - sumMap.get(sum - K));
        }

        // Store the first occurrence of the cumulative sum
        if (!sumMap.containsKey(sum)) {
            sumMap.put(sum, i);
        }
    }

    return maxLength; // Return the maximum length found
    }
}
