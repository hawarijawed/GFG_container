/*
You are given two unsorted arrays a[] and b[]. Both arrays may contain duplicate elements. For each element in a[], your task is to count how many elements in b[] are less than or equal to that element.
*/

class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here
        int max = b[0];
        for(int val: b){
            if(max < val){
                max = val;
            }
        }
        
        int []mat = new int[max+2];
        for(int i=0; i<b.length; i++){
            mat[b[i]]++;
        }
        
        //Prefix sum
        for(int i=1; i<mat.length; i++){
            mat[i] += mat[i-1];
        }
        ArrayList<Integer> lst = new ArrayList<>();
        
        for(int val: a){
            if(val >= mat.length){
                lst.add(mat[mat.length-1]);
            }
            else{
                lst.add(mat[val]);
            }
        }
        
        return lst;
    }
    
}
