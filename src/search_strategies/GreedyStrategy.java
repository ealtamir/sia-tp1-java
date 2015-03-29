package search_strategies;

import engine.GPSNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GreedyStrategy extends SearchStrategy {
    private static final int INITIAL_CAPACITY = 16384;
    private Heuristic heuristic;

    public GreedyStrategy(Heuristic heuristic) {
        this.heuristic = heuristic;
        this.frontier = new PriorityQueue<GPSNode>(INITIAL_CAPACITY, new GPSNodeComparator());
    }

    @Override
    public GPSNode frontierPop() {
        return frontier.poll();
    }

    private class GPSNodeComparator implements Comparator<GPSNode> {
        @Override
        public int compare(GPSNode o1, GPSNode o2) {
            int v1 = heuristic.evaluate(o1);
            int v2 = heuristic.evaluate(o2);
            if(v1 > v2) {
                return 1;
            } else if(v1 < v2) {
                return -1;
            }
            return 0;
        }
    }
}
