/*
Given an array arr. Return the modified array in such a way that if the current and next numbers are valid numbers and are equal then double the current number value and replace the next number with 0. After the modification, rearrange the array such that all 0's are shifted to the end.

Note:

Assume ‘0’ as the invalid number and all others as a valid number.
The sequence of the valid numbers is present in the same order.
*/
// User function Template for Java
class Solution {
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        // Complete the function
        int n = arr.length;
        int left = 0, right = 1;
        
        ArrayList<Integer> lst = new ArrayList<>();
        if(n==1){
            lst.add(arr[0]);
            return lst;
        }
        if(n==2){
            if(arr[0] == arr[1]){
                arr[0] = 2*arr[0];
                arr[1] = 0;
            }
            lst.add(arr[0]);
            lst.add(arr[1]);
            return lst;
        }
        
        while(right < n){
            if(arr[left] == arr[right]){
                arr[left] = 2*arr[left];
                arr[right] = 0;
                left = right+1;
                right = left+1;
            }
            else{
                left++;
                right++;
            }
        }
        int count_0 = 0;
        for(int a: arr){
            if(a==0){
                count_0++;
            }
            
        }
        int ind = 0;
        for(int i=0; i<n; i++){
            if(arr[i] != 0){
                lst.add(arr[i]);
                ind++;
            }
        }
        while(ind<n){
            lst.add(0);
            ind++;
        }
        
        return lst;
        
    }
}
