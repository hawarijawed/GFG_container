/*
Given an integer array arr[] sorted in ascending order, along with three integers: A, B, and C. The task is to transform each element x in the array using the quadratic function A*(x2) + B*x + C. 
After applying this transformation to every element, return the modified array in sorted order.

*/

class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        // Code here
        int n = arr.length;
        int res[] = new int [n];
        int left = 0, right = n-1;
        int index = A >= 0?n-1:0;
        
        while(left <= right){
            int leftVal = (A*(int)Math.pow(arr[left], 2)) + (B*arr[left]) + C;
            int rightVal = (A*(int)Math.pow(arr[right], 2)) + (B*arr[right]) + C;
            
            if(A >= 0){
                if(leftVal > rightVal){
                    res[index--] = leftVal;
                    left++;
                }
                else{
                    res[index--] = rightVal;
                    right--;
                }
            }
            else{
                if(leftVal < rightVal){
                    res[index++] = leftVal;
                    left++;
                }
                else{
                    res[index++] = rightVal;
                    right--;
                }
            }
        }
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=0; i<n; i++){
            lst.add(res[i]);
        }
        return lst;
    }
}
