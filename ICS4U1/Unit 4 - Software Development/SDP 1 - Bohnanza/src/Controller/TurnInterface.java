package Controller;

public interface TurnInterface {
    //all interface methods are public by default

    void startTurn();
    void plantFromOffer();           // plant any/all offered cards
    boolean plantInitialCard();         // must plant first card from hand
    boolean plantSecondCard();          // optional second card from hand
    void drawAndOffer();             // draw 2 cards into Offer Area
    void drawToHand();               // draw 2 cards to hand (left side)

}

