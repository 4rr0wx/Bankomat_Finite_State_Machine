package bankomat.actions;

import bankomat.actions.BankomatAction;
import bankomat.grafics.BankomatView;
import bankomat.semantics.BankomatSemantics;

public class CancelAction extends BankomatAction {

    public void execute(BankomatSemantics contents, BankomatView theView, int parameter) {
        theView.setText("Cancelled");
        theView.setKartenButtonLabel("Karte entnehmen");
        theView.setKartenText("Karte ausgegeben");
        contents.reset();
    }

}
