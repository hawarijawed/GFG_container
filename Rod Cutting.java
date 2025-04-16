/*
Given a rod of length n(size of price) inches and an array of prices, price. price[i] denotes the value of a piece of length i. 
Determine the maximum value obtainable by cutting up the rod and selling the pieces.
*/

// Recursive Approach
//Note: It may result in Time Limit Exceed error
class Solution {
    public int cutRod(int[] price) {
        // code here
        int N = price.length;
        
        return recur(N, N-1, price);
    }
    
    public int recur(int N, int ind, int []price){
        //Base case
        if(ind == 0){
            return N*price[ind];
        }
        
        //Apply pick & noPick logic
        int pick = 0;
        int currLength = ind + 1; //Current length of the rod
        
        if(N >= currLength){
            pick = price[ind] + recur(N-currLength, ind,price);
        }
        
        int no_pick = 0 + recur(N, ind -1, price);
        
        return Math.max(pick, no_pick);
    }
}

// //Top-down dp
class Solution {
    public int cutRod(int[] price) {
        // This problem based on two variables i.e Length of rod, and Index
        int N = price.length;
        int dp[][] = new int[N][N+1]; //N->Rod's Length, N+1->Price of at
        for(int i=0; i<N; i++){
            for(int j=0; j<=N; j++){
                dp[i][j] = -1;
            }
        }
        
        return recur(N, N-1, price, dp);
    }
    
    public int recur(int N, int ind, int [] price, int [][]dp){
        
        //Base case
        if(ind == 0){
            dp[ind][N] = N*price[0];
            return dp[ind][N];
        }
        
        if(dp[ind][N] != -1) return dp[ind][N];
        
        //Pick & No_Pick logic
        int pick = 0;
        int currLength = ind+1;
        if(N >= currLength){
            pick = price[ind] + recur(N - currLength, ind, price, dp);
        }
        
        int noPick = 0 + recur(N, ind-1, price, dp);
        dp[ind][N] = Math.max(pick, noPick);
        
        return dp[ind][N];
    }
}

// Bottom-up/Tabulation
class Solution {
    public int cutRod(int[] price) {
        // 
        int N = price.length;
        int dp[][] = new int[N][N+1];// [index][rod length]
        
        //when index = 0,
        for(int i=0; i<=N; i++){
            dp[0][i] = i*price[0];
        }
        
        for(int ind = 1; ind < N; ind++){
            for(int n =0; n <=N; n++){
                //Pick & noPick logic
                int pick = 0;
                int currLength = ind +1;
                if(n >= currLength){
                    pick = price[ind] + dp[ind][n - currLength];
                }
                
                int noPick = 0 + dp[ind-1][n];
                
                dp[ind][n] = Math.max(pick, noPick);
            }
        }
        
        return dp[N-1][N];
    }
}

