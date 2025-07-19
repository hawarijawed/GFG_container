/*
You are given a lowercase string s, determine the total number of distinct strings that can be formed using the following rules:

Identify all unique vowels (a, e, i, o, u) present in the string.
For each distinct vowel, choose exactly one of its occurrences from s. If a vowel appears multiple times, each occurrence represents a unique selection choice.
Generate all possible permutations of the selected vowels. Each unique arrangement counts as a distinct string.
Return the total number of such distinct strings.
*/

class Solution {
    public int vowelCount(String s) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        String vowels = "aeiou";
        
        for(char c : s.toCharArray()){
            int index = vowels.indexOf(c);
            if(index != -1){
                map.put(c, map.getOrDefault(c, 0)+1);
            }
        }
        
        int choice = 1;
        if(map.size()==0) return 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            choice *= entry.getValue();
        }
        
        int distinct = map.size();
        
        return fact(distinct)*choice;
    }
    
    public int fact(int n){
        if(n <2) return 1;
        int res = 1;
        for(int i=n; i>=1; i--){
            res *=i;
        }
        return res;
    }
}
 
