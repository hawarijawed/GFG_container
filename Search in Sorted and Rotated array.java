/*
Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of a target key. Return -1 if the key is not found.
*/
class Solution {
    
    int search(int[] arr, int key) {
    if (arr.length == 1) {
        return arr[0] == key ? 0 : -1;
    }
    
    int n = arr.length;
    int st = 0, en = n - 1;
    
    while (st <= en) {
        int mid = st + (en - st) / 2;
        
        // If the key is found, return the index.
        if (arr[mid] == key) {
            return mid;
        }
        
        // Determine which side of the array is sorted
        if (arr[st] <= arr[mid]) {  // Left half is sorted
            if (arr[st] <= key && key < arr[mid]) {
                en = mid - 1;  // Key lies in the left sorted part
            } else {
                st = mid + 1;  // Key lies in the right part
            }
        } else {  // Right half is sorted
            if (arr[mid] < key && key <= arr[en]) {
                st = mid + 1;  // Key lies in the right sorted part
            } else {
                en = mid - 1;  // Key lies in the left part
            }
        }
    }
    
    // If we exit the loop, the key was not found.
    return -1;
}
}
