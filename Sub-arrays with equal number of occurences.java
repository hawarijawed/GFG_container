/*
Given an array arr[] and two integers say, x and y, find the number of sub-arrays in which the number of occurrences of x is equal to the number of occurrences of y
*/
class Solution {

    static int sameOccurrence(int arr[], int x, int y) {
        // write code here
        HashMap<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1); // To handle the case when counts are equal from the start
        int countX = 0, countY = 0;
        int result = 0;

        for (int num : arr) {
            if (num == x) {
                countX++;
            } else if (num == y) {
                countY++;
            }

            // Calculate the current difference
            int difference = countX - countY;

            // Check if this difference has been seen before
            result += countMap.getOrDefault(difference, 0);

            // Update the hashmap with the current difference
            countMap.put(difference, countMap.getOrDefault(difference, 0) + 1);
        }

        return result;
    }
}
