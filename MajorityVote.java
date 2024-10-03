/*
You are given an array of integer nums[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return -1. 
Note: The answer should be returned in an increasing format.
*/

class Solution {
    // Function to find the majority elements in the array
    // Time Complexity: O(nlogn + n)
    // Space Complexity: O(n) only for hashmap, 
    public List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here.
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.size();
        int m = n/3;
        Collections.sort(nums);
        for(int i=0; i<n; i++){
            int temp = nums.get(i);
            
            map.put(temp, map.getOrDefault(temp,0)+1);
            
            if(map.get(temp) > m){
                
                if(list.isEmpty()){
                    list.add(temp);
                }
                else{
                    if(temp != list.get(list.size()-1)){
                        list.add(temp);
                    }
                }
            }
        }
        
        if(list.size() != 0){
            return list;
        }
        list.add(-1);
        
        return list;
    }
}
