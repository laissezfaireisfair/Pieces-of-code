package Graph;

import java.util.*;

public class GraphImpl {
	private ArrayList<LinkedList<Integer>> mBody;

	public GraphImpl(final ArrayList<ArrayList<Integer>> matrix) {
		final int size = matrix.size();
		mBody = new ArrayList<LinkedList<Integer>>(size);
		for (int i = 0; i < size; ++i) {
			mBody.add(new LinkedList<Integer>());
			for (int j = 0; j < size; ++j) {
				if (matrix.get(i).get(j) != 0) {
					mBody.get(i).add(j);
				}
			}
		}
	}

	public boolean isEdgeHere(final int begin, final int end) {
		return mBody.get(begin).contains(end);
	}

	boolean isWayHere(final int begin, final int end) {
		BfsSearcher searcher = new BfsSearcher(this, begin, end);
		return searcher.isWayExist();
	}

	Way getShortestWay(final int begin, final int end) throws Exception {
		BfsSearcher searcher = new BfsSearcher(this, begin, end);
		return searcher.getWay();
	}
}
