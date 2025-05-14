/*
Given an integer n. Return the nth row of the following look-and-say pattern.
1
11
21
1211
111221
Look-and-Say Pattern:

To generate a member of the sequence from the previous member, read off the digits of the previous member, counting the number of digits in groups of the same digit. For example:

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
1211 is read off as "one 1, one 2, then two 1s" or 111221.
111221 is read off as "three 1s, two 2s, then one 1" or 312211.
*/


class Solution {
    public String countAndSay(int n) {
        // code here
        if(n==1) return "1";
        
        String res = "1";
        for(int j=2; j<=n; j++){
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<res.length(); i++){
                if(res.charAt(i-1) == res.charAt(i)){
                    count++;
                }
                else{
                    char ch = (char)(count + '0');
                    sb.append(ch);
                    sb.append(res.charAt(i-1));
                    count = 1;
                }
            }
            char ch = (char)(count + '0');
            sb.append(ch);
            sb.append(res.charAt(res.length()-1));
            res = sb.toString();
        }
        
        return res;
    }
}
