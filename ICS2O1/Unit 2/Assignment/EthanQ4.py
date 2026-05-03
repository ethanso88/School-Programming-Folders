#This is the program for question 4 by Ethan So
#This program will play a round of rock paper scissors 
#Two users will input their selection of rock, paper or scissors
#The program will then display the winner of the round or if it is a draw

def main():
    #brief intro
    print('This program will allow two people to play a game of rock, paper, scissors')
    print('Please input "rock", "paper" or "scissors" next to the player input\n')

    #inputs
    player1 = input('Player 1 enter your choice here: ')
    player2 = input('Player 2 enter your choice here: ')

    #to determine the winner
    winner(player1, player2)

def winner(player1, player2):

    #possible outputs and possibilities for rock 
    if player1 == 'rock':
        #rock and rock is a tie
        if player2 == 'rock':
            print('The round is a tie')

        #paper wins against rock so player2 wins
        elif player2 == 'paper':
            print('Player 2 wins this round')

        #rock wins against scissors so player 1 wins
        elif player2 == 'scissors':
            print('Player 1 wins this round')

        #if player2 doesn't input rock, paper, or scissors
        else:
            print("Player 2 didn't input a possible choice, please try again with a possible choice")

    #then the outcomes of paper
    elif player1 == 'paper':
        if player2 == 'rock':
            print('Player 1 wins this round')

        elif player2 == 'paper':
            print('The round is a tie')

        elif player2 == 'scissors':
            print('Player 2 wins this round')

        else:
            print("Player 2 didn't input a possible choice, please try again with a possible choice")

    #then the outcomes of scissors
    elif player1 == 'scissors':
        if player2 == 'rock':
            print('Player 2 wins this round')

        elif player2 == 'paper':
            print('Player 1 wins this round')

        elif player2 == 'scissors':
            print('The round is a tie')

        else:
            print("Player 2 didn't input a possible choice, please try again with a possible choice")

    #if player1 doesn't input rock, paper, or scissors
    else:
        print("Player 1 didn't input a possible choice, please try again with a possible choice")

main()



    
    
