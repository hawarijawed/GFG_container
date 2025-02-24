/*
The stock span problem is a financial problem where we have a series of daily price quotes for a stock and we need to calculate the span of stock price for all days. 
The span arr[i] of the stocks price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on 
the given day is less than or equal to its price on the current day.
*/
class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            // Pop elements from the stack while they are smaller than the current element
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            
            // If the stack is empty, the span is i+1 (all previous elements are smaller)
            if (s.isEmpty()) {
                ans.add(i + 1);
            } else {
                // The span is the difference between current index and the index of last greater element
                ans.add(i - s.peek());
            }
            
            // Push current index to the stack
            s.push(i);
        }
        
        return ans;
    }
}
