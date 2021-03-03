import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int isNegativeWeightCycle(int n, int[][] edges) {    // each edges[i] contains 3 elements [source, destination, weight]
        int weight[][] = new int[n][n]; // will store weight of edges
        for(int i = 0; i < n; i++) {    // initializing the weight array
            for(int j = 0; j < n; j++) {
                weight[i][j] = Integer.MAX_VALUE/2; // initially, the distances are maximum (MAX_VALUE/2 is taken because it needs to represent infinity, adding to which should still be infinity, but adding to MAX_VALUE may result otherwise)
            }
        }

        for(int[] x : edges) weight[x[0]][x[1]] = x[2]; // add weight of edges from edges array to the weight[][] 2d array for fast access

        for(int i = 0; i < n; i++) {    // for every node of graph according to Floyd-Warshall algorithm
            for(int j = 0; j < n; j++) {    // outer loop for computing adjacency matrix containing shorter distances between nodes via i
                if (j == i) continue;   //  computing for nodes that are already connected to j directly from i is not required
                for(int k = 0; k < n; k++) {    // inner loop for computing adjacency matrix
                    if (k == i || j == k) continue; // no need to compute for self-loops and nodes already connected to k directly from i
                    if (weight[j][k] > weight[j][i] + weight[i][k]) {   // if there exist a shorter path from j to k via i
                        weight[j][k] = weight[j][i] + weight[i][k]; // update the weight[j][k] with shorter distance
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {    // computing for each node, once again
            for(int j = 0; j < n; j++) {
                if (j == i) continue;
                for(int k = 0; k < n; k++) {
                    if (k == i || j == k) continue;
                    if (weight[j][k] > weight[j][i] + weight[i][k]) return 1;   // if a shorter path can still be found, negative weight cycle exist, so return 1
                }
            }
        }

        return 0;   // no shorter path was found for any node when traversed the second time, so no negative weight cycle exist, return 0
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