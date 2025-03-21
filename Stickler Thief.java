/*
Stickler the thief wants to loot money from the houses arranged in a line. He cannot loot two consecutive houses and aims to maximize his total loot.
Given an array, arr[] where arr[i] represents the amount of money in the i-th house.
Determine the maximum amount he can loot.
*/
class Solution {
    public int findMaxSum(int nums[]) {
        // code here
        int prev2=0;
        int prev=nums[0];
        for(int i=1;i<nums.length;i++){
            int take=nums[i];
            if(i>1)take+=prev2;
            int notTake=0+prev;
            int curr=Math.max(take,notTake);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}
