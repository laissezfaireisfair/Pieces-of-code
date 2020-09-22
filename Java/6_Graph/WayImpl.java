package Graph;

private class WayImpl implements Way {
    private final ArrayList mBody;
    WayImpl(final ArrayList vertexes) {
        mBody = vertexes;
    }

    int getLength() {
        return mBody.size();
    }

    int at(final int place) {
        if (place >= getLength())
            throw new ArrayIndexOutOfBoundsException("Accessing unexisting element");
        return mBody.
    }
}