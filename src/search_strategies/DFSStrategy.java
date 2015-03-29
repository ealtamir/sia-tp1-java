package search_strategies;

import engine.GPSNode;

import java.util.LinkedList;

public class DFSStrategy extends SearchStrategy {

    public DFSStrategy(){
        this.frontier = new LinkedList<GPSNode>();
    }

    @Override
    public GPSNode frontierPop() {
        return ((LinkedList<GPSNode>)frontier).getLast();
    }
}
