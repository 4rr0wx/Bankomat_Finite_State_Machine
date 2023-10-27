package bankomat.automaton;

import bankomat.actions.BankomatAction;
import bankomat.edges.BankomatEdge;
import bankomat.grafics.BankomatView;
import bankomat.semantics.BankomatSemantics;

public class BankomatModel {

	// state Variables
	private BankomatView theView;
	private BankomatState theState;
	private BankomatSemantics theSemantics;
	private BankomatMatrix theMatrix;


	public BankomatModel() {
		theMatrix = new BankomatMatrix();
		theState = BankomatState.START;
		theSemantics = new BankomatSemantics();
	}

	public void setView(BankomatView view) {
		theView = view;
	}

	public void pressButton(BankomatEvent event) {
		pressButton(event,0);
	}
	public void pressButton(BankomatEvent event, int parameter) {
		BankomatEdge edge = theMatrix.getEdge(theState,event);
		if (edge != null ) {
			BankomatState newState = edge.getNextState(theSemantics);
			BankomatAction action = edge.getAction();
			if (action != null) {
				action.execute(theSemantics, theView, parameter);
			}
			debugEdge(edge.getEdgeNumber(), theState, event, newState);
			theState = newState;
		} else {
			noEdge(theState,event);
		}
	}

	private void debugEdge(int edgeNumber, BankomatState theState, BankomatEvent event, BankomatState nextState) {
		System.out.println(" From state " + theState + " with event " + event + " traversing with edge " + edgeNumber + " to state " + nextState );
	}

	private void noEdge(BankomatState theState, BankomatEvent event) {
		System.out.println(" From state " + theState + " with event " + event + " no edge defined.");
	}

		// theView.setText("Cancel pressed.");
		// theView.setText("Delete pressed.");
		// theView.setText("Enter pressed.");
		// theView.setText("Money pressed.");
		// theView.setGeldladeText("Geldlade neuer Text");
		// theView.setText("Card pressed.");
		// theView.setKartenButtonLabel("Karte Button neu");
		// theView.setKartenText("Karte Text neu");

}


