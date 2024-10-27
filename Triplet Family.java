/*
Given an array arr of integers. Find whether three numbers are such that the sum of two elements equals the third element.
*/
class Solution {
    public boolean findTriplet(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=n-1; i>=0; i--){
            int target = arr[i];
            int end = i-1;
            int st = 0;
            while(st < end){
                if(arr[st] + arr[end] == target){
                    return true;
                }
                else if(arr[st] + arr[end] < target){
                    st++;
                }
                else{
                    end--;
                }
            }
        }
        return false;
    }
}
