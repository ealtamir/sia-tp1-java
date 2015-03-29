package eight_queens.api;

import eight_queens.rules.PlaceQueenAtSquareRule;
import engine.api.GPSProblem;
import engine.api.GPSRule;
import engine.api.GPSState;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Enzo on 10.03.15.
 */
public class Problem implements GPSProblem {

    final public int[] rows = {8, 7, 6, 5, 4, 3, 2, 1};
    final public char[] cols = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    @Override
    public GPSState getInitState() {
        Set<Queen> queenSet = new HashSet<Queen>();
        return new State(queenSet);
    }

    @Override
    public GPSState getGoalState() {
        Set<Queen> queenSet = new HashSet<Queen>();
        queenSet.add(new Queen(5, 'a'));
        queenSet.add(new Queen(3, 'b'));
        queenSet.add(new Queen(1, 'c'));
        queenSet.add(new Queen(7, 'd'));
        queenSet.add(new Queen(8, 'f'));
        queenSet.add(new Queen(6, 'g'));
        queenSet.add(new Queen(4, 'h'));
        return new State(queenSet);
    }

    @Override
    public List<GPSRule> getRules() {
        List<GPSRule> rules = new ArrayList<GPSRule>();
        for (int i : rows) {
            for (char c : cols) {
                rules.add(new PlaceQueenAtSquareRule(i, c));
            }
        }
        return rules;
    }

    @Override
    public Integer getHValue(GPSState state) {
        return null;
    }
}
