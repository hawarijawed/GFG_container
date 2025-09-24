/*
Design a SpecialQueue data structure that functions like a normal queue but with additional support for retrieving the minimum and maximum element efficiently.
The SpecialQueue must support the following operations:

enqueue(x): Insert an element x at the rear of the queue.
dequeue(): Remove the element from the front of the queue.
getFront(): Return the front element without removing.
getMin(): Return the minimum element in the queue in O(1) time.
getMax(): Return the maximum element in the queue in O(1) time.
There will be a sequence of queries queries[][]. The queries are represented in numeric form:

1 x : Call enqueue(x)
2:  Call dequeue()
3: Call getFront()
4: Call getMin()
5: Call getMax()
The driver code will process the queries, call the corresponding functions, and print the outputs of getFront(), getMin(), getMax() operations.
You only need to implement the above five functions.

Note: It is guaranteed that all the queries are valid.
*/
class SpecialQueue {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    Queue<Integer> q;
    public SpecialQueue() {
        // Define Data Structures
        this.q = new LinkedList<>();
    }

    public void enqueue(int x) {
        // Insert element into the queue
        max = Math.max(x, max);
        min = Math.min(x, min);
        q.offer(x);
    }

    public void dequeue() {
        // Remove element from the queue
        if(q.isEmpty()){
            return;
        }
        int val = q.remove();
        if(val == max) max = Integer.MIN_VALUE;
        if(val == min) min = Integer.MAX_VALUE;
        for(int num: q){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
    }

    public int getFront() {
        // Get front element
        return q.peek();
    }

    public int getMin() {
        // Get minimum element
        return min;
    }

    public int getMax() {
        // Get maximum element
        return max;
    }
}
/*
[1, 3], [4], [1, 5], [5]
*/
