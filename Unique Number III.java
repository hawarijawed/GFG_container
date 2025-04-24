/*
Given an array of integers arr[] where, every element appears thrice except for one which occurs once.
Find that element which occurs once.
*/
class Solution {
    public int getSingle(int[] arr) {
        // code here
        int res = 0;
        for(int i=0; i<32; i++){
            int bit_sum = 0;
            for(int val: arr){
                if(((val >> i) & 1) == 0){
                    bit_sum += 1;
                }
            }
            
            if(bit_sum%3 == 0){
                if(i==31){
                    res -= (1 << i);
                }
                else{
                    res |= (1<<i);
                }
            }
        }
        
        return res;
    }
}
