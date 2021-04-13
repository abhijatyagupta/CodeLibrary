import java.io.*;
import java.util.*;

class Solution {
    public long count(int S[], int m, int n) {
        long[][] dp = new long[n+1][m+1];
        for(long[] x : dp) for(int i = 0; i < m+1; i++) x[i] = -1L;
        return countHelper(S, m, n, dp);    // call to actual shit
    }

    static long countHelper(int[] coins, int m, int n, long[][] dp) {
        if (n == 0) return 1;   // there is only one way to make change for 0 cents (that is don't pick any coin)
        if (n < 0) return 0;    // no ways to make change for less than 0 cents
        if (m <= 0) return 0;   // no ways to make change without any available change
        if (dp[n][m] != -1L) return dp[n][m];   // memoization
        long count1 = countHelper(coins, m - 1, n, dp); // will return ways to make change for n cents without the m'th coin
        long count2 = countHelper(coins, m, n - coins[m - 1], dp);  // will return ways to make change, with m coins, for n minus a single m'th coin
        dp[n][m] = count1 + count2; // add both counts
        return dp[n][m];    // return count
    }
}


// Driver Code Starts
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int Arr[] = new int[m];
            for(int i = 0;i<m;i++)
                Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(Arr,m,n));
        }
    }
}
// Driver Code Ends
