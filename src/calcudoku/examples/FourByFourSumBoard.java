package calcudoku.examples;

import calcudoku.Block;
import calcudoku.Board;
import calcudoku.utilities.Point;

import java.util.ArrayList;
import java.util.List;

public class FourByFourSumBoard {
    public static final String BOARD_NAME = "4v4,+";
    private static final int BOARD_SIZE = 4;
    private static final String NAME = "four_by_four_sum_board";
    private Board board;

    // http://www.conceptispuzzles.com/index.aspx?uri=puzzle/euid/010000002a6e5cbaa22408b0fa6312c6db4a88d62fc9f2953642b5523645754c48602f610e4c2ebd5db5f5de7b35b1720896f2dd/play

    public Board buildBoard() {
        board = new Board(BOARD_SIZE);
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 1));

        board.addBlock(new Block('+', 2, 4, BOARD_SIZE, points));
        points = new ArrayList<Point>();
        points.add(new Point(0, 2));
        points.add(new Point(1, 2));
        board.addBlock(new Block('+', 2, 6, BOARD_SIZE, points));
        points = new ArrayList<Point>();
        points.add(new Point(1, 0));
        points.add(new Point(2, 0));
        board.addBlock(new Block('+', 2, 3, BOARD_SIZE, points));
        points = new ArrayList<Point>();
        points.add(new Point(1, 1));
        points.add(new Point(2, 1));
        board.addBlock(new Block('+', 2, 7, BOARD_SIZE, points));
        points = new ArrayList<Point>();
        points.add(new Point(2, 2));
        board.addBlock(new Block('+', 1, 1, BOARD_SIZE, points));
        points = new ArrayList<Point>();
        points.add(new Point(0, 3));
        board.addBlock(new Block('+', 1, 4, BOARD_SIZE, points));
        points = new ArrayList<Point>();
        points.add(new Point(3, 0));
        points.add(new Point(3, 1));
        board.addBlock(new Block('+', 2, 6, BOARD_SIZE, points));
        points = new ArrayList<Point>();
        points.add(new Point(3, 2));
        points.add(new Point(3, 3));
        board.addBlock(new Block('+', 2, 4, BOARD_SIZE, points));
        points = new ArrayList<Point>();
        points.add(new Point(1, 3));
        points.add(new Point(2, 3));
        board.addBlock(new Block('+', 2, 5, BOARD_SIZE, points));

        return board;
    }
}
