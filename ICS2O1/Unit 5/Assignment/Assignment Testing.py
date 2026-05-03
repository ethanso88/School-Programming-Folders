import tkinter as tk
import tkinter.messagebox
import time



def game():
    global timeLeft
    if sentinel == 0:
        #create the toplevel window
        gameWindow = tk.Tk()
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


for x in range(1,11):
    start_time = time.time()

    #The thing to time. Using sleep as an example
    time.sleep(10)

    end_time = time.time()
    elapsed_time = end_time - start_time

    print(elapsed_time)


