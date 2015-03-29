package search_strategies;

import engine.GPSNode;

public abstract class Heuristic {
    public abstract int evaluate(GPSNode gpsNode);
}
