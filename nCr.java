/*
Given two integer values n and r, the task is to find the value of Binomial Coefficient nCr

A binomial coefficient nCr can be defined as the coefficient of xr in the expansion of (1 + x)n that gives the number of ways to choose r objects from a set of n objects without considering the order.
The binomial coefficient nCr is calculated as : C(n,r) = n! / r! * (n-r) !
Note: If r is greater than n, return 0.
It is guaranteed that the value of nCr will fit within a 32-bit integer.
*/

class Solution {
    public long factorial(int n){
        if(n==0 || n==1) return 1;
        
        return n*factorial(n-1);
    }
    public int nCr(int n, int r) {
        // code here
        if (r > n) return 0;
        
        // Since C(n, r) = C(n, n-r), calculate the coefficient for the smaller r
        if (r > n - r) r = n - r;
        
        long result = 1;
        
        // Compute C(n, r) directly
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        
        return (int)result;
    }
}
