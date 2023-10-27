package bankomat.actions;

import bankomat.grafics.BankomatView;
import bankomat.semantics.BankomatSemantics;

public class ExitCard extends BankomatAction {
    public void execute(BankomatSemantics contents, BankomatView theView, int parameter) {
        theView.setText("Willkommen beim Bankomaten!");
        theView.setKartenText("Kartenschacht leer");
        theView.setKartenButtonLabel("Karte einlegen");
        theView.setGeldladeText("");

    }
}
