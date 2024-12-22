/*
Given two strings, one is a text string txt and the other is a pattern string pat. The task is to print the indexes of all the occurrences of the pattern string in the text string. Use 0-based indexing while returning the indices. 
Note: Return an empty list in case of no occurrences of pattern.
*/
class Solution {

    public ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();
        
        // Step 1: Compute the longest prefix-suffix (LPS) array for the pattern
        int[] lps = computeLPSArray(pat);
        
        // Step 2: Perform the KMP search
        int i = 0;  // Index for txt
        int j = 0;  // Index for pat
        
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            
            if (j == m) {
                // Pattern found, add the index (0-based indexing)
                res.add(i - j);
                j = lps[j - 1];  // Use the LPS array to avoid unnecessary comparisons
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];  // Use the LPS array to skip characters
                } else {
                    i++;
                }
            }
        }
        
        return res;  // Return the list of found indices (or empty if none found)
    }

    // Compute the Longest Prefix Suffix (LPS) array for pattern
    private int[] computeLPSArray(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int length = 0;  // Length of the previous longest prefix suffix
        int i = 1;
        
        // Build the LPS array
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];  // Try the previous longest prefix suffix
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}