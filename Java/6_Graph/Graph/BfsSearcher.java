package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class BfsSearcher {
    private boolean mIsWayExist;
    private final int mSize;
    private final ArrayList<Integer> mParent;
    private final int mStart, mFinish;

    BfsSearcher(final Graph graph, final int start, final int finish) {
        mSize = graph.getSize();
        mParent = new ArrayList<>(mSize);
        mStart = start;
        mFinish = finish;
        for (int i = 0; i < mSize; ++i)
            mParent.add(-1);
        search(graph);
    }

    public boolean isWayExist() {
        return mIsWayExist;
    }

    public Way getWay() throws IllegalStateException {
        if (!isWayExist())
            throw new IllegalStateException("Cannot return non-existing way");
        LinkedList<Integer> wayList  = new LinkedList<>();
        for (int i = mFinish; i != -1; i = mParent.get(i)) {
            wayList.addFirst(i);
        }
        return new WayImpl(wayList);
    }

    public boolean isConnected() {
        for (int i = 0; i < mSize; ++i) {
            if (i != mStart && mParent.get(i) == -1) {
                return false;
            }
        }
        return true;
    }

    private void search(final Graph graph) {
        ArrayList<Integer> distance = new ArrayList<>(mSize);
        for (int  i = 0; i < mSize; ++i) distance.add(-1);
        distance.set(mStart, 0);

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(mStart);

        while (!queue.isEmpty()) {
            final int vertexNow = queue.pop();
            final int distanceNow = distance.get(vertexNow);
            List<Integer> neighbours = graph.getNeighbours(vertexNow);
            for (int neighbour : neighbours) {
                if (distance.get(neighbour) > distanceNow + 1) {
                    distance.set(neighbour, distanceNow + 1);
                    mParent.set(neighbour, vertexNow);
                    queue.add(neighbour);
                }
            }
        }
        mIsWayExist = distance.get(mFinish) != -1;
    }
}
