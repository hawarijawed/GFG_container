/*
Given an array arr[] consisting of positive integers, your task is to find the length of the longest subarray that contains at most two distinct integers.
*/

class Solution {
    public int totalElements(int[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        if(n==1) return 1;
        int left = 0, right = 0;
        int ans = 0;
        while(right < n){
            map.put(arr[right], map.getOrDefault(arr[right], 0)+1);
            
            if(map.size() > 2){
                while(map.size()>2){
                    map.put(arr[left], map.get(arr[left])-1);
                    if(map.get(arr[left]) == 0){
                        map.remove(arr[left]);
                    }
                    left++;
                }
            }
            
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
