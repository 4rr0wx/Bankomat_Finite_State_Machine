package bankomat;

import bankomat.grafics.BankomatMainFrame;
import bankomat.automaton.BankomatModel;

public class BankomatMain {

	public static void main(String[] args) {
		BankomatModel bankomatModel = new BankomatModel();
		BankomatMainFrame window = new BankomatMainFrame(bankomatModel);
		bankomatModel.setView(window);
		window.runFrame();
	}
}
