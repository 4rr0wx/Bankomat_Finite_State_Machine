package bankomat.edges;

import bankomat.actions.BankomatAction;
import bankomat.automaton.BankomatState;
import bankomat.semantics.BankomatSemantics;

public class BankomatEdge {
    private int edgeNumber;
    private BankomatState nextState;
    BankomatAction theAction;

    public BankomatEdge(int n, BankomatState state, BankomatAction action) {
        edgeNumber = n;
        nextState = state;
        theAction = action;
    }

    public BankomatState getNextState(BankomatSemantics x) { // Normally this ignores the semantics. For conditional edges -> inherit
        return nextState;
    }

    public BankomatAction getAction() {
        return theAction;
    }

    public int getEdgeNumber() {
        return edgeNumber;
    }
}
