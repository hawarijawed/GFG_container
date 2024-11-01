/*
Given an array arr[ ] of positive elements. Consider the array as a circular array, meaning the element after the last element is the first element of the array. The task is to find the maximum sum of the absolute differences between consecutive elements with shuffling of array elements allowed i.e. shuffle the array elements and make [a1..an] such order that  |a1 – a2| + |a2 – a3| + …… + |an-1 – an| + |an – a1| is maximized.
*/
class Solution {
    public long maxSum(Long[] arr) {
        // code here
        Arrays.sort(arr);
        long sum = 0;
        int n = arr.length;
        for (int i = 0; i < n/2; i++)
        {
            sum -= (2 * arr[i]);
            sum += (2 * arr[n - i - 1]);
        }
        
        return sum;
    }
}
