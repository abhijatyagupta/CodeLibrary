import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int editDistance(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int[] x : dp) Arrays.fill(x, -1);
        return getMinDistance(s, t, s.length(), t.length(), dp);    // call to actual shit
    }

    public int getMinDistance(String s1, String s2, int len1, int len2, int[][] dp) {
        if (len1 == 0) return len2; // if s1 is empty, then edit distance will be length of string 2 i.e. add all characters of string 2
        if (len2 == 0) return len1; // if s2 is empty, then edit distance will be length of string 1 i.e. delete all characters of string 1
        if (dp[len1][len2] != -1) return dp[len1][len2];    // memoization
        if (s1.charAt(len1-1) == s2.charAt(len2-1)) return getMinDistance(s1, s2, len1 - 1, len2 - 1, dp);  // if last characters are same, check the strings without the last character
        dp[len1][len2] = 1 + Math.min(  // else an operation will be performed (hence 1 cost) + the minimum cost from either of the three operations
            getMinDistance(s1, s2, len1, len2-1, dp),   // insert operation
            Math.min(
                getMinDistance(s1, s2, len1-1, len2-1, dp), // replace operation
                getMinDistance(s1, s2, len1-1, len2, dp)    // delete operation
            )
        );
        return dp[len1][len2];
    }
}


// Driver Code Starts
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// Driver Code Ends
