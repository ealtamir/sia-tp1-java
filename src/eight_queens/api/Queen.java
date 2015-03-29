package eight_queens.api;

/**
 * Created by Enzo on 10.03.15.
 */
public class Queen {

    private int row;
    private char col;

    public Queen(int row, char col) {
        assert(row > 0 && row < 9);
        assert(col >= 'a' && col <= 'h');

        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        Queen q = (Queen) o;
        return row == q.getRow() && col == q.getCol();
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + (int) col;
        return result;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getCol() {
        return col;
    }

    public void setCol(char col) {
        this.col = col;
    }

    public boolean collidesWith(Queen newQueen) {
        if (inSameRowAs(newQueen)) {
            return true;
        } else if (inSameColAs(newQueen)) {
            return true;
        } else if (inSameDeclinedDiagonalAs(newQueen)) {
            return true;
        } else if (inSameInclinedDiagonalAs(newQueen)) {
            return true;
        }
        return false;
    }

    private boolean inSameRowAs(Queen q2) {
        return row == q2.getRow();
    }

    private boolean inSameColAs(Queen q2) {
        return col == q2.getCol();
    }

    private boolean inSameInclinedDiagonalAs(Queen q2) {
        return (row + col) == (q2.getRow() + q2.getCol());
    }

    private boolean inSameDeclinedDiagonalAs(Queen q2) {
        return (col - row) == (q2.getCol() - q2.getRow());
    }

}
