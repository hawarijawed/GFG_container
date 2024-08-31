/*
You are given an array arr, you need to find any three elements in it such that arr[i] < arr[j] < arr[k] and i < j < k.
*/
class Solution {
    // Function to find three numbers such that arr[smaller[i]] < arr[i] <
    // arr[greater[i]]
    public List<Integer> find3Numbers(int[] arr) {
        // code here
        int size = arr.length;
        int []smaller = new int[size];
        int []greater = new int[size];
        
        int min = 0;
        int max = size-1; 
        smaller[min] = -1;
        greater[max] = -1;
        
        //for smaller elements
        for(int i=1; i<size; i++){
            if(arr[i] <= arr[min]){
                min = i;
                smaller[i] = -1;
            }
            else{
                smaller[i] = min;
            }
        }
        
        //for greater element
        for(int i=size-2; i>=0; i--){
            if(arr[i]>=arr[max]){
                max = i;
                greater[i] = -1;
            }
            else{
                greater[i] = max;
            }
        }
        
        List<Integer> lst = new ArrayList<>();
        //finding an element such that it is greater than on its left and smaller
        // than on its right
        for(int i=0; i<size;i++){
            if(smaller[i] != -1 && greater[i] != -1){
                lst.add(arr[smaller[i]]);
                lst.add(arr[i]);
                lst.add(arr[greater[i]]);
                return lst;
            }
        }
        return lst;
    }
}
