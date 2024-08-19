/*
Given an array arr[ ] of n elements, the task is to find the next greater element for each element of the array in order of their appearance in the array. Next greater element of an element in the array is the nearest element on the right which is greater 
than the current element.

If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.
*/

class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        if(n==1){
            return new long[]{-1};
        }
        
        
        Stack<Long> stack = new  Stack<>();
        //Absolute case
        stack.push(arr[n-1]);
        arr[n-1] = -1;
        
        for(int i = n-2; i>=0; i--){
            long temp = arr[i];
            
            //Keep popping element from stack until temp < stack.pop() found
            while(!stack.isEmpty() && temp >= stack.peek()){
                stack.pop();
            }
            //If stack is empty\
            if(stack.isEmpty()){
                arr[i] = -1;
            }else{
                arr[i] = stack.peek();
            }
            //Push the current element into stack
            stack.push(temp);
        }
        
        return arr;
    } 
}
