package search_strategies;

import engine.GPSNode;

import java.util.ArrayDeque;
import java.util.LinkedList;

/* LIFO */
public class DFSStrategy extends SearchStrategy {

    public DFSStrategy() {
        this.frontier = new ArrayDeque<GPSNode>();
    }

    @Override
    public GPSNode frontierPop() {
        return ((LinkedList<GPSNode>) frontier).pollLast();
    }
}
