/*
Given a string S consisting of the characters 0, 1 and 2. Your task is to find the length of the smallest substring of string S that contains all the three characters 0, 1 and 2. If no such substring exists, then return -1.
*/
// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        
        HashMap<Character,Integer>map = new HashMap<>();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        
        for(int right=0; right < S.length(); right++){
            char ch = S.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            
            while(map.size()==3){
                char st = S.charAt(left);
                map.put(st, map.get(st)-1);
                if(map.get(st)==0){
                    map.remove(st);
                }
                minLen = Math.min(minLen, right - left + 1);
                left++;
            }
        }
        
        return minLen==Integer.MAX_VALUE?-1:minLen;
        
    }
};
