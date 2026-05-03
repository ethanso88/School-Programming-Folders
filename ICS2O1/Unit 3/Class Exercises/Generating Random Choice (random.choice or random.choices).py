import random
cardSuit = ['Spades', 'Clubs', 'Diamonds', 'Hearts']
cardFace = ['Ace', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 'Jack', 'Queen', 'King']

def pickACard():
    suit = random.choice(cardSuit)
    face = random.choice(cardFace)

    print('You picked the card', face, 'of', suit)

pickACard()
