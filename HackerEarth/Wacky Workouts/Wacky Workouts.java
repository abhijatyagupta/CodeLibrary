import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0) {
            long n = Long.parseLong(br.readLine());
            long[][] arr = new long[][] {
                    {1, 1},
                    {1, 0}
            };
            long[][] arg1 = compute(arr, n, Long.toBinaryString(n));
            long[][] ans = multiply(arg1 , new long[][] {
                    {1},
                    {1}
            });
            System.out.println(ans[0][0] % 1000000007);
        }
        br.close();
    }

    static long[][] compute(long[][] arr, long n, String s) {
        if (n == 1) {
            return arr;
        }
        long[][][] dp = new long[s.length() + 1][][];
        Arrays.fill(dp, null);
        long[][] ans = new long[][] {
                {1, 0},
                {0, 1}
        };
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                ans = multiply(ans, calculate(arr, (long)Math.pow(2, (s.length() - i) - 1), (s.length() - i), dp));
            }
        }
        return ans;
    }

    static long[][] calculate(long[][] arr, long n, int x, long[][][] dp) {
        if (n == 1) {
            return arr;
        }

        if (dp[x] != null) {
            return dp[x];
        }

        long[][] arr2 = calculate(arr, n/2, x-1, dp);
        dp[x] = multiply(arr2, arr2);
        return dp[x];
    }

    static long[][] multiply(long[][] arr, long[][] arr2) {
        long[][] ans = new long[arr.length][arr2[0].length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr2[0].length; j++) {
                for(int k = 0; k < arr[0].length; k++) {
                    ans[i][j] += (arr[i][k] % 1000000007) * (arr2[k][j] % 1000000007);
                }
            }
        }
        return ans;
    }
}