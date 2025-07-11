/*
Given an integer n, the task is to count the number of binary strings of length n that contains at least one pair of consecutive 1's.
Note: A binary string is a sequence made up of only 0's and 1's.
*/

class Solution {
    public int countConsec(int n) {
        // code here
        int ans = (int)Math.pow(2, n) - fib(n+2);
        return ans;
    }
    
    public int fib(int n) {
        if(n<=1) return n;
        int num1 = 0;
        int num2 = 1;
        int ans = 0;
        for(int i=1; i<n; i++){
            ans = num1 + num2;
            num1 = num2;
            num2 = ans;
        }
        return ans;
    }
}
