/*
Given two integer arrays a[] and b[], you have to find the intersection of the two arrays. Intersection of two arrays is said to be elements that are common in both arrays. 
The intersection should not have duplicate elements and the result should contain items in any order.

Note: The driver code will sort the resulting array in increasing order before printing.
*/
class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<a.length; i++){
            set.add(a[i]);
        }
        
        ArrayList<Integer> lst = new ArrayList<>();
        
        for(int j=0; j<b.length; j++){
            if(!set.isEmpty() && set.contains(b[j])){
                lst.add(b[j]);
                set.remove(b[j]);
            }
        }
        
        return lst;
    }
}
