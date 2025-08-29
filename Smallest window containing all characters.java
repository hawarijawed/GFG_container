/*
Given two strings s and p. Find the smallest substring in s consisting of all the characters (including duplicates) of the string p. Return empty string in case no such substring is present.
If there are multiple such substring of the same length found, return the one with the least starting index.
*/

class Solution {
    public static String smallestWindow(String s, String p) {
        // code here
        if(p.length() > s.length()) return "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char ch: p.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        int left = 0, right = 0;
        int required = map.size();
        int formed = 0;

        // Frequency map for current window
        HashMap<Character, Integer> windowCounts = new HashMap<>();

        // Result variables: length, left, right
        int minLen = Integer.MAX_VALUE;
        int start = 0;
    
        while (right < s.length()) {
            char ch = s.charAt(right);
            windowCounts.put(ch, windowCounts.getOrDefault(ch, 0) + 1);

            // If current char's frequency matches the one in pattern
            if (map.containsKey(ch) && windowCounts.get(ch).intValue() == map.get(ch).intValue()) {
                formed++;
            }

            // Try to shrink the window
            while (left <= right && formed == required) {
                // Update minimum window
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);

                if (map.containsKey(leftChar) && windowCounts.get(leftChar).intValue() < map.get(leftChar).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
