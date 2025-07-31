/*
You are given a 2D integer array intervals[][] of length n, where each intervals[i] = [start, end] represents a closed interval (i.e., all integers from start to end, inclusive). You are also given an integer k. An integer is called Powerful if it appears in at least k intervals. Find the maximum Powerful Integer.

Note: If no integer occurs at least k times return -1.
*/
class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        // code here
        int n=intervals.length;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int it[]:intervals){
            int start=it[0];
            int end=it[1];
            map.put(start,map.getOrDefault(start,0)+1);
            map.put(end+1,map.getOrDefault(end+1,0)-1);
        }
        //System.out.println(map);
        int sum=0;
        int ans=-1;
        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            int key=it.getKey();
            int value=it.getValue();
            sum+=value;
            if(sum>=k){
                ans=Math.max(ans,key);
            }
            else if((sum-value)>=k){
                ans=Math.max(ans,key-1);
            }
        }
        return ans;
    }
}

/*
1 2 3
    3 4
      4 5 6
*/
