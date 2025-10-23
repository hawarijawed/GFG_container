/*
You are given a string s consisting of digits. Perform the following operation repeatedly until the string has exactly two digits:

For each pair of consecutive digits in s, starting from the first digit, calculate a new digit as the sum of the two digits modulo 10.
Replace s with the sequence of newly calculated digits, maintaining the order in which they are computed.
Return true if the final two digits in s are the same; otherwise, return false.
*/
class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder();
        while(s.length() > 2){
            int left=0;
            int right=1;
            while(right < s.length()){
                int ch1 = s.charAt(left) - '0';
                int ch2 = s.charAt(right) - '0';
                char ch = (char)(((ch1 + ch2)%10)+'0');
                sb.append(ch);
                left++;
                right++;
            }
            s = sb.toString();
            sb.setLength(0);
        }

        if(s.length() != 2) return false;

        return s.charAt(0)==s.charAt(1);
    }
}
