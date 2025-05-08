/*
Given a sorted array arr[] that represents an Arithmetic Progression (AP) with exactly one missing element, find the missing number.
                                                                                                                                      
Note: An element will always exist that, upon inserting into a sequence forms Arithmetic progression. If the given sequence already forms a valid complete AP, return the (n+1)-th element that would come next in the sequence.
*/

class Solution {
    public int findMissing(int[] arr) {
        // code here
        int a = arr[0];
        int n = arr.length;
        if(n==1) return 2*a;
        int d = arr[1]-arr[0];
        if(2*arr[0]+(arr.length-1)*d != arr[0]+arr[arr.length-1]){
            d = (arr[arr.length-1]-arr[0])/arr.length;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=(a+(i*d))){
                return a+(i*d);
            }
        }
        return a+(arr.length*d);
    }
}
