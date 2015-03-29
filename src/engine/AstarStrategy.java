package engine;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AstarStrategy extends SearchStrategy{
    private Heuristic h;

    AstarStrategy(Heuristic h){

    }
    @Override
    public GPSNode frontierPop() {
        return null;
    }

    private int evaluation(GPSNode node){
        throw new NotImplementedException();
    }
}
