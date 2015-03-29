package search_strategies;

import engine.GPSNode;

import java.util.LinkedList;

/* FIFO */
public class BFSStrategy extends SearchStrategy {
    private Cost cost;
    private static final int INITIAL_CAPACITY = 16384;

    public BFSStrategy(Cost cost){
        this.cost = cost;
        this.frontier = new LinkedList<GPSNode>();
    }

    private int evaluation(GPSNode node){
        return cost.evaluate(node);
    }

    @Override
    public GPSNode frontierPop() {
        return ((LinkedList<GPSNode>) frontier).getFirst();
    }
}
