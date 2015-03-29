package calcudoku;

import java.util.List;
import java.util.Map;

/**
 * Created by Enzo on 29.03.15.
 */
public class Board {

    public final int board_size;
    public final int total; 
    
    private Map<Integer, Block> blocks;
    private int block_num = 0;

    public Board(int board_size) {
        this.board_size = board_size;
        this.total = (board_size*(board_size + 1))/2;

    }
    
    public Map<Integer, Block> getBlocks(){
    	return blocks;
    }

    public void addBlock(Block block) {



    }

    public void getBlockSolutions() {

    }
}
