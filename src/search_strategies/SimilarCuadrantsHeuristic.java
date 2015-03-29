package search_strategies;

import java.util.List;
import java.util.Map;

import calcudoku.Block;
import calcudoku.CDState;
import engine.GPSNode;

public class SimilarCuadrantsHeuristic extends Heuristic{

	@Override
	public int evaluate(GPSNode gpsNode) {
		
		CDState state = (CDState) gpsNode.getState();
		int p = state.getBoard().board_size /2;
		int q = state.getBoard().board_size - p;
		int[] cuadrants = new int[4];
		
		
		
		
		return 0;
	}

}
