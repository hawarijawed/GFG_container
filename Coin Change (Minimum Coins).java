/*
You are given an array coins[], where each element represents a coin of a different denomination, and a target value sum. 
You have an unlimited supply of each coin type {coins1, coins2, ..., coinsm}.

Your task is to determine the minimum number of coins needed to obtain the target sum. If it is not possible to form the sum using the given coins, return -1.
*/
int[] dp = new int[sum+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int coin : coins)
        {
            for(int j=coin;j<=sum;j++)
            {
                if(dp[j-coin]!=Integer.MAX_VALUE)
                {
                    dp[j] = Math.min(dp[j],1+dp[j-coin]);
                }
            }
        }
        return dp[sum]==Integer.MAX_VALUE?-1:dp[sum];
