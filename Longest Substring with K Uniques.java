/*
You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.
Note : If no such substring exists, return -1. 
*/

class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int ans = 0;
        
        while(right < n){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            if(map.size() > k){
                while(map.size()>k){
                    char ch1 = s.charAt(left);
                    map.put(ch1, map.get(ch1)-1);
                    if(map.get(ch1) == 0){
                        map.remove(ch1);
                    }
                    left++;
                }
            }
            
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        if(map.size() < k){
            return -1;
        }
        return ans;
    }
}
