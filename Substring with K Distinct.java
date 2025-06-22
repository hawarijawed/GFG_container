/*
Given a string consisting of lowercase characters and an integer k, the task is to count all possible substrings (not necessarily distinct) that have exactly k distinct characters. 
*/
// User function Template for Java

class Solution {
    int atMostCount(String s, int k){
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0, right = 0;
        int count = 0;
        while(right < n){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            if(map.size() > k){
                while(map.size()>k){
                    char leftChar = s.charAt(left);
                    map.put(leftChar, map.get(leftChar)-1);
                    if(map.get(leftChar)==0){
                        map.remove(s.charAt(left));
                    }
                    left++;
                }
            }
            count += right - left + 1;

            right++;
        }
        
        return count;
    }
    int countSubstr(String s, int k) {
        // your code here
        int c1 = atMostCount(s, k);
        int c2 = atMostCount(s, k-1);
        return c1 - c2;
    }
}
