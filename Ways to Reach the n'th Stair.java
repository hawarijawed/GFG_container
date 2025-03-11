/*
There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. 
Your task is to count the number of ways, the person can reach the top (order does matter).
*/
class Solution {
   
    int countWays(int n) {
        // your code here
        if(n<=2) return n;
        int first = 1;
        int second = 2;
        int total = 0;
        for(int i=3; i<=n; i++){
            total = first + second;
            first = second;
            second = total;
        }
        
        return total;
    }
}
