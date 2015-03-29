package calcudoku;

import calcudoku.utilities.Point;
import calcudoku.utilities.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {

    public final int board_size;
    public final int total; 
    
    private Map<Integer, Block> blocks;
    private int blockNum = 0;
    private Block[][] blockArray;

    public Board(int board_size) {
        this.board_size = board_size;
        this.total = (board_size*(board_size + 1))/2;

    }
    
    public Map<Integer, Block> getBlocks(){
    	return blocks;
    }

    private void initBlockArray() {
        for(int i = 0; i < board_size; i++) {
            for (int j = 0; j <board_size; j++) {
                blockArray[i][j] = null;
            }
        }
    }

    public void addBlock(Block block) {
        if (blocks.containsKey(block.getId())) {
            System.err.println("Block already in Board");
            System.exit(1);
        }

        blocks.put(block.getId(), block);
        blockNum++;

        for (Point p : block.getPoints()) {
            if (blockArray[p.row][p.col] != null) {
                System.err.println("Blocks overlap");
                System.exit(1);
            }
            blockArray[p.row][p.col] = block;
        }
    }

    public List<Solution> getBlockSolutions() {
        List<List<Integer>> solutions;
        List<Solution> result = new ArrayList<Solution>();

        for (Block block : blocks.values()) {
            solutions = block.getSolutions();
            for (List<Integer> solution : solutions) {
                result.add(new Solution(block, solution));
            }
        }
        return result;
    }
}
