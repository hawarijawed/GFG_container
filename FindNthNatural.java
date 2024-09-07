/*
Given a positive integer n. You have to find nth natural number after removing all the numbers containing the digit 9.
*/
//It is like building a whole new number system where digit 9 does not exist
// User function Template for Java

class Solution {
    long findNth(long n) {
        // code here
        int power = 1;
        int rem = 0;
        long result = 0;
        while(n>0){
            rem = (int)n%9;
            result = result+ (long)rem*power;
            n = n/9;
            power *= 10;
        }
        
        return result;
    }
}
