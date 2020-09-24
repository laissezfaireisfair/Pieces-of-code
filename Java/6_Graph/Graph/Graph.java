package Graph;

import java.util.List;

public interface Graph {
    int getSize();
    boolean isEdgeHere(final int begin, final int end);
    boolean isWayHere(final int begin, final int end);
    boolean isConnected();
    List<Integer> getNeighbours(final int vertex);
    Way getShortestWay(final int begin, final int end);
    void addEdge(final int begin, final int end);
    boolean vertexExist(final int vertex);
    boolean vertexNotExist(final int vertex);
}