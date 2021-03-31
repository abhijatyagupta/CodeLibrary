import java.util.*;

class Solution {
    static void quickSort(int arr[], int low, int high) {
        if (low >= high) return;
        int partitionIndex = partition(arr, low, high);
        quickSort(arr, low, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, high);
    }
    static int partition(int arr[], int low, int high) {
        int pivotIndex = new Random().nextInt((high - low) + 1) + low;
        swap(arr, high, pivotIndex);
        int pivotElement = arr[high];
        int j = low;
        for(int i = low; i < arr.length; i++) {
            if (arr[i] < pivotElement) {
                swap(arr, i, j);
                j++;
            }
        }
        swap(arr, j, high);
        return j;
    }

    static void swap (int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}

// Driver Code Starts
class Sorting {
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            new Solution().quickSort(arr,0,n-1);
            printArray(arr);
            T--;
        }
    }
}
// Driver Code Ends
