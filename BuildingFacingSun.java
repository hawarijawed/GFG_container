/*Given an array height representing the heights of buildings. You have to count the buildings that will see the sunrise (Assume the sun rises on the side of the array starting point).
Note: The height of the building should be strictly greater than the height of the buildings left in order to see the sun.
*/
class Solution {
    // Returns count buildings that can see sunlight
    public int countBuildings(int[] height) {
        // code here
        int count = 1;
        int first = height[0];
        for(int i=1; i<height.length; i++){
            if(height[i]>first){
                first = height[i];
                count++;
            }
        }
        return count;
    }
}
