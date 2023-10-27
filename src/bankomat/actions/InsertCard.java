package bankomat.actions;

import bankomat.grafics.BankomatView;
import bankomat.semantics.BankomatSemantics;

public class InsertCard extends BankomatAction {

    public void execute(BankomatSemantics contents, BankomatView theView, int parameter) {
        theView.setText("Karte eingeführt. Bitte PIN eingeben");
        theView.setKartenText("Karte in Maschine");
        theView.setKartenButtonLabel("---");
        contents.reset();
    }
}
