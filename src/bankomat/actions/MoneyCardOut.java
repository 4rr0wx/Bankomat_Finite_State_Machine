package bankomat.actions;

import bankomat.grafics.BankomatView;
import bankomat.semantics.BankomatSemantics;

public class MoneyCardOut extends BankomatAction {

    public void execute(BankomatSemantics contents, BankomatView theView, int parameter) {
        theView.setText("Geld in bearbeitung. Bitte Karte entnehmen");
        theView.setKartenButtonLabel("Karte entnehmen");
        theView.setKartenText("Karte ausgegeben");

    }
}
