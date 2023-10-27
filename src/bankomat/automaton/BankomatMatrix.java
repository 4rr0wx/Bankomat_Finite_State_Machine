package bankomat.automaton;

import bankomat.actions.*;
import bankomat.edges.BankomatEdge;
import bankomat.edges.BankomatEdge16CorrectCode;

import static bankomat.automaton.BankomatEvent.*;
import static bankomat.automaton.BankomatState.*;

public class BankomatMatrix {
    private final BankomatEdge[][] automatonEdgeMatrix = new BankomatEdge[BankomatState.values().length][BankomatEvent.values().length];
    public BankomatMatrix() {
        resetMatrix();
        defineMatrix();
    }
    private void resetMatrix() {
        for (BankomatState x: BankomatState.values())
            for (BankomatEvent y: BankomatEvent.values()) {
                automatonEdgeMatrix[x.ordinal()][y.ordinal()] = null;
            }
    }

    ////////////////////////////////////////////////////////////////////
    //////////////// PUT YOUR AUTOMATON HERE !!!!!!!!!!!!!!!!!!!!!!!!!!!
    ////// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv ////////////
    private void defineMatrix() {
        // putEdge(edgeNumber, from, event, to, action )
        putEdge(CARDOUT, CARD, new BankomatEdge(2, START, new ExitCard()) );

        putEdge(START, CARD, new BankomatEdge(1, DIG0, new InsertCard()) );
        //Enter Pincode
        putEdge(DIG0, CANCEL, new BankomatEdge(3, CARDOUT, new CancelAction()) );
        putEdge(DIG0, DIGIT, new BankomatEdge(4, DIG1, new DigEntered()) );
        putEdge(DIG1, CANCEL, new BankomatEdge(12, CARDOUT, new CancelAction()) );
        putEdge(DIG1, DIGIT, new BankomatEdge(5, DIG2, new DigEntered()) );
        putEdge(DIG1, DELETE, new BankomatEdge(8,DIG0,new DeleteAction()));
        putEdge(DIG2, CANCEL, new BankomatEdge(13, CARDOUT, new CancelAction()) );
        putEdge(DIG2, DIGIT, new BankomatEdge(6, DIG3, new DigEntered()) );
        putEdge(DIG2, DELETE, new BankomatEdge(9,DIG1,new DeleteAction()));
        putEdge(DIG3, CANCEL, new BankomatEdge(14, CARDOUT, new CancelAction()) );
        putEdge(DIG3, DIGIT, new BankomatEdge(7, DIG4, new DigEntered()) );
        putEdge(DIG3, DELETE, new BankomatEdge(10,DIG2,new DeleteAction()));
        putEdge(DIG4, CANCEL, new BankomatEdge(15, CARDOUT, new CancelAction()) );
        putEdge(DIG4, DELETE, new BankomatEdge(11,DIG3,new DeleteAction()));

        //Check PIN
        // putEdge(DIG4, ENTER, new BankomatEdge());
        putEdge(DIG4, ENTER, new BankomatEdge16CorrectCode() );
        //Geldeingabe
        putEdge(MON1, CANCEL, new BankomatEdge(21, CARDOUT, new CancelAction()));
        putEdge(MON1, DIGIT, new BankomatEdge(17, MON2, new MoneyInputAction()));
        putEdge(MON2, DIGIT, new BankomatEdge(18, MON2, new MoneyInputAction()));
        putEdge(MON2, DELETE, new BankomatEdge(19, MON2, new MoneyDeleteAction()));
        putEdge(MON2, CANCEL, new BankomatEdge(22, CARDOUT, new CancelAction()));
        putEdge(MON2, ENTER, new BankomatEdge(20, MONCARDOUT, new MoneyCardOut()));
        putEdge(MONCARDOUT, CARD, new BankomatEdge(23, MONOUT, new MoneyOutAction()));
        putEdge(MONOUT, MONEY, new BankomatEdge(24, START, new ExitCard()));

   }
   /////// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ /////////
   ///////////////////////////////////////////////////////////////////

    private void putEdge(BankomatState state, BankomatEvent event, BankomatEdge edge){
        if ( automatonEdgeMatrix[state.ordinal()][event.ordinal()] != null) {
            System.out.println("WARNING: Overwriting existing edge at " + state + ", " + event );
        }
        automatonEdgeMatrix[state.ordinal()][event.ordinal()] = edge;
    }

    public BankomatEdge getEdge(BankomatState state, BankomatEvent event) {
        return automatonEdgeMatrix[state.ordinal()][event.ordinal()];
    }
}
