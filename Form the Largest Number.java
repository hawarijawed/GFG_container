/*
Given an array of integers arr[] representing non-negative integers, arrange them so that after concatenating all of them in order, it results in the largest possible number. Since the result may be very large, return it as a string.

*/
class Solution {
    public String findLargest(int[] arr) {
        // code here
        // Convert the int[] to a String[] for custom sorting
        String[] strArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }

        // Sort with a custom comparator
        Arrays.sort(strArr, new Comparator<String>() {
            public int compare(String a, String b) {
                // Compare concatenated strings
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // descending order
            }
        });

        // Edge case: if the largest number is 0, the entire number is 0
        if (strArr[0].equals("0")) {
            return "0";
        }

        // Build the largest number
        StringBuilder largestNumber = new StringBuilder();
        for (String s : strArr) {
            largestNumber.append(s);
        }

        return largestNumber.toString();
    }
}
