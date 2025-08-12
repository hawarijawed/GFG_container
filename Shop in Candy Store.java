/*
In a candy store, there are different types of candies available and prices[i] represent the price of  ith types of candies. You are now provided with an attractive offer.
For every candy you buy from the store, you can get up to k other different candies for free. Find the minimum and maximum amount of money needed to buy all the candies.
Note: In both cases, you must take the maximum number of free candies possible during each purchase.
*/

class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        int candies = prices.length; 
        int n = prices.length;
        Arrays.sort(prices);
        int minAmount = 0;
        int maxAmount = 0;
        int i=0;
        while(candies > 0 && i < n){
            minAmount += prices[i];
            candies = candies - 1 - k;
            i = i + 1;
        }
        
        candies = n;
        i = n-1;
        while(candies > 0 && i >= 0){
            maxAmount += prices[i];
            candies = candies - 1 - k;
            i = i-1;
        }
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(minAmount);
        lst.add(maxAmount);
        return lst;
    }
    
}

/*
price: 1 2 3 4 
k = 2
i=0 
0  
*/
