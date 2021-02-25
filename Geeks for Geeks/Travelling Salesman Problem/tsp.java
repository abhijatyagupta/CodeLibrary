import java.util.*;

class GFG {

    static int tour(int source, int[][] matrix, boolean[] visited) {    // will perform DFS and return the minimum distance from a node (source) to node 0, visiting all other nodes atleast once
        visited[source] = true; // mark this node as visited

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length; i++) {    // for each neighbor of source
            if (!visited[i] && matrix[source][i] < min) {   //  if the neighbor is unvisited and distance from source to neighbor is less than current minimum distance found
                int tempMin = matrix[source][i] + tour(i, matrix, visited); // calculate and add, the minimum distance from neighbor to node 0, to the distance from source to neighbor
                if(tempMin < min) { // if this calculated distance is less than current minimum
                    min = tempMin;  // update minimum
                }
            }
        }

        visited[source] = false;    // backtrack by marking the current node as unvisited in order to find other possibly shorter distances
        return min == Integer.MAX_VALUE ? matrix[source][0] : min;  // if a minimum was not found, return the distance from source to node 0, else return the minimum
    }

    // Driver
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            boolean[] visited = new boolean[n];
            System.out.println(tour(0, matrix, visited)); // the problem statement mentions that the source/destination node is 0.
        }
        sc.close();
    }
}