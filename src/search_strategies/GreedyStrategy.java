package search_strategies;

import engine.GPSNode;

public class GreedyStrategy extends SearchStrategy {
    private Heuristic heuristic;

    public GreedyStrategy(Heuristic heuristic){
        this.heuristic = heuristic;
    }

    @Override
    public GPSNode frontierPop() {
        return null;
    }
}
