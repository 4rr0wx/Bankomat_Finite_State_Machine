package bankomat.actions;

import bankomat.grafics.BankomatView;
import bankomat.semantics.BankomatSemantics;

public class DigEntered extends BankomatAction {

    public void execute(BankomatSemantics contents, BankomatView theView, int parameter) {
        theView.setText(parameter + " eingegeben.");
        contents.addCode(Integer.toString(parameter));

    }

}
