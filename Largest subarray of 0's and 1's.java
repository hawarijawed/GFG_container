/*
Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.
*/
class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        int ans=0;
        Map<Integer, Integer> hm=new HashMap<>();
        hm.put(0, -1);
        int p0=0, p1=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                p0++;
            }
            else p1++;
            if(hm.containsKey(p0-p1)){
                ans=Math.max(ans, i-hm.get(p0-p1));
            }
            else hm.put(p0-p1, i);
            
        }
        return ans;
    }
}
