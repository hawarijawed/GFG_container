/*
Given an array arr[] of positive integers and an integer k. You have to find the sum of the modes of all the subarrays of size k.
Note: The mode of a subarray is the element that occurs with the highest frequency. If multiple elements have the same highest frequency, the smallest such element is considered the mode.
*/

import java.util.*;

class Solution {
    public int sumOfModes(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>(); // element -> count
        TreeMap<Integer, TreeSet<Integer>> countToElements = new TreeMap<>(); // count -> sorted set of elements
        
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            
            // Add current number to frequency map
            int oldCount = freq.getOrDefault(num, 0);
            int newCount = oldCount + 1;
            freq.put(num, newCount);
            
            // Update countToElements
            if (oldCount > 0) {
                TreeSet<Integer> oldSet = countToElements.get(oldCount);
                oldSet.remove(num);
                if (oldSet.isEmpty()) {
                    countToElements.remove(oldCount);
                }
            }
            countToElements.computeIfAbsent(newCount, x -> new TreeSet<>()).add(num);

            // Remove the element that slides out of the window
            if (i >= k) {
                int out = arr[i - k];
                int countOutOld = freq.get(out);
                int countOutNew = countOutOld - 1;
                
                freq.put(out, countOutNew);
                TreeSet<Integer> setOutOld = countToElements.get(countOutOld);
                setOutOld.remove(out);
                if (setOutOld.isEmpty()) {
                    countToElements.remove(countOutOld);
                }
                if (countOutNew > 0) {
                    countToElements.computeIfAbsent(countOutNew, x -> new TreeSet<>()).add(out);
                } else {
                    freq.remove(out);
                }
            }

            // When we have a full window, get the mode and add it to sum
            if (i >= k - 1) {
                int maxFreq = countToElements.lastKey();
                int mode = countToElements.get(maxFreq).first(); // smallest element with max freq
                sum += mode;
            }
        }

        return sum;
    }
}
