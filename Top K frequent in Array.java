/*
Given a non-empty array arr[] of integers, find the top k elements which have the highest frequency in the array. If two numbers have the same frequencies, then the larger number should be given more preference.
*/
class Solution {
    public int[] topK(int k, int[] arr) {
        // Code here
        //Sort the array first
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int a: arr){
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        //Store the hashmap elements to list for sorting
        List<Map.Entry<Integer, Integer>> lst = new ArrayList<>(map.entrySet());
        
        //Clear all the elements from the hashmap
        map.clear();
        
        // Step 3: Sort the list by frequency and then by number (both in descending order)
        lst.sort((entry1, entry2) -> {
            int freqCompare = entry2.getValue().compareTo(entry1.getValue()); // Compare frequencies
            if (freqCompare == 0) {
                return entry2.getKey().compareTo(entry1.getKey()); // Compare numbers if frequencies are the same
            }
            return freqCompare;
        });
        
        // Fill the result array with the top K keys
        int[] res = new int[Math.min(k, lst.size())];
        for (int i = 0; i < res.length; i++) {
            res[i] = lst.get(i).getKey(); // Get the key (element) not the value (frequency)
        }
        
        return res;
    }
}
