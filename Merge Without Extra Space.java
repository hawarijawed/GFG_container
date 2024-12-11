/*
Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order without using any extra space. 
Modify a[] so that it contains the first n elements and modify b[] so that it contains the last m elements.
*/
class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        // code here
        int n = a.length;
        int m = b.length;
        
        int i = n-1, j = 0;
        while(i>=0 && j<m){
            if(a[i] < b[j]){
                break;
            }else{
                int temp = b[j];
                b[j] = a[i];
                a[i] = temp;
            }
            i--;
            j++;
        }
        
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
