/*
Given a string s consisting only lowercase alphabets and an integer k. Find the count of all substrings of length k which have exactly k-1 distinct characters.
*/

class Solution {
    public int substrCount(String s, int k) {
        
        if (s.length() < k) return 0;

        int[] freq = new int[26];
        int distinct = 0;
        int countTwo = 0;
        int res = 0;
        int n = s.length();

        for (int i = 0; i < k; i++) {
            int idx = s.charAt(i) - 'a';
            if (freq[idx] == 0) distinct++;
            freq[idx]++;
            if (freq[idx] == 2) countTwo++;
            else if (freq[idx] == 3) countTwo--; // prevent counting >2
        }

        if (distinct == k - 1 && countTwo == 1) res++;

        for (int i = k; i < n; i++) {
            // Remove s.charAt(i - k)
            int leftChar = s.charAt(i - k) - 'a';
            if (freq[leftChar] == 2) countTwo--;
            else if (freq[leftChar] == 3) countTwo++; // undo overcounting
            freq[leftChar]--;
            if (freq[leftChar] == 0) distinct--;

            // Add s.charAt(i)
            int rightChar = s.charAt(i) - 'a';
            if (freq[rightChar] == 0) distinct++;
            freq[rightChar]++;
            if (freq[rightChar] == 2) countTwo++;
            else if (freq[rightChar] == 3) countTwo--; // ignore >2

            // Check if valid
            if (distinct == k - 1 && countTwo == 1) res++;
        }

        return res;
    }
}
