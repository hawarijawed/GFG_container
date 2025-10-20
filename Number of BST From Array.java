/*
You are given an integer array arr[] containing distinct elements.

Your task is to return an array where the ith element denotes the number of unique BSTs formed when arr[i] is chosen as the root.
*/

class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        // Code here
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        int n = arr.length;
        int [] catalan = new int[n];
        catalan = computeCatalan(n);
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=0; i<n; i++){
            int sortedIndx = Arrays.binarySearch(sortedArr, arr[i]);
            int leftSize = sortedIndx;
            int rightSize = n - 1 - sortedIndx;
            lst.add(catalan[leftSize]*catalan[rightSize]);
        }
        
        return lst;
    }
    
    public int[] computeCatalan(int n ){
        int[] res = new int[n+1];
        res[0] = 1;
        
        for(int i=1; i<=n; i++){
            res[i] = 0;
            for(int j=0; j<i; j++){
                res[i] += res[j] * res[i-1-j];
            }
        }
        
        return res;
    }
}
