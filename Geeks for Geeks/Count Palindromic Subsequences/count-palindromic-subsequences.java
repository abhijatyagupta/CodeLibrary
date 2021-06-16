import java.util.*;

class Solution {
    long countPS(String str) {
        long[][] dp = new long[str.length()][str.length()];
        for(long[] x : dp) Arrays.fill(x, -1);
        String[] s = new String[] {str};    // array with original string in it so that recursion does not overflow
        return getCount(s, 0, str.length()-1, dp) % 1000000007; // call to actual shit
    }

    static long getCount(String[] s, int i, int j, long[][] dp) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (dp[i][j] != -1) return dp[i][j] % 1000000007;   // memoization
        long sum = (getCount(s, i+1, j, dp) % 1000000007) + (getCount(s, i, j-1, dp) % 1000000007) % 1000000007;    // count of palindromic subsequences in the string without first character + count of palindromic subsequences in the string without last character
        if (s[0].charAt(i) == s[0].charAt(j)) { // if the first and last character of the string are equal
            return dp[i][j] = (sum + 1) % 1000000007; // add 1 to the sum and return
        }
        return dp[i][j] = (sum - (getCount(s, i+1, j-1, dp) % 1000000007) + 1000000007) % 1000000007;   // return after subtracting, from the sum, the count of palindromic subsequences in the string without first and last characters since it was computed twice
    }
    // See this video for explanation -> https://www.youtube.com/watch?v=YHSjvswCXC8
}


// Driver Code Starts
class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0) {
            String str = sc.nextLine();
            Solution ob  = new Solution();
            System.out.println(ob.countPS(str));
            t--;
        }
    }
}
// Driver Code Ends
