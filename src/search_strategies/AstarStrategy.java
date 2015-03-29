package search_strategies;

import engine.GPSNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AstarStrategy extends SearchStrategy {
    private static final int INITIAL_CAPACITY = 16384;
    private Heuristic heuristic;
    private Cost cost;

    public AstarStrategy(Heuristic heuristic, Cost cost) {
        this.heuristic = heuristic;
        this.cost = cost;
        this.frontier = new PriorityQueue<GPSNode>(INITIAL_CAPACITY, new GPSNodeComparator());
    }

    private int evaluation(GPSNode node) {
        return cost.evaluate(node) + heuristic.evaluate(node);
    }

    private class GPSNodeComparator implements Comparator<GPSNode> {
        @Override
        public int compare(GPSNode o1, GPSNode o2) {
            int v1 = evaluation(o1);
            int v2 = evaluation(o2);
            if(v1 > v2) {
                return 1;
            } else if(v1 < v2) {
                return -1;
            }
            return 0;
        }
    }
}
