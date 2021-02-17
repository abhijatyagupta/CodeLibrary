import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int[] parent = new int[V];  // will keep track of parent of each node

        PriorityQueue<Edge> queue = new PriorityQueue<>();  // will always provide edge with minimum weight

        for(int i = 0; i < V; i++) {
            for(int j = 0; j < adj.get(i).size(); j++) {
                int destination = adj.get(i).get(j).get(0);
                int weight = adj.get(i).get(j).get(1);
                Edge edge = new Edge(i, destination, weight);
                if (!queue.contains(edge)) queue.offer(edge); // makes sure no duplicate edge from adjacency list is added (for e.g. same edge from u to v and v to u)
            }
            parent[i] = -1; // no node will have a parent initially
        }

        int sum = 0;    // will hold sum of edges that are part of MST (the required answer, basically)
        while(!queue.isEmpty()) {
            Edge edge = queue.poll();   // removes the edge with minimum weight from priority queue
            if (cycleExists(parent, edge)) continue;    // don't add weight of edge to sum if it forms a cycle
            sum += edge.weight; // add weight of the edge to sum, now that it does not form a cycle
        }
        return sum;
    }

    static boolean cycleExists(int[] parent, Edge edge) {
        int sourceParent = findParent(parent, edge.source); // find the parent of source node
        int destinationParent = findParent(parent, edge.destination);   // find the parent of destination node
        if (sourceParent == destinationParent) return true; // if both parents are same, return that cycle exists
        parent[destinationParent] = sourceParent;   // if parents are different, make their parent same, hence considering their common edge in MST
        return false; // returns that no cycle will be formed on making this edge a part of MST
    }   // https://youtu.be/wU6udHRIkcc <-- see this video to understand union-find and disjoint sets

    static int findParent(int[] parent, int node) {
        if (parent[node] == -1) return node; // if the parent of node == -1, the node itself is the parent, so return it
        return findParent(parent, parent[node]); // else find grandparent of node
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
    public int compareTo(Edge o) {      //required for priority queue
        return this.weight - o.weight;
    }

    @Override
    public boolean equals(Object o) {   //required for queue.contains()
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
