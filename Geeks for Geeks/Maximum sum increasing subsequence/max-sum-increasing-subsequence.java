import java.io.*;
import java.util.*;

class Solution {
    public int maxSumIS(int arr[], int n) {
        if (n == 1) return arr[0];
        int[] dp = Arrays.copyOf(arr, n);   // basically initialize dp array with given array values
        int max = dp[0];    // will hold the required answer
        for(int i = 1; i < n; i++) {    // for all the elements in array (skipping 0th)
            for(int j = 0; j < i; j++) {    // for each element prior to the ith element
                if (arr[j] < arr[i] && dp[i] < arr[i] + dp[j]) {    // if the preceding element is smaller than the succeeding element and if the sum succeeding element and max sum till preceding element (dp[j]) is more than max sum till succeeding element
                    dp[i] = arr[i] + dp[j]; // make the max sum till succeeding element equal to succeeding element + max sum till preceding element
                    if (max < dp[i]) max = dp[i];
                }
            }
        }
        return max;
    }
}


// Driver Code Starts
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int Arr[] = new int[n];
            for(int i = 0;i<n;i++)
                Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.maxSumIS(Arr,n));
        }
    }
}
// Driver Code Ends
