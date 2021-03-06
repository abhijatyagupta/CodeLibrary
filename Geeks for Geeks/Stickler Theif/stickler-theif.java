import java.util.*;
import java.io.*;

class solve{
    public int FindMaxSum(int arr[], int n) {
        int[] dp = new int[n];  // array for memoization
        return getMax(arr, n-1, dp);    // call to actual shit
    }

    static int getMax(int[] arr, int i, int[] dp) {
        if (i == 0) return arr[i];
        if (i == 1) return Math.max(arr[i], arr[i-1]);
        if (dp[i] != 0) return dp[i];
        dp[i] = Math.max(getMax(arr, i-1, dp), arr[i] + getMax(arr, i-2, dp));
        return dp[i];
    }
}


// Driver Code Starts
class GFG
{
    public static void main (String[] args)
    {

        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        //taking count of testcases
        int t = sc.nextInt();
        while(t-- > 0){

            //taking count of houses
            int n = sc.nextInt();
            int arr[] = new int[n];

            //inserting money present in
            //each house in the array
            for(int i = 0; i<n; ++i)
                arr[i] = sc.nextInt();

            //calling method FindMaxSum() of class solve
            System.out.println(new solve().FindMaxSum(arr, n));
        }
    }
}
// Driver Code Ends
