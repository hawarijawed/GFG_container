/*
You are given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
If there are no such elements return an empty array. In this case, the output will be -1.
*/
// User function Template for Java

class Solution {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int size1 = arr1.size();
        int size2 = arr2.size();
        int size3 = arr3.size();
        int i=0, j=0, k=0;
        while(i<size1 && j<size2 && k < size3){
            int val1 = arr1.get(i);
            int val2 = arr2.get(j);
            int val3 = arr3.get(k);
            if(val1 == val2 && val2 == val3){
                if(!set.contains(val1)){
                    set.add(val1);
                    list.add(val1);
                }
                i++;
                j++;
                k++;
                
            }
            
            else if(val1 < val2){
                i++;
            }
            else if(val2 < val3){
                j++;
            }
            else{
                k++;
            }
        }
        return list;
    }
}
