package engine;

/**
 * Created by Enzo on 28.03.15.
 */
public abstract class SearchStrategy {

    public long frontierSize() {
        return 0;
    }

    public void addNode(GPSNode node) {

    }

    public GPSNode frontierPop() {
        return null;
    }
}
