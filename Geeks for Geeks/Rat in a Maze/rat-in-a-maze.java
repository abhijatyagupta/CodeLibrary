import java.util.*;

class GfG {
    public static ArrayList<String> findPath(int[][] m, int n) {
        boolean[][] visited = new boolean[n][n];
        ArrayList<String> list = new ArrayList<>(); // will hold possible paths
        traverseMatrix(m, visited, list, 0 ,0, ""); // call to actual shit
        return list;
    }

    static void traverseMatrix(int[][] m, boolean[][]visited, ArrayList<String> list, int i, int j, String s) {
        if (i < 0 || i >= m.length || j < 0 || j >= m.length) return;   // return if the indices are out of bounds of the matrix
        if (m[i][j] == 0 || visited[i][j]) return;  // return if the path is blocked or if the cell is already visited
        visited[i][j] = true;   // mark this cell as visited

        if (i == m.length-1 && j == m.length-1) {   // if this is the destination
            list.add(s);    // add the path formed so far to the list
            visited[i][j] = false;  //backtrack
            return;
        }

        traverseMatrix(m, visited, list, i+1, j, s + "D");  // recursive calls to find other paths
        traverseMatrix(m, visited, list, i, j-1, s + "L");
        traverseMatrix(m, visited, list, i, j+1, s + "R");
        traverseMatrix(m, visited, list, i-1, j, s + "U");

        visited[i][j] = false;  // now that paths from this cell are discovered, backtrack to find other paths
    }
}


// Driver Code Starts
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            GfG g = new GfG();
            ArrayList<String> res = g.findPath(a, n);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// Driver Code Ends