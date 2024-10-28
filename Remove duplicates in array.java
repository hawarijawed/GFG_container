/*
Given an array arr consisting of positive integer numbers, remove all duplicate numbers.
*/
class Solution {
    ArrayList<Integer> removeDuplicate(int arr[]) {
        // code here
        ArrayList<Integer> lst = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int a: arr){
            set.add(a);
        }
        
        for(int a: arr){
            if(set.contains(a)){
                lst.add(a);
                set.remove(a);
            }
        }
        
        return lst;
    }
}
