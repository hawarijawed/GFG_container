/*
You are given a string s and a list dictionary[] of words. Your task is to determine whether the string s can be formed by concatenating one or more words from the dictionary[].

Note: From dictionary[], any word can be taken any number of times and in any order.
*/
class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }
    // Trie implementation for dictionary words
    private TrieNode buildTrie(String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
            }
            current.isWord = true;
        }
        return root;
    }
    
    // The optimized solve method using Trie
    public int solve(String s, TrieNode trie, int i, int[] dp) {
        if (i == s.length()) return 1;
        if (dp[i] != -1) return dp[i];
        
        TrieNode currentNode = trie;
        
        for (int j = i; j < s.length(); j++) {
            char c = s.charAt(j);
            
            if (!currentNode.children.containsKey(c)) {
                break; // No valid word can be formed beyond this point
            }
            currentNode = currentNode.children.get(c);
            
            if (currentNode.isWord) {
                if (solve(s, trie, j + 1, dp) == 1) {
                    dp[i] = 1;
                    return dp[i];
                }
            }
        }
        
        return dp[i] = 0;
    }

    public boolean wordBreak(String s, String[] dictionary) {
        int n = s.length();
        TrieNode trie = buildTrie(dictionary);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        return solve(s, trie, 0, dp) == 1;
    }
}
