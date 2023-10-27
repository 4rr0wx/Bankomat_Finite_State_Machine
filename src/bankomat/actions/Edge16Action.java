package bankomat.actions;

import bankomat.grafics.BankomatView;
import bankomat.semantics.BankomatSemantics;

public class Edge16Action extends BankomatAction {
    public void execute(BankomatSemantics contents, BankomatView theView, int parameter) {
        if (contents.codeIsCorrect()) {
            theView.setText("Code korrekt. Bitte gewünschten Betrag eingeben");
            contents.reset();
        } else {
            theView.setText("Code falsch. Bitte erneut versuchen!");

        }
    }

}
