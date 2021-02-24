import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int isNegativeWeightCycle(int n, int[][] edges) {
        int[] values = new int[n];  // will store distance of vertices from a given vertex
        Arrays.fill(values, Integer.MAX_VALUE/2); // initially, the distances are maximum (MAX_VALUE/2 is taken because it needs to represent infinity, adding to which should still be infinity, but adding to MAX_VALUE may result otherwise)

        boolean verticesDidRelax = false;   // will tell whether a vertex was relaxed in an iteration

        for(int i = 0; i < n-1; i++) {  // relax vertices n-1 times according to Bellman-Ford algorithm
            for(int[] x : edges) {
                int u = x[0];   // edge source
                int v = x[1];   // edge destination
                int distance = x[2];    // weight of edge
                if(values[u] + distance < values[v]) {  // if distance (present in value[] for this iteration) till source of edge + weight of edge is less than distance (present in value[] for this iteration) till edge destination
                    values[v] = values[u] + distance;   // assign the shorter distance to edge destination
                    verticesDidRelax = true;    // a vertex was relaxed
                }
            }
            if (!verticesDidRelax) return 0;    // if no vertex was relaxed before all the n-1 iterations were over, no negative weight cycle exists so return 0
            verticesDidRelax = false;   // reset the boolean value for the next iteration
        }

        for(int[] x : edges) {  // checking for the n'th time if a vertex can be relaxed or not
            int u = x[0];
            int v = x[1];
            int distance = x[2];
            if(values[u] + distance < values[v]) return 1;  // if a vertex can still be relaxed, a negative weight cycle exists so return 1
        }
        return 0;   // no vertex was relaxed the n'th time, so no negative weight cycle exists, return 0
    }
}


// Driver Code Starts
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}
// Driver Code Ends
