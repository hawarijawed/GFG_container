/*
Given a non-negative number represented as a list of digits, add 1 to the number (increment the number represented by the digits). The digits are stored such that the most significant digit is first element of array.
*/
class Solution {
    static ArrayList<Integer> increment(ArrayList<Integer> arr , int N) {
        // code here
        int index = arr.size()-1;
        // Increment the last digit and handle carry
        while (index >= 0) {
            if (arr.get(index) < 9) {
                arr.set(index, arr.get(index) + 1);
                return arr; // No carry, so return early
            }
            arr.set(index, 0); // Set current to 0 if it's 9 (carry)
            index--;
        }
        
        // If we exit the loop, it means we had a carry beyond the most significant digit
        arr.add(0, 1); // Add 1 at the start
        return arr;
}
}
