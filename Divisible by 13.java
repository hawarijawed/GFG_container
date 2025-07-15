/*
Given a number represented as a string s (which may be very large), check whether it is divisible by 13 or not.
*/

class Solution {
    public boolean divby13(String s) {
        // code here
        int num = 0;
        for(int i=0; i<s.length(); i++){
            int digit = s.charAt(i)-'0';
            num = (num*10 + digit)%13;
        }
        
        if(num == 0){
            return true;
        }
        return false;
    }
}
