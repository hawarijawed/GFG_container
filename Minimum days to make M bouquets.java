/*
You have a row of flowers, where each flower blooms after a specific day. The array arr[] represents the blooming schedule: arr[i] is the day the flower at position i will bloom. To create a bouquet, you need to collect k adjacent bloomed flowers. 
Each flower can only be used in one bouquet.

Your goal is to find the minimum number of days required to make exactly m bouquets. If it is not possible to make m bouquets with the given arrangement, return -1.
*/
class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        //base case if there are not enough flowers
        if(m*k > arr.length) return -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int val: arr){
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        
        int count = 0;
        int bouquets = 0; 
        int res = Integer.MAX_VALUE;
        while(min <= max){
            int day = min + (max - min)/2;
            for(int flower=0; flower<arr.length; flower++){
                if(day < arr[flower]){
                    bouquets += count/k;
                    count=0;
                }
                else{
                    count++;
                }
            }
            bouquets += count/k;
            count=0;
            if(bouquets >= m){
                res = Math.min(day, res);
                max = day - 1;
            }
            else{
                min = day + 1;
            }
            bouquets = 0;
            
        }
        
        return res!=Integer.MAX_VALUE?res:-1;
    }
}
