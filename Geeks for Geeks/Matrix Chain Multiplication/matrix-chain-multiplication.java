import java.io.*;
import java.util.*;

class Solution {
    static int matrixMultiplication(int N, int arr[]) {
        if (N == 2) return 0;   // if there is only one matrix, no multiplication will be performed
        int[][] dp = new int[N][N];
        for(int[] x : dp) Arrays.fill(x, -1);
        return multiply(arr, 1, arr.length-1, dp);  // call to actual shit
    }

    static int multiply(int[] arr, int i, int j, int[][] dp) {
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];    // memoization
        int min = Integer.MAX_VALUE;    // will store the minimum operations required to perform the multiplication of the matrices in the given range (i to j)
        for(int k = i; k <= j-1; k++) {
            int product = multiply(arr, i, k, dp) + multiply(arr, k+1, j, dp) + (arr[i-1] * arr[k] * arr[j]);   // stores the sum of minimum multiplication operations required by, the left half of the range, the right half of the range and both the halves
            if (product < min) min = product;
        }
        return dp[i][j] = min;
    }
}


// Driver Code Starts
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// Driver Code Ends
