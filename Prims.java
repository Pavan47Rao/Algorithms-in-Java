import java.util.ArrayList; 
import java.util.PriorityQueue;
import java.util.Queue;

class Edge {
    int oneEnd;
    int otherEnd;
    int cost;

    Edge(int oneEnd, int otherEnd, int cost) {
        this.oneEnd = oneEnd;
        this.otherEnd = otherEnd;
        this.cost = cost;
    }
}

class MyComparator extends Comparator<Edge>{

    @Override
    public int compare(Edge e1, Edge e2) {
        return e1.cost - e2.cost;
    }
}

class Prims {

    private static ArrayList<Edge> edgeList = new ArrayList<Edge>();
    // private HashMap<Integer, Edge> edgeMap = new HashMap<Integer, Edge>();
    private PriorityQueue<Edge> edgePQ = null;
    private Queue<Edge> minSpanningTree = null;

    private void computeMinimumSpanningTree(PriorityQueue<Edge> edgePQ, Queue<Edge> minSpanningTree) {
        int startingVertex = 1;
        boolean[] visited = new boolean[9];
        visited[startingVertex] = true;
        for (Edge edge : edgeList) {
            if(edge.oneEnd == startingVertex) {
                if(!visited[edge.otherEnd] || !visited[edge.oneEnd]) {
                    edgePQ.add(e);
                    visited[edge.otherEnd] = true;
                }
            }
        }
        Edge edgeOfMST = edgePQ.peek();
        edgePQ.poll();
        minSpanningTree.add(edgeOfMST);
        System.out.println(edgeOfMST.oneEnd);
        System.out.println(edgeOfMST.otherEnd);
        System.out.println(edgeOfMST.cost);
    }

    public static void main(String[] args) {
        Edge e1 = new Edge(1, 6, 10);
        Edge e2 = new Edge(4, 3, 12);
        Edge e3 = new Edge(2, 7, 14);
        Edge e4 = new Edge(2, 3, 16);
        Edge e5 = new Edge(7, 4, 18);
        Edge e6 = new Edge(5, 4, 22);
        Edge e7 = new Edge(5, 7, 24);
        Edge e8 = new Edge(5, 6, 25);
        Edge e9 = new Edge(1, 2, 28);
        edgeList.add(e1);
        edgeList.add(e2);
        edgeList.add(e3);
        edgeList.add(e4);
        edgeList.add(e5);
        edgeList.add(e6);
        edgeList.add(e7);
        edgeList.add(e8);
        edgeList.add(e9);

        Prims p = new Prims();

        // p.edgeMap.put(e1.oneEnd, e1);
        // p.edgeMap.put(e2.oneEnd, e2);
        // p.edgeMap.put(e3.oneEnd, e3);
        // p.edgeMap.put(e4.oneEnd, e4);
        // p.edgeMap.put(e5.oneEnd, e5);
        // p.edgeMap.put(e6.oneEnd, e6);
        // p.edgeMap.put(e7.oneEnd, e7);
        // p.edgeMap.put(e8.oneEnd, e8);
        // p.edgeMap.put(e9.oneEnd, e9);

        p.edgePQ = new PriorityQueue<>(edgeList.size(), new MyComparator());
        p.minSpanningTree = new Queue<Edge>();
        p.computeMinimumSpanningTree(p.edgePQ, p.minSpanningTree);

    }
}