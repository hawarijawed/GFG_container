/*
Implement Trie class and complete insert(), search() and isPrefix() function for the following queries :

Type 1 : (1, word), calls insert(word) function and insert word in the Trie
Type 2 : (2, word), calls search(word) function and check whether word exists in Trie or not.
Type 3 : (3, word), calls isPrefix(word) function and check whether word exists as a prefix of any string in Trie or not.
Examples :


*/
class Trie {

    private class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        
        TrieNode(){
            children=new TrieNode[26];
            isEnd=false;
        }
    }
    
    private TrieNode root;
    public Trie() {
        // Implement Trie
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        var curr=root;
        for(int k=0;k<word.length();k++){
            char c = word.charAt(k);
            int i=c-'a';
            if(curr.children[i]==null){
                curr.children[i]=new TrieNode();
            }
            
                curr=curr.children[i];
        }
        
        curr.isEnd=true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        var curr=root;
        for(int k=0;k<word.length();k++){
            char c = word.charAt(k);
            int i=c-'a';
            if(curr.children[i]==null) return false;
            curr=curr.children[i];
        }
        return curr.isEnd;
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        var curr=root;
        for(int k=0;k<word.length();k++){
            char c = word.charAt(k);
            int i=c-'a';
            if(curr.children[i]==null) return false;
            curr=curr.children[i];
        }
        return true;
    }
}
