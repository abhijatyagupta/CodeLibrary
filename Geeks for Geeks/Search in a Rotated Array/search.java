import java.util.*;

class Solution {
    int search(int A[], int start, int end, int key) {
        if (start > end) return -1;
        int mid = start + ((end - start)/2);    // calculate mid index
        if (A[mid] == key) return mid;  // if element at mid index is equal to key, return the element
        if (A[mid] <= A[end]) { // if the right half of array is sorted
            if (key > A[mid] && key <= A[end])  // if the right half is sorted, check whether the key definitely exist or definitely does not exist in the half
                return search(A, mid+1, end, key);  // if it does, search for it in the right half (from mid + 1 to end)
            return search(A, start, mid-1, key);    // else search for it in the left half (from start to mid - 1)
        }
        if (key >= A[start] && key < A[mid])     // check whether the key definitely exist or not in the left half
            return search(A, start, mid-1, key);    // if it does, search for it in the left half (from start to mid - 1)
        return search(A, mid+1, end, key);  // else search for it in the right half (from mid + 1 to end)
    }
}

// Driver Code Starts
public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];

            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            int key = sc.nextInt();

            System.out.println(new Solution().search(A, 0, n - 1, key));
        }
    }
}
// Driver Code Ends