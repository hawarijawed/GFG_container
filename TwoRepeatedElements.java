/*
You are given an integer n and an integer array arr of size n+2. All elements of the array are in the range from 1 to n. Also, all elements occur once except two numbers which occur twice. Find the two repeating numbers.
Note: Return the numbers in their order of appearing twice. So, if x and y are repeating numbers, and x's second appearance comes before the second appearance of y, then the order should be (x, y).
*/
// User function template for JAVA

class Solution {
    // Function to find two repeated elements.
    public int[] twoRepeated(int n, int arr[]) {
        // Your code here
        int []arr1 = new int[2];
        int j = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            int a = arr[i];
            if(set.contains(a)){
                arr1[j] = a;
                j++;
            }
            else{
                set.add(a);
            }
        }
        
        return arr1;
    }
}
