/*
Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.
*/
class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        
        //Sort the arr based on starting point
        Arrays.sort(arr, (a,b)-> Integer.compare(a[0],b[0]));
        
        List<int[]> lst = new ArrayList<>();
        
        lst.add(arr[0]);
        
        int n = arr.length;
        for(int i=1; i<n; i++){
            int[] curr = lst.get(lst.size()-1);
            
            if(curr[1] >= arr[i][0]){
                curr[1] = Math.max(curr[1], arr[i][1]);
            }
            else
            {
                lst.add(arr[i]);
            }
        }
        
        return lst;
    }
}
