class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        // code here
        
        //pi = 2
        //1,3,7,9,4
        
        if(low >= high) return;
        
        int pi = partition(arr, low, high);
        
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
    
    
    static int partition(int arr[], int low, int high)
    {
        // your code here
        int pi = low;
        int pivot = arr[high];
        
        for(int i=low;i<high;i++){
            if(arr[i] <= pivot){
                swap(i, pi, arr);
                pi++;
            }
        }
        
        swap(high, pi, arr);
        return pi;
    }
    
    static void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}