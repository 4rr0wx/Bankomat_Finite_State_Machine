package bankomat.actions;

import bankomat.grafics.BankomatView;
import bankomat.semantics.BankomatSemantics;

public abstract class BankomatAction {

    public abstract void execute(BankomatSemantics contents, BankomatView theView, int parameter);

}
