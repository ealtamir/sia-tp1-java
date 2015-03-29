package calcudoku;

import calcudoku.utilities.Solution;
import engine.api.GPSProblem;
import engine.api.GPSRule;
import engine.api.GPSState;
import engine.exception.NotAppliableException;

import java.util.List;

/**
 * Created by Enzo on 18.03.15.
 */
public class Problem implements GPSProblem {

    private static List<GPSRule> rules = null;
    private final Board board;

    public Problem(Board board) {
        this.board = board;
    }

    @Override
    public GPSState getInitState() {
        return null;
    }

    @Override
    public GPSState getGoalState() {
        String msg = "We're not using this goal verification method";
        throw new UnsupportedOperationException(msg);
    }

    @Override
    public List<GPSRule> getRules() {
        if (rules == null) {
            rules = generateRules();
        }
        return null;
    }

    private List<GPSRule> generateRules() {
        List<Solution> solutions = board.getBlockSolutions();
        return null;
    }

    @Override
    public Integer getHValue(GPSState state) {
        return null;
    }
}
