/*
Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.

Note: The final output will be in lexicographic order.
*/
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
       ArrayList<ArrayList<String>> lst = new ArrayList<>();
       HashMap<String, ArrayList<String>> map = new HashMap<>();
       
       int n = arr.length;
       for(int i=0; i<n; i++){
           char ch[] = arr[i].toCharArray();
           Arrays.sort(ch);
           String st = new String(ch);
           map.putIfAbsent(st, new ArrayList<>());
           
           map.get(st).add(arr[i]);
       }
       
       for(Map.Entry<String, ArrayList<String>> entry: map.entrySet()){
           lst.add(entry.getValue());
       }
       
       return lst;
    }
}
