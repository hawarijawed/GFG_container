/*
You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 

Note: The answer should be returned in an increasing format.
*/
class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        int n=nums.length;
        Arrays.sort(nums);
        int threshold=n/3;
        List<Integer> list=new ArrayList<Integer>();
        int count=1;
        for(int i=1;i<n;i++)
        {
            if(nums[i]==nums[i-1])
            count++;
            else{ 
            if(count>threshold)
            list.add(nums[i-1]);
            count=1;
            }
        }
        if (count > threshold) {
            list.add(nums[n - 1]);
        }
        return list;
        
    }
}
