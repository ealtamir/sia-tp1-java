package engine;

import engine.api.GPSState;

public class GPSNode {

	private GPSState state;

	private GPSNode parent;

	private int cost;

	public GPSNode(GPSState state, int cost) {
		super();
		this.state = state;
		this.cost = cost;
	}

	public GPSNode getParent() {
		return parent;
	}

	public void setParent(GPSNode parent) {
		this.parent = parent;
	}

	public GPSState getState() {
		return state;
	}

	public Integer getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return state.toString();
	}

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        GPSNode gpsNode = (GPSNode) o;

        if(!state.equals(gpsNode.state)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }

    public String getSolution() {
		if (this.parent == null) {
			return this.state.toString();
		}
		return this.parent.getSolution() + "\n" + this.state;

	}
}
