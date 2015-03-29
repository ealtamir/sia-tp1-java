package search_strategies;

import engine.GPSNode;

import java.util.ArrayDeque;

/* FIFO */
public class BFSStrategy extends SearchStrategy {
    private Cost cost;

    public BFSStrategy(Cost cost) {
        this.cost = cost;
        this.frontier = new ArrayDeque<GPSNode>();
    }

    private int evaluation(GPSNode node) {
        return cost.evaluate(node);
    }

    @Override
    public GPSNode frontierPop() {
        return ((ArrayDeque<GPSNode>) frontier).pollFirst();
    }
}
