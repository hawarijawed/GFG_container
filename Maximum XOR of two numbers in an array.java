/*
Given an array arr[] of non-negative integers of size n. Find the maximum possible XOR between two numbers present in the array.
*/

// User function Template for Java
class TrieNode {
    TrieNode[] children = new TrieNode[2]; // 0 and 1
}
class Solution {
    TrieNode root = new TrieNode();

    // Insert number into the Trie
    private void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) { // 32-bit integer
            int bit = (num >> i) & 1;
            if (node.children[bit] == null)
                node.children[bit] = new TrieNode();
            node = node.children[bit];
        }
    }
    
    private int findMaxXor(int num) {
        TrieNode node = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            // Try to find opposite bit for max XOR
            if (node.children[1 - bit] != null) {
                maxXor |= (1 << i);
                node = node.children[1 - bit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXor;
    }

    
    public int maxXor(int[] arr) {
        // code here
        int max = 0;
        for (int num : arr) {
            insert(num);
        }
        for (int num : arr) {
            max = Math.max(max, findMaxXor(num));
        }
        return max;
    
    }
}
