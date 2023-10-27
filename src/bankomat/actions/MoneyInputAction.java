package bankomat.actions;

import bankomat.grafics.BankomatView;
import bankomat.semantics.BankomatSemantics;

public class MoneyInputAction extends BankomatAction {
    public void execute(BankomatSemantics contents, BankomatView theView, int parameter) {
        contents.addAmount(Integer.toString(parameter));
        theView.setText("Geld: " + contents.amount);
    }
}
