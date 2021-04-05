import java.util.*;

class Solution {
    void heapify(int arr[], int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) max = arr[max] < arr[left] ? left : max;
        if (right < n) max = arr[max] < arr[right] ? right : max;

        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr, n, max);
        }
    }

    public void heapSort(int arr[], int n) {
        for(int i = (n/2) - 1; i >= 0; i--) heapify(arr, n, i);
        for(int i = n-1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
}

// Driver Code Starts
class Heap_Sort
{
    void printArray(int arr[],int n) {
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();

            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
}
// Driver Code Ends
