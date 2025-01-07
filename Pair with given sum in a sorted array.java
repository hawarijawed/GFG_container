/*
You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
Note: pairs should have elements of distinct indexes. 
*/
class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        
        int count = 0;
        int n = arr.length;
        int st = 0, en = n-1;
        
        while(st<en){
            int val = arr[st] + arr[en];
            
            if(val > target){
                en--;
            }
            else if(val < target){
                st++;
            }
            else{
                
                int elem1 = arr[st];
                int count1 = 0;
                //Move st to unique next
                while(st<=en && arr[st] == elem1){
                    st++;
                    count1++;
                }
                
                int elem2 = arr[en];
                int count2 = 0;
                //Move en to unique next
                while(st<=en && arr[en] == elem2){
                    en--;
                    count2++;
                }
                
                if(elem1 == elem2){
                    count += count1*(count1-1)/2;
                }
                else{
                    count += count1*count2;
                }
            
            }
        }
        
        return count;
    }
}
