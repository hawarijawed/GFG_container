/*
Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.
NOTE: Prefix and suffix can be overlapping but they should not be equal to the entire string
*/
class Solution {
    int lps(String str) {
        int[] A = new int[str.length()]; 
        int j = 0, i = 1; 
        while(i < str.length()) 
        { 
            if(str.charAt(i) == str.charAt(j)) 
            { 
                A[i] = j+1; 
                j++; 
                i++; 
            } 
            else
            { 
                if(j==0) 
                    i++; 
                else
                    j = A[j-1]; 
                  
            } 
        } 
  
        return A[str.length()-1]; 
    }
}
