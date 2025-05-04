/*
Given a string str, your task is to find the length of the smallest window that contains all the characters of the given string at least once.

*/
class Solution {
    public int findSubString(String str) {
        // code here
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char ch : str.toCharArray()) {
            uniqueChars.add(ch);
        }
        int required = uniqueChars.size();

        HashMap<Character, Integer> windowFreq = new HashMap<>();
        int left = 0, minLen = Integer.MAX_VALUE;
        int formed = 0;

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            windowFreq.put(ch, windowFreq.getOrDefault(ch, 0) + 1);

            // If it's the first occurrence of this character in the window
            if (windowFreq.get(ch) == 1) {
                formed++;
            }
    
            // Try to shrink the window
            while (formed == required) {
                minLen = Math.min(minLen, right - left + 1);
                char leftChar = str.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                if (windowFreq.get(leftChar) == 0) {
                    formed--;
                }
                left++;
            }
        }

        return minLen;
    }
}
