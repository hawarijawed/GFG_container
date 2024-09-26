/*
You are given the heights of consecutive buildings. You can move from the roof of a building to the roof of the next adjacent building. 
You need to find the maximum number of consecutive steps you can put forward such that you gain an increase in altitude with each step.
*/
class Solution {
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public int maxStep(int arr[]) {
        // Your code here
        int max=0;
        int curr=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]){
                curr++;
                
            }else{
                curr=0;
            }
            max=Math.max(curr,max);
        }
        return max;
    }
}
