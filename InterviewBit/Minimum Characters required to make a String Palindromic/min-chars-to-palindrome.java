public class Solution {
    public int solve(String A) {
        String str = A + "$" + new StringBuilder(A).reverse().toString();
        int[] LPS = generateLPS(str);
        return A.length() - LPS[LPS.length - 1];
    }

    static int[] generateLPS(String s) {
        int[] LPS = new int[s.length()];
        LPS[0] = 0;
        int i = 1;
        while(i < s.length()) {
            if (s.charAt(i) == s.charAt(0)) {
                int j = 1;
                LPS[i++] = j;
                while(i < s.length() && s.charAt(i) == s.charAt(j)) LPS[i++] = ++j;
            }
            else i++;
        }
        return LPS;
    }
}

// See this video for KMP string matching algorithm and LPS generation --> youtube.com/watch?v=V5-7GzOfADQ