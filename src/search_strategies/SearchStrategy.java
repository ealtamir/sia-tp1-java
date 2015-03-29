package search_strategies;

import engine.GPSNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public abstract class SearchStrategy {
    protected Queue<GPSNode> frontier;
    protected Map<GPSNode, GPSNode> explored = new HashMap<GPSNode, GPSNode>();

    public long frontierSize() {
        return frontier.size();
    }

    public void addNode(GPSNode node) {
        frontier.add(node);
    }

    public GPSNode frontierPop() {
        return frontier.poll();
    }

    public void exploredPut(GPSNode key, GPSNode value) {
        explored.put(key, value);
    }
}
