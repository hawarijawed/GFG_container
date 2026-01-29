/*
Given a string s consisting of only lowercase alphabets, for each index i in the string (0 ≤ i < n), find the first non-repeating character in the prefix s[0..i]. If no such character exists, use '#'.
*/
class Solution {
    public String firstNonRepeating(String s) {
        // code here
        int[] freq = new int[26];           // frequency of characters
        Queue<Character> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;                // update frequency
            q.offer(c);                     // add to queue

            // remove repeating characters from front
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            // append result
            if (q.isEmpty()) {
                result.append('#');
            } else {
                result.append(q.peek());
            }
        }

        return result.toString();
    }
}
