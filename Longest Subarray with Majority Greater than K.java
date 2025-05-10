/*
Given an array arr[] and an integer k, the task is to find the length of longest subarray in which the count of elements greater than k is more than the count of elements less than or equal to k.
*/

// User function Template for Java
class Solution {
    static int longestSubarray(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        for(int i=0; i<n; i++){
            arr[i] = arr[i]>k?1:-1;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;
        
        for(int i=0; i<n; i++){
            prefixSum += arr[i];
            
            if(prefixSum > 0){
                maxLen = i + 1;
            }
            
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }
            
            if(map.containsKey(prefixSum -1)){
                maxLen = Math.max(maxLen, i - map.get(prefixSum -1));
            }
        }
        
        return maxLen;
    }
}
