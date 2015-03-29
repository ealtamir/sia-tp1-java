package utilities;

import java.util.ArrayList;
import java.util.List;

public class CombinationsCalculator {

    /**
     *
     * @param op one of '+', '-', '/' or '*'
     * @param total
     * @param squares
     * @param n size of the board
     * @return A list of lists of possible combinations
     */
    static public List<List<Integer>> calculateCombinations(
            char op, int total, int squares, int n) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        if(squares == 1) {
            List<Integer> solution = new ArrayList<Integer>();
            solution.add(total);
            combinations.add(solution);
            return combinations;
        }

        for(int i = 1; i <= n; i++) {
            ArrayList<Integer> aux = new ArrayList<Integer>();
            aux.add(i);
            ArrayList<ArrayList<Integer>> temp = dispatch(op, total, squares, i, n, aux);
            if(temp != null)
                combinations.addAll(temp);
        }
        return combinations;
    }

    static public ArrayList<ArrayList<Integer>> dispatch(
            char op, int total, int squares, int v, int n, ArrayList<Integer> checked) {
        switch(op) {
            case '+':
                return calculateAdditions(total, squares, v, n, checked);
            case '-':
                return calculateSubtraction(total, squares, v, n, checked);
            case '*':
                return calculateProducts(total, squares, v, n, checked);
            case '/':
                return calculateDivisions(total, squares, v, n, checked);
            default:
                System.err.println("Invalid operator '" + op + "'");
                System.exit(1);
        }
        return null; /* for the compiler to shut up */
    }

    static private ArrayList<ArrayList<Integer>> calculateHelper(Operator op, int total, int squares, int v, int n, ArrayList<Integer> checked) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) {
            if(op.apply(i, v) <= total) {
                numbers.add(i);
            }
        }
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
        for(Integer i : numbers) {
            if(op.apply(i, v) == total && checked.size() + 1 == squares) {
                ArrayList<Integer> aux = new ArrayList<Integer>();
                aux.addAll(checked);
                aux.add(i);
                combinations.add(aux);
            } else if(op.apply(v, i) < total && checked.size() + 1 < squares) {
                ArrayList<Integer> newChecked = new ArrayList<Integer>(checked);
                newChecked.add(i);
                combinations.addAll(calculateHelper(op, total, squares, (int) op.apply(v, i), n, newChecked));
            }
        }
        return combinations;
    }

    static private ArrayList<ArrayList<Integer>> calculateDivisions(
            int total, int squares, int v, int n, ArrayList<Integer> checked) {
        for(int i = 1; i <= n; i++) {
            if(v / i == total) {
                ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
                ArrayList<Integer> l1 = new ArrayList<Integer>();
                ArrayList<Integer> l2 = new ArrayList<Integer>();
                l1.add(v);
                l1.add(i);
                l2.add(i);
                l2.add(v);
                ret.add(l1);
                ret.add(l2);
                return ret;
            }
        }
        return null;
    }

    static private ArrayList<ArrayList<Integer>> calculateProducts(
            int total, int squares, int v, int n, ArrayList<Integer> checked) {
        return calculateHelper(new ProductOperator(), total, squares, v, n, checked);
    }

    static private ArrayList<ArrayList<Integer>> calculateSubtraction(
            int total, int squares, int v, int n, ArrayList<Integer> checked) {
        return calculateHelper(new SubtractionOperator(), total, squares, v, n, checked);
    }

    static private ArrayList<ArrayList<Integer>> calculateAdditions(
            int total, int squares, int v, int n, ArrayList<Integer> checked) {
        return calculateHelper(new AdditionOperator(), total, squares, v, n, checked);
    }

    static private class SubtractionOperator implements Operator {

        @Override
        public float apply(int a, int b) {
            return a > b ? a - b : b - a;
        }
    }

    static private class ProductOperator implements Operator {

        @Override
        public float apply(int a, int b) {
            return a * b;
        }
    }

    static private class AdditionOperator implements Operator {

        @Override
        public float apply(int a, int b) {
            return (float) a + b;
        }
    }
}

