package bankomat.actions;

import bankomat.grafics.BankomatView;
import bankomat.semantics.BankomatSemantics;

public class DeleteAction extends BankomatAction {
    @Override
    public void execute(BankomatSemantics contents, BankomatView theView, int parameter) {
        contents.removeCode();
        theView.setText("Letzte Ziffer gelöscht");
    }
}
