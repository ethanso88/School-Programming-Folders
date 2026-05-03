#Colour Game--This program allos a user to play a game
#where they will have to type in the colour of the text
#but not type what the text actually says
#This game also demonstrates how to use Events and Event Handlers
#which allows for developing more sophisticated GUI games/applications

import tkinter
import random

#This is an array taht stores colours
colours = ["Red", "Blue", "Green", "Pink", "Black", "Yellow", "Orange", "White", "Purple", "Brown"]

score = 0
timeLeft = 30 #the game time that's left to play

#This function is responsible for starting the game
def startGame(event):
    if timeLeft == 30:
        #start countdown timer
        countdown()
    #run the function to choose the next colour 
    nextColour()

def buttonClick():
    global score
    global timeLeft
    score = 0
    timeLeft = 30
    
    #run the function to choose the next colour
    nextColour()

#This function chooses and displays the next colour randomly
def nextColour():
    global timeLeft
    global score
    
    #if game is currently in play
    if timeLeft > 0:
        #make the entry box active
        entryBox.focus_set()

    #if the colour typed in is equal to the colour of the text
        if entryBox.get().lower() == colours[1].lower():
            #.lower() makes all entrys in lowercase, colours[1] will always get the second element in the array but we will shuffle the array
            score += 1
        
        #.delete(0, tkinter.END)
        entryBox.delete(0, tkinter.END)

        #From the Random module, I will used the .shuffle() to shuffle
        #the order of the items in the array names colours
        random.shuffle(colours)

        #Change the colour to type, by changing the text and colour to a random colour value
        label.config(fg = str(colours[1]), text = str(colours[0])) #the colour will be the 1 element of the array and the text will be the 0 element of the array

        #update the score
        scoreLabel.config(text = "Score: " + str(score))

#This function is responsible for counting down the time
#it keeps track of how much time is left in the game
def countdown():
    global timeLeft
    
    #if a game is in play
    if timeLeft > 0:
        #decrement the timer
        timeLeft -= 1

        #update the timeLeft label
        timeLabel.config(text = "Time left: " + str(timeLeft))

        #to actually run the function again after 1 second
        #we have to use the .after(delay, callback = None) method
        #1000ms = 1s
        timeLabel.after(1000, countdown)


#------------------------GUI DRIVER----------------------------

#create GUI root window
root = tkinter.Tk()
#set the title
root.title("Colour Game! :D")
#set the size
root.geometry("500x350") #500 pixels by 350 pixels

#add an instructions label
instructions = tkinter.Label(root, text = "Type in the colour " \
                             "of the word and not the word text!", \
                             font = ("Arial", 15))
#pack the label
instructions.pack()

#add the score label--shows the current score of the game
scoreLabel = tkinter.Label(root, text = "Press Enter to start the game", \
                           font = ("Arial", 15))

#pack the label
scoreLabel.pack()

#add the timeLeft label
timeLabel = tkinter.Label(root, text = "Time left: " + str(timeLeft), \
                          font = ("Arial", 15))

#pack the label
timeLabel.pack()

#add a label for displaying the colours
label = tkinter.Label(root, font = ("Arial", 15))
label.pack()

#add reset button
button = tkinter.Button(root, text = "Reset", font = ("Arial", 15), command = buttonClick)
button.pack()

#add a text entrybox for typing in the colours
entryBox = tkinter.Entry(root, font = 15)
#run the startGame function when the enter key is pressed
#use .bind to bind startGame() to pressing the enter key or pressing the return button
#.bind takes two arguments one for the event and one for the function that will start from that
root.bind("<Return>", startGame)
entryBox.pack()

#set the focus on the entryBox
entryBox.focus_set()

#start the GUI
root.mainloop()
                                                          
                                                


































        







        
                 
    
