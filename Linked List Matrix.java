/*
Given a Matrix mat of n*n size. Your task is constructing a 2D linked list representation of the given matrix.
*/
/*class Node

class Node
{
   int data;
   Node right,down;

   Node(int data){
       this.data = data;
       right = null;
       down = null;
   }
}
*/
/*Function should return the head of the 2D LL.*/
class Solution {
    static Node construct(int arr[][]) {
        // Add your code here.
        int n = arr.length;
        Node [][] matrix = new Node[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = new Node(arr[i][j]);
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(j<n-1){
                    matrix[i][j].right = matrix[i][j+1];
                }
                
                if(i<n-1){
                    matrix[i][j].down = matrix[i+1][j];
                }
            }
        }
        
        return matrix[0][0];
    }
}
