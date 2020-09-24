import Graph.Graph;
import Graph.GraphImpl;
import Graph.Way;
import Graph.WayImpl;
import java.util.List;
import java.util.Arrays;

public class GraphExample {
    // See doc/GraphExample.png
    private static void fillGraph(Graph graph) {
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        graph.addEdge(0, 3);
    }

    private static void printNeighbours(final Graph graph, final int vertex) {
        List<Integer> neighbours = graph.getNeighbours(vertex);
        System.out.println("Neighbours of " + vertex + " :");
        System.out.println(Arrays.toString(neighbours.toArray()));
    }

    private static  void printIfConnected(final Graph graph) {
        if (graph.isConnected()) {
            System.out.println("Graph is connected.");
        } else {
            System.out.println("Graph is not connected.");
        }
    }

    private static void printWay(final Graph graph, final int start, final int finish) {
        if (!graph.isWayHere(start, finish)) {
            System.out.println("There is no way between " + start + " and " + finish);
            return;
        }
        Way way = graph.getShortestWay(start, finish);
        System.out.println("Way between " + start + " and " + finish + " :");
        for (int i = 0; i < way.getLength(); ++i) {
            System.out.print(way.at(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph graph = new GraphImpl(5);
        fillGraph(graph);
        printNeighbours(graph, 3);
        printIfConnected(graph);
        printWay(graph, 0, 1);
    }
}
