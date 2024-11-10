/*
Given two sorted arrays a[] and b[], where each array contains distinct elements , the task is to return the elements in the union of the two arrays in sorted order.

Union of two arrays can be defined as the set containing distinct common elements that are present in either of the arrays.
*/
//------------------------ Using HashSet ---------------------//
public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        HashSet<Integer> set = new HashSet<>();
        for(int num : a){
            set.add(num);
        }
        for(int val: b){
            set.add(val);
        }
        ArrayList<Integer> lst = new ArrayList<>(set);
        Collections.sort(lst);
        return lst;
    }

//------------------------ Using TreeSet ---------------------//
class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : a){
            set.add(num);
        }
        for(int val: b){
            set.add(val);
        }
       
        return new ArrayList<>(set);
    }
}
