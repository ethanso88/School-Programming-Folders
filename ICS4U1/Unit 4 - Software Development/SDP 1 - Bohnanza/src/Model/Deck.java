package Model;

import java.util.*;

public class Deck {

    //fields
    Stack<Card> drawPile; //the deck the players draw from
    Stack<Card> discardPile; //for discarded/harvested cards

    //Stack research:
    //https://www.geeksforgeeks.org/stack-class-in-java/

    /*
    a stack uses LIFO (last-in-first-out) for its data
    this means that like a stack of plates the plate placed on the top is always drawn first no matter what

    push, pop, peek, empty, and search are some of the stack functionality methods

    -push adds elements to the top of the stack
    -peek accesses the element at the top of the stack
    -pop removes and returns the element at the top of the stack
    -empty checks if the stack is empty
    -search checks if an element is within the stack

    *stack also inherits methods like .indexOf() and .equals() from Class java.util.Vector


     */

    //constructor
    public Deck(Stack<Card> drawPile, Stack<Card> discardPile) {
        this.drawPile = drawPile;
        shuffle(); //shuffle the deck at creation
        this.discardPile = discardPile;
    }

    //getters and setters
    public Stack<Card> getDrawPile() {
        return drawPile;
    }

    public void setDrawPile(Stack<Card> drawPile) {
        this.drawPile = drawPile;
    }

    public Stack<Card> getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(Stack<Card> discardPile) {
        this.discardPile = discardPile;
    }

    //toString
    @Override
    public String toString() {
        return "Deck{" +
                "drawPile=" + drawPile +
                ", discardPile=" + discardPile +
                '}';
    }

    //this method randomizes the initial draw pile (the discard pile should be empty at the start)
    public void shuffle() {

        //https://www.geeksforgeeks.org/stack-class-in-java/

        //shuffle the stack which is a list so we can use collections.shuffle to shuffle it
        Collections.shuffle(this.getDrawPile());

    }

    //removes (draws) one card from the top and returns them
    public Card draw() {

        //a reminder that peek accesses the element at the top of the stack
        return this.getDrawPile().pop();

    }

    //this method adds a card to the discard pile
    public void discard(Card card) {

        //push the card in the parameter to the top of the discard pile
        this.getDiscardPile().push(card);

    }

    //this method peeks the card at the top of the discard pile
    public Card getTopDiscard() {

        //peek at discard pile
        return this.getDiscardPile().peek();

    }


}
