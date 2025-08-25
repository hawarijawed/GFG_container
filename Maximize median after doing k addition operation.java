/*
Given an array arr[] consisting of positive integers and an integer k. You are allowed to perform at most k operations, where in each operation,
you can increment any one element of the array by 1. Determine the maximum possible median of the array that can be achieved after performing at most k such operations.

Note: The median of an array is defined as the middle element when the array (after sorting) has an odd size, or the average of the two middle elements when the array (after sorting) has an even size.
*/

class Solution {
    public int maximizeMedian(int[] arr, int k) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);

        // compute initial median floor if even length
        int iniMedian = arr[n / 2];
        if (n % 2 == 0) {
            iniMedian += arr[n / 2 - 1];
            iniMedian /= 2;
        }

        int low = iniMedian, high = iniMedian + k;
        int bestMedian = iniMedian;

        // binary search to find maximum 
        // achievable median
        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(arr, mid, k)) {
                bestMedian = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return bestMedian;
    }
    
    public boolean isPossible(int[] arr, int target, int k) {
        int n = arr.length;

        if (n % 2 == 1) {
            // for odd-sized array, consider elements from 
            // middle to end
            for (int i = n / 2; i < n; ++i) {
                if (arr[i] < target)
                    k -= (target - arr[i]);
                
                if(k < 0) break;
            }
        } else {
            // for even-sized array, handle two middle 
            // elements separately
            if (arr[n / 2] <= target) {
                k -= (target - arr[n / 2]);
                k -= (target - arr[n / 2 - 1]);
            } else {
                k -= (2 * target - (arr[n / 2] + arr[n / 2 - 1]));
            }
            // process remaining elements to the right
            for (int i = n / 2 + 1; i < n; ++i) {
                if (arr[i] < target)
                    k -= (target - arr[i]);
                
                if(k < 0) break;
            }
        }

        return k >= 0;
    }
    
}
