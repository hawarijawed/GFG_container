// User function Template for Java
/*
Given an array nums[], construct a Product Array nums[] such that nums[i] is equal to the product of all the elements of nums except nums[i].
*/
class ProductArray {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        
        int size = nums.length;
      
        if(size == 2){
            return new long[]{nums[1], nums[0]};
        }
        long left[] = new long [size];
        long right[] = new long[size];
        long prod[] = new long[size];
        
        left[0] = 1;
        right[size-1] = 1;
        
        for(int i=1;i<size;i++){
            left[i] = left[i-1]*nums[i-1];
        }
        
        for(int i = size-2;i>=0;i--){
            right[i] = right[i+1]*nums[i+1];
        }
        
        for(int i=0; i<size; i++){
            prod[i] = left[i] * right[i];
        }
        
        return prod;
    }
}
