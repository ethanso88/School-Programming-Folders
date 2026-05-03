package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Player {

    //fields
    //https://www.geeksforgeeks.org/queue-interface-java/
    //queue follows a first in first out principle which means that
    //the elements are removed in the order they were put in
    //the first elements put in are the first ones put out

    Queue<Card> hand = new LinkedList<>(); //must be kept in order, Queue-style.
    //the queue data structure has very similar common methods to the stack data
    //structure:
    /*
     * add(element): Adds an element to the rear of the queue. If the queue is full,
     * it throws an exception. offer(element): Adds an element to the rear of the
     * queue. If the queue is full, it returns false. remove(): Removes and returns
     * the element at the front of the queue. If the queue is empty, it throws an
     * exception. poll(): Removes and returns the element at the front of the queue.
     * If the queue is empty, it returns null. element(): Returns the element at the
     * front of the queue without removing it. If the queue is empty, it throws an
     * exception. peek(): Returns the element at the front of the queue without
     * removing it. If the queue is empty, it returns null.
     */
    //*note that the queue will never be full because it is a list

    Card[] beanfields; //array to hold the 3 bean fields, uses an array since there are only 3 bean
    //fields
    int coins; //number of coins earned
    boolean isHuman; //helps in differentiating human vs computer.
    boolean currentTurn;

    //constructor
    public Player(Queue<Card> hand, Card[] beanfields, int coins, boolean isHuman, boolean currentTurn) {
        this.hand = new LinkedList<>();
        this.beanfields = beanfields;
        this.coins = coins;
        this.isHuman = isHuman;
        this.currentTurn = currentTurn;
    }

    //getters and setters
    public Queue<Card> getHand() {
        return hand;
    }

    public void setHand(Queue<Card> hand) {
        this.hand = hand;
    }

    public Card[] getBeanfields() {
        return beanfields;
    }

    public void setBeanfields(Card[] beanfields) {
        this.beanfields = beanfields;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }

    public boolean isCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(boolean currentTurn) {
        this.currentTurn = currentTurn;
    }

    //toString method
    @Override
    public String toString() {
        return "Player{" + "hand=" + hand + ", beanfields=" + Arrays.toString(beanfields) + ", coins=" + coins
                + ", isHuman=" + isHuman + ", currentTurn=" + currentTurn + '}';
    }

    //utility methods

    //returns the current active card in the hand
    public Card viewCurrentCard() {
        return this.getHand().peek();
    }

    //adds a card to the "bottom" of the hand (top of the hand will be the card the
    //player will have to use)
    public void addToHand(Card card) {
        //this adds the card to the end of the queue, the front of the queue is what is
        //drawn
        this.getHand().add(card);
    }

    //removes a card from the "top" of the hand (top of the hand will be the card
    //the player will have to use)
    public Card removeFromHand(Card card) {
        //this takes a card from the front of the queue
        return this.getHand().remove();
    }

    //adds a card to a field by planting it
    public boolean plantCard(int fieldIndex, Card card) {
        //this method assumes that a card is already removed from the hand
        //and will be placed in a field

        //check if the field is empty
        if (this.getBeanfields()[fieldIndex] == null) {
            //if it is just "plant" a card by placing it there
            this.getBeanfields()[fieldIndex] = card;
            //is planted
            return true;
        } //if not then we have to check and merge the cards

        //check if the bean types are the same
        else if (this.getBeanfields()[fieldIndex].getBeantype().equals(card.getBeantype())) {
            int originalBeanCount = this.getBeanfields()[fieldIndex].getTotalBeanCount();
            int addedBeanCount = card.getTotalBeanCount();

            //update the new beanCount for the field (number of beans of that type)
            this.getBeanfields()[fieldIndex].setTotalBeanCount(originalBeanCount + addedBeanCount);

            //is planted
            return true;

        } else //else there is an invalid planting and nothing happens
            return false;
    }

    //clears a field and adds the coins earned to the total, also returns the
    //number of cards needed to be discarded
    public int harvestField(int fieldIndex) {
        int beanCount = this.getBeanfields()[fieldIndex].getTotalBeanCount();
        int moneyEarned = 0;

        //iterate through the beanometer values of that card in the field
        for (int x = 0; x < this.getBeanfields()[fieldIndex].getBeanometer().length; x++) {
            //this means that the beanCount is greater than all of the other beanometer
            //values
            if (x == 3)
                //if the beanometer is higher than beanCount use the previous beanometer value
                if (beanCount < this.getBeanfields()[fieldIndex].getBeanometer()[x]) {
                    //add the money earned
                    moneyEarned = (x - 1) + 1; //money = beanometerIndex + 1
                    this.coins += moneyEarned;
                    break;
                } else { //otherwise use this beanometer value
                    //add the money earned
                    moneyEarned = x + 1; //money = beanometerIndex + 1
                    this.coins += moneyEarned;
                    break;
                }

                //if the beanometer is higher than beanCount use the previous beanometer value
            else if (beanCount < this.getBeanfields()[fieldIndex].getBeanometer()[x]) {
                //add the money earned
                moneyEarned = (x - 1) + 1; //money = beanometerIndex + 1
                this.coins += moneyEarned;
                //exit for loop since otherwise it will think its less than the last beanometer
                //for example
                //when its really also less than the previous one
                break;
            }
        }

        //return number of extra cards need to be added to discard (some cards get
        //turned into money)
        return beanCount - moneyEarned;
        //*the beanfield should be cleared in the controller so the bean type is
        //obtainable
    }

    //turns the hand into a list (may not be necessary)
    public ArrayList<Card> getHandAsList() {
        //create new ArrayList from the stream
        return this.getHand().stream().collect(Collectors.toCollection(ArrayList::new));
    }

}
