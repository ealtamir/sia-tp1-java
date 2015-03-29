package search_strategies;

import engine.GPSNode;

public class Cost {
    public int evaluate(GPSNode gpsNode) {
        return gpsNode.getCost();
    }
}
