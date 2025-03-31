/*
Given a string s of lowercase English alphabets, your task is to return the maximum number of substrings formed, after possible partitions (probably zero) of s such that no two substrings have a common character.
*/

class Solution {
    public int maxPartitions(String s) {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int n = s.length();
        
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        
        int res = 0;
        for(int i=0;i<n;i++){
            int idx = map.get(arr[i]);
            int k=i;
            while(k<idx){
                idx = Math.max(idx,map.get(arr[k]));
                k++;
            }
            
            res++;
            i = idx;
        }
        return res;
    }
}
