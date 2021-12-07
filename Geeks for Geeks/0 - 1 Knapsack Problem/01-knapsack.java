import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n+1][W+1];
        for(int[] x : dp) Arrays.fill(x, -1);
        return compute(wt, val, W, n, dp);
    }

    static int compute(int[] weight, int[] value, int w, int n, int[][] dp) {
        if (n == 0 || w == 0) return 0;
        if (dp[n][w] != -1) return dp[n][w];
        if (w - weight[n-1] < 0) return dp[n][w] = compute(weight, value, w, n-1, dp);
        return dp[n][w] = Math.max(
            value[n-1] + compute(weight, value, w - weight[n-1], n-1, dp),
            compute(weight, value, w, n-1, dp)
        );
    }
}


// Driver Code Starts
class gfg {
    public static void main(String args[])throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            int val[] = new int[n];
            int wt[] = new int[n];
            String st[] = read.readLine().trim().split("\\s+");
            for(int i = 0; i < n; i++) val[i] = Integer.parseInt(st[i]);
            String s[] = read.readLine().trim().split("\\s+");
            for(int i = 0; i < n; i++) wt[i] = Integer.parseInt(s[i]);
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}
// Driver Code Ends
