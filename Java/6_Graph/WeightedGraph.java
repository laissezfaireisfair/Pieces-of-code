package Graph;

public interface WeightedGraph extends Graph {
    double getEdgeWeight(final int begin, final int end);
    WeightedWay getLightestWay(final int begin, final int end);
    @Override
    WeightedWay getShortestWay(final int begin, final int end);
}