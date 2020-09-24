package Graph;

import java.util.ArrayList;
import java.util.List;

public class WayImpl implements Way {
    private final ArrayList<Integer> mBody;

    WayImpl(final List<Integer> vertexes) {
        mBody = new ArrayList<>(vertexes);
    }

    public int getLength() {
        return mBody.size();
    }

    public int at(final int place) throws ArrayIndexOutOfBoundsException {
        if (place >= getLength())
            throw new ArrayIndexOutOfBoundsException("Accessing non-existing element");
        return mBody.get(place);
    }
}