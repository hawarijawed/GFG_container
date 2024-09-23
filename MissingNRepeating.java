/*Given an unsorted array arr of of positive integers. One number 'A' from set {1, 2,....,n} is missing and one number 'B' occurs twice in array. Find numbers A and B*/
class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        int originalSum = 0;
        int arrSum = 0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            originalSum+=i+1;
            arrSum += arr[i];
        }
        
        //Sort the element
        Arrays.sort(arr);
        int repeated = 0;
        for(int i=1; i<n; i++){
            if(arr[i-1] == arr[i]){
                repeated = arr[i];
                break;
            }
        }
        
        int missing = originalSum - (arrSum - repeated);
        
        int ans[] = {repeated, missing};
        return ans;
    }
}
