package engine;

public abstract class SearchStrategy {

    public long frontierSize() {
        return 0;
    }

    public void addNode(GPSNode node) {

    }

    public abstract GPSNode frontierPop();
}
