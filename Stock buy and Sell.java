/*
Given an array arr[] denoting the cost of stock on each day, the task is to find the maximum total profit if we can buy and sell the stocks any number of times.

Note: We can only sell a stock which we have bought earlier and we cannot hold multiple stocks on any day.
*/
class Solution {
    // Function to find the days of buying and selling stock for max profit.
    int stockBuySell(int arr[]) {
        // code here
        int profit = 0;
        
        for(int i=1; i<arr.length; i++){
            
            if(arr[i] > arr[i-1]){
                profit += arr[i] - arr[i-1];
            }
        }
        
        return profit;
    }

}
