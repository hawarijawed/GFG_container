/*
You are given two integer arrays a[] and b[] of equal size. A sum combination is formed by adding one element from a[] and one from b[], using each index pair (i, j) at most once. 
Return the top k maximum sum combinations, sorted in non-increasing order.
*/
class Solution {
    class Pair {
        int i, j, sum;

        Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        int n = a.length;
        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> p2.sum - p1.sum);
        Set<String> visited = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        int i = n - 1, j = n - 1;
        maxHeap.add(new Pair(i, j, a[i] + b[j]));
        visited.add(i + "," + j);

        while (k-- > 0 && !maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            result.add(current.sum);

            int x = current.i;
            int y = current.j;

            if (x - 1 >= 0 && !visited.contains((x - 1) + "," + y)) {
                maxHeap.add(new Pair(x - 1, y, a[x - 1] + b[y]));
                visited.add((x - 1) + "," + y);
            }

            if (y - 1 >= 0 && !visited.contains(x + "," + (y - 1))) {
                maxHeap.add(new Pair(x, y - 1, a[x] + b[y - 1]));
                visited.add(x + "," + (y - 1));
            }
        }

        return result;
    }
}

// 1 2 3 4 
// 1 2 5 6  
// 10 9 6
