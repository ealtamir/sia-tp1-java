package calcudoku;

import calcudoku.utilities.Solution;

/**
 * Created by Enzo on 18.03.15.
 */
public class Rule {

    public final Integer DEFAULT_COST = 1;

    private final Block block;
    private final Solution solution;
    private final Integer cost;

    public Rule(Solution solution, Block block) {
        this.solution = solution;
        this.block = block;
        this.cost = DEFAULT_COST;
    }

    public Rule(Block block, Solution solution, Integer cost) {
        this.block = block;
        this.solution = solution;
        this.cost = cost;
    }
}
