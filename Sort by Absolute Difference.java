/*
You are given a number x and array arr[]. Your task is to rearrange the elements of the array according to the absolute difference with x, i.e., an element having minimum difference comes first, and so on.
Note: If two or more elements are at equal distances arrange them in the same sequence as in the given array.
*/

class Solution {
    public void rearrange(int[] arr, int x) {
        // code here
        Integer[] temp = Arrays.stream(arr).boxed()
                            .toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> Math.abs(a - x) - Math.abs(b - x));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}
