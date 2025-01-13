/*
Given an array arr[] of non-negative integers, where each element arr[i] represents the height of the vertical lines, find the maximum amount of water that can be contained between any two lines, together with the x-axis.

Note: In the case of a single vertical line it will not be able to hold water.
*/
class Solution {

    public int maxWater(int arr[]) {
        // Code Here
        int water = 0;
        int n = arr.length;
        int i=0, j = n-1;
        while(i < j){
            int area = Math.min(arr[i], arr[j]) *(j-i);
            water = Math.max(water, area);
            if(arr[i] <= arr[j]){
                i++;
            }
            else{
                j--;
            }
        }
        
        return water;
    }
}
