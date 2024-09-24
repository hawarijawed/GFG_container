class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return "-1";
        }

        Map<Character, Integer> pCount = new HashMap<>();
        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

        int required = pCount.size();
        int left = 0, right = 0;
        int formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (pCount.containsKey(c) && windowCounts.get(c).intValue() == pCount.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = s.charAt(left);
                
                // Update the minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                // Remove the leftmost character from the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (pCount.containsKey(c) && windowCounts.get(c).intValue() < pCount.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            // Expand the window by moving the right pointer
            right++;
        }

        // If we found a valid window, return it; otherwise, return -1
        return minLen == Integer.MAX_VALUE ? "-1" : s.substring(minStart, minStart + minLen);
    }
}
