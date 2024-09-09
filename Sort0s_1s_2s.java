/*
Given an array arr containing only 0s, 1s, and 2s. Sort the array in ascending order.
*/
class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        // code here
        int count_0=0, count_1=0, count_2=0;
        int size = arr.size();
        for(int i=0; i<size; i++){
            int num = arr.get(i);
            if(num == 0){
                count_0++;
            }
            else if(num == 1){
                count_1++;
            }
            else{
                count_2++;
            }
        }
        //setting 0's
        for(int i=0; i<count_0; i++){
            arr.set(i, 0);
        }
        //setting 1's
        for(int i = count_0; i<(count_0+count_1);i++){
            arr.set(i,1);
        }
        
        //setting 2's
        for(int i=(count_0+count_1); i<size; i++){
            arr.set(i, 2);
        }
    }
}
