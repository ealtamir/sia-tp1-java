package calcudoku.utilities;

import calcudoku.Block;

import java.util.List;

/**
 * Created by Enzo on 29.03.15.
 */
public class Solution {

    private final Block block;
    private final List<Integer> solution;

    public Solution(Block block, List<Integer> solution) {
        this.block = block;
        this.solution = solution;
    }

    public Block getBlock() {
        return block;
    }

    public List<Integer> getSolution() {
        return solution;
    }
}
