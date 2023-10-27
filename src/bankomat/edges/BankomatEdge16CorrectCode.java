package bankomat.edges;

import bankomat.actions.BankomatAction;
import bankomat.actions.Edge16Action;
import bankomat.automaton.BankomatState;
import bankomat.semantics.BankomatSemantics;

public class BankomatEdge16CorrectCode extends BankomatEdge{

    public BankomatEdge16CorrectCode() {
        super(16, null, null);
    }

    public BankomatState getNextState(BankomatSemantics x) {
        if (x.codeIsCorrect()) {
//            theAction = new Edge161Action();
            return BankomatState.MON1;
        } else {
//            theAction = new Edge162Action();
            return BankomatState.DIG0;
        }
    }

    public BankomatAction getAction() {
        return new Edge16Action();
    }

}
