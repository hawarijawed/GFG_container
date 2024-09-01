/*
Given two sorted arrays of distinct integers arr1 and arr2. Each array may have some elements in common with the other array. Find the maximum sum of a path from the beginning of any array to the end of any array. You can switch from one array to another array only at the common elements.

Note:  When we switch from one array to other,  we need to consider the common element only once in the result.
*/
class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        // code here
        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0; 
        int result = 0;
        
        int size1 = arr1.size();
        int size2 = arr2.size();
        
        while(i<size1 && j<size2){
            
            if(arr1.get(i) > arr2.get(j)){
                sum2 = sum2 + arr2.get(j);
                j++;
            }
            else if(arr1.get(i) < arr2.get(j)){
                sum1 = sum1 + arr1.get(i);
                i++;
            }
            else{
                //Update the result with max of sum1 and sum2 along with common element
                result = result + Math.max(sum1, sum2) + arr1.get(i);
                
                //Re initialize the sum variables 
                sum1 = 0;
                sum2 = 0;
                //Update the indeces for further verification
                i++;
                j++;
            
            }
        }
        
        //Iterate to end of arr1
        while(i<size1){
            sum1 = sum1 + arr1.get(i);
            i++;
        }
        //Iterate to end of arr2
        while(j<size2){
            sum2 = sum2 + arr2.get(j);
            j++;
        }
        
        //Update the final result with max of sum1 and sum2
        result = result + Math.max(sum1, sum2);
        
        return result;
    }
}
