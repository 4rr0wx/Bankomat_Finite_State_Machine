package bankomat.actions;

import bankomat.grafics.BankomatView;
import bankomat.semantics.BankomatSemantics;

public class MoneyOutAction extends BankomatAction {

    public void execute(BankomatSemantics contents, BankomatView theView, int parameter) {
        theView.setKartenButtonLabel("---");
        theView.setKartenText("Kartenschacht leer");
        theView.setText("Bitte Geld entnehmen");
        theView.setGeldladeText(contents.amount);
        contents.reset();
    }
}
