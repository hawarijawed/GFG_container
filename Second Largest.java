/*
Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.

Note: The second largest element should not be equal to the largest element.
*/
class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int largest = Integer.MIN_VALUE;
        int second_largest = Integer.MIN_VALUE;
        for(int a: arr){
            if(a > largest){
                largest = a;
            }
        }
        
        for(int b: arr){
            if(b > second_largest && b < largest){
                second_largest = b;
            }
        }
        
        return second_largest==Integer.MIN_VALUE?-1:second_largest;
    }
}
