import java.io.*;
import java.util.*;

class Solution {
    public void merge(int arr1[], int arr2[], int n, int m) {   // both arrays are sorted already
        int i = n-1;    // points to last element of first array
        int j = 0;  // points to first element of second array
        while(i >= 0 && j < m) {    // while pointers are within array bounds
            if (arr1[i] > arr2[j]) {
                arr1[i] = arr1[i] ^ arr2[j];    // swap the elements
                arr2[j] = arr1[i] ^ arr2[j];
                arr1[i] = arr1[i] ^ arr2[j];
            }
            else break;
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}


// Driver Code Starts
class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int arr1[] = new int[n];
            int arr2[] = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().merge(arr1, arr2, n, m);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr1[i] + " ");
            }
            for (int i = 0; i < m; i++) {
                str.append(arr2[i] + " ");
            }
            System.out.println(str);
        }
    }
}
// Driver Code Ends