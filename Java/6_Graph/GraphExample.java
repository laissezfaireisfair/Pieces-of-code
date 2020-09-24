import Graph.Graph;
import Graph.GraphImpl;
import Graph.WayImpl;
import java.util.List;

public class GraphExample {
    // See doc/GraphExample.png
    private static void fillGraph(Graph graph) {
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 1);
        graph.addEdge(1, 4);
    }

    public static void main(String[] args) {
        Graph graph = new GraphImpl(5);
        fillGraph(graph);
        List<Integer> neighbours = graph.getNeighbours(4);
    }
}
