/*
Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose sum is closest to target.
Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.
*/
class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        List<Integer> lst = new ArrayList<>();
        Arrays.sort(arr);
        
  
        int diff = Integer.MAX_VALUE;
        int n = arr.length;
        int st = 0, en = n-1;
        
        while(st< en){
            int val = arr[en] + arr[st];
            
            int currentDiff = Math.abs(target - val);
            if(currentDiff < diff){
                diff = currentDiff;
                lst.clear();
                lst.add(arr[st]);
                lst.add(arr[en]);
            }
            if(val < target){
                st++;
            }
            else if(val > target){
                en--;
            }
            else return lst;
        }
        
        return lst;
    }
}
