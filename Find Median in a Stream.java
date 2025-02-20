/*
Given a data stream arr[] where integers are read sequentially, the task is to determine the median of the elements encountered so far after each new integer is read.

There are two cases for median on the basis of data set size.

1. If the data set has an odd number then the middle one will be consider as median.
2. If the data set has an even number then there is no distinct middle value and the median will be the arithmetic mean of the two middle values.
*/
class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        PriorityQueue <Integer> min = new PriorityQueue<>();
        PriorityQueue <Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        ArrayList<Double> ans = new ArrayList<>();
        
        for (int it: arr){
            insertIntoHeaps(it, min, max);
            
            double mid;
            if (min.size() == max.size()){
                mid = (min.peek() + max.peek()) / 2.0;
            }else{
                mid = max.peek();
            }
            
            ans.add(mid);
        }
        
        return ans;
    }
    
    private void insertIntoHeaps(int num, PriorityQueue <Integer> min, PriorityQueue <Integer> max){
        if (max.isEmpty() || num <= max.peek()){
            max.add(num);
        }else{
            min.add(num);
        }
        
        if (max.size() > min.size() + 1){
            min.add(max.poll());
        }else if (max.size() < min.size()){
            max.add(min.poll());
        }
    }
}
