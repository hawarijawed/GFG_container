/*
Given a string s, write a program to delete the minimum number of characters from the string so that the resultant string is a palindrome, while maintaining the order of characters.
*/

class Solution {
    static int minDeletions(String s) {
        /*
        Approach: Reverse the given string, and find the Longest Common Subsequence(LCS)
        That LCS will be the length of the palindromic subsequence.
        Then subtract LCS from length of the given string.
        */
        String s2 = reverse(s);
        int matched = LCS(s, s2);
        
        return (s.length() - matched);
    }
    
    //Function to reverse the String
    static String reverse(String st){
        StringBuilder sb = new StringBuilder();
        int n = st.length();
        for(int i=n-1; i>=0; i--){
            sb.append(st.charAt(i));
        }
        
        return sb.toString();
    }
    
    //Function to find Longest Common Subsequenc
    static int LCS(String st1, String st2){
        int n1 = st1.length();
        int n2 = st2.length();
        int[][] dp = new int[n1+1][n2+1];
        dp[0][0] = 0;
        
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(st1.charAt(i-1) == st2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n1][n2];
    }
}
