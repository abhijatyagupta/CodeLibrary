import java.io.*;
import java.util.*;

class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        int[][] dp = new int[n+1][m+1]; // will store the largest matrix size each corresponding element from mat[][] can be a part of
        int max = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {   // both loop starts from 1 to prevent IndexOutOfBounds
                if (mat[i-1][j-1] == 1) {   // if the element in the matrix is a 1
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]));    // mark the corresponding element in dp = 1 + minimum of element above, to the left and to the diagonally left of the current element
                    if (dp[i][j] > max) max = dp[i][j];
                }
                else dp[i][j] = 0;  // if it is not 1, mark it as it is (0) in the dp array
            }
        }
        return max;
    }
}


// Driver Code Starts
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            String a[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            String a1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[n][m];
            for(int i = 0;i < n*m;i++)
                mat[i/m][i%m] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// Driver Code Ends
