package search_strategies;

import engine.GPSNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AstarStrategy extends SearchStrategy {
    private Heuristic heuristic;
    private Cost cost;
    private PriorityQueue<GPSNode> frontier;
    private static final int INITIAL_CAPACITY = 16384;

    public AstarStrategy(Heuristic heuristic, Cost cost){
        this.heuristic = heuristic;
        this.cost = cost;
        frontier = new PriorityQueue<GPSNode>(INITIAL_CAPACITY, new GPSNodeComparator());
    }

    @Override
    public GPSNode frontierPop() {
        return frontier.poll();
    }

    private int evaluation(GPSNode node){
        return cost.evaluate(node) + heuristic.evaluate(node);
    }

    private class GPSNodeComparator implements Comparator<GPSNode>{
        @Override
        public int compare(GPSNode o1, GPSNode o2) {
            return evaluation(o1) - evaluation(o2);
        }
    }
}
