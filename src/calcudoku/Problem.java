package calcudoku;

import engine.api.GPSProblem;
import engine.api.GPSRule;
import engine.api.GPSState;

import java.util.List;

/**
 * Created by Enzo on 18.03.15.
 */
public class Problem implements GPSProblem {

    @Override
    public GPSState getInitState() {
        return null;
    }

    @Override
    public GPSState getGoalState() {
        return null;
    }

    @Override
    public List<GPSRule> getRules() {
        return null;
    }

    @Override
    public Integer getHValue(GPSState state) {
        return null;
    }
}
