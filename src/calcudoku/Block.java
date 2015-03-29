package calcudoku;

import calcudoku.exceptions.BlockClassAlreadyInitiatedException;
import calcudoku.exceptions.BlockClassNotInitiatedException;
import calcudoku.exceptions.InvalidBlockStructure;
import calcudoku.utilities.Point;

import java.util.List;

/**
 * Created by Enzo on 29.03.15.
 */
public class Block {

    static private int blockCounter = 0;
    static private int boardSize = -1;

    private final char operation;
    private final int id;
    private final List<Point> points;

    private int squares_num = 0;
    private int total = 0;

    public Block(char operation, int squares_num, int total, List<Point> points)
            throws BlockClassNotInitiatedException, InvalidBlockStructure {
        this.operation = operation;
        this.squares_num = squares_num;
        this.total = total;
        this.id = Block.generateId();

        if (pointsAreInvalid(points)) {
            throw new InvalidBlockStructure();
        }
        this.points = points;

        if (Block.boardSize == -1) {
            throw new BlockClassNotInitiatedException();
        }
    }

    private boolean pointsAreInvalid(List<Point> points) {
        // TODO: Check here that all the points of the block are adyacent.
        return false;
    }

    private static int generateId() {
        blockCounter += 1;
        return blockCounter - 1;
    }

    public static void initBlockClass(int n)
            throws BlockClassAlreadyInitiatedException {
        if (boardSize != -1) {
            throw new BlockClassAlreadyInitiatedException();
        }
        boardSize = n;
    }

    public void getMoves() {

    }

    public int getId() {
        return id;
    }

    public List<Point> getPoints() {
        return points;
    }
}
