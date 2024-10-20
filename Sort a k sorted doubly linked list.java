/*
Given a doubly linked list, each node is at most k-indices away from its target position. The problem is to sort the given doubly linked list. The distance can be assumed in either of the directions (left and right).
*/
// User function Template for Java
class Solution {
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        // Code here
        if (head == null) {
            return null;
        }

        PriorityQueue<DLLNode> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);
        DLLNode current = head;
        DLLNode newHead = null;
        DLLNode lastSorted = null;

        // Step 1: Insert the first k+1 elements into the min-heap
        for (int i = 0; i <= k && current != null; i++) {
            minHeap.offer(current);
            current = current.next;
        }

        // Step 2: Extract the minimum from the heap and build the sorted list
        while (!minHeap.isEmpty()) {
            DLLNode minNode = minHeap.poll();

            // Update the sorted list
            if (newHead == null) {
                newHead = minNode;
                lastSorted = newHead;
            } else {
                lastSorted.next = minNode;
                minNode.prev = lastSorted;
                lastSorted = minNode;
            }

            // If there are more nodes to process, add the next one to the heap
            if (current != null) {
                minHeap.offer(current);
                current = current.next;
            }
        }

        // Make sure the last node points to null
        lastSorted.next = null;

        return newHead;
    }
}
