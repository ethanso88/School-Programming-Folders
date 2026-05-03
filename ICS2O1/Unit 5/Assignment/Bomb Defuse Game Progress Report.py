#This is the GUI program for the Bomb Defuse Game
#It will be seperated into two parts the GUI parts and the parts that don't need GUI
#This GUI is a bomb defusal game
#The user will start the game and they will have to complete many puzzles before they can defuse the bomb
#If the timer of the bomb hits 0 then the user loses
#If the user makes a mistake then the user loses
#If the user completes all the puzzles in time before the bomb explodes then they have defused the bomb and have won

import tkinter as tk
import tkinter.messagebox
import time

timeLeft = 300 #time global variable
life = 1 #life global variable
sentinel = 0

def main():
    #non gui parts:
    






    
    #create root window
    window = tk.Tk()
    window.title("Bomb Defusal Starting Window") #Title
    window.geometry("500x400") #Size

    #Root window widgets:
    #Frames
    windowTopFrame = tk.Frame(window, relief = 'raised', borderwidth = 1)
    windowBottomFrame = tk.Frame(window, relief = 'raised', borderwidth = 1)

    #Labels
    windowTitle = tk.Label(windowTopFrame, text = 'Bomb Defusal', font = ("Arial", 50, "bold"), \
                           fg = "Red")
    windowInfo1 = tk.Label(windowTopFrame, text = 'Welcome to the starting window for the Bomb Defusal Game', \
                           font = ("Arial", 25))
    windowInfo2 = tk.Label(windowTopFrame, text = 'Reading the Instructions is highly recommended', \
                           font = ("Arial", 25))
    windowInfo3 = tk.Label(windowTopFrame, text = 'Click the Start button to start the game', \
                           font = ("Arial", 25))
    windowInfo4 = tk.Label(windowTopFrame, text = 'Click the Quit button to quit the game at any time', \
                           font = ("Arial", 25))

    windowTopFrame.pack()
    windowBottomFrame.pack()
    windowTitle.pack()
    windowInfo1.pack()
    windowInfo2.pack()
    windowInfo3.pack()
    windowInfo4.pack()

    #game window and all of the game related windows
    def game():
        global timeLeft
        if sentinel == 0:
            #create the toplevel window
            gameWindow = tk.Toplevel()
            gameWindow.geometry('500x400')
            gameWindow.title('Bomb Timer')

            #add frame for organization
            mainFrame = tk.Frame(gameWindow, relief = 'raised', borderwidth = 1)

            #label
            defuseLabel = tk.Label(mainFrame, text = 'Defuse the Bomb!', font = ("Arial", 50, "bold"))
            timerLabel = tk.Label(mainFrame, text = 'Time Left: ' + str(timeLeft), font = ("Arial", 50, "bold"), \
                          fg = 'Red')
            
            #pack game widgets
            defuseLabel.pack()
            mainFrame.pack()
            timerLabel.pack()

            gameWindow.mainloop() #enter the toplvl window into the mainloop

        #start timer
        start_time = time.time()

        #The thing to time
        time.timeLeft(1)

        end_time = time.time()
        elapsed_time = end_time - start_time

        timerLabel.config(text = 'Time left: ' + str(elapsed_time))


        
        #pzButton1 = tk.Button(mainFrame, text = 'Device 1', font = ('Arial', 35), command = puzzle1) #puzzle button 1
        #pzButton2 = tk.Button(mainFrame, text = 'Device 2', font = ('Arial', 35), command = puzzle2)
        #pzButton3 = tk.Button(mainFrame, text = 'Device 3', font = ('Arial', 35), command = puzzle3)
        #pzButton4 = tk.Button(mainFrame, text = 'Device 4', font = ('Arial', 35), command = puzzle4)
        #manualButton = tk.Button(mainFrame, text = 'Manual', font = ('Arial', 35), command = manual)
        #defuseButton = tk.Button(mainFrame, text = 'DEFUSE', font = ('Arial', 35), command = defuse, fg = 'Blue')

        #add widgets
        


        
        

        
            
        

        
        
        
        

    #Root window buttons (have to be placed at the end so the functions can be before it)
    start = tk.Button(windowBottomFrame, text = 'Start', font = ("Arial", 25), command = game)
    #instructions = tk.Button(windowBottomFrame, text = 'Instructions', font = ("Arial", 25), command = game_instructions)
    quitButton = tk.Button(windowBottomFrame, text = 'Quit', font = ("Arial", 25), command = window.destroy)

    start.pack(side = 'left')
    #instructions.pack()
    quitButton.pack(side = 'left')

    #Enter into the mainloop
    tk.mainloop()

main()
