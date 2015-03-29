package eight_queens.api;

import engine.api.GPSRule;
import engine.api.GPSState;
import engine.exception.NotAppliableException;

/**
 * Created by Enzo on 10.03.15.
 */
public abstract class Rule implements GPSRule {

    @Override
    public Integer getCost() {
        return 1;
    }

    abstract public String getName();

    abstract public GPSState evalRule(GPSState state) throws NotAppliableException;
}
