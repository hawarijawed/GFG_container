/*
Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as lengths of three sides of the triangle. 
A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.

*/
class Solution {
    public int countTriangles(int arr[]) {
        // code here
        Arrays.sort(arr);
        int count = 0;
        for(int k=arr.length-1; k>=1; k--){
            int i=0; 
            int j=k-1;
            while(i<j){
                if(arr[i] + arr[j] > arr[k]){
                    count+= j-i;
                    j--;
                }
                else{
                    i++;
                }
            }
        }
        return count;
    }
}
/*
4, 6, 3, 7
3, 4, 6, 7
*/
