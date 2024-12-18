/*
You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book. You also have an integer k representing the number of students. 
The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).
*/
class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        if (arr.length < k) {
            return -1;
        }
    
        // Calculate the sum of pages (high) and the maximum single book pages (low)
        int low = 0, high = 0;
        for (int pages : arr) {
            high += pages;
            low = Math.max(low, pages);  // the maximum pages in a book
        }
    
        // Binary search for the minimum possible maximum pages
        while (low <= high) {
            int mid = low + (high - low) / 2;
        
            // Check if it's possible to allocate books with maximum pages `mid`
            if (canAllocate(arr, k, mid)) {
                high = mid - 1;  // Try for a smaller maximum
            } else {
                low = mid + 1;   // Try for a larger maximum
            }
        }
    
        // After the loop, `low` will be the minimum maximum pages
        return low;
    }
    // Helper function to check if we can allocate books such that no student gets more than `maxPages` pages
    private static boolean canAllocate(int[] arr, int k, int maxPages) {
        int studentsRequired = 1;  // We start by assigning the first student
        int currentSum = 0;
    
        for (int i = 0; i < arr.length; i++) {
            if (currentSum + arr[i] > maxPages) {
                // If adding this book exceeds the maximum pages, we need to allocate to a new student
                studentsRequired++;
                currentSum = arr[i];  // This book goes to the new student
                if (studentsRequired > k) {
                    return false;  // If we exceed the number of students, return false
                }
            } else {
                // Otherwise, add this book to the current student
                currentSum += arr[i];
            }
        }
        
        return true;
    }
}
