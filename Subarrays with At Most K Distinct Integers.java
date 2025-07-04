/*
You are given an array arr[] of positive integers and an integer k, find the number of subarrays in arr[] where the count of distinct integers is at most k.

Note: A subarray is a contiguous part of an array.
*/

class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int left = 0, right = 0;
        int res = 0;
        for (right = 0; right < n; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }

            // Count of subarrays ending at right with at most k distinct elements
            res += (right - left + 1);
        }
        
        return res;
    }
}
