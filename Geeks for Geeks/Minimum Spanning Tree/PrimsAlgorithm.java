import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];

        HashMap<Integer, Integer> latestWeight = new HashMap<>(); // will store most updated weight of node. required since getting a random element from queue is not possible
        PriorityQueue<Node> queue = new PriorityQueue<>();  // will provide the unvisited node with minimum weight

        parent[0] = -1;     //first node setup
        Node first = new Node(0);
        first.weight = 0;
        queue.offer(first);

        for(int i = 1; i < V; i++) {    // initially the weight of each node(except the first) will be Integer.MAX_VALUE
            queue.offer(new Node(i));
            latestWeight.put(i, Integer.MAX_VALUE);
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();   // visiting the node with minimum weight, hence removing it from queue because queue will hold only unvisited nodes
            int currentNode = node.value;
            visited[currentNode] = true;  // marking the node as visited
            ArrayList<ArrayList<Integer>> list = adj.get(currentNode);      //neighbors of node from adjacency list
            for(ArrayList<Integer> x : list) {
                int destinationNode = x.get(0);     // value of the neighbor node
                int weight = x.get(1);      // weight of edge from current node to neighbor node
                if(!visited[destinationNode]) {
                    if (weight < latestWeight.get(destinationNode)) {       // if weight of edge is less than latest weight we know (stored in map)
                        latestWeight.replace(destinationNode, weight);      // replace the weight with new minimum weight in the map
                        parent[destinationNode] = currentNode;      // mark the current node as parent of neighbor node
                        queue.remove(new Node(destinationNode));    //since we cannot directly get/update element in queue, we will remove existing element and add updated one
                        Node updatedNode = new Node(destinationNode);
                        updatedNode.weight = weight;
                        queue.offer(updatedNode);   // adding updated node to queue
                    }
                }
            }
        }
        int sum = 0;
        for(int i = 1; i < V; i++) {
            for(ArrayList<Integer> x : adj.get(i)) {
                if(x.get(0) == parent[i]) sum += x.get(1); // summing weight of edges which are part of MST (edge between each node and its parent)
            }
        }
        return sum;
    }
}

class Node implements Comparable {
    int value;
    int weight = Integer.MAX_VALUE;

    Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {  // required for priority queue
        if (o instanceof Node) {
            return this.weight - ((Node)o).weight;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) { // required for hash map
        if (o instanceof Node) {
            return this.value == ((Node)o).value;
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


