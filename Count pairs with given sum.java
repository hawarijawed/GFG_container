/*
Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums up to given target.
*/
class Solution {

    int countPairs(int arr[], int target) {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int count = 0;
        for(int i=0; i<n; i++){
            int val = target - arr[i];
            count += map.getOrDefault(val,0);
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        return count;
    }
}
