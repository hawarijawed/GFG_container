/*
Given an array arr[] containing 2*n + 2 positive numbers, out of which 2*n numbers exist in pairs whereas the other two number occur exactly once and are distinct. Find the other two numbers. 
Return the answer in increasing order.
*/
class Solution {
    public int[] singleNum(int[] arr) {
        // Code here
        int xor = 0;
        for(int val: arr){
            xor ^= val;
        }
        
        int elem1 =0, elem2 =0;
        int set_bit = xor & -xor;
        for(int val: arr){
            if((val & set_bit) == 0){
                elem1 ^= val;
            }
            else{
                elem2 ^= val;
            }
        }
        
        if(elem1 < elem2){
            return new int[]{elem1, elem2};
        }
        
        return new int[]{elem2, elem1};
    }
}
