/*
Given an array prices[] of length n, representing the prices of the stocks on different days. The task is to find the maximum profit possible by buying and selling the stocks on different days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then return 0.

Note: Stock must be bought before being sold.
*/
class Solution {
    public int maximumProfit(int prices[]) {
        // Code here
        int buy = prices[0];
        int profit = 0;
        int n = prices.length;
        for(int i=0; i<n; i++){
            int cost = prices[i] - buy;
            profit = Math.max(profit, cost);
            buy = Math.min(prices[i], buy);
        }
        
        return profit;
    }
}
