package calcudoku;

import calcudoku.exceptions.BlockClassAlreadyInitiatedException;
import calcudoku.exceptions.BlockClassNotInitiatedException;
import calcudoku.exceptions.InvalidBlockStructure;
import calcudoku.exceptions.InvalidSolutionSizeException;
import calcudoku.utilities.Point;

import java.util.Iterator;
import java.util.List;

import static utilities.CombinationsCalculator.calculateCombinations;

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

    public String toString() {
        return String.valueOf(total) + operation;
    }

    private boolean pointsAreInvalid(List<Point> points) {
        // TODO: Check here that all the points of the block are adjacent.
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

    public List<List<Integer>> getSolutions() {
        List<List<Integer>> solutions = calculateCombinations(
                operation, total, squares_num, boardSize);
        solutions = removeInvalidSolutions(solutions);
        return solutions;
    }

    private List<List<Integer>> removeInvalidSolutions(List<List<Integer>> solutions) {
        int invalidSolutionCount = 0;
        Iterator<List<Integer>> iterator = solutions.iterator();
        while (iterator.hasNext()) {
            List<Integer> solution = iterator.next();
            if (solutionIsInvalid(solution)) {
                System.out.print("Invalid solution removed: " + solution.toString());
                invalidSolutionCount += 1;
                iterator.remove();
            }
        }
        System.out.println("Removed " + invalidSolutionCount + " invalid solutions.");
        return solutions;
    }

    private boolean solutionIsInvalid(List<Integer> solution) {
        if (solution.size() != points.size()) {
            System.err.println("Solution size " + String.valueOf(solution.size())
                    + " doesn't match points " + points.toString());
            System.exit(1);
        }
        return conflictingSolutionExist(solution);
    }

    private boolean conflictingSolutionExist(List<Integer> solution) {
        boolean sameSolution, inSameRow, inSameCol;

        for (int i = 0; i < solution.size(); i++) {
            for (int j = 0; j < solution.size(); j++) {
                if (i == j) {
                    continue;
                }

                sameSolution = solution.get(i).equals(solution.get(j));
                inSameRow = points.get(i).row == points.get(j).row;
                inSameCol = points.get(i).col == points.get(j).col;
                if (sameSolution && (inSameRow || inSameCol)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public List<Point> getPoints() {
        return points;
    }
}
