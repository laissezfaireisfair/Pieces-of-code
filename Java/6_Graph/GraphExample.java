import Graph.Graph;
import Graph.GraphImpl;
import Graph.Way;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class GraphExample {
    // See doc/GraphExample.png
    private static void fillGraph(Graph graph, Scanner scanner) throws InputMismatchException, IllegalArgumentException {
        System.out.print("Type number of edges: ");
        final int numEdges = scanner.nextInt();
        for (int i = 0; i < numEdges; ++i) {
            System.out.print("Type edge as pair of vertex: ");
            final int begin = scanner.nextInt();
            final int end = scanner.nextInt();
            graph.addEdge(begin, end);
        }
    }

    private static void printNeighbours(final Graph graph, Scanner scanner) throws IllegalArgumentException {
        System.out.print("Type vertex which neighbours you need: ");
        final int vertex = scanner.nextInt();
        List<Integer> neighbours = graph.getNeighbours(vertex);
        System.out.print("Neighbours of " + vertex + " : ");
        System.out.println(Arrays.toString(neighbours.toArray()));
    }

    private static  void printIfConnected(final Graph graph) {
        if (graph.isConnected()) {
            System.out.println("Graph is connected.");
        } else {
            System.out.println("Graph is not connected.");
        }
    }

    private static void printWay(final Graph graph, Scanner scanner) throws IllegalArgumentException {
        System.out.print("Type vertexes way between you need: ");
        final int start = scanner.nextInt();
        final int finish = scanner.nextInt();
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
        System.out.print("Type size of graph: ");
        Scanner scanner = new Scanner(System.in);
        try {
            final int size = scanner.nextInt();
            Graph graph = new GraphImpl(size);
            fillGraph(graph, scanner);
            printNeighbours(graph, scanner);
            printIfConnected(graph);
            printWay(graph, scanner);
        }
        catch (InputMismatchException e) {
            System.out.print("Wrong input " + e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println("Wrong argument " + e.getMessage());
        }
        catch (IllegalStateException e) {
            System.out.println("Wrong input " + e.getMessage());
        }
    }
}
