package Graph;

import java.util.*;

public interface Graph {
    int getSize();
    boolean isEdgeHere(final int begin, final int end);
    boolean isWayHere(final int begin, final int end);
    boolean isConnected();
    boolean isCyclic();
    List<Integer> getNeighbours();
    Way getShortestWay(final int begin, final int end);
}