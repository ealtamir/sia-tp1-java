package eight_queens.api;

import eight_queens.QueensState;
import engine.api.GPSState;

import java.util.Set;

/**
 * Created by Enzo on 10.03.15.
 */
public class State implements QueensState {

    private final Set<Queen> queens;

    public State(Set<Queen> queens) {
        this.queens = queens;
    }

    @Override
    public boolean compare(GPSState state) {
        if (haveSameNumberOfQueens(state) == false) {
            return false;
        } else if (haveTheSameQueens(state) == false) {
            return false;
        }
        return true;
    }

    private boolean haveTheSameQueens(GPSState state) {
        return queens.equals(((State) state).getQueens());
    }

    public int numberOfQueens() {
        return queens.size();
    }

    private boolean haveSameNumberOfQueens(GPSState state) {
        return numberOfQueens() != ((QueensState) state).numberOfQueens();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        if (queens != null ? !queens.equals(state.queens) : state.queens != null) return false;

        return true;
    }

    public Set<Queen> getQueens() {
        return queens;
    }

}
