#This program will demonstrate how to use radiobuttons
import tkinter
import tkinter.messagebox

def main():
    #create root window
    window = tkinter.Tk()

    #Create two frames -- one will be for the Radiobuttons
    #the other will be for the regular Button widgets
    topFrame = tkinter.Frame(window)
    bottomFrame = tkinter.Frame(window)

    topFrame.pack()
    bottomFrame.pack()

    #create the IntVar() Object
    radioVar = tkinter.IntVar()
    #Set the IntVar() Object to be 1--this calls the radioVar's object's set method to store the integer value 1 in the object
    radioVar.set(1) #this just makes it so option 1 of the radiobuttons is selected by default

    #create the Radiobutton widgets to go on the topFrame
    #the IntVar() radioVar allows for an object for the radiobutton to store the value of 1,2 or 3 into the object when selected
    rb1 = tkinter.Radiobutton(topFrame, text = 'Pizza', font = 25, variable = radioVar, value = 1)

    rb2 = tkinter.Radiobutton(topFrame, text = 'Burger', font = 25, variable = radioVar, value = 2)

    rb3 = tkinter.Radiobutton(topFrame, text = 'Shawarma', font = 25, variable = radioVar, value = 3)

    rb1.pack()
    rb2.pack()
    rb3.pack()


     #This is the call back function for when the user click "OK" after selecting the option
    def showChoice():
        tkinter.messagebox.showinfo("Food Selection", "You selected option" + str(radioVar.get()))

    #Create buttons now and put it on the bottomFrame
    okayButton = tkinter.Button(bottomFrame, text = "OK", font = 25, command = showChoice)

    quitButton = tkinter.Button(bottomFrame, text = "Quit", font = 25, command = window.destroy)

    okayButton.pack(side = 'left')
    quitButton.pack(side = 'left')


    #Enter the tkinter mainloop
    tkinter.mainloop()

main()
