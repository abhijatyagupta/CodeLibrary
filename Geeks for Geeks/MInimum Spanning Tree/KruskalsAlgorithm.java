import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];

        PriorityQueue<Edge> queue = new PriorityQueue<>();

        for(int i = 0; i < V; i++) {
            for(int j = 0; j < adj.get(i).size(); j++) {
                int destination = adj.get(i).get(j).get(0);
                int weight = adj.get(i).get(j).get(1);
                Edge edge = new Edge(i, destination, weight);
                if (!queue.contains(edge)) queue.offer(edge);
            }
            parent[i] = -1;
        }

        int sum = 0;
        while(!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (cycleExists(parent, edge)) continue;
            sum += edge.weight;
        }
        return sum;
    }

    static boolean cycleExists(int[] parent, Edge edge) {
        int sourceParent = findParent(parent, edge.source);
        int destinationParent = findParent(parent, edge.destination);
        if (sourceParent == destinationParent) return true;
        parent[destinationParent] = sourceParent;
        return false;
    }

    static int findParent(int[] parent, int node) {
        if (parent[node] == -1) return node;
        return findParent(parent, parent[node]);
    }
}



class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Edge) {
            return this.source == ((Edge)o).source && this.destination == ((Edge)o).destination;
        }
        return super.equals(o);
    }
}


//Driver Code Starts
class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }

            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

            Solution ob = new Solution();

            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
//Driver Code Ends
