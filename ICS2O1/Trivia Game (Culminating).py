#This program is a trivia game that will have 6 different categories of questions 
#The goal of this trivia game is to get the most points 
#the player will be able to restart the game and also quit at any time
#this game will have a game window for the actual game 
#and also a starting menu to start the game and view the instructions 
#This game will use tkinter and will mainly use buttons to activate the game questions
#*also most of the questions are facts gathered from the internet

import tkinter as tk
import tkinter.messagebox

score = 0 #score global variable
highscore = 0 #highscore global variable

def main():
    #Create main window
    window = tk.Tk()
    window.title("Trivia Game Starting Window") #Title
    window.geometry("1000x500") #Size

    #Main window widgets:

    #Frames
    windowTopFrame = tk.Frame(window, relief = 'raised', borderwidth = 1, bg = '#0D9FCA')
    windowMiddleFrame = tk.Frame(window, relief = 'raised', borderwidth = 1, bg = '#0D9FCA')
    windowBottomFrame = tk.Frame(window, relief = 'raised', borderwidth = 1, bg = '#0D9FCA')

    #Labels (TopFrame)
    windowTitle = tk.Label(windowTopFrame, text = 'Big Brain', font = ("Helvetica", 50, "bold"), bg = '#0D9FCA', fg = 'white')
    windowInfo1 = tk.Label(windowTopFrame, text = 'Welcome to the starting window for Big Brain!', \
                           font = ("Arial", 25), bg = '#0D9FCA', fg = 'white')
    windowInfo2 = tk.Label(windowTopFrame, text = 'Big Brain is a Trivia Game to test General Knowledge', \
                           font = ("Arial", 25), bg = '#0D9FCA', fg = 'white')
    windowInfo3 = tk.Label(windowTopFrame, text = 'Click the Start button to start the game', \
                           font = ("Arial", 25), bg = '#0D9FCA', fg = 'white')
    windowInfo4 = tk.Label(windowTopFrame, text = 'Click the Quit button to quit the game at any time', \
                           font = ("Arial", 25), bg = '#0D9FCA', fg = 'white')
    windowInfo5 = tk.Label(windowTopFrame, text = 'Click Rules if you would like to read it', \
                           font = ("Arial", 25), bg = '#0D9FCA', fg = 'white')

    #Pack Labels and Frames
    windowTopFrame.pack()
    windowMiddleFrame.pack()
    windowBottomFrame.pack()
    windowTitle.pack()
    windowInfo1.pack()
    windowInfo2.pack()
    windowInfo3.pack()
    windowInfo4.pack()
    windowInfo5.pack()

    def game_rules():
        #Game instructions for the Trivia Game

        #Toplvl window for instructions
        rules = tk.Toplevel()
        rules.title('Trivia Game Instructions')
        rules.geometry('1500x400')

        #Frames
        rulesTopFrame = tk.Frame(rules, relief = 'raised', borderwidth = 1, bg = '#0D9FCA')
        rulesBottomFrame = tk.Frame(rules, relief = 'raised', borderwidth = 1, bg = '#0D9FCA')

        #Widgets
        rulesTitle = tk.Label(rulesTopFrame, text = 'Big Brain Rules:', font = ("Helvetica", 50, "bold"), bg = '#0D9FCA', fg = 'white')
        rulesLabel = tk.Label(rulesTopFrame, text = 'In this game you will be given 6 different categories of trivia questions!\n' +
                         'You will click from the bottom of each category to answer the questions.\n' +
                         'The questions increase in difficulty the lower they are positioned.\n' +
                         'But they are worth more. The greater the risk the greater the reward!\n' +
                         'How much they are worth will show up on the button.\n' +
                         'Wrong answers will take away the score on the button.\n' +
                         'You do have the option to skip a question if you would like to.\n' +
                         'There is no time limit to answer the questions.\n' +
                         'The only goal is to try and get the highest score that you can by answering the questions right\n' +
                         'Once all the questions are answered a final question will be revealed to gain 5000 bonus points! (the bonus question will not take away score)\n' +
                         'After answering the bonus question the game will end and it will reveal your total score!', \
                         font = ("Arial", 15, "bold"), bg = '#0D9FCA', fg = 'white')

        rulesQuit = tk.Button(rulesBottomFrame, text = 'Quit', font = ("Arial", 15, "bold"), command = rules.destroy, bg = '#0D9FCA', fg = 'white')

        #Pack widgets
        rulesTopFrame.pack()
        rulesBottomFrame.pack()
        rulesTitle.pack()
        rulesLabel.pack()
        rulesQuit.pack()

        #Enter intomainloop
        rules.mainloop()

    def dud():
        #this is to make the question buttons do nothing so the user won't answer the question again
        #to eliminate infinite points or accidently repeating questions
        pass

    def game():
        #game window
        gameWin = tk.Toplevel()
        gameWin.title('Trivia Game')
        gameWin.geometry('1500x500')

        #Frames for each row of buttons (top row will be category names)
        row1 = tk.Frame(gameWin)
        row2 = tk.Frame(gameWin)
        row3 = tk.Frame(gameWin)
        row4 = tk.Frame(gameWin)
        row5 = tk.Frame(gameWin)
        row6 = tk.Frame(gameWin)
        row7 = tk.Frame(gameWin)

        #score label
        before_show_score = tk.Label(row7, text = 'Score:', font = ('Arial', 25))
        show_score = tk.Label(row7, text = score, font = ('Arial', 25), fg = 'dark orange')

        #Functions for all the button questions:
        def vq1():
            #This is the first question and all others follow the same format so they don't require comments
            
            #window
            vWin = tk.Toplevel()
            vWin.title('Video Games Question 1')
            vWin.geometry('750x400')

            #widgets
            vLabel = tk.Label(vWin, text = 'What is the best selling video game?', font = ("Arial", 30, "bold"))

            #IntVar() Object
            var = tk.IntVar()
            #Set IntVar() Object to 1
            var.set(1) #this allows option 1 to be selected by default

            #Radiobuttons:
            rb1 = tk.Radiobutton(vWin, text = 'GTA V', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(vWin, text = 'Tetris', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(vWin, text = 'Minecraft', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(vWin, text = 'Wii Sports', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 3:
                    #update score by the amount labelled on the button
                    score_200()

                    #update score label
                    show_score.config(text = score)

                    #tell the user they got the answer right
                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    #disable the button after it is complete
                    vb1.config(command = dud)
                    
                    #config button to show as correct to the user
                    vb1.config(text = 'Correct!', fg = 'Lime Green')

                    #destroy window
                    vWin.destroy()
                else:
                    #update score by the amount labelled on the button (decreasing)
                    notscore_200()
                    
                    #update score label
                    show_score.config(text = score)

                    #tell the user they got the answer wrong
                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    #disable the button after it is complete
                    vb1.config(command = dud)

                    #config button to show that the user got the question wrong
                    vb1.config(text = 'Incorrect', fg = 'Red')

                    #destroy window
                    vWin.destroy()

            #submit button
            submit = tk.Button(vWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                #destory window
                vWin.destroy()

                #change display
                vb1.config(text = 'Skipped')

                #won't disable the button in case the user wants to answer it later

            skipp = tk.Button(vWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            #pack vq1 widgets
            vLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()

            
        def vq2():
            vWin = tk.Toplevel()
            vWin.title('Video Games Question 2')
            vWin.geometry('750x400')

            vLabel = tk.Label(vWin, text = 'What is the first home video console?', font = ("Arial", 30, "bold"))

            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(vWin, text = "Atari's Video Computer System", font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(vWin, text = 'The Magnavox Odyssey', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(vWin, text = 'The Nintendo Entertainment System (NES)', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(vWin, text = 'Playstation 1', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 2:
                    score_400()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    vb2.config(command = dud)
                    
                    vb2.config(text = 'Correct!', fg = 'Lime Green')

                    vWin.destroy()
                else:
                    notscore_400()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    vb2.config(command = dud)

                    vb2.config(text = 'Incorrect', fg = 'Red')

                    vWin.destroy()

            submit = tk.Button(vWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                vWin.destroy()

                vb2.config(text = 'Skipped')

            skipp = tk.Button(vWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            vLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()

            
        def vq3():
            vWin = tk.Toplevel()
            vWin.title('Video Games Question 3')
            vWin.geometry('1400x300')

            vLabel = tk.Label(vWin, text = 'True or False the second most popular free game downloaded on iPhones in 2018 was Helix Jump', font = ("Arial", 20, "bold"))

            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(vWin, text = "True", font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(vWin, text = 'False', font = ('Arial', 25), variable = var, value = 2)

            def solve():
                if var.get() == 1:
                    score_600()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    vb3.config(command = dud)
                    
                    vb3.config(text = 'Correct!', fg = 'Lime Green')

                    vWin.destroy()
                else:
                    notscore_600()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    vb3.config(command = dud)

                    vb3.config(text = 'Incorrect', fg = 'Red')

                    vWin.destroy()

            submit = tk.Button(vWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                vWin.destroy()

                vb3.config(text = 'Skipped')

            skipp = tk.Button(vWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            vLabel.pack()
            rb1.pack()
            rb2.pack()
            submit.pack()
            skipp.pack()

            
        def vq4():
            vWin = tk.Toplevel()
            vWin.title('Video Games Question 4')
            vWin.geometry('1000x400')

            vLabel = tk.Label(vWin, text = 'What Pokemon holds the title as the first listed creature?', font = ("Arial", 15, "bold"))
            vLabel2 = tk.Label(vWin, text = 'This creature is No.1 in the encyclopedic Pokedex and is considered a hybrid grass-poison type', font = ("Arial", 15, "bold"))

            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(vWin, text = 'Bulbasaur', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(vWin, text = 'Squirtle', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(vWin, text = 'Pikachu', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(vWin, text = 'Charmander', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 1:
                    score_800()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    vb4.config(command = dud)
                    
                    vb4.config(text = 'Correct!', fg = 'Lime Green')

                    vWin.destroy()
                else:
                    notscore_800()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    vb4.config(command = dud)

                    vb4.config(text = 'Incorrect', fg = 'Red')

                    vWin.destroy()

            submit = tk.Button(vWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                vWin.destroy()

                vb4.config(text = 'Skipped')

            skipp = tk.Button(vWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            vLabel.pack()
            vLabel2.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()

            
        def vq5():
            vWin = tk.Toplevel()
            vWin.title('Video Games Question 5')
            vWin.geometry('900x400')

            vLabel = tk.Label(vWin, text = 'Select all that are Legend of Zelda Games', font = ("Arial", 30, "bold"))

            #Create the IntVar Objects we will match with the Checkbuttons used
            cbVar1 = tkinter.IntVar()
            cbVar2 = tkinter.IntVar()
            cbVar3 = tkinter.IntVar()
            cbVar4 = tkinter.IntVar()
            cbVar5 = tkinter.IntVar()
            cbVar6 = tkinter.IntVar()

            #set the IntVar object to have an initial value of 0 because we don't know what the user will pick first
            cbVar1.set(0)
            cbVar2.set(0)
            cbVar3.set(0)
            cbVar4.set(0)
            cbVar5.set(0)
            cbVar6.set(0)
            #setting all of the checkbuttons to "off"

            #checkbuttons:
            cb1 = tkinter.Checkbutton(vWin, text = 'Tears of the Kingdom', font = 25, variable = cbVar1)
            cb2 = tkinter.Checkbutton(vWin, text = 'New Horizons', font = 25, variable = cbVar2)
            cb3 = tkinter.Checkbutton(vWin, text = "Majora's Mask", font = 25, variable = cbVar3)
            cb4 = tkinter.Checkbutton(vWin, text = 'Ocarina of Time', font = 25, variable = cbVar4)
            cb5 = tkinter.Checkbutton(vWin, text = 'Between Time', font = 25, variable = cbVar5)
            cb6 = tkinter.Checkbutton(vWin, text = 'The Wind Waker', font = 25, variable = cbVar6)

            def solve():
                if cbVar1.get() == 1 and cbVar2.get() == 0 and cbVar3.get() == 1 and cbVar4.get() == 1 and cbVar5.get() == 0 and cbVar6.get() == 1:
                    score_1000()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    vb5.config(command = dud)
                    
                    vb5.config(text = 'Correct!', fg = 'Lime Green')

                    vWin.destroy()
                else:
                    notscore_1000()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    vb5.config(command = dud)

                    vb5.config(text = 'Incorrect', fg = 'Red')

                    vWin.destroy()

            submit = tk.Button(vWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                vWin.destroy()

                vb5.config(text = 'Skipped')

            skipp = tk.Button(vWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            vLabel.pack()
            cb1.pack()
            cb2.pack()
            cb3.pack()
            cb4.pack()
            cb5.pack()
            cb6.pack()
            submit.pack()
            skipp.pack()
            


        def cq1():
            cWin = tk.Toplevel()
            cWin.title('Countries Question 1')
            cWin.geometry('1400x300')

            cLabel = tk.Label(cWin, text = "True or False Yonge Street in Canada is the longest street in the world", font = ("Arial", 20, "bold"))

            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(cWin, text = "True", font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(cWin, text = 'False', font = ('Arial', 25), variable = var, value = 2)

            def solve():
                if var.get() == 1:
                    score_200()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    cob1.config(command = dud)
                    
                    cob1.config(text = 'Correct!', fg = 'Lime Green')

                    cWin.destroy()
                else:
                    notscore_200()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    cob1.config(command = dud)

                    cob1.config(text = 'Incorrect', fg = 'Red')

                    cWin.destroy()

            submit = tk.Button(cWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                cWin.destroy()

                cob1.config(text = 'Skipped')

            skipp = tk.Button(cWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            cLabel.pack()
            rb1.pack()
            rb2.pack()
            submit.pack()
            skipp.pack()
            
        def cq2():
            cWin = tk.Toplevel()
            cWin.title('Countries Question 2')
            cWin.geometry('1100x400')

            cLabel = tk.Label(cWin, text = 'Which Country consumes the most chocolate per year?', font = ("Arial", 30, "bold"))
            
            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(cWin, text = 'The United States', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(cWin, text = 'Belgium', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(cWin, text = 'Indonesia', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(cWin, text = 'Switzerland', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 4:
                    score_400()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    cob2.config(command = dud)
                    
                    cob2.config(text = 'Correct!', fg = 'Lime Green')

                    cWin.destroy()
                else:
                    notscore_400()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    cob2.config(command = dud)

                    cob2.config(text = 'Incorrect', fg = 'Red')

                    cWin.destroy()

            submit = tk.Button(cWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                cWin.destroy()

                cob2.config(text = 'Skipped')

            skipp = tk.Button(cWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            cLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()
            
        def cq3():
            cWin = tk.Toplevel()
            cWin.title('Countries Question 3')
            cWin.geometry('1000x400')

            cLabel = tk.Label(cWin, text = 'Which Country produces the most oxygen? (from trees)', font = ("Arial", 20, "bold"))
            
            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(cWin, text = 'China', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(cWin, text = 'Canada', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(cWin, text = 'Russia', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(cWin, text = 'Brazil', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 3:
                    score_600()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    cob3.config(command = dud)
                    
                    cob3.config(text = 'Correct!', fg = 'Lime Green')

                    cWin.destroy()
                else:
                    notscore_600()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    cob3.config(command = dud)

                    cob3.config(text = 'Incorrect', fg = 'Red')

                    cWin.destroy()

            submit = tk.Button(cWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                cWin.destroy()

                cob3.config(text = 'Skipped')

            skipp = tk.Button(cWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            cLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()

            
        def cq4():
            cWin = tk.Toplevel()
            cWin.title('Countries Question 4')
            cWin.geometry('1000x400')

            cLabel = tk.Label(cWin, text = 'What Country did Lego Originate from?', font = ("Arial", 30, "bold"))
            
            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(cWin, text = 'Denmark', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(cWin, text = 'Sweden', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(cWin, text = 'France', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(cWin, text = 'United Kingdom', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 1:
                    score_800()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    cob4.config(command = dud)
                    
                    cob4.config(text = 'Correct!', fg = 'Lime Green')

                    cWin.destroy()
                else:
                    notscore_800()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    cob4.config(command = dud)

                    cob4.config(text = 'Incorrect', fg = 'Red')

                    cWin.destroy()

            submit = tk.Button(cWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                cWin.destroy()

                cob4.config(text = 'Skipped')

            skipp = tk.Button(cWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            cLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()

            
        def cq5():
            cWin = tk.Toplevel()
            cWin.title('Countries Question 5')
            cWin.geometry('1200x400')

            cLabel = tk.Label(cWin, text = 'Select all that are members of the Commonwealth', font = ("Arial", 30, "bold"))

            cbVar1 = tkinter.IntVar()
            cbVar2 = tkinter.IntVar()
            cbVar3 = tkinter.IntVar()
            cbVar4 = tkinter.IntVar()
            cbVar5 = tkinter.IntVar()
            cbVar6 = tkinter.IntVar()

            cbVar1.set(0)
            cbVar2.set(0)
            cbVar3.set(0)
            cbVar4.set(0)
            cbVar5.set(0)
            cbVar6.set(0)

            cb1 = tkinter.Checkbutton(cWin, text = 'Canada', font = 25, variable = cbVar1)
            cb2 = tkinter.Checkbutton(cWin, text = 'China', font = 25, variable = cbVar2)
            cb3 = tkinter.Checkbutton(cWin, text = 'India', font = 25, variable = cbVar3)
            cb4 = tkinter.Checkbutton(cWin, text = 'Pakistan', font = 25, variable = cbVar4)
            cb5 = tkinter.Checkbutton(cWin, text = 'Egypt', font = 25, variable = cbVar5)
            cb6 = tkinter.Checkbutton(cWin, text = 'France', font = 25, variable = cbVar6)

            def solve():
                if cbVar1.get() == 1 and cbVar2.get() == 0 and cbVar3.get() == 1 and cbVar4.get() == 1 and cbVar5.get() == 0 and cbVar6.get() == 0:
                    score_1000()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    cob5.config(command = dud)
                    
                    cob5.config(text = 'Correct!', fg = 'Lime Green')

                    cWin.destroy()
                else:
                    notscore_1000()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    cob5.config(command = dud)

                    cob5.config(text = 'Incorrect', fg = 'Red')

                    cWin.destroy()

            submit = tk.Button(cWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                cWin.destroy()

                cob5.config(text = 'Skipped')

            skipp = tk.Button(cWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            cLabel.pack()
            cb1.pack()
            cb2.pack()
            cb3.pack()
            cb4.pack()
            cb5.pack()
            cb6.pack()
            submit.pack()
            skipp.pack()



        def sq1():
            sWin = tk.Toplevel()
            sWin.title('Science 1')
            sWin.geometry('1400x300')

            sLabel = tk.Label(sWin, text = "True or False, Pluto is on the same orbital plane as the other planets", font = ("Arial", 20, "bold"))

            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(sWin, text = "True", font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(sWin, text = 'False', font = ('Arial', 25), variable = var, value = 2)

            def solve():
                if var.get() == 2:
                    score_200()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    sb1.config(command = dud)
                    
                    sb1.config(text = 'Correct!', fg = 'Lime Green')

                    sWin.destroy()
                else:
                    notscore_200()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "False! Pluto has a different orbit than the other planets")

                    sb1.config(command = dud)

                    sb1.config(text = 'Incorrect', fg = 'Red')

                    sWin.destroy()

            submit = tk.Button(sWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                sWin.destroy()

                sb1.config(text = 'Skipped')

            skipp = tk.Button(sWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            sLabel.pack()
            rb1.pack()
            rb2.pack()
            submit.pack()
            skipp.pack()
            

        def sq2():
            sWin = tk.Toplevel()
            sWin.title('Science Question 2')
            sWin.geometry('1000x400')

            sLabel = tk.Label(sWin, text = "What is the biggest producer of the world's oxygen?", font = ("Arial", 30, "bold"))
            
            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(sWin, text = 'Forests', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(sWin, text = 'Oceans', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(sWin, text = 'Deserts', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(sWin, text = 'Animals', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 2:
                    score_400()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    sb2.config(command = dud)
                    
                    sb2.config(text = 'Correct!', fg = 'Lime Green')

                    sWin.destroy()
                else:
                    notscore_400()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    sb2.config(command = dud)

                    sb2.config(text = 'Incorrect', fg = 'Red')

                    sWin.destroy()

            submit = tk.Button(sWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                sWin.destroy()

                sb2.config(text = 'Skipped')

            skipp = tk.Button(sWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            sLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()

        def sq3():
            sWin = tk.Toplevel()
            sWin.title('Science Question 3')
            sWin.geometry('1000x400')

            sLabel = tk.Label(sWin, text = "How much does a cloud weigh?", font = ("Arial", 30, "bold"))
            
            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(sWin, text = 'Nearly No Weight', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(sWin, text = '10,000 pounds', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(sWin, text = '1 million pounds', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(sWin, text = '1 billion pounds', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 4:
                    score_600()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    sb3.config(command = dud)
                    
                    sb3.config(text = 'Correct!', fg = 'Lime Green')

                    sWin.destroy()
                else:
                    notscore_600()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    sb3.config(command = dud)

                    sb3.config(text = 'Incorrect', fg = 'Red')

                    sWin.destroy()

            submit = tk.Button(sWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                sWin.destroy()

                sb3.config(text = 'Skipped')

            skipp = tk.Button(sWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            sLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()

        def sq4():
            sWin = tk.Toplevel()
            sWin.title('Science Question 4')
            sWin.geometry('1000x400')

            sLabel = tk.Label(sWin, text = "What is the speed of light?", font = ("Arial", 30, "bold"))
            
            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(sWin, text = 'around 100,000,000m/s', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(sWin, text = 'around 300,000,000m/s', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(sWin, text = 'around 2,000,000,000m/s', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(sWin, text = 'infinite m/s', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 2:
                    score_800()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    sb4.config(command = dud)
                    
                    sb4.config(text = 'Correct!', fg = 'Lime Green')

                    sWin.destroy()
                else:
                    notscore_800()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    sb4.config(command = dud)

                    sb4.config(text = 'Incorrect', fg = 'Red')

                    sWin.destroy()

            submit = tk.Button(sWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                sWin.destroy()

                sb4.config(text = 'Skipped')

            skipp = tk.Button(sWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            sLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()


        def sq5():
            sWin = tk.Toplevel()
            sWin.title('Science Question 5')
            sWin.geometry('1200x400')

            sLabel = tk.Label(sWin, text = 'Select all that are Alkali Metals', font = ("Arial", 30, "bold"))

            cbVar1 = tkinter.IntVar()
            cbVar2 = tkinter.IntVar()
            cbVar3 = tkinter.IntVar()
            cbVar4 = tkinter.IntVar()
            cbVar5 = tkinter.IntVar()
            cbVar6 = tkinter.IntVar()

            cbVar1.set(0)
            cbVar2.set(0)
            cbVar3.set(0)
            cbVar4.set(0)
            cbVar5.set(0)
            cbVar6.set(0)

            cb1 = tkinter.Checkbutton(sWin, text = 'Lithium', font = 25, variable = cbVar1)
            cb2 = tkinter.Checkbutton(sWin, text = 'Rubidium', font = 25, variable = cbVar2)
            cb3 = tkinter.Checkbutton(sWin, text = 'Calcium', font = 25, variable = cbVar3)
            cb4 = tkinter.Checkbutton(sWin, text = 'Hydrogen', font = 25, variable = cbVar4)
            cb5 = tkinter.Checkbutton(sWin, text = 'Potassium', font = 25, variable = cbVar5)
            cb6 = tkinter.Checkbutton(sWin, text = 'Aluminium', font = 25, variable = cbVar6)

            def solve():
                if cbVar1.get() == 1 and cbVar2.get() == 1 and cbVar3.get() == 0 and cbVar4.get() == 0 and cbVar5.get() == 1 and cbVar6.get() == 0:
                    score_1000()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    sb5.config(command = dud)
                    
                    sb5.config(text = 'Correct!', fg = 'Lime Green')

                    sWin.destroy()
                else:
                    notscore_1000()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    sb5.config(command = dud)

                    sb5.config(text = 'Incorrect', fg = 'Red')

                    sWin.destroy()

            submit = tk.Button(sWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                sWin.destroy()

                sb5.config(text = 'Skipped')

            skipp = tk.Button(sWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            sLabel.pack()
            cb1.pack()
            cb2.pack()
            cb3.pack()
            cb4.pack()
            cb5.pack()
            cb6.pack()
            submit.pack()
            skipp.pack()



        def hq1():
            hWin = tk.Toplevel()
            hWin.title('History 1')
            hWin.geometry('1400x300')

            hLabel = tk.Label(hWin, text = "True or False, Canada has no official languages", font = ("Arial", 20, "bold"))

            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(hWin, text = "True", font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(hWin, text = 'False', font = ('Arial', 25), variable = var, value = 2)

            def solve():
                if var.get() == 2:
                    score_200()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    hb1.config(command = dud)
                    
                    hb1.config(text = 'Correct!', fg = 'Lime Green')

                    hWin.destroy()
                else:
                    notscore_200()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Canada has 2 official languanges. English and French")

                    hb1.config(command = dud)

                    hb1.config(text = 'Incorrect', fg = 'Red')

                    hWin.destroy()

            submit = tk.Button(hWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                hWin.destroy()

                hb1.config(text = 'Skipped')

            skipp = tk.Button(hWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            hLabel.pack()
            rb1.pack()
            rb2.pack()
            submit.pack()
            skipp.pack()
            
            
        def hq2():
            hWin = tk.Toplevel()
            hWin.title('History 1')
            hWin.geometry('1400x300')

            hLabel = tk.Label(hWin, text = "True or False, The name Canada is derived from the indigenous word Kanata", font = ("Arial", 20, "bold"))

            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(hWin, text = "True", font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(hWin, text = 'False', font = ('Arial', 25), variable = var, value = 2)

            def solve():
                if var.get() == 1:
                    score_400()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    hb2.config(command = dud)
                    
                    hb2.config(text = 'Correct!', fg = 'Lime Green')

                    hWin.destroy()
                else:
                    notscore_400()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    hb2.config(command = dud)

                    hb2.config(text = 'Incorrect', fg = 'Red')

                    hWin.destroy()

            submit = tk.Button(hWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                hWin.destroy()

                hb2.config(text = 'Skipped')

            skipp = tk.Button(hWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            hLabel.pack()
            rb1.pack()
            rb2.pack()
            submit.pack()
            skipp.pack()
            


        def hq3():
            hWin = tk.Toplevel()
            hWin.title('History Question 3')
            hWin.geometry('1000x400')

            hLabel = tk.Label(hWin, text = "What year did Canada become a country?", font = ("Arial", 30, "bold"))
            
            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(hWin, text = '1776', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(hWin, text = '1797', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(hWin, text = '1853', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(hWin, text = '1867', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 4:
                    score_600()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    hb3.config(command = dud)
                    
                    hb3.config(text = 'Correct!', fg = 'Lime Green')

                    hWin.destroy()
                else:
                    notscore_600()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    hb3.config(command = dud)

                    hb3.config(text = 'Incorrect', fg = 'Red')

                    hWin.destroy()

            submit = tk.Button(hWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                hWin.destroy()

                hb3.config(text = 'Skipped')

            skipp = tk.Button(hWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            hLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()
            

        def hq4():
            hWin = tk.Toplevel()
            hWin.title('History Question 4')
            hWin.geometry('1000x400')

            hLabel = tk.Label(hWin, text = "What year did Canada get its own flag?", font = ("Arial", 30, "bold"))
            
            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(hWin, text = '1964', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(hWin, text = '1965', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(hWin, text = '1966', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(hWin, text = '1967', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 2:
                    score_800()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    hb4.config(command = dud)
                    
                    hb4.config(text = 'Correct!', fg = 'Lime Green')

                    hWin.destroy()
                else:
                    notscore_800()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    hb4.config(command = dud)

                    hb4.config(text = 'Incorrect', fg = 'Red')

                    hWin.destroy()

            submit = tk.Button(hWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                hWin.destroy()

                hb4.config(text = 'Skipped')

            skipp = tk.Button(hWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            hLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()


        def hq5():
            hWin = tk.Toplevel()
            hWin.title('Science Question 5')
            hWin.geometry('1200x400')

            hLabel = tk.Label(hWin, text = 'Select all top three voted "Greatest Canadians"', font = ("Arial", 30, "bold"))

            cbVar1 = tkinter.IntVar()
            cbVar2 = tkinter.IntVar()
            cbVar3 = tkinter.IntVar()
            cbVar4 = tkinter.IntVar()
            cbVar5 = tkinter.IntVar()
            cbVar6 = tkinter.IntVar()

            cbVar1.set(0)
            cbVar2.set(0)
            cbVar3.set(0)
            cbVar4.set(0)
            cbVar5.set(0)
            cbVar6.set(0)

            cb1 = tkinter.Checkbutton(hWin, text = 'Lester B. Pearson', font = 25, variable = cbVar1)
            cb2 = tkinter.Checkbutton(hWin, text = 'David Suzuki', font = 25, variable = cbVar2)
            cb3 = tkinter.Checkbutton(hWin, text = 'Terry Fox', font = 25, variable = cbVar3)
            cb4 = tkinter.Checkbutton(hWin, text = 'Tommy Douglas', font = 25, variable = cbVar4)
            cb5 = tkinter.Checkbutton(hWin, text = 'Wayne Gretzky', font = 25, variable = cbVar5)
            cb6 = tkinter.Checkbutton(hWin, text = 'Pierre Trudeau', font = 25, variable = cbVar6)

            def solve():
                if cbVar1.get() == 0 and cbVar2.get() == 0 and cbVar3.get() == 1 and cbVar4.get() == 1 and cbVar5.get() == 0 and cbVar6.get() == 1:
                    score_1000()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    hb5.config(command = dud)
                    
                    hb5.config(text = 'Correct!', fg = 'Lime Green')

                    hWin.destroy()
                else:
                    notscore_1000()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    hb5.config(command = dud)

                    hb5.config(text = 'Incorrect', fg = 'Red')

                    hWin.destroy()

            submit = tk.Button(hWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                hWin.destroy()

                hb5.config(text = 'Skipped')

            skipp = tk.Button(hWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            hLabel.pack()
            cb1.pack()
            cb2.pack()
            cb3.pack()
            cb4.pack()
            cb5.pack()
            cb6.pack()
            submit.pack()
            skipp.pack()



        def tq1():
            tWin = tk.Toplevel()
            tWin.title('History 1')
            tWin.geometry('1400x300')

            tLabel = tk.Label(tWin, text = "True or False, The QWERTY keyboard is the most efficient keyboard", font = ("Arial", 20, "bold"))

            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(tWin, text = "True", font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(tWin, text = 'False', font = ('Arial', 25), variable = var, value = 2)

            def solve():
                if var.get() == 2:
                    score_200()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    tb1.config(command = dud)
                    
                    tb1.config(text = 'Correct!', fg = 'Lime Green')

                    tWin.destroy()
                else:
                    notscore_200()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "False! It was designed to prevent jamming between frequently used letters on typewriters")

                    tb1.config(command = dud)

                    tb1.config(text = 'Incorrect', fg = 'Red')

                    tWin.destroy()

            submit = tk.Button(tWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                tWin.destroy()

                tb1.config(text = 'Skipped')

            skipp = tk.Button(tWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            tLabel.pack()
            rb1.pack()
            rb2.pack()
            submit.pack()
            skipp.pack()


        def tq2():
            tWin = tk.Toplevel()
            tWin.title('Technology Question 2')
            tWin.geometry('1000x400')

            tLabel = tk.Label(tWin, text = "What is the number of Internet users (As of 2022)?", font = ("Arial", 30, "bold"))
            
            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(tWin, text = '4.3 billion', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(tWin, text = '4.7 billion', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(tWin, text = '5.1 billion', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(tWin, text = '6.3 billion', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 3:
                    score_400()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    tb2.config(command = dud)
                    
                    tb2.config(text = 'Correct!', fg = 'Lime Green')

                    tWin.destroy()
                else:
                    notscore_400()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    tb2.config(command = dud)

                    tb2.config(text = 'Incorrect', fg = 'Red')

                    tWin.destroy()

            submit = tk.Button(tWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                tWin.destroy()

                tb2.config(text = 'Skipped')

            skipp = tk.Button(tWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            tLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()


        def tq3():
            tWin = tk.Toplevel()
            tWin.title('Technology Question 3')
            tWin.geometry('1200x400')

            tLabel = tk.Label(tWin, text = "What is approximately Elon Musk's networth (As of 2023)?", font = ("Arial", 30, "bold"))
            
            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(tWin, text = '$180 billion', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(tWin, text = '$203 billion', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(tWin, text = '$216 billion', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(tWin, text = '$245 billion', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 3:
                    score_600()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    tb3.config(command = dud)
                    
                    tb3.config(text = 'Correct!', fg = 'Lime Green')

                    tWin.destroy()
                else:
                    notscore_600()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    tb3.config(command = dud)

                    tb3.config(text = 'Incorrect', fg = 'Red')

                    tWin.destroy()

            submit = tk.Button(tWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                tWin.destroy()

                tb3.config(text = 'Skipped')

            skipp = tk.Button(tWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            tLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()


        def tq4():
            tWin = tk.Toplevel()
            tWin.title('Technology Question 4')
            tWin.geometry('1000x400')

            tLabel = tk.Label(tWin, text = "How many google searches happen per second?", font = ("Arial", 30, "bold"))
            
            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(tWin, text = '30,000', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(tWin, text = '100,000', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(tWin, text = '130,000', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(tWin, text = '180,000', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 2:
                    score_800()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    tb4.config(command = dud)
                    
                    tb4.config(text = 'Correct!', fg = 'Lime Green')

                    tWin.destroy()
                else:
                    notscore_800()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    tb4.config(command = dud)

                    tb4.config(text = 'Incorrect', fg = 'Red')

                    tWin.destroy()

            submit = tk.Button(tWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                tWin.destroy()

                tb4.config(text = 'Skipped')

            skipp = tk.Button(tWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            tLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()


        def tq5():
            tWin = tk.Toplevel()
            tWin.title('Technology Question 5')
            tWin.geometry('1200x400')

            tLabel = tk.Label(tWin, text = 'Select all that were once or are real Apple Products', font = ("Arial", 30, "bold"))

            cbVar1 = tkinter.IntVar()
            cbVar2 = tkinter.IntVar()
            cbVar3 = tkinter.IntVar()
            cbVar4 = tkinter.IntVar()
            cbVar5 = tkinter.IntVar()
            cbVar6 = tkinter.IntVar()

            cbVar1.set(0)
            cbVar2.set(0)
            cbVar3.set(0)
            cbVar4.set(0)
            cbVar5.set(0)
            cbVar6.set(0)

            cb1 = tkinter.Checkbutton(tWin, text = 'An Apple gaming console', font = 25, variable = cbVar1)
            cb2 = tkinter.Checkbutton(tWin, text = 'An Apple printer', font = 25, variable = cbVar2)
            cb3 = tkinter.Checkbutton(tWin, text = 'An Apple microwave', font = 25, variable = cbVar3)
            cb4 = tkinter.Checkbutton(tWin, text = 'An Apple clothing line', font = 25, variable = cbVar4)
            cb5 = tkinter.Checkbutton(tWin, text = 'An Apple toothbrush', font = 25, variable = cbVar5)
            cb6 = tkinter.Checkbutton(tWin, text = 'An Apple key', font = 25, variable = cbVar6)

            def solve():
                if cbVar1.get() == 1 and cbVar2.get() == 1 and cbVar3.get() == 0 and cbVar4.get() == 1 and cbVar5.get() == 0 and cbVar6.get() == 0:
                    score_1000()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    tb5.config(command = dud)
                    
                    tb5.config(text = 'Correct!', fg = 'Lime Green')

                    tWin.destroy()
                else:
                    notscore_1000()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    tb5.config(command = dud)

                    tb5.config(text = 'Incorrect', fg = 'Red')

                    tWin.destroy()

            submit = tk.Button(tWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                tWin.destroy()

                tb5.config(text = 'Skipped')

            skipp = tk.Button(tWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            tLabel.pack()
            cb1.pack()
            cb2.pack()
            cb3.pack()
            cb4.pack()
            cb5.pack()
            cb6.pack()
            submit.pack()
            skipp.pack()



        def pq1():
            pWin = tk.Toplevel()
            pWin.title('Pop Culture Question 1')
            pWin.geometry('1400x300')

            pLabel = tk.Label(pWin, text = "True or False, the most watched Youtube video of all time is Baby Shark", font = ("Arial", 20, "bold"))

            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(pWin, text = "True", font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(pWin, text = 'False', font = ('Arial', 25), variable = var, value = 2)

            def solve():
                if var.get() == 1:
                    score_200()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    pb1.config(command = dud)
                    
                    pb1.config(text = 'Correct!', fg = 'Lime Green')

                    pWin.destroy()
                else:
                    notscore_200()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Incorrect")

                    pb1.config(command = dud)

                    pb1.config(text = 'Incorrect', fg = 'Red')

                    pWin.destroy()

            submit = tk.Button(pWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                pWin.destroy()

                pb1.config(text = 'Skipped')

            skipp = tk.Button(pWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            pLabel.pack()
            rb1.pack()
            rb2.pack()
            submit.pack()
            skipp.pack()


        def pq2():
            pWin = tk.Toplevel()
            pWin.title('Pop Culture Question 2')
            pWin.geometry('1000x400')

            pLabel = tk.Label(pWin, text = "What is the name of the alternate dimension in Stranger Things?", font = ("Arial", 20, "bold"))
            
            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(pWin, text = 'The Depths', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(pWin, text = 'Hell', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(pWin, text = 'The Upside Down', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(pWin, text = 'Reversed Dimension', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 3:
                    score_400()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    pb2.config(command = dud)
                    
                    pb2.config(text = 'Correct!', fg = 'Lime Green')

                    pWin.destroy()
                else:
                    notscore_400()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    pb2.config(command = dud)

                    pb2.config(text = 'Incorrect', fg = 'Red')

                    pWin.destroy()

            submit = tk.Button(pWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                pWin.destroy()

                pb2.config(text = 'Skipped')

            skipp = tk.Button(pWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            pLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()


        def pq3():
            pWin = tk.Toplevel()
            pWin.title('Pop Culture Question 3')
            pWin.geometry('1000x400')

            pLabel = tk.Label(pWin, text = "How many Harry Potter books are there (not including cursed child)?", font = ("Arial", 20, "bold"))
            
            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(pWin, text = '6', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(pWin, text = '7', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(pWin, text = '8', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(pWin, text = '9', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 2:
                    score_600()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    pb3.config(command = dud)
                    
                    pb3.config(text = 'Correct!', fg = 'Lime Green')

                    pWin.destroy()
                else:
                    notscore_600()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    pb3.config(command = dud)

                    pb3.config(text = 'Incorrect', fg = 'Red')

                    pWin.destroy()

            submit = tk.Button(pWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                pWin.destroy()

                pb3.config(text = 'Skipped')

            skipp = tk.Button(pWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            pLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()
            

        def pq4():
            pWin = tk.Toplevel()
            pWin.title('Pop Culture Question 4')
            pWin.geometry('1000x400')

            pLabel = tk.Label(pWin, text = "How much money has the MCU grossed so far?", font = ("Arial", 30, "bold"))
            
            var = tk.IntVar()
            var.set(1) 

            rb1 = tk.Radiobutton(pWin, text = '$10 billion', font = ('Arial', 25), variable = var, value = 1)
            rb2 = tk.Radiobutton(pWin, text = '$15 billion', font = ('Arial', 25), variable = var, value = 2)
            rb3 = tk.Radiobutton(pWin, text = '$20 billion', font = ('Arial', 25), variable = var, value = 3)
            rb4 = tk.Radiobutton(pWin, text = '$25 billion', font = ('Arial', 25), variable = var, value = 4)

            def solve():
                if var.get() == 4:
                    score_800()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    pb4.config(command = dud)
                    
                    pb4.config(text = 'Correct!', fg = 'Lime Green')

                    pWin.destroy()
                else:
                    notscore_800()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    pb4.config(command = dud)

                    pb4.config(text = 'Incorrect', fg = 'Red')

                    pWin.destroy()

            submit = tk.Button(pWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                pWin.destroy()

                pb4.config(text = 'Skipped')

            skipp = tk.Button(pWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            pLabel.pack()
            rb1.pack()
            rb2.pack()
            rb3.pack()
            rb4.pack()
            submit.pack()
            skipp.pack()


        def pq5():
            pWin = tk.Toplevel()
            pWin.title('Pop Culture Question 5')
            pWin.geometry('1200x400')

            pLabel = tk.Label(pWin, text = 'Select all that are Christopher Nolan movies', font = ("Arial", 30, "bold"))

            cbVar1 = tkinter.IntVar()
            cbVar2 = tkinter.IntVar()
            cbVar3 = tkinter.IntVar()
            cbVar4 = tkinter.IntVar()
            cbVar5 = tkinter.IntVar()
            cbVar6 = tkinter.IntVar()

            cbVar1.set(0)
            cbVar2.set(0)
            cbVar3.set(0)
            cbVar4.set(0)
            cbVar5.set(0)
            cbVar6.set(0)

            #trick question. all of them are Christopher Nolan movies :)
            cb1 = tkinter.Checkbutton(pWin, text = 'Interstellar', font = 25, variable = cbVar1)
            cb2 = tkinter.Checkbutton(pWin, text = 'The Dark Knight', font = 25, variable = cbVar2)
            cb3 = tkinter.Checkbutton(pWin, text = 'Memento', font = 25, variable = cbVar3)
            cb4 = tkinter.Checkbutton(pWin, text = 'Tenet', font = 25, variable = cbVar4)
            cb5 = tkinter.Checkbutton(pWin, text = 'Inception', font = 25, variable = cbVar5)
            cb6 = tkinter.Checkbutton(pWin, text = 'Dunkirk', font = 25, variable = cbVar6)

            def solve():
                if cbVar1.get() == 1 and cbVar2.get() == 1 and cbVar3.get() == 1 and cbVar4.get() == 1 and cbVar5.get() == 1 and cbVar6.get() == 1:
                    score_1000()

                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Correct!", "Correct!")

                    pb5.config(command = dud)
                    
                    pb5.config(text = 'Correct!', fg = 'Lime Green')

                    pWin.destroy()
                else:
                    notscore_1000()
                    
                    show_score.config(text = score)

                    tkinter.messagebox.showinfo("Incorrect", "Sorry, that is the wrong answer")

                    pb5.config(command = dud)

                    pb5.config(text = 'Incorrect', fg = 'Red')

                    pWin.destroy()

            submit = tk.Button(pWin, text = 'Submit', font = ("Arial", 20, "bold"), command = solve)

            def skip():
                pWin.destroy()

                pb5.config(text = 'Skipped')

            skipp = tk.Button(pWin, text = 'Skip', font = ("Arial", 20, "bold"), command = skip)
            
            pLabel.pack()
            cb1.pack()
            cb2.pack()
            cb3.pack()
            cb4.pack()
            cb5.pack()
            cb6.pack()
            submit.pack()
            skipp.pack()
            

        def final_question():
            #final question window
            final = tk.Toplevel()
            final.title('Final Question')
            final.geometry('800x200')

            #widgets
            finalLabel = tk.Label(final, text = 'Did you have fun?', font = ("Arial", 30, "bold"))

            finalEntry = tk.Entry(final, width = 10, font = 30)


            def calculation(event):
                #calculation the final score and opening the end window
                if finalEntry.get().lower() == 'yes' or finalEntry.get().lower() == 'yeah':
                    #.lower() makes all entrys in lowercase
                    
                    score_bonus()
                    #will add 5000 bonus points to score

                    end_game()
                    #end game function to end the game and display the end window
                    
                elif finalEntry.get().lower() == 'no' or finalEntry.get().lower() == 'nah':
                    #no bonus points for people that didn't like the game
                    
                    end_game()
                    #end game function to end the game and display the end window
                    
                else:
                    #if the user types in something else                    
                    end_game()

            final.bind("<Return>", calculation)
            #Use .bind to bind calculation() to pressing the enter key or pressing the return button
            #This makes it so the user controls when they will answer the final question

            #pack widgets
            finalLabel.pack()
            finalEntry.pack()



            
        #Buttons that will activate the functions
        Video_Games = tk.Button(row1, text = 'Video Games', font = ('Arial', 25, 'bold'), width = 11, bg = '#0D9FCA', fg = 'white')
        vb1 = tk.Button(row2, text = '200', font = ('Arial', 25, 'bold'), command = vq1, width = 11)
        vb2 = tk.Button(row3, text = '400', font = ('Arial', 25, 'bold'), command = vq2, width = 11)
        vb3 = tk.Button(row4, text = '600', font = ('Arial', 25, 'bold'), command = vq3, width = 11)
        vb4 = tk.Button(row5, text = '800', font = ('Arial', 25, 'bold'), command = vq4, width = 11)
        vb5 = tk.Button(row6, text = '1000', font = ('Arial', 25, 'bold'), command = vq5, width = 11)
        
        Countries = tk.Button(row1, text = 'Countries', font = ('Arial', 25, 'bold'), width = 11, bg = '#0D9FCA', fg = 'white')
        #set as cob so that it isn't confused with cb/checkbuttons
        cob1 = tk.Button(row2, text = '200', font = ('Arial', 25, 'bold'), command = cq1, width = 11)
        cob2 = tk.Button(row3, text = '400', font = ('Arial', 25, 'bold'), command = cq2, width = 11)
        cob3 = tk.Button(row4, text = '600', font = ('Arial', 25, 'bold'), command = cq3, width = 11)
        cob4 = tk.Button(row5, text = '800', font = ('Arial', 25, 'bold'), command = cq4, width = 11)
        cob5 = tk.Button(row6, text = '1000', font = ('Arial', 25, 'bold'), command = cq5, width = 11)
        
        Science = tk.Button(row1, text = 'Science', font = ('Arial', 25, 'bold'), width = 11, bg = '#0D9FCA', fg = 'white')
        sb1 = tk.Button(row2, text = '200', font = ('Arial', 25, 'bold'), command = sq1, width = 11)
        sb2 = tk.Button(row3, text = '400', font = ('Arial', 25, 'bold'), command = sq2, width = 11)
        sb3 = tk.Button(row4, text = '600', font = ('Arial', 25, 'bold'), command = sq3, width = 11)
        sb4 = tk.Button(row5, text = '800', font = ('Arial', 25, 'bold'), command = sq4, width = 11)
        sb5 = tk.Button(row6, text = '1000', font = ('Arial', 25, 'bold'), command = sq5, width = 11)
        
        History = tk.Button(row1, text = 'History', font = ('Arial', 25, 'bold'), width = 11, bg = '#0D9FCA', fg = 'white')
        hb1 = tk.Button(row2, text = '200', font = ('Arial', 25, 'bold'), command = hq1, width = 11)
        hb2 = tk.Button(row3, text = '400', font = ('Arial', 25, 'bold'), command = hq2, width = 11)
        hb3 = tk.Button(row4, text = '600', font = ('Arial', 25, 'bold'), command = hq3, width = 11)
        hb4 = tk.Button(row5, text = '800', font = ('Arial', 25, 'bold'), command = hq4, width = 11)
        hb5 = tk.Button(row6, text = '1000', font = ('Arial', 25, 'bold'), command = hq5, width = 11)

        Technology = tk.Button(row1, text = 'Technology', font = ('Arial', 25, 'bold'), width = 11, bg = '#0D9FCA', fg = 'white')
        tb1 = tk.Button(row2, text = '200', font = ('Arial', 25, 'bold'), command = tq1, width = 11)
        tb2 = tk.Button(row3, text = '400', font = ('Arial', 25, 'bold'), command = tq2, width = 11)
        tb3 = tk.Button(row4, text = '600', font = ('Arial', 25, 'bold'), command = tq3, width = 11)
        tb4 = tk.Button(row5, text = '800', font = ('Arial', 25, 'bold'), command = tq4, width = 11)
        tb5 = tk.Button(row6, text = '1000', font = ('Arial', 25, 'bold'), command = tq5, width = 11)
        
        Pop_Culture = tk.Button(row1, text = 'Pop Culture', font = ('Arial', 25, 'bold'), width = 11, bg = '#0D9FCA', fg = 'white')
        pb1 = tk.Button(row2, text = '200', font = ('Arial', 25, 'bold'), command = pq1, width = 11)
        pb2 = tk.Button(row3, text = '400', font = ('Arial', 25, 'bold'), command = pq2, width = 11)
        pb3 = tk.Button(row4, text = '600', font = ('Arial', 25, 'bold'), command = pq3, width = 11)
        pb4 = tk.Button(row5, text = '800', font = ('Arial', 25, 'bold'), command = pq4, width = 11)
        pb5 = tk.Button(row6, text = '1000', font = ('Arial', 25, 'bold'), command = pq5, width = 11)

        finish_button = tk.Button(row7, text = 'Finish', font = ('Arial', 25, 'bold'), command = final_question)


        #pack all widgets
        row1.pack()
        row2.pack()
        row3.pack()
        row4.pack()
        row5.pack()
        row6.pack()
        row7.pack()

        before_show_score.pack(side = 'left')
        show_score.pack(side = 'left')
        finish_button.pack(side = 'left')
        
        Video_Games.pack(side = 'left')
        vb1.pack(side = 'left')
        vb2.pack(side = 'left')
        vb3.pack(side = 'left')
        vb4.pack(side = 'left')
        vb5.pack(side = 'left')

        Countries.pack(side = 'left')
        cob1.pack(side = 'left')
        cob2.pack(side = 'left')
        cob3.pack(side = 'left')
        cob4.pack(side = 'left')
        cob5.pack(side = 'left')

        Science.pack(side = 'left')
        sb1.pack(side = 'left')
        sb2.pack(side = 'left')
        sb3.pack(side = 'left')
        sb4.pack(side = 'left')
        sb5.pack(side = 'left')

        History.pack(side = 'left')
        hb1.pack(side = 'left')
        hb2.pack(side = 'left')
        hb3.pack(side = 'left')
        hb4.pack(side = 'left')
        hb5.pack(side = 'left')

        Technology.pack(side = 'left')
        tb1.pack(side = 'left')
        tb2.pack(side = 'left')
        tb3.pack(side = 'left')
        tb4.pack(side = 'left')
        tb5.pack(side = 'left')

        Pop_Culture.pack(side = 'left')
        pb1.pack(side = 'left')
        pb2.pack(side = 'left')
        pb3.pack(side = 'left')
        pb4.pack(side = 'left')
        pb5.pack(side = 'left')

        #enter into tkinter mainloop
        gameWin.mainloop()

        


    def answers ():
        #question answers window
        ans = tk.Toplevel()
        ans.title('Question Answers')
        ans.geometry('1000x650')
        
        #widgets
        ansTitle = tk.Label(ans, text = 'Answers:', font = ('Arial', 30, 'bold'), bg = '#0D9FCA', fg = 'white')
        ansLabel = tk.Label(ans, text = 'Minecraft is the best selling video game\n' +
                            'The first home video console was the Magnavox Odyssey\n' +
                            'The second most popular free game downloaded on iPhones in 2018 was Helix Jump\n' +
                            'Bulbasaur is No. 1 in the Pokedex\n' +
                            "Tears of the Kingdom, Majora's Mask, Ocarina of Time and Wind Waker are all Zelda games\n" +
                            'Yonge Street is the longest street in the world\n' +
                            'Switzerland consumes the most chocolate per year\n' +
                            'Russia produces the most oxygen because they have the most forests\n' +
                            'Lego originated from Denmark\n' +
                            'Canada, India and Pakistan are members of the Commonwealth\n' +
                            'Pluto is not on the same orbital plane as the other planets, pluto has its own unique orbit\n' +
                            "Oceans are the biggest producers of Earth's oxygen\n" +
                            'A cloud weighs between 400 million to 1 billion pounds\n' +
                            'The speed of light is around 300,000,000 m/s\n' +
                            'Lithium, Rubidium and Potassium are all Alkali Metals\n' +
                            "Canada's official languages are English and French\n" +
                            'The name Canada is derived from the indigenous word Kanata\n' +
                            'Canada became a country in 1867\n' +
                            'Canada got its own flag in 1965\n' +
                            'Tommy Douglas, Terry Fox and Pierre Trudeau were the top 3 voted Greatest Canadians\n' +
                            'The QWERTY keyboard is not the most efficient keyboard and was made to prevent jamming in typewriters\n' +
                            'There are around 5.1 billion internet users\n' +
                            "Elon Musk's networth is around 216 billion\n" +
                            'around 100,000 google searches happen every second\n' +
                            'An apple console, printer and clothing line were all once real products\n' +
                            'The most watched youtube video of all time is Baby Shark\n' +
                            'The alternate dimension in Stranger Things is called the Upside Down\n' +
                            'There are 7 Harry Potter books\n' +
                            'the MCU has grossed $25 billion\n' +
                            'Interstellar, the Dark Knight, Memento, Tenet, Inception and Dunkirk are all Christopher Nolan movies'
                            , font = ('Arial', 10), bg = '#0D9FCA', fg = 'white')
        ansQuit = tk.Button(ans, text = 'Quit', font = ('Arial', 15), command = ans.destroy, bg = '#0D9FCA', fg = 'white')

        #pack widgets
        ansTitle.pack()
        ansLabel.pack()
        ansQuit.pack()



    def end_game():
        #Function for the end of the game

        def another():
            #function for another game

            #destroy end game window
            endWin.destroy()

            #reset score
            global score
            score = 0

            #start game/program again
            main()


        #destroy main window
        window.destroy()

        #end game window
        endWin = tk.Tk()
        endWin.title('End Game Window')
        endWin.geometry('1000x300')

        #highscore (deciding wether to change the highscore or to leave it)
        global highscore
        if highscore < score:
            highscore = score

        #frames
        endTopFrame = tk.Frame(endWin, relief = 'raised', borderwidth = 1, bg = '#0D9FCA')
        endMiddleFrame = tk.Frame(endWin, relief = 'raised', borderwidth = 1, bg = '#0D9FCA')
        endBottomFrame = tk.Frame(endWin, relief = 'raised', borderwidth = 1)

        #widgets
        before_end_score = tk.Label(endTopFrame, text = 'Final Score:', font = ("Arial", 30, "bold"), bg = '#0D9FCA', fg = 'white')
        end_score = tk.Label(endTopFrame, text = score, font = ("Arial", 30, "bold"), bg = '#0D9FCA', fg = 'orange')
        before_highscore = tk.Label(endMiddleFrame, text = 'Highscore:', font = ("Arial", 30, "bold"), bg = '#0D9FCA', fg = 'white')
        highscoreLabel = tk.Label(endMiddleFrame, text = highscore, font = ("Arial", 30, "bold"), bg = '#0D9FCA', fg = 'yellow')
        endQuit = tk.Button(endBottomFrame, text = 'Quit', font = ('Arial', 25), command = endWin.destroy, bg = '#0D9FCA', fg = 'white')
        answerButton = tk.Button(endBottomFrame, text = 'Answers', font = ('Arial', 25), command = answers, bg = '#0D9FCA', fg = 'white')
        again = tk.Button(endBottomFrame, text = 'Try Again?', font = ('Arial', 25), command = another, bg = '#0D9FCA', fg = 'white')

        #pack widgets
        endTopFrame.pack()
        endMiddleFrame.pack()
        endBottomFrame.pack()
        before_end_score.pack(side = 'left')
        end_score.pack(side = 'left')
        before_highscore.pack(side = 'left')
        highscoreLabel.pack(side = 'left')
        endQuit.pack(side = 'left')
        answerButton.pack(side = 'left')
        again.pack(side = 'left')

       
    


    #functions to increase score approriately for the questions
    def score_200():
        global score
        score += 200

    def score_400():
        global score
        score += 400

    def score_600():
        global score
        score += 600
        
    def score_800():
        global score
        score += 800

    def score_1000():
        global score
        score += 1000

    def score_bonus():
        global score
        score += 5000



    def notscore_200():
        global score
        score -= 200

        #incase score goes into the negatives
        if score < 0:
            score = 0

    def notscore_400():
        global score
        score -= 400
        
        if score < 0:
            score = 0

    def notscore_600():
        global score
        score -= 600
        
        if score < 0:
            score = 0
        
    def notscore_800():
        global score
        score -= 800
        
        if score < 0:
            score = 0

    def notscore_1000():
        global score
        score -= 1000
        
        if score < 0:
            score = 0


    #Buttons (MiddleFrame)
    startButton = tk.Button(windowMiddleFrame, text = 'Start', font = ("Arial", 25), command = game, bg = '#0D9FCA', fg = 'white')
    rulesButton = tk.Button(windowMiddleFrame, text = 'Rules', font = ("Arial", 25), command = game_rules, bg = '#0D9FCA', fg = 'white')
    quitButton = tk.Button(windowMiddleFrame, text = 'Quit', font = ("Arial", 25), command = window.destroy, bg = '#0D9FCA', fg = 'white')

    #pack buttons
    startButton.pack(side = 'left')
    rulesButton.pack(side = 'left')
    quitButton.pack(side = 'left')

    #Enter into mainloop
    tk.mainloop()

#Run main function
main()








        
