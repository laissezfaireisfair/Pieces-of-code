package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphImpl implements Graph {
	private ArrayList<LinkedList<Integer>> mBody;

	public GraphImpl(final List<List<Integer>> matrix) {
		final int size = matrix.size();
		mBody = new ArrayList<>(size);
		for (int i = 0; i < size; ++i) {
			mBody.add(new LinkedList<>());
			for (int j = 0; j < size; ++j) {
				if (matrix.get(i).get(j) != 0) {
					mBody.get(i).add(j);
				}
			}
		}
	}

	public GraphImpl(final int size) {
		mBody = new ArrayList<>(size);
		for (int i = 0; i < size; ++i) {
			mBody.add(new LinkedList<>());
		}
	}

	public int getSize() {
		return mBody.size();
	}

	public boolean isEdgeHere(final int begin, final int end) throws IllegalArgumentException {
		if (vertexNotExist(begin) || vertexNotExist(end)) {
			throw new IllegalArgumentException("No such vertex");
		}
		return mBody.get(begin).contains(end);
	}

	public boolean isWayHere(final int begin, final int end) throws IllegalArgumentException {
		if (vertexNotExist(begin) || vertexNotExist(end)) {
			throw new IllegalArgumentException("No such vertex");
		}
		BfsSearcher searcher = new BfsSearcher(this, begin, end);
		return searcher.isWayExist();
	}

	public Way getShortestWay(final int begin, final int end) throws IllegalArgumentException, IllegalStateException {
		if (vertexNotExist(begin) || vertexNotExist(end)) {
			throw new IllegalArgumentException("No such vertex");
		}
		BfsSearcher searcher = new BfsSearcher(this, begin, end);
		return searcher.getWay();
	}

	public boolean isConnected() {
		if (mBody.size() == 0)
			return true;
		BfsSearcher searcher = new BfsSearcher(this, 0, getSize() - 1);
		return searcher.isWayExist();
	}

	public List<Integer> getNeighbours(final int vertex) throws IllegalArgumentException {
		if (vertexNotExist(vertex)) {
			throw new IllegalArgumentException("No such vertex");
		}
		return mBody.get(vertex);
	}

	public void addEdge(final int begin, final int end) throws IllegalArgumentException {
		if (vertexNotExist(begin) || vertexNotExist(end)) {
			throw new IllegalArgumentException("No such vertex");
		}
		if (!mBody.get(begin).contains(end)) {
			mBody.get(begin).add(end);
		}
	}

	public boolean vertexExist(final int vertex) {
		return vertex < mBody.size() && vertex >= 0;
	}

	public boolean vertexNotExist(final int vertex) {
		return !vertexExist(vertex);
	}
}
