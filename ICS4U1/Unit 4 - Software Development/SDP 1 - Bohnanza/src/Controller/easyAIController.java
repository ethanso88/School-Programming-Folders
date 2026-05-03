package Controller;

import Model.Card;
import Model.Player;
import View.BohnanzaGameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

import static Controller.BohnanzaController.*;

public class easyAIController implements TurnInterface {

    static int[] AIdifficultyLevels = {1,2,3};
    static int currentDifficulty;
    private BohnanzaGameFrame gameFrame = BohnanzaController.getGameFrame();

    //gui components accessed through proper getters
    private JLabel[] offerAreaLabels = gameFrame.getOfferAreaLabel();
    private JButton discardPileButton = gameFrame.getDiscardPileButton();
    private JButton drawPileButton = gameFrame.getDrawPileButton();
    private JLabel[][] fieldCardCounters = gameFrame.getFieldCardCounters();

    Player easyAI = BohnanzaController.players[1]; //PLAYER 2

    public easyAIController() {
        //set current difficulty
        currentDifficulty = AIdifficultyLevels[0];

        //this method starts the ai's turn
        startTurn();

        //this method plant any/all offered cards
        //if any offer has enough to give coins plant it (or if any matches with existing fields)
        //this is the remaining beans in the offer area from the previous player
        plantFromOffer();

        //harvest if you can't plant the current card
        harvestCheck();

        //this method tries to plant the first card from hand and returns false if it is not possible
        boolean firstCardPlanted = plantInitialCard();

        //if there are any cards which can’t reach a tier to give coins since not enough cards left in deck discard them
        //check for discard as you can only discard after planting a card
        boolean discarded = false;

        if (firstCardPlanted) {
            //try to discard
            discarded = discardAction();
        }

        //can only try to plant the second card if the first card is already planted
        boolean secondCardPlanted = false;
        if (firstCardPlanted) {
            secondCardPlanted = plantSecondCard();         //this method tries to plant the optional second card from hand
        }

        //check for discard once again, however we can only discard again if we planted a second card and we haven't previously discarded
        if (secondCardPlanted && !discarded)
            discardAction();

        //draw cards into Offer Area
        //Plants offered cards if possible.
        drawAndOffer();

        //draw 2 cards to hand (left side)
        drawToHand();

        //update all visuals at end of turn
        SwingUtilities.invokeLater(() -> {
            updateAllVisuals();
        });
    }

    //start turn method
    @Override
    public void startTurn() {
        //make the AI have the active turn
        easyAI.setCurrentTurn(true);
    }

    @Override
    public void plantFromOffer() {
        //this nested loop ensures each offer area is compared with each bean field
        for (int offerIndex = 0; offerIndex < offerArea.length; offerIndex++) {
            for (int beanfieldIndex = 0; beanfieldIndex < easyAI.getBeanfields().length - 1; beanfieldIndex++) {
                //if the field is not empty and the beantypes in the fields match then plant
                if (offerArea[offerIndex] != null && Objects.equals(offerArea[offerIndex].getBeantype(), easyAI.getBeanfields()[beanfieldIndex].getBeantype())) {

                    //plant by updating the bean count in the beanfield and clearing that part of the offer area
                    easyAI.getBeanfields()[beanfieldIndex].setTotalBeanCount(easyAI.getBeanfields()[beanfieldIndex].getTotalBeanCount() + offerArea[offerIndex].getTotalBeanCount());
                    offerArea[offerIndex] = null;

                    //update gui
                    int finalBeanfieldIndex = beanfieldIndex;
                    SwingUtilities.invokeLater(() -> {
                        updateOfferArea();
                        updateFieldVisual(1, finalBeanfieldIndex);
                    });
                }
            }
        }
    }

    public void harvestCheck() {
        //view  the first card of the hand
        Card firstCard = easyAI.viewCurrentCard();

        //if it stays not plantable then we must harvest
        boolean isPlantable = false;

        for (int x = 0; x < easyAI.getBeanfields().length - 1; x++) {
            //if the card is plantable set plantable to true
            if (easyAI.plantCard(x, firstCard))
                isPlantable = true;
        }

        //harvest if harvesting is necessary
        if (!isPlantable) {
            //check for unique cases:

            //if there is only one card each in each beanfield
            if (easyAI.getBeanfields()[0].getTotalBeanCount() == 1 && easyAI.getBeanfields()[1].getTotalBeanCount() == 1)
                //harvest the first field by default if both fields have 1 card
                harvestAction(0);

                //if 1 has 1 card
            else if (easyAI.getBeanfields()[0].getTotalBeanCount() > 1 && easyAI.getBeanfields()[1].getTotalBeanCount() == 1)
                //harvest the field that is not at 1 as we have no choice
                harvestAction(0);

                //if 1 has 1 card
            else if (easyAI.getBeanfields()[0].getTotalBeanCount() == 1 && easyAI.getBeanfields()[1].getTotalBeanCount() > 1)
                //harvest the field that is not at 1 as we have no choice
                harvestAction(1);

                //otherwise harvest the one that has more money
                // extracards = beancount - money
                // therefore: money = beancount - extracards
            else if (easyAI.getBeanfields()[0].getTotalBeanCount() - easyAI.harvestField(0) > easyAI.getBeanfields()[1].getTotalBeanCount() - easyAI.harvestField(1))
                harvestAction(0);

                //harvest the one with more money again
            else if (easyAI.getBeanfields()[1].getTotalBeanCount() - easyAI.harvestField(1) > easyAI.getBeanfields()[0].getTotalBeanCount() - easyAI.harvestField(0))
                harvestAction(1);

                //if the money is equal harvest the one with fewer cards
            else if (easyAI.getBeanfields()[0].getTotalBeanCount() - easyAI.harvestField(0) == easyAI.getBeanfields()[1].getTotalBeanCount() - easyAI.harvestField(1)) {
                if (easyAI.getBeanfields()[0].getTotalBeanCount() > easyAI.getBeanfields()[1].getTotalBeanCount())
                    harvestAction(1);
                else if (easyAI.getBeanfields()[1].getTotalBeanCount() > easyAI.getBeanfields()[0].getTotalBeanCount())
                    harvestAction(0);
            }
        }
    }

    //this method wraps up the harvesting by using the data from harvesting a field and updating the cards
    private void harvestAction(int fieldIndex) {
        //harvesting automatically adds the money earned buy doesn't clear the bean field nor discard the cards
        int extraCardCount = easyAI.harvestField(fieldIndex);

        //the discarded card will be the same but different bean count
        Card discardedCard = easyAI.viewCurrentCard();
        discardedCard.setTotalBeanCount(extraCardCount);

        //add the discarded card to the discard pile
        deck.discard(discardedCard);

        //clear the bean field
        easyAI.getBeanfields()[fieldIndex] = null;

        //update gui
        SwingUtilities.invokeLater(() -> {
            updateFieldVisual(1, fieldIndex);
            updateDiscardPileDisplay();
        });
    }

    @Override
    public boolean plantInitialCard() {
        //view the first card of the hand:
        Card firstCard = easyAI.viewCurrentCard();

        //check if it is planted
        boolean isPlanted = false;

        //try to plant in each field (only 1 and 2 as we won't buy a new field with easyAI)
        for (int x = 0; x < easyAI.getBeanfields().length - 1; x++) {
            //if the card is plantable plant it
            if (easyAI.plantCard(x, firstCard)) {
                isPlanted = easyAI.plantCard(x, firstCard);

                //update gui
                final int fieldIndex = x;
                SwingUtilities.invokeLater(() -> {
                    updateFieldVisual(1, fieldIndex);
                    updateHandCounter();
                });
                break;
            }
        }
        return isPlanted;
    }

    //this method attempts the discard action and is used after planting 1 or 2 cards
    public boolean discardAction() {
        //check if the next card is plantable in any field if not then remove it
        if (easyAI.getHand().peek() != easyAI.getBeanfields()[0]) {
            //remove the card from hand and add to discard pile
            Card removedCard = easyAI.removeFromHand(easyAI.viewCurrentCard());
            deck.discard(removedCard);

            //update gui
            SwingUtilities.invokeLater(() -> {
                updateDiscardPileDisplay();
                updateHandCounter();
            });
            return true;
        }
        else if (easyAI.getHand().peek() != easyAI.getBeanfields()[1]) {
            //remove the card from hand and add to discard pile
            Card removedCard = easyAI.removeFromHand(easyAI.viewCurrentCard());
            deck.discard(removedCard);

            //update gui
            SwingUtilities.invokeLater(() -> {
                updateDiscardPileDisplay();
                updateHandCounter();
            });
            return true;
        }
        //else
        return false;
    }

    @Override
    public boolean plantSecondCard() {
        //reuse the old method code as it'll do the same thing
        return plantInitialCard();
    }

    @Override
    public void drawAndOffer() {
        //create a list of the available cards drawn
        ArrayList<Card> availableCards = new ArrayList<>();

        //keep drawing until we have 3 cards available to process (process as in plant or offer)
        while (availableCards.size() < 3 && !deck.getDrawPile().isEmpty()) {
            Card drawnCard = deck.draw();

            //check if it matches discard pile
            if (!deck.getDiscardPile().isEmpty() && drawnCard.getBeantype().equals(deck.getTopDiscard().getBeantype())) {
                //add to discard pile stack
                deck.getTopDiscard().setTotalBeanCount(
                        deck.getTopDiscard().getTotalBeanCount() + drawnCard.getTotalBeanCount());

                //update discard pile display
                SwingUtilities.invokeLater(this::updateDiscardPileDisplay); //intelliJ bug fix suggestion
            } else {
                //add to available cards as it doesn't match the discard pile
                availableCards.add(drawnCard);
            }
        }

        //update draw pile count
        SwingUtilities.invokeLater(this::updateDrawPileVisual); //intelliJ bug fix suggestion

        //now process exactly 3 cards
        for (Card currentCard : availableCards) {
            boolean planted = false;

            //try to plant in matching ai bean fields
            for (int beanfieldindex = 0; beanfieldindex < easyAI.getBeanfields().length - 1; beanfieldindex++) {
                //check if the current card matches the type of the bean field
                if (easyAI.getBeanfields()[beanfieldindex].getBeantype().equals(currentCard.getBeantype())) {
                    //merge the count of the total beans
                    easyAI.getBeanfields()[beanfieldindex].setTotalBeanCount(
                            easyAI.getBeanfields()[beanfieldindex].getTotalBeanCount() + currentCard.getTotalBeanCount());
                    planted = true;

                    //update field display
                    final int fieldIdx = beanfieldindex;
                    SwingUtilities.invokeLater(() -> {
                        updateFieldVisual(1, fieldIdx);
                    });
                    break;
                }
            }

            //if the current card did not get planted it must go to the offer area
            if (!planted) {
                //try to add to offer area (go through each offer area)
                for (int offerIndex = 0; offerIndex < offerArea.length; offerIndex++) {
                    //if the offer area isn't empty and the card types match
                    if (offerArea[offerIndex] != null && offerArea[offerIndex].getBeantype().equals(currentCard.getBeantype())) {
                        //merge matching types
                        offerArea[offerIndex].setTotalBeanCount(
                                offerArea[offerIndex].getTotalBeanCount() + currentCard.getTotalBeanCount());
                        planted = true;

                        //update offer area
                        SwingUtilities.invokeLater(this::updateOfferArea); //intelliJ bug fix suggestion
                        break;
                    } else if (offerArea[offerIndex] == null) {
                        //use the empty slot
                        offerArea[offerIndex] = currentCard;
                        planted = true;

                        //update offer area
                        SwingUtilities.invokeLater(this::updateOfferArea); //intelliJ bug fix suggestion
                        break;
                    }
                }
            }

            //if couldn't plant or offer discard the card
            if (!planted) {
                deck.discard(currentCard);
                SwingUtilities.invokeLater(this::updateDiscardPileDisplay); //intelliJ bug fix suggestion
            }
        }
    }

    @Override
    public void drawToHand() {
        //draw a card from the drawpile and add that card to the ai's hand
        easyAI.addToHand(deck.draw());

        //repeat it again (drawing 2 cards total)
        easyAI.addToHand(deck.draw());

        //update gui
        SwingUtilities.invokeLater(() -> {
            updateHandCounter();
            updateDrawPileVisual();
        });
    }

    
    
    
    
    
    //gui updater methods

    //updates whats shown in the discard pile area
    private void updateDiscardPileDisplay() {
        SwingUtilities.invokeLater(() -> {
            //if theres cards in discard pile show top card
            if (!deck.getDiscardPile().isEmpty()) {
                Card topDiscard = deck.getTopDiscard();
                ImageIcon icon = new ImageIcon("cards/" + topDiscard.getBeantype() + ".png");
                //make image smaller to fit button
                discardPileButton.setIcon(scaleIcon(icon, 100, 157));
                discardPileButton.setText(String.valueOf(topDiscard.getTotalBeanCount()));
            } else {
                //clear if no cards
                discardPileButton.setIcon(null);
                discardPileButton.setText("Discard");
            }
        });
    }

    //refreshes the 3 offer slots in the middle
    private void updateOfferArea() {
        SwingUtilities.invokeLater(() -> {
            //go through each offer slot
            for (int x = 0; x < offerArea.length; x++) {
                JLabel offerLabel = offerAreaLabels[x];
                //if theres a card here
                if (offerArea[x] != null) {
                    //show card image and number
                    ImageIcon icon = new ImageIcon("cards/" + offerArea[x].getBeantype() + ".png");
                    offerLabel.setIcon(scaleIcon(icon, 100, 157));
                    offerLabel.setText(String.valueOf(offerArea[x].getTotalBeanCount()));
                } else {
                    //clear empty slots
                    offerLabel.setIcon(null);
                    offerLabel.setText("");
                }
            }
        });
    }

    //updates one bean fields display (image and counter)
    private void updateFieldVisual(int playerIndex, int fieldIndex) {
        SwingUtilities.invokeLater(() -> {
            //get references to field components
            JPanel fieldPanel = gameFrame.getPlayer2Fields()[fieldIndex];
            JLabel counterLabel = fieldCardCounters[playerIndex][fieldIndex];
            Card fieldCard = BohnanzaController.players[playerIndex].getBeanfields()[fieldIndex];

            //if field has beans
            if (fieldCard != null) {
                //update image and counter
                ImageIcon icon = new ImageIcon("cards/" + fieldCard.getBeantype() + ".png");
                counterLabel.setText(String.valueOf(fieldCard.getTotalBeanCount()));
                ((JLabel) fieldPanel.getClientProperty("cardLabel")).setIcon(scaleIcon(icon, 150, 236));
            } else {
                //clear empty fields
                counterLabel.setText("0");
                ((JLabel) fieldPanel.getClientProperty("cardLabel")).setIcon(null);
            }
        });
    }

    //updates the number shown on draw pile button
    private void updateDrawPileVisual() {
        SwingUtilities.invokeLater(() -> {
            drawPileButton.setText("Cards: " + deck.getDrawPile().size());
        });
    }

    //updates the counter for ai's hand size
    private void updateHandCounter() {
        SwingUtilities.invokeLater(() -> {
            gameFrame.getHandCardCounters()[1].setText(String.valueOf(easyAI.getHand().size()));
        });
    }

    //updates all visual elements at once
    private void updateAllVisuals() {
        updateDiscardPileDisplay();
        updateOfferArea();
        updateDrawPileVisual();
        //update all 3 AI fields
        for (int x = 0; x < 3; x++) {
            updateFieldVisual(1, x);
        }
        updateHandCounter();
    }

    //makes images smaller/bigger to fit different areas
    private ImageIcon scaleIcon(ImageIcon icon, int width, int height) {
        if (icon == null) return null;
        //resize image smoothly
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

}