/*
You are given an array of words where each word consists of lowercase English letters.
wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB. For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".

A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k = 1.

Return the length of the longest possible word chain with words chosen from the given list of words in any order.
*/
class Solution {
    public int longestStringChain(String words[]) {
        // code here
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        Map<String, Integer> dp = new HashMap<>();
        int longestChain = 1;  // Minimum chain length is 1 (just the word itself).
        
        // Step 3: Traverse all words
        for (String word : words) {
            dp.put(word, 1);  // Each word itself forms a chain of length 1.
            
            // Step 4: Try to form a predecessor by removing one character at a time
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                
                // If the predecessor exists, try to extend the chain.
                if (dp.containsKey(predecessor)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(predecessor) + 1));
                }
            }
            
            // Step 5: Update the result with the longest chain length.
            longestChain = Math.max(longestChain, dp.get(word));
        }
        
        return longestChain;
    }
}
