/*
Given an array arr integers. Assume sz to be the initial size of the array. Do the following operations exactly sz/2 times. In every kth (1<= k <= sz/2) operation:
Right-rotate the array clockwise by 1.
Delete the (n– k + 1)th element from begin.
Now, Return the first element of the array.
Note: Here n keeps on decreasing with every operation.
*/
class Solution {
    public static void rigthRotate(ArrayList<Integer> arr, int n){
        if(n<=1){
            return;
        }
        int last_element = arr.get(n-1);
        for(int i=n-1; i>0; i--){
            arr.set(i, arr.get(i-1));
        }
        arr.set(0,last_element);
    }
    public static int rotateDelete(ArrayList<Integer> arr) {
        // code here
        int n = arr.size();
        int sz = n;
        
        for(int k=1; k<=sz/2; k++){
            rigthRotate(arr,n);
            
            int delete = n-k;
            arr.remove(delete);
            n--;
        }
        
        return arr.get(0);
    }
}
