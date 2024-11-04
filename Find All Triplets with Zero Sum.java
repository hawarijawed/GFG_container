/*
Given an array arr[], find all possible indices [i, j, k] of triplets [arr[i], arr[j], arr[k]] in the array whose sum is equal to zero. 
Return indices of triplets in any order and all the returned triplets indices should also be internally sorted, i.e., for any triplet indices [i, j, k], the condition i < j < k should hold.

Note: Try to solve this using the O(n2) approach.
*/
class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
         List<List<Integer>> answer = new ArrayList<>();

        for (int i =0;i< arr.length;i++)
        {
            Map<Integer,List<Integer>> map = new HashMap<>();
            for (int j = i+1; j< arr.length;j++){
                int sum = (arr[i] + arr[j]) * -1;

                if(map.containsKey(sum)) {
                    for (int k : map.get(sum)) {
                        List<Integer> ans = new ArrayList<>(Arrays.asList(i,j,k));
                        Collections.sort(ans);
                        answer.add(ans);
                    }
                }
                map.putIfAbsent(arr[j],new ArrayList<>());
                map.get(arr[j]).add(j);
            }
        }
        
        return answer;
    }
}
