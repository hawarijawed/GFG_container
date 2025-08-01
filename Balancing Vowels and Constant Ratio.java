/*
You are given an array of strings arr[], where each arr[i] consists of lowercase english alphabets. You need to find the number of balanced strings in arr[] which can be formed by concatinating one or more contiguous strings of arr[].
A balanced string contains the equal number of vowels and consonants. 
*/
class Solution {
    public int countBalanced(String[] arr) {
        // code here
        Map<Integer, Integer> diffCount = new HashMap<>();
        diffCount.put(0, 1); // initial prefix diff 0
        int total = 0;
        int diff = 0;

        for (String s : arr) {
            int vowels = 0, consonants = 0;
            for (char c : s.toCharArray()) {
                if (isVowel(c)) vowels++;
                else consonants++;
            }
            diff += (vowels - consonants);
            total += diffCount.getOrDefault(diff, 0);
            diffCount.put(diff, diffCount.getOrDefault(diff, 0) + 1);
        }

        return total;
    }
    
    public boolean isVowel(char c){
        return "aeiou".indexOf(c) != -1;
    }
}
