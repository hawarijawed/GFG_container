/*
Given a 2d integer array arr[][] of size k*n, where each row is sorted in ascending order. Your task is to find the smallest range [l, r] that includes at least one element from each of the k lists. If more than one such ranges are found, return the first one.

*/
class Solution {
    class Element implements Comparable<Element>{
        int val, col, row;
        Element(int val, int row ,int col){
            this.val = val;
            this.col = col;
            this.row = row;
        }
        
        public int compareTo(Element other){
            return Integer.compare(this.val, other.val);
        }
    }
    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        // code here
        int k = arr.length;
        int n = arr[0].length;
        PriorityQueue<Element> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<k; i++){
            int val = arr[i][0];
            pq.add(new Element(val, i, 0));
            max = Math.max(max, val);
        }
        
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;
        
        while(true){
            Element curr = pq.poll();
            int min = curr.val;
            if((max - min )< (rangeEnd - rangeStart)){
                rangeStart = min;
                rangeEnd = max;
            }
            
            if((curr.col + 1) == n){
                break;
            }
            
            int nextVal = arr[curr.row][curr.col + 1];
            pq.add(new Element(nextVal, curr.row, curr.col+1));
            max = Math.max(max, nextVal);
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(rangeStart);
        res.add(rangeEnd);
        return res;
    }
}
