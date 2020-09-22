package Graph;

public interface Graph {
    boolean isEdgeHere(final int begin, final int end);
    boolean isWayHere(final int begin, final int end);
    boolean isConnected();
    boolean isCyclic();
    Way getShortestWay(final int begin, final int end);
}