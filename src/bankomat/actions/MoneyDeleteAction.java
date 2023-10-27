package bankomat.actions;

import bankomat.grafics.BankomatView;
import bankomat.semantics.BankomatSemantics;

public class MoneyDeleteAction extends BankomatAction {
    public void execute(BankomatSemantics contents, BankomatView theView, int parameter) {
        contents.removeAmount();
        theView.setText("Geld: " + contents.amount);
    }
}
