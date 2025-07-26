/*
You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 

Note: The answer should be returned in an increasing format.
*/

class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()>(n/3)){
                res.add(entry.getKey());
            }
        }
        
        return res;
    }
}


