package search_strategies;

import engine.GPSNode;

import java.util.ArrayDeque;
import java.util.HashMap;

public class IterativeDFSStrategy extends SearchStrategy {
    private int limit = 0;
    private boolean nodeWasIgnored = false;
    private Cost cost;
    private GPSNode rootNode;

    public IterativeDFSStrategy(Cost cost) {
        this.cost = cost;
        this.frontier = new ArrayDeque<GPSNode>();
    }

    @Override
    public long frontierSize() {
        if(frontier.size() > 0)
            return frontier.size();
        else if(nodeWasIgnored) {
            explored = new HashMap<GPSNode, GPSNode>();
            limit++;
            nodeWasIgnored = false;
            frontier.add(rootNode);
            return frontier.size();
        }
        return 0;
    }

    @Override
    public void addNode(GPSNode node) {
        if(frontier.isEmpty()) {
            rootNode = node;
        }
        frontier.add(node);
    }

    @Override
    public GPSNode frontierPop() {
        return ((ArrayDeque<GPSNode>) frontier).pollLast();
    }

    @Override
    public void exploredPut(GPSNode key, GPSNode value) {
        if(cost.evaluate(value) > limit) {
            nodeWasIgnored = true;
            return;
        }
        explored.put(key, value);
    }
}
