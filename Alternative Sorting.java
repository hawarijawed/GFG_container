/*
Given an array arr of distinct integers. Rearrange the array in such a way that the first element is the largest and the second element is the smallest, 
the third element is the second largest and the fourth element is the second smallest, and so on.
*/
class Solution {
    public static void mergeSort(int []arr, int st, int mid, int en){
        int n1 = mid-st+1;
        int n2 = en-mid;
        
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for(int i=0; i<n1; i++){
            arr1[i] = arr[i+st];
        }
        for(int i=0; i<n2; i++){
            arr2[i] = arr[mid+i+1];
        }
        
        int i=0, j=0, k=st;
        while(i<n1 & j<n2){
            if(arr1[i]<arr2[j]){
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
    public static void merge(int [] arr, int st, int en){
        if(st<en){
            int mid = st + (en - st)/2;
            merge(arr, st, mid);
            merge(arr, mid+1, en);
            mergeSort(arr, st, mid, en);
        }
    }
    public static ArrayList<Integer> alternateSort(int[] arr) {

        // Your code goes here
        int count = 0;
        int n = arr.length;
        merge(arr,0,n-1);
        int left=0, right = n-1;
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i%2==0){
                lst.add(arr[right]);
                right--;
            }
            else{
                lst.add(arr[left]);
                left++;
            }
        }
        return lst;
    }
}
