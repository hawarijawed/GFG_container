/*
Given a circular integer array arr[], the task is to determine the next greater element (NGE) for each element in the array.

The next greater element of an element arr[i] is the first element that is greater than arr[i] when traversing circularly. If no such element exists, return -1 for that position.

Circular Property:

Since the array is circular, after reaching the last element, the search continues from the beginning until we have looked at all elements once.
*/

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=n-2; i>=0; i--){
            stack.push(arr[i]);
        }
        
        int[] res = new int[n];
        
        for(int i=n-1; i>=0; i--){
            if(arr[i] < stack.peek()){
                res[i] = stack.peek();
                stack.push(arr[i]);
            }
            else{
                while(!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
                
                if(stack.isEmpty())
                {
                    res[i] = -1;
                }
                else{
                    res[i] = stack.peek();
                }
                stack.push(arr[i]);
            }
        }
        ArrayList<Integer> lst = new ArrayList<>();
        for(int val: res){
            lst.add(val);
        }
        
        return lst;
    }
}
