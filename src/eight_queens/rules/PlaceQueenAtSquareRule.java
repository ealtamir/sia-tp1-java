package eight_queens.rules;

import eight_queens.api.*;
import engine.api.GPSState;
import engine.exception.NotAppliableException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Enzo on 10.03.15.
 */
public class PlaceQueenAtSquareRule extends Rule {

    private final int row;
    private final char col;

    public PlaceQueenAtSquareRule(int row, char col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String getName() {
        return String.format("(%d, %c) ", row, col);
    }

    @Override
    public GPSState evalRule(GPSState state) throws NotAppliableException {
        Queen newQueen = new Queen(row, col);
        boolean collides = false;

        if (thereIsACollision(newQueen, state)) {
            throw new NotAppliableException();
        }

        return generateNewState(state, newQueen);
    }

    private GPSState generateNewState(GPSState state, Queen newQueen) {
        Set<Queen> queenSet = new HashSet<Queen>();
        for (Queen queen : ((State) state).getQueens()) {
            queenSet.add(new Queen(queen.getRow(), queen.getCol()));
        }
        return new State(queenSet);
    }

    private boolean thereIsACollision(Queen newQueen, GPSState state) {
        for (Queen queen : ((State) state).getQueens()) {
            if (queen.collidesWith(newQueen)) {
                return true;
            }
        }
        return false;
    }
}
