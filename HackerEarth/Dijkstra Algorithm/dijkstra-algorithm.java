import java.util.*;
import java.io.*;

class TestClass {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//|
        int vertices = Integer.parseInt(br.readLine());//                          |
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();//                      |
        for(int i = 0; i < vertices; i++) {//                                      |
            adj.add(new ArrayList<Node>());//                                      |
            String[] s = br.readLine().split(" ");//                          |
            for(int j = 0; j < s.length; j++) {//                                  stupid input shit
                int temp = Integer.parseInt(s[j]);//                               |
                if (temp != 0) adj.get(i).add(new Node(j, temp));//                |
            }//                                                                    |
        }//                                                                        |
        int q = Integer.parseInt(br.readLine());//                                 |
        while(q-- != 0) {//                                                        |
            String[] s = br.readLine().split(" "); //_________________________|
            int source = Integer.parseInt(s[0]);
            int destination = Integer.parseInt(s[1]);
            int[] dist = new int[vertices];
            dijsktra(vertices, adj, source, dist);  //call to actual shit
            System.out.println(dist[destination]);
        }
        br.close();
    }

    static void dijsktra(int vertices, ArrayList<ArrayList<Node>> adj, int source, int[] dist) {
        boolean[] visited = new boolean[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(source, 0)); //adding source node to queue

        while(!pq.isEmpty()) {
            int u = pq.poll().value; // popped node index
            visited[u] = true;
            for(Node neighbor: adj.get(u)) {
                if(!visited[neighbor.value]) { //if the neighbor is unvisited
                    int calculatedDistance = dist[u] + neighbor.weight; // distance from source to popped node + distance from popped node to neighbor
                    if(calculatedDistance < dist[neighbor.value]) { // if calculatedDistance is less than distance from source to neighbor
                        pq.remove(new Node(neighbor.value, dist[neighbor.value])); // remove the node from queue if it exists, since now we have a shorter path to node
                        dist[neighbor.value] = calculatedDistance; //updates the distance from source to neighbor
                        pq.offer(new Node(neighbor.value, calculatedDistance)); //adds the node to queue with updated distance
                    }
                }
            }
        }
    }
}


class Node implements Comparable {
    int value;  //index of the node
    int weight; //weight of the path to this node

    Node(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {    //required for priorityQueue
        if(o instanceof Node) {
            return this.weight - ((Node)o).weight;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {   //required for removal from priorityQueue
        if(o instanceof Node) {
            return this.value == ((Node)o).value;
        }
        return super.equals(o);
    }
}
