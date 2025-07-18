/*
Given a number n, find the maximum possible LCM that can be obtained by selecting three numbers less than or equal to n.
Note : LCM stands for Lowest Common Multiple
*/
class Solution {
    int lcmTriplets(int n) {
        // code here
        int maxLcm = 1;
        for(int i=1; i<=n; i++){
            for(int j=i; j<=n; j++){
                for(int k=j; k<=n; k++){
                    int currLCM = lcm(lcm(i, j),k);
                    maxLcm = Math.max(currLCM, maxLcm);
                }
            }
        }
        
        return maxLcm;
    }
    
    int lcm(int a, int b){
        int prod = a*b;
        return prod/gcd(a,b);
    }
    
    //Better Approach
    int lcmTriplets(int n){
        //Base case
        if(n<3) return n;
        //If n is odd then n,n-1, n-3 will have max lcm
        if(n%2 != 0){
            return n*(n-1)*(n-2);
        }
        
        if(gcd(n, n-3) == 1){
            return n*(n-1)*(n-3);
        }
        
        return (n-1)*(n-2)*(n-3);
    }
    int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a, a);
    }
    
    //Pattern based
    int lcmTriplets(int n)
    {
        if(n<3) return n;
        if(n%2 != 0) {
            return n*(n-1)*(n-2);
        }
        
        if(n%3 != 0){
            return n*(n-1)*(n-3);
        }
        
        return (n-1)*(n-2)*(n-3);
    }
}
