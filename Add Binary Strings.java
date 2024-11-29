/*
Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
Note: The input strings may contain leading zeros but the output string should not have any leading zeros.
*/
class Solution {
    public String helper(String st){
        String result = st.replaceAll("^0+", "");
        return result.isEmpty() ? "0" : result;
    }
    public String addBinary(String s1, String s2) {
        // code here
        int n1 = s1.length();
        int n2 = s2.length();
        
        int i=0;
        StringBuilder sb = new StringBuilder();
        int sum = 0, carry = 0;
        for(i=0; i<Math.min(n1, n2); i++){
            char ch1 = s1.charAt(n1-1-i);
            char ch2 = s2.charAt(n2-1-i);
            
            sum = (ch1-'0') + (ch2-'0') + carry;
            carry = sum/2;
            char ch = (char)((sum%2)+'0');
            sb.append(ch);
        }
        
        while(i<n1){
            char ch1 = s1.charAt(n1-1-i);
            sum = (ch1-'0') + carry;
            carry = sum/2;
            char ch = (char)((sum%2)+'0');
            sb.append(ch); 
            i++;
        }
        while(i<n2){
            char ch2 = s2.charAt(n2-1-i);
            sum = (ch2-'0') + carry;
            carry = sum/2;
            char ch = (char)((sum%2)+'0');
            sb.append(ch);
            i++;
        }
        if(carry > 0){
            sb.append(carry);
        }
        return helper(sb.reverse().toString());
    }
}
