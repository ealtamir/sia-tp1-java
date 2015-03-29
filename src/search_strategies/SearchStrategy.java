package search_strategies;

import engine.GPSNode;

import java.util.Queue;

public abstract class SearchStrategy {
    protected Queue<GPSNode> frontier;

    public long frontierSize(){
        return frontier.size();
    }

    public void addNode(GPSNode node){
        frontier.add(node);
    }

    public GPSNode frontierPop(){
        return frontier.poll();
    }
}
