/*
Given an array of strings words[]. Find the longest string in words[] such that every prefix of it is also present in the array words[]. 

Note: If multiple strings have the same maximum length, return the lexicographically smallest one.
*/

class Solution {
    public String longestString(String[] words) {
        // code here
        Arrays.sort(words, (a, b) ->{
            if(a.length() != b.length()){
                return a.length() - b.length();
            }
            else{
                return a.compareTo(b);
            }
        });
        
        HashSet<String> build = new HashSet<>();
        String result = "";
        for(String word: words){
            if(word.length() == 1 || build.contains(word.substring(0, word.length()-1))){
                build.add(word);
                if(word.length() > result.length() 
                || word.length() == result.length()
                && word.compareTo(result)<0){
                    result = word;
                }
            }
        }
        return result;
    }
}
