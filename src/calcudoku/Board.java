package calcudoku;

import calcudoku.exceptions.BlockAlreadyInBoardException;
import calcudoku.exceptions.BlockOverlapException;
import calcudoku.utilities.Point;

import java.util.List;
import java.util.Map;

/**
 * Created by Enzo on 29.03.15.
 */
public class Board {

    public final int board_size;

    private Map<Integer, Block> blocks;
    private int block_num = 0;
    private Block[][] blockArray;

    public Board(int board_size) {
        this.board_size = board_size;
        blockArray = new Block[board_size][board_size];
        initBlockArray();
    }

    private void initBlockArray() {
        for(int i = 0; i < board_size; i++) {
            for (int j = 0; j <board_size; j++) {
                blockArray[i][j] = null;
            }
        }
    }

    public void addBlock(Block block)
            throws BlockOverlapException, BlockAlreadyInBoardException {
        if (blocks.containsKey(block.getId())) {
            throw new BlockAlreadyInBoardException();
        }

        blocks.put(block.getId(), block);
        block_num += 1;

        for (Point p : block.getPoints()) {
            if (blockArray[p.row][p.col] != null) {
                throw new BlockOverlapException();
            }
            blockArray[p.row][p.col] = block;
        }
    }

    public void getBlockSolutions() {

    }
}
