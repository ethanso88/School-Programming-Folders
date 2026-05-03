#This is the GUI program for the Bomb Defuse Game
#This GUI is a bomb defusal game
#The user will start the game and they will have to complete many puzzles before they can defuse the bomb
#If the timer of the bomb hits 0 then the user loses
#If the user makes a mistake then the user loses
#If the user completes all the puzzles in time before the bomb explodes then they have defused the bomb and have won
#The starting menu has a start button an instructions button and a quit button
#If the user presses start then the game will begin with anotehr window popping up with the puzzles the user has to solve
#The user will hit defuse when all puzzles have been solved in the game window and they will win

import tkinter as tk
import tkinter.messagebox
import random

timeLeft = 300 #Time global variable
score = 0 #Score global variable


def main():
    #Create root window
    window = tk.Tk()
    window.title("Bomb Defusal Starting Window") #Title
    window.geometry("1000x400") #Size

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


    def game_instructions():
        #These are the game instructions that the user is recommended to read before starting the game

        #Instruction window 
        instruct = tk.Toplevel()
        instruct.title('Game Instructions/Intro')
        instruct.geometry('730x300')

        #Frames
        insTopFrame = tk.Frame(instruct, relief = 'raised', borderwidth = 1)
        insBottomFrame = tk.Frame(instruct, relief = 'raised', borderwidth = 1)

        #Widgets 
        ins = tk.Label(insTopFrame, text = "This is a bomb defusal game\n" +
                       "Your goal is to defuse the bomb by completing the devices\n" +
                       "If you get a puzzle wrong the bomb will explode and the game will end\n" +
                       "If the timer runs out of time the bomb will also explode and the game will end\n" +
                       "You can try again if that happens\n" +
                       "Good luck! You will have a manual to help you with the devices", font = ("Arial", 15, "bold"))

        insQuit = tk.Button(insBottomFrame, text = 'Quit', font = ("Arial", 15, "bold"), command = instruct.destroy)

        #Pack widgets
        insTopFrame.pack()
        insBottomFrame.pack()
        ins.pack()
        insQuit.pack()

    
    def game_over():
        #What happens if the user gets an answer wrong or if the timer runs out

        
        def tryagain():
            #This is the function that will be triggered if the user clicks "try again?" on the failed window

            #Destroy fail window
            fail.destroy()

            #reset timeLeft and score
            global timeLeft
            timeLeft = 300

            global score
            score = 0

            #Start the program again
            main()

                
        #Destroy main window
        window.destroy()

        #Fail window
        fail = tk.Tk()
        fail.title('You lost!')
        fail.geometry('1700x300')
        fail.configure(bg = 'black') #colour

        #Frame
        fail_frame = tk.Frame(fail, bg = 'black')

        #Widgets
        explode_label = tk.Label(fail_frame, text = 'The Bomb Exploded!', font = ("Arial", 50, "bold"), fg = 'Red', bg = 'black')
        fail_label = tk.Label(fail_frame, text = 'You either got a puzzle wrong or the timer ran out', font = ('Arial', 25, 'bold'), fg = 'white', bg = 'black')
        fail_label2 = tk.Label(fail_frame, text = '*If you accidentally pressed "DEFUSE" before you completed the Devices then the bomb will still explode*', font = ('Arial', 25, 'bold'), fg = 'white', bg = 'black')
        try_again = tk.Button(fail_frame, text = 'Try again?', font = ("Arial", 25, "bold"), command = tryagain)
        fail_quit = tk.Button(fail_frame, text = 'Quit', font = ("Arial", 25, "bold"), command = fail.destroy)

        #Pack widgets
        fail_frame.pack()
        explode_label.pack()
        fail_label.pack()
        fail_label2.pack()
        try_again.pack()
        fail_quit.pack()

    def game_won():
        #What happens if the user won and successfully defused the bomb

        def another_game():
            #This is the function that will be triggered if the user clicks "Back to Starting Window" on the won window

            #Destroy win window
            win.destroy()

            #reset timeLeft and score
            global timeLeft
            timeLeft = 300

            global score
            score = 0

            #Start the program again
            main()

    
        #Destroy main window
        window.destroy()

        #Won window
        win = tk.Tk()
        win.title('You won!')
        win.geometry('500x300')
        win.configure(bg = 'black') #colour

        #Frame
        won_frame = tk.Frame(win, bg = 'black')

        #Widgets
        defused_label = tk.Label(won_frame, text = 'Bomb Defused!', font = ("Arial", 50, "bold"), fg = 'Lime Green', bg = 'black')
        won_label = tk.Label(won_frame, text = 'Congratulations!', font = ('Arial', 25, 'bold'), fg = 'white', bg = 'black')
        won_label2 = tk.Label(won_frame, text = 'You Won!', font = ('Arial', 25, 'bold'), fg = 'white', bg = 'black')
        back = tk.Button(won_frame, text = 'Back to Starting Window', font = ("Arial", 25, "bold"), command = another_game)
        win_quit = tk.Button(won_frame, text = 'Quit', font = ("Arial", 25, "bold"), command = win.destroy)

        #Pack widgets
        won_frame.pack()
        defused_label.pack()
        won_label.pack()
        won_label2.pack()
        back.pack()
        win_quit.pack()
        
    #Game window and all of the game related windows
    def game():        
        #Create the toplevel window
        gameWindow = tk.Toplevel()
        gameWindow.geometry('1000x400')
        gameWindow.title("Bomb Timer")
        gameWindow.configure(bg = 'gray')

        #Add frame for organization
        mainFrame = tk.Frame(gameWindow, bg = 'gray', relief = 'raised', borderwidth = 1)
        timerFrame = tk.Frame(gameWindow, bg = 'gray', relief = 'raised', borderwidth = 1)
        buttonFrame = tk.Frame(gameWindow, bg = 'gray', relief = 'raised', borderwidth = 1)

        #Timer/countdown
        def countdown():
            #Allow to get and update the global variable timeLeft
            global timeLeft
            
            #Minus 1 from the total each time
            timeLeft -= 1

            #Update the label
            timerLabel.config(text = str(timeLeft))
            timerLabel.after(1000, countdown)

            #If time hits 0
            if timeLeft == 0 or timeLeft < 0:
                game_over()
        
    
        #Labels
        defuseLabel = tk.Label(mainFrame, text = 'Defuse the Bomb!', font = ("Arial", 50, "bold"), fg = 'white', bg = 'gray')
        timeleftLabel = tk.Label(timerFrame, text = 'Time Left: ', font = ("Arial", 50, "bold"), fg = 'white', bg = 'gray')
        timerLabel = tk.Label(timerFrame, text = 'This is placeholder text that will get replaced and if it shows up then something went wrong', font = ("Arial", 50, "bold"), \
                      fg = 'Red', bg = 'gray')
        
        #Pack mainFrame widgets
        defuseLabel.pack()
        timeleftLabel.pack(side = 'left')
        timerLabel.pack(side = 'left')

        countdown()

        def manual():
            #This the function for the manual window of the game
            #The manual is necessary to complete the game because it tells you how to complete the puzzles
            #Without the manual the user is just blindly guessing to complete the puzzles

            #Manual window
            manualWin = tk.Toplevel()
            manualWin.title("Manual")
            manualWin.geometry("500x650")

            #Frames
            manualContentFrame = tk.Frame(manualWin, relief = 'raised', borderwidth = 1)
            manualQuitFrame = tk.Frame(manualWin, relief = 'raised', borderwidth = 1)
            
            #The Manual guide for the user during the game:
            manualTitle = tk.Label(manualContentFrame, text = 'The Manual', font = ("Arial", 25, 'bold'))
            manualDescription = tk.Label(manualContentFrame, text = 'This is the manual that will help you in the game')
            
            manualNumberOrder = tk.Label(manualContentFrame, text = 'Regarding number order:', font = ("Arial", 10, "bold"))
            manualNumberOrderDescription = tk.Label(manualContentFrame, text = 'if the first number is 1 type 1\n' +
                                                    'if the second number is 4 type 2\n' +
                                                    'if the first and third number are 2 and 3 type 3\n' +
                                                    'if the last number is 1 type 5\n' +
                                                    'if none of the above type 4')
            
            manualCalculation = tk.Label(manualContentFrame, text = 'Regarding calculation:', font = ('Arial', 10, "bold"))
            manualCalculationDescription = tk.Label(manualContentFrame, text = 'there are 4 numbers\n' +
                                                    'multiply the first and second number, this now X\n' +
                                                    'multiply the third and fourth number, this now Y\n' +
                                                    'divide Y by 2\n' +
                                                    'subtract X by Y (X - Y)\n' +
                                                    'if the answer is negative type 0')
            
            manualDecoding = tk.Label(manualContentFrame, text = 'Regarding decoding:', font = ('Arial', 10, "bold"))
            manualDecodingDescription = tk.Label(manualContentFrame, text = '! = 1, @ = 2, # = 3, $ = 4, % = 5, ^ = 6, & = 7, * = 8, ( = 9, ) = 0\n' +
                                                 'add your decoded answer together')
            
            manualBinary = tk.Label(manualContentFrame, text = 'Regarding binary:', font = ('Arial', 10, "bold"))
            manualBinaryDescription = tk.Label(manualContentFrame, text = 'check for these in order\n' +
                                               'if there are 4 1s pick option 1\n' +
                                               'if the first two are 0 pick option 2\n' +
                                               'if the last 3 are 1s pick option 3\n' +
                                               'if the order is alternating pick option 4\n' +
                                               'none of the above pick option 5')


            #Quit button
            manualQuit = tk.Button(manualQuitFrame, text = 'Quit', font = ("Arial", 25), command = manualWin.destroy)

            #Pack widgets
            manualTitle.pack()
            manualDescription.pack()
            manualNumberOrder.pack()
            manualNumberOrderDescription.pack()
            manualCalculation.pack()
            manualCalculationDescription.pack()
            manualDecoding.pack()
            manualDecodingDescription.pack()
            manualBinary.pack()
            manualBinaryDescription.pack()

            manualContentFrame.pack()
            manualQuitFrame.pack()

            manualQuit.pack()
            
            #Enter into mainloop
            manualWin.mainloop()

        def number_order():
            #Puzzle 1 window
            puzzle1_win = tk.Toplevel()
            puzzle1_win.geometry('500x200')
            puzzle1_win.title('Device 1')

            #Randomize the options
            num = random.randint(1, 5)
            if num == 1:
                option = '1 3 5 2 4'
            elif num == 2:
                option = '3 4 2 1 5'
            elif num == 3:
                option = '2 5 3 1 4'
            elif num == 4:
                option = '5 3 4 2 1'
            else:
                option = '2 3 1 4 5'

            
            #Frames
            pz1topFrame = tk.Frame(puzzle1_win)
            pz1bottomFrame = tk.Frame(puzzle1_win)
            pz1extraFrame = tk.Frame(puzzle1_win)
            pz1topFrame.pack()
            pz1bottomFrame.pack()
            pz1extraFrame.pack()
            
            #Widgets
            numbers = tk.Label(pz1topFrame, text = option, font = ("Arial", 20, "bold"))
            pz1_entryLabel = tk.Label(pz1bottomFrame, text = 'Enter your answer here: ', font = ("Arial", 20, "bold"))
            pz1_numberEntry = tk.Entry(pz1bottomFrame, width = 5, font = 25)

            #If the user got the answer right or wrong
            def solve(event):
                if int(pz1_numberEntry.get()) == 1 and option == '1 3 5 2 4':
                    tkinter.messagebox.showinfo("Puzzle 1 Complete!", "You solved the puzzle!")
                    puzzle1_win.destroy()
                    complete_puzzle1()
                    
                elif int(pz1_numberEntry.get()) == 2 and option == '3 4 2 1 5':
                    tkinter.messagebox.showinfo("Puzzle 1 Complete!", "You solved the puzzle!")
                    puzzle1_win.destroy()
                    complete_puzzle1()
                    
                elif int(pz1_numberEntry.get()) == 3 and option == '2 5 3 1 4':
                    tkinter.messagebox.showinfo("Puzzle 1 Complete!", "You solved the puzzle!")
                    puzzle1_win.destroy()
                    complete_puzzle1()
                    
                elif int(pz1_numberEntry.get()) == 4 and option == '2 3 1 4 5':
                    tkinter.messagebox.showinfo("Puzzle 1 Complete!", "You solved the puzzle!")
                    puzzle1_win.destroy()
                    complete_puzzle1()
                    
                elif int(pz1_numberEntry.get()) == 5 and option == '5 3 4 2 1':
                    tkinter.messagebox.showinfo("Puzzle 1 Complete!", "You solved the puzzle!")
                    puzzle1_win.destroy()
                    complete_puzzle1()
                    
                else:
                    game_over()
        
            
            puzzle1_win.bind("<Return>", solve)
            #Use .bind to bind solve() to pressing the enter key or pressing the return button
            #This makes it so it won't try to find out if the user got it right or wrong before the user inputted an answer

            
            #Pack widgets
            numbers.pack()
            pz1_entryLabel.pack(side = 'left')
            pz1_numberEntry.pack(side = 'left')

            puzzle1_win.mainloop() #Enter puzzle 1 window into tkinter mainloop


        def calculation():
            #Puzzle 2 window
            puzzle2_win = tk.Toplevel()
            puzzle2_win.geometry('500x200')
            puzzle2_win.title('Device 2')

            #The random numbers for the puzzle for calculation
            num1 = random.randint(1, 20)
            num2 = random.randint(1, 20)
            num3 = random.randint(1, 20)
            num4 = random.randint(1, 20)

            #Calculations
            X = num1 * num2
            Y = (num3 * num4)/2
            ans = X - Y

            #Frames
            pz2topFrame = tk.Frame(puzzle2_win)
            pz2bottomFrame = tk.Frame(puzzle2_win)

            #Widgets
            pz2_label = tk.Label(pz2topFrame, text = str(num1) + ' ' + str(num2) + ' ' + str(num3) + ' ' + str(num4), font = ("Arial", 20, "bold"))
            pz2_entryLabel = tk.Label(pz2bottomFrame, text = 'Enter your answer here: ', font = ("Arial", 20, "bold"))
            pz2_entry = tk.Entry(pz2bottomFrame, width = 5, font = 25)
            
            def solve2(event):
                #If the user failed or got it right
                if float(pz2_entry.get()) == ans:
                    tkinter.messagebox.showinfo("Puzzle 2 Complete!", "You solved the puzzle!")
                    puzzle2_win.destroy()
                    complete_puzzle2()
                    
                elif ans < 0 and float(pz2_entry.get()) == 0:
                    tkinter.messagebox.showinfo("Puzzle 2 Complete!", "You solved the puzzle!")
                    puzzle2_win.destroy()
                    complete_puzzle2()
                    
                else:
                    game_over()
                    
            puzzle2_win.bind("<Return>", solve2)
            #Use .bind to bind solve2() to pressing the enter key or pressing the return button
            #This makes it so it won't try to find out if the user got it right or wrong before the user inputted an answer

            
            #Pack widgets
            pz2topFrame.pack()
            pz2bottomFrame.pack()
            pz2_label.pack()
            pz2_entryLabel.pack(side = 'left')
            pz2_entry.pack(side = 'left')

            puzzle2_win.mainloop() #Enter puzzle 2 window into tkinter mainloop


        def decoding():
            #Puzzle 3 window
            puzzle3_win = tk.Toplevel()
            puzzle3_win.geometry('500x200')
            puzzle3_win.title('Device 3')

            #Randomize the choices
            integer = random.randint(1, 5)
            if integer == 1:
                choice = '(^!)$*#&@^'
            elif integer == 2:
                choice = '(!^#*&@@!*'
            elif integer == 3:
                choice = '!%#)&^^$@&'
            elif integer == 4:
                choice = ')(*@&!(^%@'
            else:
                choice = '(!&#^$*!%#'

            #Frames
            pz3topFrame = tk.Frame(puzzle3_win)
            pz3middleFrame = tk.Frame(puzzle3_win)
            pz3bottomFrame = tk.Frame(puzzle3_win)

            #Widgets
            pz3_label = tk.Label(pz3topFrame, text = choice, font = ("Arial", 20, "bold"))
            pz3_label2 = tk.Label(pz3topFrame, text = 'Enter Answer Below:', font = ("Arial", 20, "bold"))
            
            entry1 = tk.Entry(pz3bottomFrame, width = 2, font = 25)
            entry2 = tk.Entry(pz3bottomFrame, width = 2, font = 25)
            entry3 = tk.Entry(pz3bottomFrame, width = 2, font = 25)
            entry4 = tk.Entry(pz3bottomFrame, width = 2, font = 25)
            entry5 = tk.Entry(pz3bottomFrame, width = 2, font = 25)
            entry6 = tk.Entry(pz3bottomFrame, width = 2, font = 25)
            entry7 = tk.Entry(pz3bottomFrame, width = 2, font = 25)
            entry8 = tk.Entry(pz3bottomFrame, width = 2, font = 25)
            entry9 = tk.Entry(pz3bottomFrame, width = 2, font = 25)
            entry10 = tk.Entry(pz3bottomFrame, width = 2, font = 25)

            def solve3(event):
                #If the user failed or got it right
                #Each one is another if statement that checks the numbers inputted to see if it matches the puzzle option for the label
                
                if int(entry1.get()) == 9 and int(entry2.get()) == 6 and int(entry3.get()) == 1 and int(entry4.get()) == 0 and int(entry5.get()) == 4 and\
                   int(entry6.get()) == 8 and int(entry7.get()) == 3 and int(entry8.get()) == 7 and int(entry9.get()) == 2 and int(entry10.get()) == 6 and choice == '(^!)$*#&@^':
                    tkinter.messagebox.showinfo("Puzzle 3 Complete!", "You solved the puzzle!")
                    puzzle3_win.destroy()
                    complete_puzzle3()
                    
                elif int(entry1.get()) == 9 and int(entry2.get()) == 1 and int(entry3.get()) == 6 and int(entry4.get()) == 3 and int(entry5.get()) == 8 and\
                   int(entry6.get()) == 7 and int(entry7.get()) == 2 and int(entry8.get()) == 2 and int(entry9.get()) == 1 and int(entry10.get()) == 8 and choice == '(!^#*&@@!*':
                    tkinter.messagebox.showinfo("Puzzle 3 Complete!", "You solved the puzzle!")
                    puzzle3_win.destroy()
                    complete_puzzle3()
                    
                elif int(entry1.get()) == 1 and int(entry2.get()) == 5 and int(entry3.get()) == 3 and int(entry4.get()) == 0 and int(entry5.get()) == 7 and\
                   int(entry6.get()) == 6 and int(entry7.get()) == 6 and int(entry8.get()) == 4 and int(entry9.get()) == 2 and int(entry10.get()) == 7 and choice == '!%#)&^^$@&':
                    tkinter.messagebox.showinfo("Puzzle 3 Complete!", "You solved the puzzle!")
                    puzzle3_win.destroy()
                    complete_puzzle3()
                    
                elif int(entry1.get()) == 0 and int(entry2.get()) == 9 and int(entry3.get()) == 8 and int(entry4.get()) == 2 and int(entry5.get()) == 7 and\
                   int(entry6.get()) == 1 and int(entry7.get()) == 9 and int(entry8.get()) == 6 and int(entry9.get()) == 5 and int(entry10.get()) == 2 and choice == ')(*@&!(^%@':
                    tkinter.messagebox.showinfo("Puzzle 3 Complete!", "You solved the puzzle!")
                    puzzle3_win.destroy()
                    complete_puzzle3()
                    
                elif int(entry1.get()) == 9 and int(entry2.get()) == 1 and int(entry3.get()) == 7 and int(entry4.get()) == 3 and int(entry5.get()) == 6 and\
                   int(entry6.get()) == 4 and int(entry7.get()) == 8 and int(entry8.get()) == 1 and int(entry9.get()) == 5 and int(entry10.get()) == 3 and choice == '(!&#^$*!%#':
                    tkinter.messagebox.showinfo("Puzzle 3 Complete!", "You solved the puzzle!")
                    puzzle3_win.destroy()
                    complete_puzzle3()
                    
                else:
                    game_over()
            puzzle3_win.bind("<Return>", solve3)
            #Use .bind to bind solve2() to pressing the enter key or pressing the return button
            #This makes it so it won't try to find out if the user got it right or wrong before the user inputted an answer


            #Pack widgets
            pz3topFrame.pack()
            pz3middleFrame.pack()
            pz3bottomFrame.pack()
            
            pz3_label.pack()
            pz3_label2.pack()

            entry1.pack(side = 'left')
            entry2.pack(side = 'left')
            entry3.pack(side = 'left')
            entry4.pack(side = 'left')
            entry5.pack(side = 'left')
            entry6.pack(side = 'left')
            entry7.pack(side = 'left')
            entry8.pack(side = 'left')
            entry9.pack(side = 'left')
            entry10.pack(side = 'left')

            puzzle3_win.mainloop() #Enter puzzle 3 window into tkinter mainloop


        def binary():
            #Puzzle 4 window
            puzzle4_win = tk.Toplevel()
            puzzle4_win.geometry('300x350')
            puzzle4_win.title('Device 4')

            #Randomize the alternatives
            number = random.randint(1, 5)
            if number == 1:
                alt = '1111'
            elif number == 2:
                alt = '0011'
            elif number == 3:
                alt = '0111'
            elif number == 4:
                alt = '0101'
            else:
                alt = '1001'

            #Frames
            pz4topFrame = tk.Frame(puzzle4_win)
            pz4middleFrame = tk.Frame(puzzle4_win)
            pz4bottomFrame = tk.Frame(puzzle4_win)


            #Radiobuttons:
            #Create the IntVar() Object
            pz4Var = tkinter.IntVar()
            #Set the IntVar() Object to be 1
            pz4Var.set(1) #Option 1 will be selected by default 

            #Create the Radiobutton widgets
            #The IntVar() pz4Var allows for an object for the radiobutton to store the value of 1,2, 3, 4 or 5 into the object when selected
            rb1 = tkinter.Radiobutton(pz4middleFrame, text = 'option 1', font = ('Arial', 25), variable = pz4Var, value = 1)

            rb2 = tkinter.Radiobutton(pz4middleFrame, text = 'option 2', font = ('Arial', 25), variable = pz4Var, value = 2)

            rb3 = tkinter.Radiobutton(pz4middleFrame, text = 'option 3', font = ('Arial', 25), variable = pz4Var, value = 3)

            rb4 = tkinter.Radiobutton(pz4middleFrame, text = 'option 4', font = ('Arial', 25), variable = pz4Var, value = 4)

            rb5 = tkinter.Radiobutton(pz4middleFrame, text = 'option 5', font = ('Arial', 25), variable = pz4Var, value = 5)

            def solve4():
                #If the user failed or got it right
                
                if pz4Var.get() == 1 and alt == '1111':
                    tkinter.messagebox.showinfo("Puzzle 4 Complete!", "You solved the puzzle!")
                    puzzle4_win.destroy()
                    complete_puzzle4()
                    
                elif pz4Var.get() == 2 and alt == '0011':
                    tkinter.messagebox.showinfo("Puzzle 4 Complete!", "You solved the puzzle!")
                    puzzle4_win.destroy()
                    complete_puzzle4()
                    
                elif pz4Var.get() == 3 and alt == '0111':
                    tkinter.messagebox.showinfo("Puzzle 4 Complete!", "You solved the puzzle!")
                    puzzle4_win.destroy()
                    complete_puzzle4()
                    
                elif pz4Var.get() == 4 and alt == '0101':
                    tkinter.messagebox.showinfo("Puzzle 4 Complete!", "You solved the puzzle!")
                    puzzle4_win.destroy()
                    complete_puzzle4()

                elif pz4Var.get() == 5 and alt == '1001':
                    tkinter.messagebox.showinfo("Puzzle 4 Complete!", "You solved the puzzle!")
                    puzzle4_win.destroy()
                    complete_puzzle4()

                else:
                    game_over()


            
            #Other widgets
            pz4_label = tk.Label(pz4topFrame, text = alt, font = ("Arial", 20, "bold"))
            submit = tk.Button(pz4bottomFrame, text = 'Submit', font = ("Arial", 20, "bold"), command = solve4)

            #Pack widgets
            pz4topFrame.pack()
            pz4middleFrame.pack()
            pz4bottomFrame.pack()

            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            rb5.pack()

            pz4_label.pack()
            submit.pack()

            
        def defuse():
            global score

            #If the total score is equal to 4 then the user has won
            if score == 4:
                game_won()

            #If not then the user did not finish the puzzles and the games ends because they clicked this button
            elif score < 4:
                game_over()


        

        #The buttons to open the puzzles
        pzButton1 = tk.Button(buttonFrame, text = 'Device 1', font = ('Arial', 25), command = number_order) #puzzle button 1
        pzButton2 = tk.Button(buttonFrame, text = 'Device 2', font = ('Arial', 25), command = calculation)
        pzButton3 = tk.Button(buttonFrame, text = 'Device 3', font = ('Arial', 25), command = decoding)
        pzButton4 = tk.Button(buttonFrame, text = 'Device 4', font = ('Arial', 25), command = binary) #puzzle with radio/checkbuttons
        manualButton = tk.Button(buttonFrame, text = 'Manual', font = ('Arial', 25), command = manual)
        defuseButton = tk.Button(buttonFrame, text = 'DEFUSE', font = ('Arial', 25, 'bold'), command = defuse, fg = 'Blue')


        def complete_puzzle1():
            #This happens when the user finished puzzle 1
            #It will update the score to be +1 and at the end when the user presses defuse
            #It will check the score to see if the user completed all the puzzles
            
            global score
            score += 1

            #This function also updates the game button
            pzButton1.config(text = "Solved", fg = "Lime Green")
            
        def complete_puzzle2():
            #This happens when the user finished puzzle 2
            #It will update the score to be +1 and at the end when the user presses defuse
            #It will check the score to see if the user completed all the puzzles
            
            global score
            score += 1

            #This function also updates the game button
            pzButton2.config(text = "Solved", fg = "Lime Green")

        def complete_puzzle3():
            #This happens when the user finished puzzle 3
            #It will update the score to be +1 and at the end when the user presses defuse
            #It will check the score to see if the user completed all the puzzles
            
            global score
            score += 1

            #This function also updates the game button
            pzButton3.config(text = "Solved", fg = "Lime Green")
            
        def complete_puzzle4():
            #This happens when the user finished puzzle 4
            #It will update the score to be +1 and at the end when the user presses defuse
            #It will check the score to see if the user completed all the puzzles
            
            global score
            score += 1

            #This function also updates the game button
            pzButton4.config(text = "Solved", fg = "Lime Green")
        
                
        #Pack bottomFrame widgets (the buttons) in the game window
        pzButton1.pack(side = 'left')
        pzButton2.pack(side = 'left')
        pzButton3.pack(side = 'left')
        pzButton4.pack(side = 'left')
        manualButton.pack(side = 'left')
        defuseButton.pack(side = 'left')


        #Pack Frames
        mainFrame.pack()
        timerFrame.pack()
        buttonFrame.pack()
        
        
        gameWindow.mainloop() #Enter the toplvl window into the mainloop


        
        

    #Root window buttons (have to be placed at the end so the functions can be before it)
    start = tk.Button(windowBottomFrame, text = 'Start', font = ("Arial", 25), command = game)
    instructions = tk.Button(windowBottomFrame, text = 'Instructions', font = ("Arial", 25), command = game_instructions)
    quitButton = tk.Button(windowBottomFrame, text = 'Quit', font = ("Arial", 25), command = window.destroy)

    start.pack(side = 'left')
    instructions.pack(side = 'left')
    quitButton.pack(side = 'left')

    #Enter into the mainloop
    tk.mainloop()

main()
