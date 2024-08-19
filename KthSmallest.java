/*
Given an array arr[] and an integer k where k is smaller than the size of the array, the task is to find the kth smallest element in the given array. It is given that all array elements are distinct.

Follow up: Don't solve it using the inbuilt sort function.
*/
class Solution {
    //Building custom merge sort function
    public static void merge(int [] arr, int st, int mid, int end){
        int n1 = mid-st+1;
        int n2 = end-mid;
        
        int [] arr1 = new int[n1];
        int [] arr2 = new int[n2];
        
        //copy elements of arr from 0 to m-1 in arr1
        for(int i=0; i<n1;i++){
            arr1[i] = arr[st+i];
        }
        
        //copy elements of arr from m+1 to end in arr2
        for(int i=0; i<n2; i++){
            arr2[i] = arr[mid+1+i];
        }
        
        int i = 0;
        int j = 0;
        int k = st;
        while(i<n1 && j<n2){
            if(arr1[i] <= arr2[j]){
                arr[k] = arr1[i];
                i++;
            }
            else{
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        
        while(i<n1){
            arr[k] = arr1[i];
            i++;
            k++;
        }
        
        while(j<n2){
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }
    public static void mergeSort(int [] arr, int st, int end){
        if(st<end){
            int mid = st + (end-st)/2;
        
            mergeSort(arr,st, mid);
            mergeSort(arr,mid+1,end);
        
            merge(arr, st, mid, end);
        }

    }
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        int size = arr.length;
        //Sorting array using merge sort
        mergeSort(arr, 0, size-1);

        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<size;i++){
            map.put(i+1, arr[i]);
        }
        
        return map.get(k);
        
    }
}
