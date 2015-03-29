package engine;

import engine.api.GPSProblem;
import engine.api.GPSRule;
import engine.api.GPSState;
import engine.exception.NotAppliableException;
import search_strategies.SearchStrategy;

import java.util.HashMap;
import java.util.Map;

public abstract class GPSEngine {

	private Map<GPSNode, GPSNode> explored = new HashMap<GPSNode, GPSNode>();

	private GPSProblem problem;

	private long explosionCounter = 0;

	// Use this variable in the addNode implementation
	private SearchStrategy strategy;

	public GPSEngine(GPSProblem myProblem, SearchStrategy myStrategy) {
		problem = myProblem;
		strategy = myStrategy;
	}

	public void solve() {
		boolean finished;
		GPSNode rootNode = new GPSNode(problem.getInitState(), 0);
		strategy.addNode(rootNode);

		finished = startExploration();

		if (finished) {
			System.out.println("OK! solution found!");
		} else {
			System.err.println("FAILED! solution not found!");
		}
	}

	private boolean startExploration() {
		boolean finished = false;
		boolean failed = false;

		while (!failed && !finished) {
			if (strategy.frontierSize() <= 0) {
				failed = true;
			} else {
				finished = exploreFrontier();
			}
		}
		return finished;
	}

	private boolean exploreFrontier() {
		boolean finished = false;
		GPSNode currentNode = strategy.frontierPop();
		explored.put(currentNode, currentNode);
		if (isGoal(currentNode)) {
			finished = true;
			System.out.println(currentNode.getSolution());
			System.out.println("Expanded nodes: " + explosionCounter);
		} else {
			explode(currentNode);
			explosionCounter++;
		}
		return finished;
	}

	private  boolean isGoal(GPSNode currentNode) {
		return  currentNode.getState().satisfiesGoal();
	}

	private void explode(GPSNode node) {
		for (GPSRule rule : problem.getRules()) {
			GPSState newState = null;
			try {
				newState = rule.evalRule(node.getState());
			} catch (NotAppliableException e) {
				// Do nothing
			}

			if (nodeIsValid(node, newState, rule)) {
				addNodeToFrontier(node, newState, rule);
			}
		}
	}

	private boolean nodeIsValid(GPSNode node, GPSState newState, GPSRule rule) {
		boolean stateIsReplicated = checkBranch(node.getParent(), newState);
		boolean betterOptionFound = betterStateAlreadyChecked(node.getCost() + rule.getCost(),
				newState);
		return !stateIsReplicated && !betterOptionFound;
	}

	private void addNodeToFrontier(GPSNode node, GPSState newState, GPSRule rule) {
		GPSNode newNode = new GPSNode(newState, node.getCost() + rule.getCost());
		newNode.setParent(node);
		strategy.addNode(newNode);
	}

	private boolean betterStateAlreadyChecked(Integer cost, GPSState state) {
		if (stateInFrontier(cost, state)) {
			return true;
		}
		if (stateInExplored(cost, state)) {
			return true;
		}
		return false;
	}

	private boolean stateInExplored(Integer cost, GPSState state) {
		for (GPSNode closedNode : explored) {
			if (closedNode.getState().compare(state) && closedNode.getCost() < cost) {
				return true;
			}
		}
		return false;
	}

	private boolean stateInFrontier(Integer cost, GPSState state) {
		for (GPSNode openNode : frontier) {
			if (openNode.getState().compare(state) && openNode.getCost() < cost) {
				return true;
			}
		}
		return false;
	}

	private  boolean checkBranch(GPSNode parent, GPSState state) {
		if (parent == null) {
			return false;
		}
		return checkBranch(parent.getParent(), state) || state.compare(parent.getState());
	}
}
