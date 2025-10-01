/*
Given an array arr[] that may contain duplicates. Find all possible distinct permutations of the array in sorted order.
Note: A sequence A is greater than sequence B if there is an index i for which Aj = Bj for all j<i and Ai > Bi.
*/
class Solution {
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        // code here
        int n = arr.length;
        boolean [] used = new boolean[n];
        Arrays.fill(used, false);
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(res, arr, new ArrayList<>(),  used);
        
        return res;
    }
    
    public static void backtrack(ArrayList<ArrayList<Integer>> res,int[] arr, ArrayList<Integer> lst, boolean[] used){
        if(lst.size() == arr.length){
            res.add(new ArrayList<>(lst));
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            if(used[i]) continue;
            if(i>0 && arr[i] == arr[i-1] && !used[i - 1]) continue;
            
            used[i] = true;
            lst.add(arr[i]);
            backtrack(res, arr, lst, used);
            lst.remove(lst.size()-1);
            used[i] = false;
        }
    }
};
