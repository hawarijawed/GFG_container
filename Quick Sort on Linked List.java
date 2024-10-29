/*
You are given a Linked List. Sort the given Linked List using quicksort. 
*/
class GfG {
    public static int partition (int a[], int start, int end)  
    {  
        int pivot = a[end]; // pivot element  
        int i = (start - 1);  
  
        for (int j = start; j <= end - 1; j++)  
        {  
            // If current element is smaller than the pivot  
            if (a[j] < pivot)  
            {  
                i++; // increment index of smaller element  
                int t = a[i];  
                a[i] = a[j];  
                a[j] = t;  
            }  
        }  
        int t = a[i+1];  
        a[i+1] = a[end];  
        a[end] = t;  
        return (i + 1);  
    }  
    public static void QUICKSORT(int[] arr, int st, int en){
        if(st < en){
            int p = partition(arr, st, en);
            QUICKSORT(arr, st, p-1);
            QUICKSORT(arr, p+1, en);
        }
    }
    public static Node quickSort(Node node) {
        // Your code here
        int size = 0;
        Node temp = node;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        
        int [] arr = new int[size];
        int i=0;
        temp = node;
        while(temp != null){
            arr[i++] = temp.data;
            temp = temp.next;
        }
        
        QUICKSORT(arr, 0, size-1);
        
        Node dummy = new Node(-1);
        temp = dummy;
        for(int j=0; j<size; j++){
            temp.next = new Node(arr[j]);
            temp = temp.next;
        }
        
        return dummy.next;
        
    }
}
