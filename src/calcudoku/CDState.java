package calcudoku;

import java.util.List;
import java.util.Map;

import engine.api.GPSState;

public class CDState implements GPSState{

	private Board board;
	private Map<Integer, List<Integer>> solutions;
	private int[] sumCols;
	private int[] sumRows;

	public CDState(Board board, Map<Integer, List<Integer>> sol) {

		this.board = board;
		this.solutions = sol;
		this.sumCols = new int[board.board_size];
		this.sumRows = new int[board.board_size];
	}

	public Map<Integer, List<Integer>> getSolutions() {
		return this.solutions;
	}

	public void setSolution(Map<Integer, List<Integer>> solutions) {
		this.solutions = solutions;
	}
	
	public Board getBoard(){
		return board;
	}

	public int hashCode() {
		int hash = 0;
		for (Integer key : solutions.keySet()) {
			hash += solutions.get(key).hashCode() + key;
		}
		return hash;
	}

	public boolean isGoal() {

		for (int i = 0; i < this.board.board_size; i++) {
			if (sumCols[i] != this.board.total
					|| sumRows[i] != this.board.total)
				return false;
		}

		return true;
	}

	public boolean hasSameSolutionsAs(CDState state) {

		for (Integer key : solutions.keySet()) {
			if (!state.getSolutions().containsKey(key))
				return false;

			List<Integer> sol1 = this.solutions.get(key);
			List<Integer> sol2 = state.getSolutions().get(key);

			if (!sol1.equals(sol2))
				return false;
		}
		return false;
	}

	@Override
	public boolean compare(GPSState state) {
		
		if (!(state instanceof CDState))
			return false;

		if (((CDState) state).getSolutions().size() != this.solutions.size())
			return false;

		if (state.hashCode() == this.hashCode())
			return true;

		return false;
	}
	

}
